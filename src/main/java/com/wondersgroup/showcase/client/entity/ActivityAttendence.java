package com.wondersgroup.showcase.client.entity;

import java.io.Serializable;
import java.util.Date;

public class ActivityAttendence implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String userId;//用户id
	private String activityId;//活动id
	private Date attendenceDate;//签到时间
	private double attendenceLatitude;//签到的位置
	private double attendenceLongitude;
	private int flag;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public Date getAttendenceDate() {
		return attendenceDate;
	}
	public void setAttendenceDate(Date attendenceDate) {
		this.attendenceDate = attendenceDate;
	}
	public double getAttendenceLatitude() {
		return attendenceLatitude;
	}
	public void setAttendenceLatitude(double attendenceLatitude) {
		this.attendenceLatitude = attendenceLatitude;
	}
	public double getAttendenceLongitude() {
		return attendenceLongitude;
	}
	public void setAttendenceLongitude(double attendenceLongitude) {
		this.attendenceLongitude = attendenceLongitude;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
