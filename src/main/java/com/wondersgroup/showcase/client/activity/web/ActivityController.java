package com.wondersgroup.showcase.client.activity.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.showcase.client.activity.service.IActivityAttendenceService;
import com.wondersgroup.showcase.client.activity.service.IActivityInfoService;
import com.wondersgroup.showcase.client.entity.ActivityAttendence;
import com.wondersgroup.showcase.client.entity.ActivityInfo;
import com.wondersgroup.showcase.client.entity.UserInfo;
import com.wondersgroup.showcase.core.utils.DateUtils;
import com.wondersgroup.showcase.core.utils.DistanceUtils;
import com.wondersgroup.showcase.core.utils.SessionCommons;
import com.wondersgroup.showcase.core.utils.SessionJudge;
import com.wondersgroup.showcase.core.utils.UUIDGenerator;
import com.wondersgroup.showcase.core.web.BaseSpringController;
import com.wondersgroup.showcase.core.web.Servlets;

@Controller
@RequestMapping(value = "/activity")
public class ActivityController extends BaseSpringController{

	
	@Autowired
	IActivityInfoService activityInfoService;
	@Autowired
	IActivityAttendenceService activityAttendenceService;
	
	@RequestMapping(value="/list",method = {RequestMethod.GET})
	public Object home(Model model,HttpServletRequest request){
		Map map=new HashMap<>();
		map.put("currentPage", 1);
		List<ActivityInfo> activityInfos=activityInfoService.selectActivityInfosByPage(map);
		HttpSession session=request.getSession();
		Date date=new Date();
		if (SessionJudge.isUserLogin(session)){
			for (int i=0;i<activityInfos.size();i++){
				ActivityAttendence activityAttendence=activityAttendenceService.selectActivityAttendenceByActivityIdAndUserId(activityInfos.get(i).getId(), ((UserInfo)session.getAttribute(SessionCommons.SEESION_USER_INFO)).getId());
				String reserveString="";
				if (activityAttendence!=null)
					reserveString+="attendence,";
				if (activityInfos.get(i).getEndDate().getTime()<date.getTime())
					reserveString+="complete";
				activityInfos.get(i).setReserve(reserveString);
			}
		}
		model.addAttribute("activityInfos",activityInfos);
		return "activity/frontPage";
	}
	
	@RequestMapping(value="/attendence",method={RequestMethod.POST})
	@ResponseBody
	public Object activityAttendence(Model model,HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		if (!SessionJudge.isUserLogin(session))
			return "redirect:/user/login";
		Map map=Servlets.getParametersStartingWith(request, "");
		ActivityInfo activityInfo=activityInfoService.selectActivityInfoById((String)map.get("activityId"));
		if (activityInfo!=null){
			if (activityAttendenceService.selectActivityAttendenceByActivityIdAndUserId(activityInfo.getId(), (String)map.get("userId"))!=null)
				return "attendenceAlready";
			//距离合适，签到记录
			if (DistanceUtils.Distance(activityInfo.getLongitude(), activityInfo.getLatitude(), Double.parseDouble((String)map.get("longitude")), Double.parseDouble((String)map.get("latitude")))<50){
				ActivityAttendence activityAttendence=new ActivityAttendence();
				activityAttendence.setId(UUIDGenerator.getUUID());
				activityAttendence.setActivityId(activityInfo.getId());
				activityAttendence.setAttendenceDate(new Date());
				activityAttendence.setAttendenceLatitude(Double.parseDouble((String)map.get("latitude")));
				activityAttendence.setAttendenceLongitude(Double.parseDouble((String)map.get("longitude")));
				activityAttendence.setUserId((String)map.get("userId"));
				activityAttendence.setFlag(1);
				activityAttendenceService.insertActivityAttendence(activityAttendence);
				return "success";
			}
		}
		return "fail";
	}
	
}
