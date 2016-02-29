package com.wondersgroup.showcase.server.activity.web;

import java.util.List;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.wondersgroup.showcase.client.entity.ActivityInfo;
import com.wondersgroup.showcase.core.utils.DateUtils;
import com.wondersgroup.showcase.core.utils.ImageUtils;
import com.wondersgroup.showcase.core.utils.SessionCommons;
import com.wondersgroup.showcase.core.utils.SessionJudge;
import com.wondersgroup.showcase.core.utils.UUIDGenerator;
import com.wondersgroup.showcase.core.web.BaseSpringController;
import com.wondersgroup.showcase.core.web.Servlets;
import com.wondersgroup.showcase.server.activity.service.IActivityInfoAdminService;
import com.wondersgroup.showcase.server.entity.UserAdminInfo;

@Controller
@RequestMapping(value="/console/activity")
public class ActivityAdminController extends BaseSpringController{

	@Autowired
	IActivityInfoAdminService activityInfoAdminService;
	
	@RequestMapping(value="/add",method={RequestMethod.GET})
	public Object gotoAddActivityPage(Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		if (StringUtils.equals((String)session.getAttribute(SessionCommons.SESSION_IS_ADMIN_LOGIN), SessionCommons.LOGIN_OK))
			return "console/activity/addActivity";
		else {
			return "redirect:/console/user/login";
		}
	}
	
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public Object addActivity(Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		Map activityMap=Servlets.getParametersStartingWith(request, "");
		String id=UUIDGenerator.getUUID();
		activityMap.put(ActivityInfo.ID, id);
		String activityPicAddres="";
		try {
			String path=ImageUtils.getImagePath();
			long  startTime=System.currentTimeMillis();
	        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
			CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
			//检查form中是否有enctype="multipart/form-data"
			if(multipartResolver.isMultipart(request)){
	           //将request变成多部分request
	           MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
	          //获取multiRequest 中所有的文件名
	           Iterator iter=multiRequest.getFileNames();
	           while(iter.hasNext())
	           {
	               //一次遍历所有文件
	               MultipartFile file=multiRequest.getFile(iter.next().toString());
	               if(file!=null)
	               {
	            	   String tempTileName =  file.getOriginalFilename();
	            	   if (StringUtils.isNotBlank(tempTileName)){
	            		   activityPicAddres = id+tempTileName.substring(tempTileName.indexOf("."), tempTileName.length());
		            	   File file2=new File(path);
		                   if(!file2.exists()&&!file2.isDirectory())      
		                   {       
		                       System.out.println("//不存在");  
		                       file2.mkdirs(); 
		                   }
		                   path=path+activityPicAddres;
		                   //上传
						   file.transferTo(new File(path));
	            	   }
	               }
                 }
	           long  endTime=System.currentTimeMillis();
	           System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		activityMap.put(ActivityInfo.ACTIVITY_PIC_ADDRESS, activityPicAddres);
		activityMap.put(ActivityInfo.PUBLISHER_ID, ((UserAdminInfo)session.getAttribute(SessionCommons.SEESION_USER_INFO)).getId());
		activityMap.put(ActivityInfo.ACTIVITY_TYPE, "普通活动");
		activityMap.put(ActivityInfo.RESERVE, "");
		activityInfoAdminService.insertActivityInfo(activityMap);
		return "redirect:/console/activity/list";
	}
	
	@RequestMapping(value="/list",method={RequestMethod.GET})
	public Object gotoActivityList(Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		if (StringUtils.equals((String)session.getAttribute(SessionCommons.SESSION_IS_ADMIN_LOGIN), SessionCommons.LOGIN_OK)){
			List<ActivityInfo> activityList=activityInfoAdminService.selectActivityInfosByPublisherId(((UserAdminInfo)session.getAttribute(SessionCommons.SEESION_USER_INFO)).getId());
			model.addAttribute("activityList",activityList);
			return "console/activity/activityList";
		}
		else {
			return "redirect:/console/user/login";
		}
	}
	@RequestMapping(value="/{activityId}/edit",method={RequestMethod.GET})
	public Object gotoEditActivity(@PathVariable String activityId,Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		if (!SessionJudge.isAdminLogin(session))
			return "redirect:/console/user/login";
		ActivityInfo activityInfo=activityInfoAdminService.selectActivityInfoById(activityId);
		model.addAttribute("activityInfo", activityInfo);
		model.addAttribute("activityStartDate", DateUtils.getDateWithoutSecond(activityInfo.getStartDate()));
		model.addAttribute("activityEndDate", DateUtils.getDateWithoutSecond(activityInfo.getEndDate()));
		return "console/activity/editActivity";
	}
}
