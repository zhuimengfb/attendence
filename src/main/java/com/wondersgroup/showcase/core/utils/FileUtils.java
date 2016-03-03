package com.wondersgroup.showcase.core.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class FileUtils {

	public static enum FileType {
		image, excel, word
	};

	public static List<MultipartFile> getFileFromRequest(
			HttpServletRequest request) {
		List<MultipartFile> multipartFiles = new ArrayList<>();
		try {
			long startTime = System.currentTimeMillis();
			// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			// 检查form中是否有enctype="multipart/form-data"
			if (multipartResolver.isMultipart(request)) {
				// 将request变成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				// 获取multiRequest 中所有的文件名
				Iterator iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					// 一次遍历所有文件
					MultipartFile file = multiRequest.getFile(iter.next()
							.toString());
					if (file != null)
						multipartFiles.add(file);
				}
				long endTime = System.currentTimeMillis();
				System.out.println("方法三的运行时间："
						+ String.valueOf(endTime - startTime) + "ms");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return multipartFiles;
	}

	public static FileType getFileType(MultipartFile file) {
		if (file != null) {
			String tempTileName = file.getOriginalFilename();
			String type= tempTileName.substring(
					tempTileName.lastIndexOf(".")+1, tempTileName.length());
			if (StringUtils.isNotBlank(tempTileName)) {
				if (StringUtils.equals("xlsx",type) || StringUtils.equals("xls",type)) {
						return FileType.excel;
				}
			}
		}
		return null;
	}
}
