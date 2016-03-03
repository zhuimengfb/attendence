package com.wondersgroup.showcase.server.course.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.showcase.client.entity.CourseSelectMember;
import com.wondersgroup.showcase.core.service.BaseService;
import com.wondersgroup.showcase.core.utils.PageUtils;
import com.wondersgroup.showcase.core.utils.UUIDGenerator;
import com.wondersgroup.showcase.server.course.repository.mybatis.ICourseSelectMemberServerDao;
import com.wondersgroup.showcase.server.course.service.ICourseSeleceMemberServerService;

@Service
public class CourseSelectMemberServerService extends BaseService implements ICourseSeleceMemberServerService {

	@Autowired
	ICourseSelectMemberServerDao courseSelectMemberServerDao;
	@Override
	public void insertCourseSelectMember(Map map) {
		// TODO Auto-generated method stub
		CourseSelectMember courseSelectMember = courseSelectMemberServerDao.selectMemberByCourseIdAndMemberAccount(map);
		if (courseSelectMember!=null) return;
		CourseSelectMember courseSelectMember2=new CourseSelectMember();
		courseSelectMember2.setCourseId((String)map.get(CourseSelectMember.COURSE_ID));
		courseSelectMember2.setFlag(Integer.parseInt((String)map.get(CourseSelectMember.FLAG)));
		courseSelectMember2.setCourseTitle((String)map.get(CourseSelectMember.COURSE_TITLE));
		courseSelectMember2.setId(UUIDGenerator.getUUID());
		courseSelectMember2.setMemberAccount((String)map.get(CourseSelectMember.MEMBER_ACCOUNT));
		courseSelectMember2.setMemberApartment((String)map.get(CourseSelectMember.MEMBER_APARTMENT));
		courseSelectMember2.setMemberName((String)map.get(CourseSelectMember.MEMBER_NAME));
		courseSelectMemberServerDao.insertCourseSelectMember(courseSelectMember2);
	}

	@Override
	public List<CourseSelectMember> selectCourseSelectMembersByCourseId(
			Map map) {
		// TODO Auto-generated method stub
		PageUtils pageUtils=new PageUtils((Integer)map.get("currentPage"));
		map.put("start", pageUtils.getStart());
		map.put("pageSize", pageUtils.getPageSize());
		return courseSelectMemberServerDao.selectCourseSelectMembersByCourseIdWithPage(map);
	}

	@Override
	public List<CourseSelectMember> selectCourseSelectMembersByCourseTitle(
			Map map) {
		// TODO Auto-generated method stub
		PageUtils pageUtils=new PageUtils((Integer)map.get("currentPage"));
		map.put("start", pageUtils.getStart());
		map.put("pageSize", pageUtils.getPageSize());
		return courseSelectMemberServerDao.selectCourseSelectMembersByCourseTitleWithPage(map);
	}

	@Override
	public void deleteCourseSelectMember(String memberAccount) {
		// TODO Auto-generated method stub
		courseSelectMemberServerDao.deleteCourseSelectMember(memberAccount);
	}

}
