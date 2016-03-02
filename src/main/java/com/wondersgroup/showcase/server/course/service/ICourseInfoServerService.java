package com.wondersgroup.showcase.server.course.service;

import java.util.Map;

import com.wondersgroup.showcase.client.entity.CourseInfo;

public interface ICourseInfoServerService {

	public void insertCourseInfo(Map map);
	
	public CourseInfo selectCourseByTitle(String title);
}
