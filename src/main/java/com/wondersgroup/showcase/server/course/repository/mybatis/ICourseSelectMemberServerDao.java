package com.wondersgroup.showcase.server.course.repository.mybatis;

import java.util.List;
import java.util.Map;

import com.wondersgroup.showcase.client.entity.CourseSelectMember;
import com.wondersgroup.showcase.core.repository.mybatis.IMyBatisRepository;

@IMyBatisRepository
public interface ICourseSelectMemberServerDao {

	
	public void insertCourseSelectMember(CourseSelectMember courseSelectMember);
	
	public CourseSelectMember selectMemberByCourseIdAndMemberAccount(Map map);
	
	public List<CourseSelectMember> selectCourseSelectMembersByCourseIdWithPage(Map map);
	
	public List<CourseSelectMember> selectCourseSelectMembersByCourseTitleWithPage(Map map);
	
	public void deleteCourseSelectMember(String memberAccount);
	
}
