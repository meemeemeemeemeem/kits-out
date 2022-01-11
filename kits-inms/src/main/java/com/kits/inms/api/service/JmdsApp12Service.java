package com.kits.inms.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kits.inms.api.entity.BaseResponse;
import com.kits.inms.api.url.JmdsApp12Url;
import com.kits.inms.api.utils.Send;
import com.kits.inms.bs.exception.ApiException;

@Service
public class JmdsApp12Service {
	//private RestTemplate restTemplate = new RestTemplate();
	
	
	/********************调试测试用********************/
	/**
	 * (同步请求)
	 * @param req
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings({ "rawtypes" })
	//public BaseResponse<Map<String, Object>> app31_To_App12_InvoiceInfoSynchronization(Map<String, Object> req, String appkey, String requestid) throws ApiException {
	public BaseResponse app31_To_App12_InvoiceInfoSynchronization(Map<String, Object> req) throws ApiException {
		//String url = JmdsApp12Url.IV_TRADE_E_01+"?appkey="+ appkey +"&requestid="+ requestid;
		String url = JmdsApp12Url.IV_TRADE_E_01;
    	//LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        
		/*
		try {
	    	ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
	    	String result = responseEntity.getBody();
	    	//LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);
	    	
			ObjectMapper om = new ObjectMapper();
			BaseResponse resp = om.readValue(result, BaseResponse.class);
			
			return resp;
		} catch (Exception e) {
			//log.error(e.getMessage(), e);
			e.printStackTrace();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ApiException(e.getMessage());
		}
		*/
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		data.add(req);
		return Send.send(data, url);
	}
	
	
	/********************三期系统调用********************/
	/**
	 * 销售发票反填:开票信息同步(同步请求)
	 * @param req
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings({ "rawtypes" })
	//public BaseResponse<Map<String, Object>> app31_To_App12_InvoiceInfoSynchronization(Map<String, Object> req, String appkey, String requestid) throws ApiException {
	public BaseResponse jmdsApp31_to_jmdsApp12_S_invoice(Map<String, Object> req) throws ApiException {
		String url = JmdsApp12Url.IV_TRADE_E_01;
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		data.add(req);
		return Send.send(data, url);
	}

	/**
	 * 电商入金(同步请求)
	 * @param req
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings({ "rawtypes" })
	//public BaseResponse<Map<String, Object>> app31_To_App12_InvoiceInfoSynchronization(Map<String, Object> req, String appkey, String requestid) throws ApiException {
	public BaseResponse jmdsApp31_to_jmdsApp12_S_deposit(Map<String, Object> req) throws ApiException {
		String url = JmdsApp12Url.IV_TRADE_E_02;
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		data.add(req);
		return Send.send(data, url);
	}

	/**
	 * 提单货齐(同步请求)
	 * @param req
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings({ "rawtypes" })
	//public BaseResponse jmdsApp31_to_jmdsApp12_S_ladingComplete(Map<String, Object> req) throws ApiException {
	public BaseResponse jmdsApp31_to_jmdsApp12_S_ladingComplete(List<Map<String, Object>> req) throws ApiException {
		String url = JmdsApp12Url.AR_TRADE_E_01;
		return Send.send(req, url);
	}
	
	
	
}