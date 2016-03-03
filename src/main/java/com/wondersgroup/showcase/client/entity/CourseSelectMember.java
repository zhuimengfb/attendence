package com.wondersgroup.showcase.client.entity;

import java.io.Serializable;

public class CourseSelectMember implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String memberAccount;
	private String memberName;
	private String courseId;
	private String courseTitle;
	private String memberApartment;
	private int flag;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getMemberApartment() {
		return memberApartment;
	}
	public void setMemberApartment(String memberApartment) {
		this.memberApartment = memberApartment;
	}
}
