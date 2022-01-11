package com.kits.inms.api.controller;

import java.util.List;
import java.util.Map;

import com.kits.inms.api.expection.CheckException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kits.inms.api.entity.BaseResponse;
import com.kits.inms.api.service.JmdsApp12Service;
import com.kits.inms.api.service.validate.App31To12Validate;
import com.kits.inms.bs.exception.ApiException;
import com.kits.itf.enhance.ApiLog;

/**
 * 金贸一期电商系统对外开放接口
 * @author zhangcheng
 */
@Controller
@RequestMapping("/api/jmdsApp12Api")
public class JmdsApp12Api {
	@Autowired
	private JmdsApp12Service service;
	/*三期系统调用一期电商系统参数验证*/
    @Autowired
	App31To12Validate app31To12Validate;
	
    
    /********************调试测试用********************/
	/**
	 * (同步请求)
	 * @param req
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings("unchecked")
	@ApiLog
	@ResponseBody
	@RequestMapping(value="/invoiceInfoSynchronization", method=RequestMethod.POST)
	//public BaseResponse<Map<String, Object>> app31_To_App12_InvoiceInfoSynchronization(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
	public BaseResponse<Map<String, Object>> app31_To_App12_InvoiceInfoSynchronization(@RequestBody Map<String, Object> req) throws ApiException {
		//return service.app31_To_App12_InvoiceInfoSynchronization(req, appkey, requestid);
		return service.app31_To_App12_InvoiceInfoSynchronization(req);
	}
	
	
	/********************三期系统调用********************/
	/**
	 * 销售发票反填(同步请求)
	 * @param req
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings("unchecked")
	@ApiLog
	@ResponseBody
	@RequestMapping(value="/jmdsApp31_to_jmdsApp12_S_invoice", method=RequestMethod.POST)
	public BaseResponse<Map<String, Object>> jmdsApp31_to_jmdsApp12_S_invoice(@RequestBody Map<String, Object> req) throws ApiException {
		System.out.println("jmdsApp31_to_jmdsApp12_S_invoice ----------Start。。。。");
		System.out.println("arg ====" + req);
		System.out.println("jmdsApp31_to_jmdsApp12_S_invoice ----------End。。。。");
		try {
			app31To12Validate.sInvoiceValidate(req);
		} catch (CheckException ce) {
			ce.printStackTrace();
			return new BaseResponse(ce.getCode(), ce.getMessage());
		}
		return service.jmdsApp31_to_jmdsApp12_S_invoice(req);
	}

	/**
	 * 电商入金(同步请求)
	 * @param req
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings("unchecked")
	@ApiLog
	@ResponseBody
	@RequestMapping(value="/jmdsApp31_to_jmdsApp12_S_deposit", method=RequestMethod.POST)
	public BaseResponse<Map<String, Object>> jmdsApp31_to_jmdsApp12_S_deposit(@RequestBody Map<String, Object> req) throws ApiException {
		System.out.println("jmdsApp31_to_jmdsApp12_S_deposit ----------Start。。。。");
		System.out.println("arg ====" + req);
		System.out.println("jmdsApp31_to_jmdsApp12_S_deposit ----------End。。。。");
		try {
			app31To12Validate.sDepositValidate(req);
		} catch (CheckException ce) {
			ce.printStackTrace();
			return new BaseResponse(ce.getCode(), ce.getMessage());
		}
		return service.jmdsApp31_to_jmdsApp12_S_deposit(req);
	}

	/**
	 * 提单货齐(同步请求)
	 * @param req
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings("unchecked")
	@ApiLog
	@ResponseBody
	@RequestMapping(value="/jmdsApp31_to_jmdsApp12_S_ladingComplete", method=RequestMethod.POST)
	//public BaseResponse<Map<String, Object>> jmdsApp31_to_jmdsApp12_S_ladingComplete(@RequestBody Map<String, Object> req) throws ApiException {
	public BaseResponse<Map<String, Object>> jmdsApp31_to_jmdsApp12_S_ladingComplete(@RequestBody List<Map<String, Object>> req) throws ApiException {
		System.out.println("jmdsApp31_to_jmdsApp12_S_ladingComplete ----------Start。。。。");
		System.out.println("arg ====" + req);
		System.out.println("jmdsApp31_to_jmdsApp12_S_ladingComplete ----------End。。。。");
		try {
			app31To12Validate.sLadingCompleteValidate(req);
		} catch (CheckException ce) {
			ce.printStackTrace();
			return new BaseResponse(ce.getCode(), ce.getMessage());
		}
		return service.jmdsApp31_to_jmdsApp12_S_ladingComplete(req);
	}
	
	
	
}