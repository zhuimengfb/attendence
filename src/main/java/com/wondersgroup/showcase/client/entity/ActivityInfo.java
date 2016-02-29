package com.wondersgroup.showcase.client.entity;

import java.io.Serializable;
import java.util.Date;

public class ActivityInfo implements Serializable{

	public static final String ID = "id";
	public static final String TITLE="title";
	public static final String PLACE="place";
	public static final String LATITUDE="latitude";
	public static final String LONGITUDE="longitude";
	public static final String ACTIVITY_DES="activityDes";
	public static final String PUBLISHER_ID="publisherId";
	public static final String ACTIVITY_PIC_ADDRESS="activityPicAddress";
	public static final String ACTIVITY_TYPE="activityType";
	public static final String START_DATE="startDate";
	public static final String END_DATE="endDate";
	public static final String GENERATE_DATE="generateDate";
	public static final String MODIFY_DATE="modifyDate";
	public static final String RESERVE="reserve";
	public static final String STATUS="status";
	public static final String FLAG="flag";
	
	public static final int FLAG_NORMAL = 1;
	public static final int STATUS_NORMAL = 1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;  //活动id
	private String title;  //活动标题
	private String place;  //活动地点
	private double latitude;
	private double longitude; //活动具体的经纬度
	private String activityDes;  //活动描述
	private String activityPicAddress;  //活动图片地址
	private String publisherId;  //活动发布者id
	private String activityType; //活动类型
	private Date startDate;  //开始时间
	private Date endDate;   //结束时间
	private Date generateDate;
	private Date modifyDate;
	private String reserve; //保留字段
	private int status; //活动进行状态
	private int flag;  //活动状态,1表示正常，0表示删除
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getActivityDes() {
		return activityDes;
	}
	public void setActivityDes(String activityDes) {
		this.activityDes = activityDes;
	}
	public String getActivityPicAddress() {
		return activityPicAddress;
	}
	public void setActivityPicAddress(String activityPicAddress) {
		this.activityPicAddress = activityPicAddress;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
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
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
