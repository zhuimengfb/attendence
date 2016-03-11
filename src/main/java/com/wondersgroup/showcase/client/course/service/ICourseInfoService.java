package com.wondersgroup.showcase.client.course.service;

import java.util.List;

import com.wondersgroup.showcase.client.entity.CourseInfo;

public interface ICourseInfoService {

	public CourseInfo selectCourseByTitle(String title);
	
	public CourseInfo selectCourseById(String id);
	
	public List<CourseInfo> selectCourseByPage(int pageNum);
}
