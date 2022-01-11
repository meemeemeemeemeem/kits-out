package com.kits.inms.bs.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("deprecation")
public class ExcelUtilsby {
//成品
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
			exportia090(out);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (out != null) {
			out.close();
		}
		return null;
	}
	//原料
	public static String exportExcela(HttpServletResponse response,
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
			exportia090a(out);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (out != null) {
			out.close();
		}
		return null;
	}

	//备品备件
	public static String exportExcelb(HttpServletResponse response,
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
			exportia090b(out);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (out != null) {
			out.close();
		}
		return null;
	}
	//废钢库存
		public static String exportExcelc(HttpServletResponse response,
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
				exportia090c(out);

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (out != null) {
				out.close();
			}
			return null;
		}
		//辅助库存模板
		public static String exportExceld(HttpServletResponse response,
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
				exportia090d(out);

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (out != null) {
				out.close();
			}
			return null;
		}
		//财务
		public static String exportExcele(HttpServletResponse response,
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
				exportia090e(out);

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
	//成品
	public static void exportia090(ServletOutputStream out)

			throws Exception {
		// 1.创建工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// workbook.set
		// 1.1创建合并单元格
		CellRangeAddress cra = new CellRangeAddress(0, 16, 0, 16);

		// 1.2创建标题样式
		HSSFCellStyle style1 = createStyle(workbook, 10);
		// 1.3创建列标题样式
		HSSFCellStyle style2 = createStyle(workbook, 10);
		// 1.3创建特殊列标题样式
		// HSSFCellStyle style3 = createStyle(workbook,
		// 12,HSSFColor.SKY_BLUE.index);
		// 2.创建工作表
		HSSFSheet sheet = workbook.createSheet("成品库存模板");

		// 设置默认列宽
		sheet.setDefaultColumnWidth(15);
		// 2.1将合并单元格作用于sheet
		sheet.addMergedRegion(cra);
		// 3.创建行
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格
		HSSFCell cell = row.createCell(0);
		// 5.向单元格写入数据
		cell.setCellValue( "成品库存期初模板说明：" + "\r\n" +
				"1.钢品编号、仓库、储位、外观、生产类型、品名、计价方式、数量、重量（标记红色的栏位）为必须填写的栏位。" + "\r\n" +
				"2.材质、规格、厚、宽、长、内径、外径、净重（标记蓝色的栏位）为按照实际情况进行选填的栏位，例如有明确的厚、宽、长、内径、外径时，需填写厚/宽/长/外径/" + "\r\n" +
				"内径，规格栏位不填写；否则如为混规时，只在规格栏位填入混规，厚/宽/长/外径/内径不填。材质根据实际情况，有材质的填入，没有材质的不填。" + "\r\n" +
				"3.其它栏位为非必填栏位，如果现有资料已有对应信息，则希望能够详细填写，请评估好工作量，选择填入。" + "\r\n" +
				"4.钢品编号为每个成品的实物编号，唯一可以重复。与现有的一些名称是同一个意思，例如南钢炉号等。对于没有实物编号的成品，建议统一规则进行编号。" + "\r\n" +
				"5.仓库储位层级按加工配送部现有生产统计的编码方式进行填入（参照仓库储区基础参数资料）。" + "\r\n" +
				"6.南钢订单号、项次号按实际信息填入。销售合同号、项次号为库存中已指定合同的存货填入对于合同号信息，方便提单发货，也可期初开账后，在系统中挑选库存进行挂合同操作，关联合同信息。" + "\r\n" +
				"7.入库日期格式为2018-10-01或者2018/10/01或者2018.10.01，注意年份为4位组成，月份为2位组成，日期为2位组成，不足位数需前面补0，需符合日历规则，不可出现超出日历范围的日期，例如2018-13-33。"+ "\r\n" +
				"8.货源填入范例（不局限于范例）：南钢板材事业部、南钢特钢事业部、南钢中厚板厂、南钢宽厚板厂、南钢中板厂。" + "\r\n" +
				"9.质量信息填入范例（不局限于范例）：正品、协议品、次品、不合格品、废品。" + "\r\n" +
				"10.尺寸信息填入范例（不局限于范例）：二切边、四切边、毛边。" + "\r\n" +
				"11.计价方式填入且局限于以下范例：数量、重量。" + "\r\n" +
				"12.数量填入，按现场情况，可以确认的填入准确数量，不可确认的填入理论估算数量，计价方式为数量的资料，必须为准确数量。" + "\r\n" +
				"13.理重、净重，按现场情况，理重为必填栏位，净重按现场习惯，可先用理重统计到系统（系统也可发货称重时进行修改调整）。" + "\r\n" +
				"14.库存期初数据请从第3行开始填入，系统从第3行开始导入期初数据。");
		// 6.将单元格加入样式
		cell.setCellStyle(style1);

		//sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
		// 写列标题
		String[] titles = { "钢品编号","仓库","储位","层级"+ "\r\n" +"001-999","南钢订单号","南钢项次号", "销售合同号","销售项次号", "入库日期"+ "\r\n" +"2018-10-01"+ "\r\n" +"2018/10/01"+ "\r\n" +"2018.10.01","货源","外观","生产类型","品名","材质","规格","厚","宽","长","内径","外径","质量信息","尺寸信息","计价方式","数量","理重(t)","净重(t)"};
		// 创建列标题行
		HSSFRow row2 = sheet.createRow(17);
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
	//原料
	public static void exportia090a(ServletOutputStream out)

			throws Exception {
		// 1.创建工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// workbook.set
		// 1.1创建合并单元格
		CellRangeAddress cra = new CellRangeAddress(0, 15, 0, 15);

		// 1.2创建标题样式
		HSSFCellStyle style1 = createStyle(workbook, 10);
		// 1.3创建列标题样式
		HSSFCellStyle style2 = createStyle(workbook, 10);
		// 1.3创建特殊列标题样式
		// HSSFCellStyle style3 = createStyle(workbook,
		// 12,HSSFColor.SKY_BLUE.index);
		// 2.创建工作表
		HSSFSheet sheet = workbook.createSheet("原料");

		// 设置默认列宽
		sheet.setDefaultColumnWidth(15);
		// 2.1将合并单元格作用于sheet
		sheet.addMergedRegion(cra);
		// 3.创建行
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格
		HSSFCell cell = row.createCell(0);
		// 5.向单元格写入数据
		cell.setCellValue("原料库存期初模板说明："+ "\r\n" +
				"1.钢品编号、仓库、储位、外观、生产类型、品名、计价方式、数量、重量（标记红色的栏位）为必须填写的栏位。"+ "\r\n" +
				"2.材质、规格、厚、宽、长、内径、外径、净重（标记蓝色的栏位）为按照实际情况进行选填的栏位，例如有明确的厚、宽、长、内径、外径时，需填写厚/宽/长/外径/内径，规格栏位不填写；否则如为混规时，只在规格栏位填入混规，厚/宽/长/外径/内径不填。材质根据实际情况，有材质的填入，没有材质的不填。"+ "\r\n" +
				"3.其它栏位为非必填栏位，如果现有资料已有对应信息，则希望能够详细填写，请评估好工作量，选择填入。"+ "\r\n" +
				"4.钢品编号为每个成品的实物编号，唯一可以重复。与现有的一些名称是同一个意思，例如南钢炉号等。对于没有实物编号的成品，建议统一规则进行编号。"+ "\r\n" +
				"5.仓库储位层级按加工配送部现有生产统计的编码方式进行填入（参照仓库储区基础参数资料）。"+ "\r\n" +
				"6.南钢订单号、项次号按实际信息填入。采购合同号、项次号为库存中已指定合同的存货填入对于合同号信息，用于关联采购信息。"+ "\r\n" +
				"7.入库日期格式为2018-10-01或者2018/10/01或者2018.10.01，注意年份为4位组成，月份为2位组成，日期为2位组成，不足位数需前面补0，需符合日历规则，不可出现超出日历范围的日期，例如2018-13-33。"+ "\r\n" +
				"8.货源填入范例（不局限于范例）：南钢板材事业部、南钢特钢事业部、南钢中厚板厂、南钢宽厚板厂、南钢中板厂。"+ "\r\n" +
				"9.质量信息填入范例（不局限于范例）：正品、协议品、次品、不合格品、废品。"+ "\r\n" +
				"10.尺寸信息填入范例（不局限于范例）：二切边、四切边、毛边。"+ "\r\n" +
				"11.计价方式填入且局限于以下范例：数量、重量。"+ "\r\n" +
				"12.数量填入，按现场情况，可以确认的填入准确数量，不可确认的填入理论估算数量，计价方式为数量的资料，必须为准确数量。"+ "\r\n" +
				"13.理重、净重，按现场情况，理重为必填栏位，净重按现场习惯，可先用理重统计到系统（系统也可发货称重时进行修改调整）。"+ "\r\n" +
				"14.库存期初数据请从第3行开始填入，系统从第3行开始导入期初数据。");
		// 6.将单元格加入样式
		cell.setCellStyle(style1);

		//sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
		// 写列标题
		String[] titles = { "钢品编号","仓库","储位","层级"+ "\r\n" +"001-999","南钢订单号","南钢项次号", "采购合同号","采购合同项次", "入库日期"+ "\r\n" +"2018-10-01"+ "\r\n" +"2018/10/01"+ "\r\n" +"2018.10.01","货源","外观","生产类型","品名","材质","规格","厚","宽","长","内径","外径","质量信息","尺寸信息","计价方式","数量","理重(t)","净重(t)"};
		// 创建列标题行
		HSSFRow row2 = sheet.createRow(16);
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
		//备品备件
		public static void exportia090b(ServletOutputStream out)

				throws Exception {
			// 1.创建工作薄
			HSSFWorkbook workbook = new HSSFWorkbook();
			// workbook.set
			// 1.1创建合并单元格
			CellRangeAddress cra = new CellRangeAddress(0, 4, 0, 15);

			// 1.2创建标题样式
			HSSFCellStyle style1 = createStyle(workbook, 10);
			// 1.3创建列标题样式
			HSSFCellStyle style2 = createStyle(workbook, 10);
			// 1.3创建特殊列标题样式
			// HSSFCellStyle style3 = createStyle(workbook,
			// 12,HSSFColor.SKY_BLUE.index);
			// 2.创建工作表
			HSSFSheet sheet = workbook.createSheet("备品备件库存");

			// 设置默认列宽
			sheet.setDefaultColumnWidth(15);
			// 2.1将合并单元格作用于sheet
			sheet.addMergedRegion(cra);
			// 3.创建行
			HSSFRow row = sheet.createRow(0);
			// 4.创建单元格
			HSSFCell cell = row.createCell(0);
			// 5.向单元格写入数据
			cell.setCellValue("备品备件库存期初模板说明："+ "\r\n" +
						"1.日期、供货单位、名称、型号、单位、数量、单价、总价（标记红色的栏位）为必须填写的栏位。"+ "\r\n" +
						"2.其它栏位为非必填栏位，如果现有资料已有对应信息，则希望能够详细填写，请评估好工作量，选择填入。"+ "\r\n" +
						"3.库存期初数据请从第3行开始填入，系统从第3行开始导入期初数据。");
			// 6.将单元格加入样式
			cell.setCellStyle(style1);

			//sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
			// 写列标题
			String[] titles = { "日期","供货单位","名称","型号","单位", "数量", "单价","总价","不含税金额","入库单号","备注"};
			// 创建列标题行
			HSSFRow row2 = sheet.createRow(5);
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
		//废钢
				public static void exportia090c(ServletOutputStream out)

						throws Exception {
					// 1.创建工作薄
					HSSFWorkbook workbook = new HSSFWorkbook();
					// workbook.set
					// 1.1创建合并单元格
					CellRangeAddress cra = new CellRangeAddress(0,5, 0, 15);

					// 1.2创建标题样式
					HSSFCellStyle style1 = createStyle(workbook, 10);
					// 1.3创建列标题样式
					HSSFCellStyle style2 = createStyle(workbook, 10);
					// 1.3创建特殊列标题样式
					// HSSFCellStyle style3 = createStyle(workbook,
					// 12,HSSFColor.SKY_BLUE.index);
					// 2.创建工作表
					HSSFSheet sheet = workbook.createSheet("废钢备件库存");

					// 设置默认列宽
					sheet.setDefaultColumnWidth(15);
					// 2.1将合并单元格作用于sheet
					sheet.addMergedRegion(cra);
					// 3.创建行
					HSSFRow row = sheet.createRow(0);
					// 4.创建单元格
					HSSFCell cell = row.createCell(0);
					// 5.向单元格写入数据
					cell.setCellValue("废钢库存期初模板说明："+ "\r\n" +
								"1.仓库、储位（标记红色的栏位）为必须填写的栏位。"+ "\r\n" +
								"2.其它栏位为非必填栏位，如果现有资料已有对应信息，则希望能够详细填写，请评估好工作量，选择填入。"+ "\r\n" +
								"3.仓库储位层级按加工配送部现有生产统计的编码方式进行填入（参照仓库储区基础参数资料）。"+ "\r\n" +
								"4.库存期初数据请从第3行开始填入，系统从第3行开始导入期初数据。");
					// 6.将单元格加入样式
					cell.setCellStyle(style1);

					//sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
					// 写列标题
					String[] titles = { "仓库","储位","重量(t)"};
					// 创建列标题行
					HSSFRow row2 = sheet.createRow(6);
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
				//辅助库存
				public static void exportia090d(ServletOutputStream out)

						throws Exception {
					// 1.创建工作薄
					HSSFWorkbook workbook = new HSSFWorkbook();
					// workbook.set
					// 1.1创建合并单元格
					CellRangeAddress cra = new CellRangeAddress(0, 4, 0, 15);

					// 1.2创建标题样式
					HSSFCellStyle style1 = createStyle(workbook, 10);
					// 1.3创建列标题样式
					HSSFCellStyle style2 = createStyle(workbook, 10);
					// 1.3创建特殊列标题样式
					// HSSFCellStyle style3 = createStyle(workbook,
					// 12,HSSFColor.SKY_BLUE.index);
					// 2.创建工作表
					HSSFSheet sheet = workbook.createSheet("辅助库存");

					// 设置默认列宽
					sheet.setDefaultColumnWidth(15);
					// 2.1将合并单元格作用于sheet
					sheet.addMergedRegion(cra);
					// 3.创建行
					HSSFRow row = sheet.createRow(0);
					// 4.创建单元格
					HSSFCell cell = row.createCell(0);
					// 5.向单元格写入数据
					cell.setCellValue("辅料库存期初模板说明："+ "\r\n" +
								"1.日期、供货单位、名称、型号、单位、数量、单价、总价（标记红色的栏位）为必须填写的栏位。"+ "\r\n" +
								"2.其它栏位为非必填栏位，如果现有资料已有对应信息，则希望能够详细填写，请评估好工作量，选择填入。"+ "\r\n" +
								"3.库存期初数据请从第3行开始填入，系统从第3行开始导入期初数据。");
					// 6.将单元格加入样式
					cell.setCellStyle(style1);

					//sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
					// 写列标题
					String[] titles = { "日期","供货单位","名称","型号","单位","数量","单价","总价","入库单号","备注"};
					// 创建列标题行
					HSSFRow row2 = sheet.createRow(5);
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
				//财务
				public static void exportia090e(ServletOutputStream out)

						throws Exception {
					// 1.创建工作薄
					HSSFWorkbook workbook = new HSSFWorkbook();
					// workbook.set
					// 1.1创建合并单元格
					CellRangeAddress cra = new CellRangeAddress(0, 4, 0, 15);

					// 1.2创建标题样式
					HSSFCellStyle style1 = createStyle(workbook, 10);
					// 1.3创建列标题样式
					HSSFCellStyle style2 = createStyle(workbook, 10);
					// 1.3创建特殊列标题样式
					// HSSFCellStyle style3 = createStyle(workbook,
					// 12,HSSFColor.SKY_BLUE.index);
					// 2.创建工作表
					HSSFSheet sheet = workbook.createSheet("财务期初模板");

					// 设置默认列宽
					sheet.setDefaultColumnWidth(15);
					// 2.1将合并单元格作用于sheet
					sheet.addMergedRegion(cra);
					// 3.创建行
					HSSFRow row = sheet.createRow(0);
					// 4.创建单元格
					HSSFCell cell = row.createCell(0);
					// 5.向单元格写入数据
					cell.setCellValue("加工配送财务期初模板说明："+ "\r\n" +
								"1.系统先导入生产库存期初，产出期初开账库存统计表（财务），提供给财务进行金额分摊，金额为财务必填栏位。"+ "\r\n" +
								"2.统计完成的期初开账库存统计表（财务），再导入系统进行期初开账。"+ "\r\n" +
								"3.系统从第3行开始导入期初数据。");
					// 6.将单元格加入样式
					cell.setCellStyle(style1);

					//sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
					// 写列标题
					String[] titles = { "料号","料别","规格","材质","用途","仓库","重量","金额"};
					// 创建列标题行
					HSSFRow row2 = sheet.createRow(5);
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
				

	public static String exportExcel2(HttpServletResponse response,
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
			exportia0011(out);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (out != null) {
			out.close();
		}
		return null;
	}

	public static void exportia0011(ServletOutputStream out)

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
		HSSFSheet sheet = workbook.createSheet("报支预算信息列表");

		// 设置默认列宽
		sheet.setDefaultColumnWidth(15);
		// 2.1将合并单元格作用于sheet
		sheet.addMergedRegion(cra);
		// 3.创建行
		HSSFRow row = sheet.createRow(0);
		// 4.创建单元格
		HSSFCell cell = row.createCell(0);
		// 5.向单元格写入数据
		cell.setCellValue("报支预算信息列表");
		// 6.将单元格加入样式
		cell.setCellStyle(style1);

		// 写列标题
		String[] titles = { "部门编码","费用部门","费用编码","费用项目","预算年月（xxxx-xx）", "预算金额", "已用预算","未用预算","预算使用比例" };
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
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
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