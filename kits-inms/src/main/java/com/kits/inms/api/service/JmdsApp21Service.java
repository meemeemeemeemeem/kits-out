package com.kits.inms.api.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kits.inms.api.entity.BaseResponse;
import com.kits.inms.api.url.JmdsApp21Url;
import com.kits.inms.bs.exception.ApiException;

@Service
public class JmdsApp21Service {
	private RestTemplate restTemplate = new RestTemplate();
	
	
	/********************三期系统调用********************/
	/**
     * 采购发票报账回写(同步请求)
     * @param req
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp31_to_jmdsApp21_P_invoice(Map<String, Object> req) throws ApiException {
        String url = JmdsApp21Url.AP_C2M_01;
        System.out.println(url);
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            //om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BaseResponse resp = om.readValue(result, BaseResponse.class);

            return resp;
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new ApiException(e.getMessage());
        }
    }
    
    /**
     * 销售发票开票回写(同步请求)
     * @param req
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp31_to_jmdsApp21_S_invoice(Map<String, Object> req) throws ApiException {
        String url = JmdsApp21Url.IV_C2M_01;
        System.out.println(url);
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            //om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BaseResponse resp = om.readValue(result, BaseResponse.class);

            return resp;
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new ApiException(e.getMessage());
        }
    }
	
	
	
}