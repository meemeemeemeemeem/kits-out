package com.kits.inms.api.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kits.inms.api.entity.BaseResponse;
import com.kits.inms.api.entity.FdDeliveryRequest;
import com.kits.inms.api.url.JmdsApp31Url;
import com.kits.inms.bs.exception.ApiEnum;
import com.kits.inms.bs.exception.ApiException;
import com.kits.itf.enhance.ExceptionLog;

@Service
public class JmdsApp31Service {
	private RestTemplate restTemplate = new RestTemplate();
	
	
	/********************调试测试用********************/
	/**
	 * 
	 * @param req
	 * @param appkey
	 * @param requestid
	 * @return
	 */
	@Async
	@ExceptionLog
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseResponse<Map<String, Object>> jmdsApp11_To_JmdsApp31_P_ContractInfo(Map<String, Object> req, String appkey, String requestid) {
		String url = JmdsApp31Url.TRADE_AP_01+"?appkey="+ appkey +"&requestid="+ requestid;
    	//LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        	
    	ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
    	String result = responseEntity.getBody();
    	//LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);
    	
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		BaseResponse resp = null;
		try {
			resp = om.readValue(result, BaseResponse.class);
		} catch (Exception e) {
			//log.error(e.getMessage(), e);
			e.printStackTrace();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			//return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
			//throw new ApiException(ApiEnum.PARAMETER_MISS_OR_TYPEERROR_CODE);
		}
		return resp;
	}
	
	/**
	 * 
	 * @param req
	 * @param appkey
	 * @param requestid
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseResponse<Map<String, Object>> jmdsApp11_To_JmdsApp31_P_ContractClose(Map<String, Object> req, String appkey, String requestid) throws ApiException {
		String url = JmdsApp31Url.TRADE_AP_01+"?appkey="+ appkey +"&requestid="+ requestid;
    	//LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        
		try {
	    	ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
	    	String result = responseEntity.getBody();
	    	//LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);
	    	
			ObjectMapper om = new ObjectMapper();
			om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			BaseResponse resp = om.readValue(result, BaseResponse.class);
			
			return resp;
		} catch (Exception e) {
			//log.error(e.getMessage(), e);
			e.printStackTrace();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new ApiException(e.getMessage());
		}
	}

    
	/********************一期供应链调用********************/
	/**
     *(异步请求改为同步)采购合同信息
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    //@Async
    //@ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_To_JmdsApp31_P_Contract(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.TRADE_AP_03+"?appkey="+ appkey +"&requestid="+ requestid;
        System.out.println(url);
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BaseResponse resp = om.readValue(result, BaseResponse.class);

            return resp;
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            throw new ApiException(e.getMessage());
        }
    }

    /**
     *(同步请求)采购合同结案
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_To_JmdsApp31_P_ContractCs(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.TRADE_AP_04+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
	 * (同步请求改为异步)采购入库
	 * @param req
	 * @param appkey
	 * @param requestid
	 * @return
	 * @throws ApiException 
	 */
    @Async
    @ExceptionLog
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseResponse<Map<String, Object>> jmdsApp11_To_JmdsApp31_P_Storage(Map<String, Object> req, String appkey, String requestid) throws ApiException {
		String url = JmdsApp31Url.TRADE_AP_05+"?appkey="+ appkey +"&requestid="+ requestid;
		System.out.println(url);
    	//LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        BaseResponse resp = null;
		try {
	    	ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
	    	String result = responseEntity.getBody();
	    	//LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);
	    	
			ObjectMapper om = new ObjectMapper();
			om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			resp = om.readValue(result, BaseResponse.class);
		} catch (Exception e) {
			//log.error(e.getMessage(), e);
			e.printStackTrace();
			//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			//return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
			//throw new ApiException(e.getMessage());
		}
        return resp;
	}

