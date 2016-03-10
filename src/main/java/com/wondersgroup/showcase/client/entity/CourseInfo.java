package com.wondersgroup.showcase.client.entity;

import java.io.Serializable;
import java.util.Date;

public class CourseInfo implements Serializable{
	
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String START_DATE = "startDate";
	public static final String PUBLISHER_ID = "publisherId";
	public static final String END_DATE = "endDate";
	public static final String DEPARTMENT = "department";
	public static final String PIC_ADDRESS = "picAddress";
	public static final String PLACE = "place";
	public static final String DESCRIPTION="description";
	public static final String GENERATE_DATE = "generateDate";
	public static final String MODIFY_DATE = "modifyDate";
	public static final String FLAG = "flag";
	public static final String RESERVE = "reserve";
	public static final String CREDIT="credit";
	public static final int FLAG_NORMAL = 1;
	public static final int FLAG_DELETE = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	private String publisherId;
	private String department;
	private String picAddress;
	private String place;
	private String description;
	private int credit;//学分
	private Date generateDate;
	private Date modifyDate;
	private Date startDate;
	private Date endDate;
	private int flag;
	private String reserve;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPicAddress() {
		return picAddress;
	}
	public void setPicAddress(String picAddress) {
		this.picAddress = picAddress;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getGenerateDate() {
		return generateDate;
	}
	public void setGenerateDate(Date generateDate) {
		this.generateDate = generateDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
}
