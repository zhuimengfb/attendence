package com.wondersgroup.showcase.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static final String DATE_FORMAT_NORMAL="yyyy-MM-dd HH:mm:ss";
	private static final String DATE_FORMAT_WITHOUT_SECOND="yyyy-MM-dd HH:mm";
	private static final String DATE_FORMAT_DATE="yyyy-MM-dd";
	private static final String DATE_FORMAT_TIME="HH:mm:ss";
	private static String parseDate(Date date,String format){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}
	
	public static String getNormalDate(Date date){
		return parseDate(date, DATE_FORMAT_NORMAL);
	}
	public static String getDateWithoutSecond(Date date){
		return parseDate(date, DATE_FORMAT_WITHOUT_SECOND);
	}
	public static String getDateDay(Date date){
		return parseDate(date, DATE_FORMAT_DATE);
	}
	public static String getDateTime(Date date){
		return parseDate(date, DATE_FORMAT_TIME);
	}
	
	public static Date getDateWithoutSecond(String date){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(DATE_FORMAT_WITHOUT_SECOND);
		try {
			return simpleDateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
