package com.wondersgroup.showcase.client.front.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wondersgroup.showcase.core.web.BaseSpringController;

@Controller
@RequestMapping(value="/front")
public class FrontPageController extends BaseSpringController{

	
	@RequestMapping(value="",method={RequestMethod.GET})
	public Object homePage(Model model,HttpServletRequest request){
		return "front/HomePage";
	}
}
