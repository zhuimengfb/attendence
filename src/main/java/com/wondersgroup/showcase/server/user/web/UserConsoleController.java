package com.wondersgroup.showcase.server.user.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wondersgroup.showcase.core.utils.SessionCommons;
import com.wondersgroup.showcase.core.web.BaseSpringController;
import com.wondersgroup.showcase.core.web.Servlets;
import com.wondersgroup.showcase.server.entity.UserAdminInfo;
import com.wondersgroup.showcase.server.user.service.IUserConsoleService;
import com.wondersgroup.showcase.server.user.service.imp.UserConsoleService;

@Controller
@RequestMapping(value="/console/user")
public class UserConsoleController extends BaseSpringController{

	@Autowired
	IUserConsoleService userConsoleService;
	
	@RequestMapping(value="/login",method={RequestMethod.GET})
	public Object gotoUserLogin(Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		if (StringUtils.equals((String)session.getAttribute(SessionCommons.SESSION_IS_ADMIN_LOGIN),SessionCommons.LOGIN_OK))
			return "redirect:/console/activity/list";
		return "console/login";
	}
	
	//管理员用户登录，添加session
	@RequestMapping(value="/login",method={RequestMethod.POST})
	public Object userAdminLogin(Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		if (StringUtils.equals((String)session.getAttribute(SessionCommons.SESSION_IS_ADMIN_LOGIN),SessionCommons.LOGIN_OK))
			return "redirect:/console/activity/list";
		Map loginParams=Servlets.getParametersStartingWith(request, "");
		UserAdminInfo userAdminInfo=userConsoleService.login(loginParams);
		if (userAdminInfo!=null){
			session.setAttribute(SessionCommons.SESSION_IS_ADMIN_LOGIN, SessionCommons.LOGIN_OK);
			session.setAttribute(SessionCommons.SEESION_USER_INFO, userAdminInfo);
			session.setAttribute(SessionCommons.SEESION_ORIGIN, SessionCommons.LOGIN_FROM_OWN_WEB);
			return "redirect:/console/activity/list";
		}
		return "console/login";
	}
	
	@RequestMapping(value="/register",method={RequestMethod.GET})
	public Object gotoUserRegister(Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		if (StringUtils.equals((String)session.getAttribute(SessionCommons.SESSION_IS_ADMIN_LOGIN),SessionCommons.LOGIN_OK))
			return "redirect:/console/activity/list";
		return "console/register";
	}
	
	//管理员用户注册，注册完可以登录，但需要审核后才能进行管理操作
	@RequestMapping(value="/register",method={RequestMethod.POST})
	public Object userAdminRegister(Model model,HttpServletRequest request){
		HttpSession session=request.getSession();
		if (StringUtils.equals((String)session.getAttribute(SessionCommons.SESSION_IS_ADMIN_LOGIN),SessionCommons.LOGIN_OK))
			return "redirect:/console/activity/list";
		Map registerMap=Servlets.getParametersStartingWith(request, "");
		int status=userConsoleService.register(registerMap);
		if (status==UserConsoleService.REGISTERED_ALREADY){
			model.addAttribute("REGISTER_ALREADY", true);
			return "console/register";
		}
		else {
			return "redirect:/console/user/login";
		}
	}
}
