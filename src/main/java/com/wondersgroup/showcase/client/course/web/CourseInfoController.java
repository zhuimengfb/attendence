package com.wondersgroup.showcase.client.course.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wondersgroup.showcase.client.course.service.ICourseInfoService;
import com.wondersgroup.showcase.client.entity.CourseInfo;
import com.wondersgroup.showcase.core.web.BaseSpringController;
import com.wondersgroup.showcase.core.web.Servlets;

@Controller
@RequestMapping(value="/course")
public class CourseInfoController extends BaseSpringController{

	@Autowired
	ICourseInfoService courseInfoService;
	
	@RequestMapping(value="/list",method={RequestMethod.GET})
	public Object gotoCourseList(Model model,HttpServletRequest request){
		Map map=Servlets.getParametersStartingWith(request, "");
		int currentPage=1;
		if (map.get("currentPage")!=null)
			currentPage=(Integer)map.get("currentPage");
		List<CourseInfo> courseInfos=courseInfoService.selectCourseByPage(currentPage);
		model.addAttribute("courseInfos", courseInfos);
		return "course/CourseList";
	}
}
