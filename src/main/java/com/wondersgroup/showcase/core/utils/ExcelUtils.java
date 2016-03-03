package com.wondersgroup.showcase.core.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.wondersgroup.showcase.client.entity.CourseSelectMember;

public class ExcelUtils {

	public static List<CourseSelectMember> getCourseSelectMember(
			MultipartFile multipartFile) {
		List<CourseSelectMember> courseSelectMembers = new ArrayList<>();
		String tempNameString = multipartFile.getOriginalFilename();
		if (StringUtils.equals(tempNameString.substring(
				tempNameString.lastIndexOf(".")+1, tempNameString.length()), "xls")) {
			try {
				POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
						multipartFile.getInputStream());
				@SuppressWarnings("resource")
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
				int rowstart = hssfSheet.getFirstRowNum();
				int rowEnd = hssfSheet.getLastRowNum();
				Map<Integer, String> map = new HashMap<Integer, String>();
				for (int i = rowstart; i <= rowEnd; i++) {
					HSSFRow row = hssfSheet.getRow(i);
					if (null == row)
						continue;
					int cellStart = row.getFirstCellNum();
					int cellEnd = row.getLastCellNum();
					CourseSelectMember courseSelectMember = new CourseSelectMember();
					for (int k = cellStart; k <= cellEnd; k++) {
						HSSFCell cell = row.getCell(k);
						if (null == cell)
							continue;
						if (i == rowstart) {
							map.put(k, cell.getStringCellValue());
						} else {
							switch (map.get(k)) {
							case "课程":
								courseSelectMember.setCourseTitle(cell
										.getStringCellValue());
								break;
							case "姓名":
								courseSelectMember.setMemberName(cell
										.getStringCellValue());
								break;
							case "学号":
								if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
									courseSelectMember
											.setMemberAccount(""
													+ Integer.parseInt(Double.toString(cell
															.getNumericCellValue())));
								else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
									courseSelectMember.setMemberAccount(cell.getStringCellValue());
								break;
							case "工号":
								if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
									courseSelectMember
											.setMemberAccount(""
													+ Integer.parseInt(Double.toString(cell
															.getNumericCellValue())));
								else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
									courseSelectMember.setMemberAccount(cell.getStringCellValue());
								break;
							case "部门":
								courseSelectMember.setMemberApartment(cell
										.getStringCellValue());
								break;
							default:
								break;
							}
						}
					}
					if (i != rowstart)
						courseSelectMembers.add(courseSelectMember);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (StringUtils.equals(tempNameString.substring(
				tempNameString.lastIndexOf(".")+1, tempNameString.length()), "xlsx")) {
			XSSFWorkbook xssfWorkbook;
			try {
				xssfWorkbook = new XSSFWorkbook(multipartFile.getInputStream());
				XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
				int rowstart = xssfSheet.getFirstRowNum();
				int rowEnd = xssfSheet.getLastRowNum();
				Map<Integer, String> map = new HashMap<Integer, String>();
				for (int i = rowstart; i <= rowEnd; i++) {
					XSSFRow row = xssfSheet.getRow(i);
					if (null == row)
						continue;
					int cellStart = row.getFirstCellNum();
					int cellEnd = row.getLastCellNum();
					CourseSelectMember courseSelectMember = new CourseSelectMember();
					for (int k = cellStart; k <= cellEnd; k++) {
						XSSFCell cell = row.getCell(k);
						if (null == cell)
							continue;
						if (i == rowstart) {
							map.put(k, cell.getStringCellValue());
						} else {
							switch (map.get(k)) {
							case "课程":
								courseSelectMember.setCourseTitle(cell
										.getStringCellValue());
								break;
							case "姓名":
								courseSelectMember.setMemberName(cell
										.getStringCellValue());
								break;
							case "学号":
								if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
									courseSelectMember
											.setMemberAccount(""
													+ Integer.parseInt(Double.toString(cell
															.getNumericCellValue())));
								else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
									courseSelectMember.setMemberAccount(cell.getStringCellValue());
								break;
							case "工号":
								if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
									courseSelectMember
											.setMemberAccount(""
													+ Integer.parseInt(Double.toString(cell
															.getNumericCellValue())));
								else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
									courseSelectMember.setMemberAccount(cell.getStringCellValue());
								break;
							case "部门":
								courseSelectMember.setMemberApartment(cell
										.getStringCellValue());
								break;
							default:
								break;
							}
						}
					}
					if (i != rowstart)
						courseSelectMembers.add(courseSelectMember);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courseSelectMembers;
	}
}
