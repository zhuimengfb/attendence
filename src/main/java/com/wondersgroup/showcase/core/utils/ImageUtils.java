package com.wondersgroup.showcase.core.utils;

import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class ImageUtils {
	
	private static final String BASE_IMAGE_LINUX_PATH="/usr/image/attendence";
	private static final String BASE_IMAGE_WINDOWS_PATH="D:/WebServerImage/attendence";
	private static final String BASE_ACTIVITY_PIC_ADDRESS_LINUX="/activity/";
	private static final String BASE_ACTIVITY_PIC_ADDRESS_WINDOWS="/activity/";
	private static final String BASE_COURSE_PIC_ADDRESS_LINUX="/course/";
	private static final String BASE_COURSE_PIC_ADDRESS_WINDOWS="/course/";

	public static String getActivityImagePath(){
		if (StringUtils.equals(OsInfoUtils.getOSname().toString(), EPlatform.Linux.toString()))
			return BASE_IMAGE_LINUX_PATH+BASE_ACTIVITY_PIC_ADDRESS_LINUX;
		else if (StringUtils.equals(OsInfoUtils.getOSname().toString(), EPlatform.Windows.toString()))
			return BASE_IMAGE_WINDOWS_PATH+BASE_ACTIVITY_PIC_ADDRESS_WINDOWS;
		else
			return "";
	}
	
	public static String getCourseImagePath(){
		if (StringUtils.equals(OsInfoUtils.getOSname().toString(), EPlatform.Linux.toString()))
			return BASE_IMAGE_LINUX_PATH+BASE_COURSE_PIC_ADDRESS_LINUX;
		else if (StringUtils.equals(OsInfoUtils.getOSname().toString(), EPlatform.Windows.toString()))
			return BASE_IMAGE_WINDOWS_PATH+BASE_COURSE_PIC_ADDRESS_WINDOWS;
		else
			return "";
	}
	
	public static String saveCoursePicture(HttpServletRequest request,String id){
		return savePicture(request, getCourseImagePath(), id);
	}
	public static String saveActivityPicture(HttpServletRequest request,String id){
		return savePicture(request, getActivityImagePath(), id);
	}
	private static String savePicture(HttpServletRequest request,String saveBasePath, String id){
		String activityPicAddres="";
		try {
			String path=saveBasePath;
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
		return activityPicAddres;
	}
	
}
