package com.wondersgroup.showcase.core.utils;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

public class SessionJudge {

	public static boolean isAdminLogin(HttpSession session){
		if (StringUtils.equals((String)session.getAttribute(SessionCommons.SESSION_IS_ADMIN_LOGIN), SessionCommons.LOGIN_OK))
			return true;
		else
			return false;
	}
	public static boolean isUserLogin(HttpSession session){
		if (StringUtils.equals((String)session.getAttribute(SessionCommons.SESSION_IS_LOGIN), SessionCommons.LOGIN_OK))
			return true;
		else
			return false;
	}
}
