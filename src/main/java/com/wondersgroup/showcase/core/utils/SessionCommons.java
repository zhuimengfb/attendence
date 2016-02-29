package com.wondersgroup.showcase.core.utils;

/**
 * session规则
 * seesion中保存的信息
 * isLogin:ok//是否登录
 * userInfo:userInfo//用户的基本信息
 * origin：ownWeb,jaccount//登录来源
 * @author bo
 *
 */
public class SessionCommons {

	public static final String SESSION_IS_LOGIN="SESSION_IS_LOGIN";
	public static final String SEESION_USER_INFO="SESSION_USER_INFO";
	public static final String SEESION_ORIGIN="SESSION_ORIGIN";
	
	public static final String SESSION_IS_ADMIN_LOGIN="SESSION_IS_ADMIN_LOGIN";
	
	public static final String LOGIN_OK="LOGIN_OK";
	public static final String LOGIN_FROM_OWN_WEB="LOGIN_FROM_OWN_WEB";//从自身平台登录
}
