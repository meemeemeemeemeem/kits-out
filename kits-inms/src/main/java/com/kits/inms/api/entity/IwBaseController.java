package com.kits.inms.api.entity;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"unused","serial"})
public class IwBaseController implements Serializable {
    protected static final Logger logger = LoggerFactory.getLogger(IwBaseController.class);
    
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	/**
	 * 执行处理方法，处理特殊情况（定义个空方法）
	 * @param request
	 * @param response
	 */
	private void execute() {}
	

	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	
	
}