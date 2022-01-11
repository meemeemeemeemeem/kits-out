package com.kits.inms.bs.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("deprecation")
public class ExcelUtils {

	public static String exportExcel(HttpServletResponse response,
			String fileName) throws IOException {
		// 1.查询用户
		// List<User> userlist = userService.findObjects();
		// 2.导出excel
		// HttpServletResponse response = ServletActionContext.getResponse();
		// String fold =
		// String fileName = AppUtils.getUUIDKey()+".csv";
		//
		response.setContentType("application/csv,charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=\""
				+ new String(fileName.getBytes(), "iso-8859-1") + "\"");

		/*
		 * File fileDirs = new File(folder); if (!fileDirs.isDirectory()) {
		 * fileDirs.mkdirs(); } File savedFile = null; if
		 * (!StringUtils.isEmpty(fileName)) { savedFile = new File(fileDirs,
		 * fileName); if (savedFile.exists()) { savedFile.delete(); } }
		 * FileOutputStream outputStream = new FileOutputStream(savedFile);
		 */
		ServletOutputStream out = response.getOutputStream();

		try {
			exportMaterToryExcel(out);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (out != null) {
			out.close();
		}
		return null;
	}

	public static void exportMaterToryExcel(ServletOutputStream out)
			throws Exception {
		// 1.创建工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// workbook.set
		// 1.1创建合并单元格
		CellRangeAddress cra = new CellRangeAddress(0, 0, 0, 4);

		// 1.2创建标题样式
		HSSFCellStyle style1 = createStyle(workbook, 16);
		// 1.3创建列标题样式
		HSSFCellStyle style2 = createStyle(workbook, 12);
		// 1.3创建特殊列标题样式
		// HSSFCellStyle style3 = createStyle(workbook,
		// 12,HSSFColor.SKY_BLUE.index);
		// 2.创建工作表
		HSSFSheet sheet = workbook.createSheet("物料盘点信息列表");

		// 设置默认列宽
		sheet.setDefaultColumnWidth(15);
		// 2.1将合并单元格作用于sheet
		sheet.addMergedRegion(cra);
		// 3.创建行
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格
		HSSFCell cell = row.createCell(0);
		// 5.向单元格写入数据
		cell.setCellValue("物料盘点信息列表");
		// 6.将单元格加入样式
		cell.setCellStyle(style1);

		// 写列标题
		String[] titles = { "盘点钢品编号", "盘点库位", "盘点储位", "重量", "数量" };
		// 创建列标题行
		HSSFRow row2 = sheet.createRow(1);
		row2.setHeight((short) 800);

		for (int i = 0; i < titles.length; i++) {
			// 创建单元格
			HSSFCell cell1 = row2.createCell(i);
			// 向单元格写入数据
			cell1.setCellValue(titles[i]);
			if (i == 2 || i == 3 || i == 4) {
				cell1.setCellStyle(createStyle1(workbook, 12));
			} else if (i == 5 || i == 6 || i == 7 || i == 8) {
				cell1.setCellStyle(createStyle2(workbook, 12));
			} else {
				// 将单元格加入样式
				cell1.setCellStyle(createStyle3(workbook, 12));
			}
		}

		/*
		 * for (int i = 0; i < 5; i++) { // User user = userlist.get(i); HSSFRow
		 * rowdata = sheet.createRow(i + 2); // 姓名 HSSFCell cell0 =
		 * rowdata.createCell(0); // cell0.setCellValue(user.getName()); // 账号
		 * HSSFCell cell1 = rowdata.createCell(1); //
		 * cell1.setCellValue(user.getAccount()); // 部门 HSSFCell cell2 =
		 * rowdata.createCell(2); // cell2.setCellValue(user.getDept()); // //
		 * 性别 HSSFCell cell3 = rowdata.createCell(3); //
		 * cell3.setCellValue(user.isGender() ? "男" : "女"); // 手机 HSSFCell cell4
		 * = rowdata.createCell(4); // cell4.setCellValue(user.getMobile()); //
		 * 电邮 HSSFCell cell5 = rowdata.createCell(5); //
		 * cell5.setCellValue(user.getEmail()); // 生日 HSSFCell cell6 =
		 * rowdata.createCell(6);
		 * 
		 * if(user.getBirthday()!=null){ SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyy/MM/dd");
		 * cell6.setCellValue(sdf.format(user.getBirthday())); }else{
		 * cell6.setCellValue(""); }
		 * 
		 * 
		 * }
		 */

		// 6.写入硬盘文件
		// ServletOutputStream out = r
		workbook.write(out);
		// outputStream.close();
		workbook.close();

	}

	public static void exportInventtoryModel(ServletOutputStream out)
			throws Exception {
		// 1.创建工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// workbook.set
		// 1.1创建合并单元格
		CellRangeAddress cra = new CellRangeAddress(0, 0, 0, 4);

		// 1.2创建标题样式
		HSSFCellStyle style1 = createStyle(workbook, 16);
		// 1.3创建列标题样式
		HSSFCellStyle style2 = createStyle(workbook, 12);
		// 1.3创建特殊列标题样式
		// HSSFCellStyle style3 = createStyle(workbook,
		// 12,HSSFColor.SKY_BLUE.index);
		// 2.创建工作表
		HSSFSheet sheet = workbook.createSheet("库存盘点信息列表");

		// 设置默认列宽
		sheet.setDefaultColumnWidth(15);
		// 2.1将合并单元格作用于sheet
		sheet.addMergedRegion(cra);
		// 3.创建行
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格
		HSSFCell cell = row.createCell(0);
		// 5.向单元格写入数据
		cell.setCellValue("库存盘点信息列表");
		// 6.将单元格加入样式
		cell.setCellStyle(style1);

		// 写列标题
		String[] titles = { "盘点钢品编号", "盘点库位", "盘点储位", "重量", "数量" };
		// 创建列标题行
		HSSFRow row2 = sheet.createRow(1);
		row2.setHeight((short) 800);

		for (int i = 0; i < titles.length; i++) {
			// 创建单元格
			HSSFCell cell1 = row2.createCell(i);
			// 向单元格写入数据
			cell1.setCellValue(titles[i]);
			if (i == 2 || i == 3 || i == 4) {
				cell1.setCellStyle(createStyle1(workbook, 12));
			} else if (i == 5 || i == 6 || i == 7 || i == 8) {
				cell1.setCellStyle(createStyle2(workbook, 12));
			} else {
				// 将单元格加入样式
				cell1.setCellStyle(createStyle3(workbook, 12));
			}
		}

		/*
		 * for (int i = 0; i < 5; i++) { // User user = userlist.get(i); HSSFRow
		 * rowdata = sheet.createRow(i + 2); // 姓名 HSSFCell cell0 =
		 * rowdata.createCell(0); // cell0.setCellValue(user.getName()); // 账号
		 * HSSFCell cell1 = rowdata.createCell(1); //
		 * cell1.setCellValue(user.getAccount()); // 部门 HSSFCell cell2 =
		 * rowdata.createCell(2); // cell2.setCellValue(user.getDept()); // //
		 * 性别 HSSFCell cell3 = rowdata.createCell(3); //
		 * cell3.setCellValue(user.isGender() ? "男" : "女"); // 手机 HSSFCell cell4
		 * = rowdata.createCell(4); // cell4.setCellValue(user.getMobile()); //
		 * 电邮 HSSFCell cell5 = rowdata.createCell(5); //
		 * cell5.setCellValue(user.getEmail()); // 生日 HSSFCell cell6 =
		 * rowdata.createCell(6);
		 * 
		 * if(user.getBirthday()!=null){ SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyy/MM/dd");
		 * cell6.setCellValue(sdf.format(user.getBirthday())); }else{
		 * cell6.setCellValue(""); }
		 * 
		 * 
		 * }
		 */

		// 6.写入硬盘文件
		// ServletOutputStream out = r
		workbook.write(out);
		// outputStream.close();
		workbook.close();

	}
	
	// 设置样式方法
	public static HSSFCellStyle createStyle(HSSFWorkbook workbook, int fontsize) {
		// 1.2设置单元格样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置水平居中
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		short border = 1;
		style.setBorderBottom(border);
		style.setBorderTop(border);
		style.setBorderLeft(border);
		style.setBorderRight(border);
		style.setWrapText(true);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		// style.set
		// 设置垂直居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 1.3设置字体
		HSSFFont font = workbook.createFont();
		// 设置字体为ARIAL
		font.setFontName(HSSFFont.FONT_ARIAL);
		// 设置粗体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 设置字体颜色
		// font.setColor(HSSFColor.BLUE.index);
		// 设置字体大小
		font.setFontHeightInPoints((short) fontsize);
		// 将字体加入样式
		style.setFont(font);
		return style;
	}

	// 设置样式方法
	public static HSSFCellStyle createStyle1(HSSFWorkbook workbook, int fontsize) {
		// 1.2设置单元格样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置水平居中
		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		short border = 1;
		style.setBorderBottom(border);
		style.setBorderTop(border);
		style.setBorderLeft(border);
		style.setBorderRight(border);

		style.setWrapText(true);

		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setFillForegroundColor(HSSFColor.RED.index);
		// style.set
		// 设置垂直居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		// 1.3设置字体
		HSSFFont font = workbook.createFont();
		// 设置字体为ARIAL
		font.setFontName(HSSFFont.FONT_ARIAL);
		// 设置粗体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 设置字体颜色
		// font.setColor(HSSFColor.BLUE.index);
		// 设置字体大小
		font.setFontHeightInPoints((short) fontsize);
		// 将字体加入样式
		style.setFont(font);
		return style;
	}

	// 设置样式方法
	public static HSSFCellStyle createStyle2(HSSFWorkbook workbook, int fontsize) {
		// 1.2设置单元格样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置水平居中
		// style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		short border = 1;
		style.setBorderBottom(border);
		style.setBorderTop(border);
		style.setBorderLeft(border);
		style.setBorderRight(border);
		style.setWrapText(true);
		// .setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		// style.setFillForegroundColor(HSSFColor.RED.index);
		// style.set
		// 设置垂直居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		// 1.3设置字体
		HSSFFont font = workbook.createFont();
		// 设置字体为ARIAL
		font.setFontName(HSSFFont.FONT_ARIAL);
		// 设置粗体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 设置字体颜色
		// font.setColor(HSSFColor.BLUE.index);
		// 设置字体大小
		font.setFontHeightInPoints((short) fontsize);
		// 将字体加入样式
		style.setFont(font);
		return style;
	}

	public static HSSFCellStyle createStyle3(HSSFWorkbook workbook, int fontsize) {
		// 1.2设置单元格样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置水平居中
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
		short border = 1;
		style.setBorderBottom(border);
		style.setBorderTop(border);
		style.setBorderLeft(border);
		style.setBorderRight(border);
		style.setWrapText(true);
		// .setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		// style.setFillForegroundColor(HSSFColor.RED.index);
		// style.set
		// 设置垂直居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 1.3设置字体
		HSSFFont font = workbook.createFont();
		// 设置字体为ARIAL
		font.setFontName(HSSFFont.FONT_ARIAL);
		// 设置粗体
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 设置字体颜色
		// font.setColor(HSSFColor.BLUE.index);
		// 设置字体大小
		font.setFontHeightInPoints((short) fontsize);
		// 将字体加入样式
		style.setFont(font);
		return style;
	}

}