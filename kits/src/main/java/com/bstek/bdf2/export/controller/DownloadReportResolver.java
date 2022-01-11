/*
 * 文件名: DownloadReportResolver.java
 * 版权：武汉英思博锐科技有限公司 Copyright © 2015
 * 描述：
 * 修改人：刘冰
 * 修改时间：2016-1-27
 * 修改单号：
 * 修改内容：
 */
package com.bstek.bdf2.export.controller;

import com.bstek.bdf2.export.utils.ExportUtils;
import com.bstek.dorado.core.Configure;
import com.bstek.dorado.web.resolver.AbstractResolver;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * DownloadReportResolver简述：com.bstek.bdf2.export.controller中文乱码处理
 * 
 * @author 刘冰
 * @version 2016年4月20日
 * @since
 */
public class DownloadReportResolver extends AbstractResolver {
	public String extensionFileType = Configure.getString("bdf2.export.extension.fileType");

	protected ModelAndView doHandleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		doDownloadReport(request, response);
		return null;
	}

	private void doDownloadReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginUserSessionKey = Configure.getString("bdf2.export.loginUserSessionKey");
		if (StringUtils.isNotEmpty(loginUserSessionKey)) {
			Object key = request.getSession().getAttribute(loginUserSessionKey);
			if (key == null) {
				processError(request, response, "request error,please login!");
				return;
			}
		}
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		System.out.println("导出的文件名为："+name); //跟踪使用，后期删除
		
		// 中文乱码转换处理------------------Start-------------
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(name); //校验文件名中是否包含中文
		if (!m.find()) {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		}
		// 中文乱码转换处理------------------End-------------

		if ((!StringUtils.isNotEmpty(id)) || (!id.matches("[a-z0-9-]+"))) {
			processError(request, response, "request parameter id error");
			return;
		}
		String type = "";
		if (StringUtils.isNotEmpty(this.extensionFileType)) {
			type = "|" + this.extensionFileType;
		}
		if ((!StringUtils.isNotEmpty(name))
				|| (!name.matches("[^/\\\\?<>*:\"|]+(\\.(xls|xlsx|pdf|csv" + type + "))$"))) {
			processError(request, response, "request parameter name error");
			return;
		}
		String fileName = id + "_" + name;
		String location = ExportUtils.getFileStorePath();
		File file = new File(location, fileName);
		if ((!file.exists()) || (!file.isFile())) {
			// processError(request, response, "request file error");
			processError(request, response, "文件导出失败！");

			return;
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Server", "http://www.bstek.com");
		response.setContentType("application/octet-stream;charset=utf-8");
		response.setHeader("Connection", "close");
		response.setHeader("Accept-Ranges", "bytes");
		name = URLEncoder.encode(name, "UTF-8");
		name = name.replaceAll("\\+", "%20");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + name + "\";filename*=utf-8''" + name + "");
		FileInputStream input = null;
		OutputStream out = null;
		try {
			input = new FileInputStream(file);
			out = response.getOutputStream();
			IOUtils.copy(input, out);
			out.flush();
		} finally {
			IOUtils.closeQuietly(input);
			IOUtils.closeQuietly(out);
			if (file != null)
				deletePreviousDayTempFile();
		}
	}

	private void deletePreviousDayTempFile() throws IOException {
		String location = ExportUtils.getFileStorePath();
		File file = new File(location);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				long time = f.lastModified();
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(time);
				Calendar last = Calendar.getInstance();
				last.add(5, -1);
				if (cal.before(last))
					f.delete();
			}
		}
	}

	private void processError(HttpServletRequest request, HttpServletResponse response, String message)
			throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(message);
		out.flush();
		out.close();
	}
}
