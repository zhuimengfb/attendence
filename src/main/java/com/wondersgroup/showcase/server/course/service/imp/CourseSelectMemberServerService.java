package com.wondersgroup.showcase.server.course.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.showcase.client.entity.CourseSelectMember;
import com.wondersgroup.showcase.core.service.BaseService;
import com.wondersgroup.showcase.core.utils.PageUtils;
import com.wondersgroup.showcase.core.utils.UUIDGenerator;
import com.wondersgroup.showcase.server.course.repository.mybatis.ICourseSelectMemberServerDao;
import com.wondersgroup.showcase.server.course.service.ICourseSelectMemberServerService;

@Service
public class CourseSelectMemberServerService extends BaseService implements ICourseSelectMemberServerService {
	@Autowired
	ICourseSelectMemberServerDao courseSelectMemberServerDao;
	@Override
	public void insertCourseSelectMember(Map map) {
		// TODO Auto-generated method stub
		if (isStudentCourseSelceted(map)) return;
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
	public void insertCourseSelectMember(CourseSelectMember courseSelectMember) {
		// TODO Auto-generated method stub
		Map<String,String> map=new HashMap<String, String>();
		map.put(CourseSelectMember.COURSE_ID, courseSelectMember.getCourseId());
		map.put(CourseSelectMember.MEMBER_ACCOUNT, courseSelectMember.getMemberAccount());
		if (isStudentCourseSelceted(map)) return;
		courseSelectMember.setId(UUIDGenerator.getUUID());
		courseSelectMemberServerDao.insertCourseSelectMember(courseSelectMember);
	}
	private boolean isStudentCourseSelceted(Map<String,String> map){
		if (courseSelectMemberServerDao.selectMemberByCourseIdAndMemberAccount(map)!=null) return true;
		return false;
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
