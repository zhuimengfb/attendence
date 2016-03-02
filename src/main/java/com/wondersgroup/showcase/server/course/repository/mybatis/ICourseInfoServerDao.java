package com.wondersgroup.showcase.server.course.repository.mybatis;

import java.util.List;
import java.util.Map;

import com.wondersgroup.showcase.client.entity.CourseInfo;
import com.wondersgroup.showcase.core.repository.mybatis.IMyBatisRepository;

@IMyBatisRepository
public interface ICourseInfoServerDao {

	public void insertCourseInfo(CourseInfo courseInfo);
	
	public CourseInfo selectCourseByTitle(String title);
	
	public List<CourseInfo> selectCourseByPage(Map map);
}
