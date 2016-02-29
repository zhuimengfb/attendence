package com.wondersgroup.showcase.client.user.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wondersgroup.showcase.client.entity.UserInfo;
import com.wondersgroup.showcase.client.user.service.IUserLoginService;
import com.wondersgroup.showcase.client.user.service.imp.UserLoginService;
import com.wondersgroup.showcase.core.utils.SessionCommons;
import com.wondersgroup.showcase.core.web.BaseSpringController;
import com.wondersgroup.showcase.core.web.Servlets;


@Controller
@RequestMapping(value="/user")
public class UserController extends BaseSpringController{
	
	@Autowired
	IUserLoginService userLoginService;
	
	@RequestMapping(value="/login",method={RequestMethod.GET})
	public Object gotoLogin(Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		if (StringUtils.equals(SessionCommons.LOGIN_OK,(String)session.getAttribute(SessionCommons.SESSION_IS_LOGIN)))
			return "redirect:/activity/home";
		else
			return "user/login";
	}
	
	@RequestMapping(value="/login",method={RequestMethod.POST})
	public Object userLogin(Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		if (StringUtils.equals(SessionCommons.LOGIN_OK,(String)session.getAttribute(SessionCommons.SESSION_IS_LOGIN)))
			return "redirect:/activity/home";
		Map<String, Object> loginParams = Servlets.getParametersStartingWith(request, "");
		UserInfo userInfo=userLoginService.userLogin(loginParams);
		//登录失败
		if (userInfo==null)
			return "user/login";
		else {
			session.setAttribute(SessionCommons.SESSION_IS_LOGIN, SessionCommons.LOGIN_OK);
			session.setAttribute(SessionCommons.SEESION_USER_INFO, userInfo);
			session.setAttribute(SessionCommons.SEESION_ORIGIN, SessionCommons.LOGIN_FROM_OWN_WEB);
			return "redirect:/activity/home";
		}
	}
	
	@RequestMapping(value="/register",method={RequestMethod.GET})
	public Object gotoRegister(Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		if (StringUtils.equals(SessionCommons.LOGIN_OK,(String)session.getAttribute(SessionCommons.SESSION_IS_LOGIN)))
			return "redirect:/activity/home";
		else
			return "user/register";
	}
	@RequestMapping(value="/register",method={RequestMethod.POST})
	public Object userRegister(Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		if (StringUtils.equals(SessionCommons.LOGIN_OK,(String)session.getAttribute(SessionCommons.SESSION_IS_LOGIN)))
			return "redirect:/activity/home";
		Map<String, Object> registerParams = Servlets.getParametersStartingWith(request, "");
		//验证学号是否已经注册
		if (userLoginService.userRegister(registerParams)==UserLoginService.REGISTER_ALREADY){
			model.addAttribute("REGISTER_ALREADY",true);
			return "user/register";
		};
		return "redirect:/user/login";
	}

}
