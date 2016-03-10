package com.wondersgroup.showcase.server.course.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.wondersgroup.showcase.client.entity.CourseInfo;
import com.wondersgroup.showcase.client.entity.CourseSelectMember;
import com.wondersgroup.showcase.core.utils.ExcelUtils;
import com.wondersgroup.showcase.core.utils.FileUtils;
import com.wondersgroup.showcase.core.utils.ImageUtils;
import com.wondersgroup.showcase.core.utils.UUIDGenerator;
import com.wondersgroup.showcase.core.utils.FileUtils.FileType;
import com.wondersgroup.showcase.core.web.BaseSpringController;
import com.wondersgroup.showcase.core.web.Servlets;
import com.wondersgroup.showcase.server.course.service.ICourseInfoServerService;
import com.wondersgroup.showcase.server.course.service.ICourseSelectMemberServerService;

@Controller
@RequestMapping(value="/console/course")
public class CourseInfoServerController extends BaseSpringController {

	@Autowired
	ICourseInfoServerService courseInfoServerService;
	@Autowired
	ICourseSelectMemberServerService courseSelectMemberServerService;
	
	@RequestMapping(value="/add",method={RequestMethod.GET})
	public Object gotoAddCourse(Model model,HttpServletRequest request){
		return "console/course/add";
	}
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public Object addCourse(Model model,HttpServletRequest request){
		Map map=Servlets.getParametersStartingWith(request, "");
		String id=UUIDGenerator.getUUID();
		map.put(CourseInfo.ID, id);
		map.put(CourseInfo.PIC_ADDRESS, ImageUtils.saveCoursePicture(request, id));
		map.put(CourseInfo.FLAG, CourseInfo.FLAG_NORMAL);
		courseInfoServerService.insertCourseInfo(map);
		return "redirect:/console/course/list";
	}
	
	@RequestMapping(value="/list",method={RequestMethod.GET})
	public Object gotoCourseList(Model model,HttpServletRequest request){
		Map map=Servlets.getParametersStartingWith(request, "");
		int currentPage=1;
		if (map.get("currentPage")!=null)
			currentPage=Integer.parseInt((String)map.get("currentPage"));
		List<CourseInfo> courseInfos=courseInfoServerService.selectCourseByPage(currentPage);
		model.addAttribute("courseList", courseInfos);
		model.addAttribute("currentPage", currentPage++);
		return "console/course/courseList";
	}
	@RequestMapping(value="/{courseId}/courseSelectList",method={RequestMethod.GET})
	public Object gotoCourseSelectList(@PathVariable String courseId,Model model,HttpServletRequest request){
		Map map=Servlets.getParametersStartingWith(request, "");
		map.put(CourseSelectMember.COURSE_ID, courseId);
		List<CourseSelectMember> courseSelectMembers=courseSelectMemberServerService.selectCourseSelectMembersByCourseId(map);
		model.addAttribute(CourseSelectMember.COURSE_ID, courseSelectMembers);
		return "console/course/courseSelectList";
	}
	@RequestMapping(value="/addMember",method={RequestMethod.GET})
	public Object gotoAddMember(Model model,HttpServletRequest request){
		
		
		return "console/course/addCourseSelect";
	}
	@RequestMapping(value="/addMember",method={RequestMethod.POST})
	public Object addMember(Model model,HttpServletRequest request){
		Map map=Servlets.getParametersStartingWith(request, "");
		List<MultipartFile> multipartFiles=FileUtils.getFileFromRequest(request);
		if (multipartFiles!=null){
			for (MultipartFile file : multipartFiles){
				//如果是excel表格，进行解析
				if (FileUtils.getFileType(file)==FileType.excel){
					List<CourseSelectMember> courseSelectMembers=ExcelUtils.getCourseSelectMember(file);
					for (int i=0;i<courseSelectMembers.size();i++){
						CourseInfo courseInfo=courseInfoServerService.selectCourseByTitle(courseSelectMembers.get(i).getCourseTitle());
						courseSelectMembers.get(i).setCourseId(courseInfo.getId());
						courseSelectMembers.get(i).setFlag(CourseSelectMember.FLAG_NORMAL);
						courseSelectMemberServerService.insertCourseSelectMember(courseSelectMembers.get(i));
					}
				}
			}
		}
		
		return "redirect:/console/course/courseSelectList";
	}
}
