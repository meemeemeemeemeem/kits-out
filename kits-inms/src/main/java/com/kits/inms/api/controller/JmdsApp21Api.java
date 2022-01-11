package com.kits.inms.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kits.inms.api.entity.BaseResponse;
import com.kits.inms.api.expection.CheckException;
import com.kits.inms.api.service.JmdsApp21Service;
import com.kits.inms.api.service.validate.App31To21Validate;
import com.kits.inms.bs.exception.ApiException;
import com.kits.itf.enhance.ApiLog;

/**
 * 金贸二期加工配送系统对外开放接口
 * @author zhangcheng
 */
@Controller
@RequestMapping("/api/jmdsApp21Api")
public class JmdsApp21Api {
	@Autowired
	private JmdsApp21Service service;
	/*三期系统调用二期加工配送系统参数验证*/
    @Autowired
	App31To21Validate app31To21Validate;
	
    
    /********************三期系统调用********************/
    /**
	 * 采购发票报账回写(同步请求)
	 * @param req
	 * @return
	 * @throws ApiException
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
	@ResponseBody
	@RequestMapping(value="/jmdsApp31_to_jmdsApp21_P_invoice", method=RequestMethod.POST)
	public BaseResponse<Map<String, Object>> jmdsApp31_to_jmdsApp21_P_invoice(@RequestBody Map<String, Object> req) throws ApiException {
		System.out.println("jmdsApp31_to_jmdsApp21_P_invoice ----------Start。。。。");
		System.out.println("arg ====" + req);
		System.out.println("jmdsApp31_to_jmdsApp21_P_invoice ----------End。。。。");
		try {
			app31To21Validate.pInvoiceValidate(req);
		} catch (CheckException ce) {
			ce.printStackTrace();
			return new BaseResponse(ce.getCode(), ce.getMessage());
		}
		return service.jmdsApp31_to_jmdsApp21_P_invoice(req);
	}
    
	/**
	 * 销售发票开票回写(同步请求)
	 * @param req
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
	@ResponseBody
	@RequestMapping(value="/jmdsApp31_to_jmdsApp21_S_invoice", method=RequestMethod.POST)
	public BaseResponse<Map<String, Object>> jmdsApp31_to_jmdsApp21_S_invoice(@RequestBody Map<String, Object> req) throws ApiException {
		System.out.println("jmdsApp31_to_jmdsApp21_S_invoice ----------Start。。。。");
		System.out.println("arg ====" + req);
		System.out.println("jmdsApp31_to_jmdsApp21_S_invoice ----------End。。。。");
		try {
			app31To21Validate.sInvoiceValidate(req);
		} catch (CheckException ce) {
			ce.printStackTrace();
			return new BaseResponse(ce.getCode(), ce.getMessage());
		}
		return service.jmdsApp31_to_jmdsApp21_S_invoice(req);
	}
	
	
	
}