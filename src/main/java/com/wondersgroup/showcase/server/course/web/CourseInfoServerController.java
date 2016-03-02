package com.wondersgroup.showcase.server.course.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wondersgroup.showcase.core.web.BaseSpringController;
import com.wondersgroup.showcase.core.web.Servlets;
import com.wondersgroup.showcase.server.course.service.ICourseInfoServerService;

@Controller
@RequestMapping(value="/console/course")
public class CourseInfoServerController extends BaseSpringController {

	@Autowired
	ICourseInfoServerService courseInfoServerService;
	
	
	@RequestMapping(value="/add",method={RequestMethod.GET})
	public Object gotoAddCourse(Model model,HttpServletRequest request){
		return "console/course/add";
	}
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public Object addCourse(Model model,HttpServletRequest request){
		Map map=Servlets.getParametersStartingWith(request, "");
		//courseInfoServerService.insertCourseInfo(map);
		return "redirect:/course/list";
	}
	
	@RequestMapping(value="/list",method={RequestMethod.GET})
	public Object gotoCourseList(Model model,HttpServletRequest request){
		return "console/course/courseList";
	}
}
