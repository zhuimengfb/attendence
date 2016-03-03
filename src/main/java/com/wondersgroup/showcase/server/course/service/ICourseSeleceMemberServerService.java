package com.wondersgroup.showcase.server.course.service;

import java.util.List;
import java.util.Map;

import com.wondersgroup.showcase.client.entity.CourseSelectMember;

public interface ICourseSeleceMemberServerService {

	public void insertCourseSelectMember(Map map);

	public List<CourseSelectMember> selectCourseSelectMembersByCourseId(
			Map map);

	public List<CourseSelectMember> selectCourseSelectMembersByCourseTitle(
			Map map);

	public void deleteCourseSelectMember(String memberAccount);
}