	/**
	 * (异步请求)采购运费结算
	 * @param req
	 * @param appkey
	 * @param requestid
	 * @return
	 */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_P_carriage(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_AP_06+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
        String result = responseEntity.getBody();
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BaseResponse resp = null;
        try {
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //	throw new ApiException(ApiEnum.PARAMETER_MISS_OR_TYPEERROR_CODE);
        }
        return resp;
    }

    /**
     * (异步请求)采购结算调整
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_P_settlement(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_AP_07+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
        String result = responseEntity.getBody();
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BaseResponse resp = null;
        try {
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //	throw new ApiException(ApiEnum.PARAMETER_MISS_OR_TYPEERROR_CODE);
        }
        return resp;
    }

    /**
     * (同步请求)销售合同信息
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_contractInfo(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.TRADE_AR_01+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * (同步请求)销售合同结案
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_contractClose(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.TRADE_AR_01+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * (同步请求)销售合同信息
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_contract(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.TRADE_AR_04+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * (同步请求)销售合同结案
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_contractCs(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.TRADE_AR_05+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * (同步请求)销售提单
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_lading(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.TRADE_AR_06+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * (同步请求)销售提单货齐
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_ladingComplete(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.TRADE_AR_06LC+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * (同步请求改为异步)销售结算
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_storage(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.TRADE_AR_07+"?appkey="+ appkey +"&requestid="+ requestid;
        System.out.println(url);
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        BaseResponse resp = null;
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //throw new ApiException(e.getMessage());
        }
        return resp;
    }

    /**
     * (异步请求)销售运费结算
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_carriage(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_AR_08+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
        String result = responseEntity.getBody();
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BaseResponse resp = null;
        try {
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //	throw new ApiException(ApiEnum.PARAMETER_MISS_OR_TYPEERROR_CODE);
        }
        return resp;
    }

    /**
     * (异步请求)销售结算调整
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_settlement(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_AR_09+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
        String result = responseEntity.getBody();
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BaseResponse resp = null;
        try {
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //	throw new ApiException(ApiEnum.PARAMETER_MISS_OR_TYPEERROR_CODE);
        }
        return resp;
    }

    /**
     * (同步请求改为异步)盘盈盘亏
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_I_profitAndLoss(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.TRADE_MP_0+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        BaseResponse resp = null;
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //throw new ApiException(e.getMessage());
        }
        return resp;
    }

    /**
     * (异步请求)库存调拨（调出）
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_I_transferOut(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_MP_1+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
        String result = responseEntity.getBody();
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BaseResponse resp = null;
        try {
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //	throw new ApiException(ApiEnum.PARAMETER_MISS_OR_TYPEERROR_CODE);
        }
        return resp;
    }

    /**
     * (异步请求)库存调拨（调入）
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_I_transferIn(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_MP_2+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
        String result = responseEntity.getBody();
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BaseResponse resp = null;
        try {
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //	throw new ApiException(ApiEnum.PARAMETER_MISS_OR_TYPEERROR_CODE);
        }
        return resp;
    }

    /**
     * (异步请求)物资调整
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_I_adjustment(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_MP_3+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
        String result = responseEntity.getBody();
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BaseResponse resp = null;
        try {
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //	throw new ApiException(ApiEnum.PARAMETER_MISS_OR_TYPEERROR_CODE);
        }
        return resp;
    }

    /**
     * (异步请求)翻包/切割
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_I_split(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_MP_4+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
        String result = responseEntity.getBody();
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BaseResponse resp = null;
        try {
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //	throw new ApiException(ApiEnum.PARAMETER_MISS_OR_TYPEERROR_CODE);
        }
        return resp;
    }

    /**
     * (异步请求)品名相关信息接口
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_I_goodsName(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_MP_5+"?appkey="+ appkey +"&requestid="+ requestid;
        System.out.println(url);
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
        String result = responseEntity.getBody();
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);
        
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BaseResponse resp = null;
        try {
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //	throw new ApiException(ApiEnum.PARAMETER_MISS_OR_TYPEERROR_CODE);
        }
        return resp;
    }

    /**
     * (异步请求)仓储结算接口
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_storageSettlement(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_MP_6+"?appkey="+ appkey +"&requestid="+ requestid;
        System.out.println(url);
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
        String result = responseEntity.getBody();
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);
        
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BaseResponse resp = null;
        try {
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //throw new ApiException(ApiEnum.PARAMETER_MISS_OR_TYPEERROR_CODE);
        }
        return resp;
    }
    
    
    /********************一期电商调用********************/
    /**
     * (异步请求)采购订单（挂网销售）电商订单
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @Async
    @ExceptionLog
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp12_to_jmdsApp31_S_contract(FdDeliveryRequest req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_E_AR_06+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
        String result = responseEntity.getBody();
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BaseResponse resp = null;
        try {
            resp = om.readValue(result, BaseResponse.class);
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //throw new ApiException(e.getMessage());
        }
        return resp;
    }

    /**
     * (同步请求)电商出金
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp12_to_jmdsApp31_S_refund(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_E_AR_07+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        System.out.println(url);
        
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BaseResponse resp = om.readValue(result, BaseResponse.class);

            return resp;
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //throw new ApiException(e.getMessage());
        }
    }

    /**
     * (同步请求)电商入金
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp12_to_jmdsApp31_S_b2bDeposit(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_E_AR_08+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BaseResponse resp = om.readValue(result, BaseResponse.class);

            return resp;
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //throw new ApiException(e.getMessage());
        }
    }

    /**
     * (同步请求)资金查询
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp12_to_jmdsApp31_S_getFund(Map<String, Object> req, String appkey, String requestid) {
        String url = JmdsApp31Url.TRADE_E_AR_09+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BaseResponse resp = om.readValue(result, BaseResponse.class);

            return resp;
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new BaseResponse(ApiEnum.CLASS_CAST_CODE.code(), "响应数据映射或转换失败！");
            //throw new ApiException(e.getMessage());
        }
    }
    
    
    /********************二期加工配送调用********************/
    /**
     * 采购入库/结算
     * (同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_P_settlement(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.C2M_IV_03+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * 原料采购合同/原料运杂费合同/物料采购合同/其他合同接口
     * (同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_P_contractInfo(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.C2M_IV_05+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);
        System.out.println("url===" + url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);
            System.out.println("result===" + result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BaseResponse resp = om.readValue(result, BaseResponse.class);
            System.out.println("resp===" + resp);

            return resp;
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new ApiException(e.getMessage());
        }
    }
    
    /**
     * 采购合同结案
     * (同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_P_contractClose(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.C2M_IV_06+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * 销售实提结算
     * (同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_S_settlement(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.C2M_AR_04+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * 销售合同
     * (同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_S_contractInfo(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.C2M_AR_06+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * 销售合同结案
     * (同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_S_contractClose(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.C2M_AR_07+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * 销售提单
     * (同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_S_lading(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.C2M_AR_08+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * 物料领料/物料报废
     * (同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_M_productionUse(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.C2M_M_01+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * 成本核算结转
     * (同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_C_accounting(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.C2M_M_02+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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
     * 通用凭证处理 (同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_F_voucher(Map<String, Object> req, String appkey, String requestid) throws ApiException {
        String url = JmdsApp31Url.C2M_GL_07+"?appkey="+ appkey +"&requestid="+ requestid;
        //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "url", url);

        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, req, String.class);
            String result = responseEntity.getBody();
            //LogTool.logInfo("CallBankServiceImpl", "externalAcceptanceBillToBank", "response", result);

            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            BaseResponse resp = om.readValue(result, BaseResponse.class);

            return resp;
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new ApiException(e.getMessage());
        }
    }
    
    
    /********************二期电商调用********************/
    
    
    
    
}