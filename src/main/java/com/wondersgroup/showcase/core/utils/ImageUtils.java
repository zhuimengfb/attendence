package com.wondersgroup.showcase.core.utils;

import org.apache.commons.lang3.StringUtils;

public class ImageUtils {
	
	private static final String BASE_IMAGE_LINUX_PATH="/usr/image/attendence";
	private static final String BASE_IMAGE_WINDOWS_PATH="D:/WebServerImage/attendence";
	private static final String BASE_ACTIVITY_PIC_ADDRESS_LINUX="/activity/";
	private static final String BASE_ACTIVITY_PIC_ADDRESS_WINDOWS="/activity/";

	public static String getImagePath(){
		if (StringUtils.equals(OsInfoUtils.getOSname().toString(), EPlatform.Linux.toString()))
			return BASE_IMAGE_LINUX_PATH+BASE_ACTIVITY_PIC_ADDRESS_LINUX;
		else if (StringUtils.equals(OsInfoUtils.getOSname().toString(), EPlatform.Windows.toString()))
			return BASE_IMAGE_WINDOWS_PATH+BASE_ACTIVITY_PIC_ADDRESS_WINDOWS;
		else
			return "";
	}
}
