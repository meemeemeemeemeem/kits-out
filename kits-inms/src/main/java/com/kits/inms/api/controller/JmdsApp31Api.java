package com.kits.inms.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bstek.dorado.core.Configure;
import com.kits.inms.api.entity.BaseModel;
import com.kits.inms.api.entity.BaseResponse;
import com.kits.inms.api.entity.FdDeliveryRequest;
import com.kits.inms.api.entity.IwBaseController;
import com.kits.inms.api.expection.CheckException;
import com.kits.inms.api.service.JmdsApp31Service;
import com.kits.inms.api.service.validate.App11To31Validate;
import com.kits.inms.api.service.validate.App12To31Validate;
import com.kits.inms.api.service.validate.App21To31Validate;
import com.kits.inms.api.utils.HttpClientUtils;
import com.kits.inms.bs.exception.ApiEnum;
import com.kits.inms.bs.exception.ApiException;
import com.kits.itf.enhance.ApiLog;

/**
 * 金贸三期财务系统对外开放接口
 * @author zhangcheng
 */
@SuppressWarnings("serial")
@Controller
@RequestMapping("/api/jmdsApp31Api")
public class JmdsApp31Api extends IwBaseController {
    @Autowired
    private JmdsApp31Service service;
    /*一期供应链系统调用三期系统参数验证*/
    @Autowired
	App11To31Validate app11To31Validate;
    /*一期电商系统调用三期系统参数验证*/
    @Autowired
	App12To31Validate app12To31Validate;
    /*二期加工配送系统调用三期系统参数验证*/
    @Autowired
	App21To31Validate app21To31Validate;
    /*一期电商key值*/
    public static final String ENCRYPT_KEY = Configure.getString("inms.jmdsApp12.key");
    /*一期电商调用三期接口参数appkey值*/
    public static final String APPKEY = "jmdsApp12";
    /*调用三期接口参数requestid值*/
    public String getRequestid() {
    	return UUID.randomUUID().toString();
    }
    
    
    /********************调试测试用********************/
    /**
     * (异步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @ApiLog
    @ResponseBody
    @RequestMapping(value = "/pContractInfo", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_To_JmdsApp31_P_ContractInfo(@RequestBody Map<String, Object> req, String appkey, String requestid) {
        service.jmdsApp11_To_JmdsApp31_P_ContractInfo(req, appkey, requestid);

        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * (同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @ApiLog
    @ResponseBody
    @RequestMapping(value = "/pContractClose", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_To_JmdsApp31_P_ContractClose(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        return service.jmdsApp11_To_JmdsApp31_P_ContractClose(req, appkey, requestid);
    }
    
    
    /********************一期供应链调用********************/
    /**
     * 采购合同信息(异步请求改为同步)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_P_contractInfo", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_To_JmdsApp31_P_Contract(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
    	System.out.println("jmdsApp11_to_jmdsApp31_P_contractInfo ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_P_contractInfo ----------End。。。。");
        try {
			app11To31Validate.pContractInfoValidate(req);
		} catch (CheckException ce) {
			ce.printStackTrace();
			return new BaseResponse(ce.getCode(), ce.getMessage());
		}
        return service.jmdsApp11_To_JmdsApp31_P_Contract(req, appkey, requestid);
        
        //状态码(code):200	描述(msg):操作成功！
        //return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * 采购合同结案(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_P_contractClose", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_To_JmdsApp31_P_ContractCs(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_To_JmdsApp31_P_ContractCs ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_To_JmdsApp31_P_ContractCs ----------End。。。。");
        try {
            app11To31Validate.pContractCloseValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        return service.jmdsApp11_To_JmdsApp31_P_ContractCs(req, appkey, requestid);
    }

    /**
     * 采购入库(同步请求改为异步)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException 
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_P_storage", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_To_JmdsApp31_P_Sg(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_P_storage ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_P_storage ----------End。。。。");
        try {
            app11To31Validate.pStorageValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_To_JmdsApp31_P_Storage(req, appkey, requestid);

        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * 采购运费结算(异步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_P_carriage", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_P_carriage(@RequestBody Map<String, Object> req, String appkey, String requestid) {
        System.out.println("jmdsApp11_to_jmdsApp31_P_carriage ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_P_carriage ----------End。。。。");
        try {
            app11To31Validate.pCarriageValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_to_jmdsApp31_P_carriage(req, appkey, requestid);
        
        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * 采购结算调整（补差）(异步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_P_settlement", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_P_settlement(@RequestBody Map<String, Object> req, String appkey, String requestid) {
        System.out.println("jmdsApp11_to_jmdsApp31_P_settlement ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_P_settlement ----------End。。。。");
        try {
            app11To31Validate.pSettlementValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_to_jmdsApp31_P_settlement(req, appkey, requestid);
        
        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * 销售合同信息(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_S_contractInfo", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_contract(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_S_contract ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_S_contract ----------End。。。。");
        try {
            app11To31Validate.sContractInfoValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }

        return service.jmdsApp11_to_jmdsApp31_S_contract(req, appkey, requestid);
    }

    /**
     * 销售合同结案(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_S_contractClose", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_contractCs(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_S_contractCs ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_S_contractCs ----------End。。。。");
        try {
            app11To31Validate.sContractCloseValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }

        return service.jmdsApp11_to_jmdsApp31_S_contractCs(req, appkey, requestid);
    }

    /**
     * 销售提单(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_S_lading", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_lade(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_S_lading ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_S_lading ----------End。。。。");
        try {
            app11To31Validate.sLadingValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        return service.jmdsApp11_to_jmdsApp31_S_lading(req, appkey, requestid);
    }
    
    /**
     * 销售提单货齐(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_S_ladingComplete", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_ladingComplete(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_S_ladingComplete ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_S_ladingComplete ----------End。。。。");
        try {
            app11To31Validate.sLadingCompleteValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        return service.jmdsApp11_to_jmdsApp31_S_ladingComplete(req, appkey, requestid);
    }

    /**
     * 销售结算(同步请求改为异步)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_S_storage", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_storag(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_S_storage ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_S_storage ----------End。。。。");
        try {
            app11To31Validate.sStorageValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_to_jmdsApp31_S_storage(req, appkey, requestid);

        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * 销售运费结算(异步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_S_carriage", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_carriage(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_S_carriage ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_S_carriage ----------End。。。。");
        try {
            app11To31Validate.sCarriageValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_to_jmdsApp31_S_carriage(req, appkey, requestid);
        
        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);

    }

    /**
     * 销售结算调整(异步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_S_settlement", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_settlement(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_S_settlement ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_S_settlement ----------End。。。。");
        try {
            app11To31Validate.sSettlementValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_to_jmdsApp31_S_settlement(req, appkey, requestid);
        
        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * 同步库存盘盈盘亏(同步请求改为异步)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_I_profitAndLoss", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_I_profitAndLoss(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_I_profitAndLoss ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_I_profitAndLoss ----------End。。。。");
        try {
            app11To31Validate.iProfitAndLossValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_to_jmdsApp31_I_profitAndLoss(req, appkey, requestid);

        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * 库存调拨（调出）(异步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_I_transferOut", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_I_transferOut(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_I_transferOut ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_I_transferOut ----------End。。。。");
        try {
            app11To31Validate.iTransferOutValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_to_jmdsApp31_I_transferOut(req, appkey, requestid);
        
        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * 库存调拨（调入）(异步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_I_transferIn", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_I_transferIn(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_I_transferIn ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_I_transferIn ----------End。。。。");
        try {
            app11To31Validate.iTransferInValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_to_jmdsApp31_I_transferIn(req, appkey, requestid);
        
        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * 物资调整(异步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_I_adjustment", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_I_adjustment(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_I_adjustment ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_I_adjustment ----------End。。。。");
        try {
            app11To31Validate.iAdjustmentValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_to_jmdsApp31_I_adjustment(req, appkey, requestid);
        
        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * 翻包/切割(异步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_I_split", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_I_split(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_I_split ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_I_split ----------End。。。。");
        try {
            app11To31Validate.iSplitValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_to_jmdsApp31_I_split(req, appkey, requestid);
        
        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * 品名相关信息接口(异步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_I_goodsName", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_I_goodsName(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_I_goodsName ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_I_goodsName ----------End。。。。");
        try {
            app11To31Validate.iGoodsNameValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_to_jmdsApp31_I_goodsName(req, appkey, requestid);
        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }

    /**
     * 仓储结算接口(异步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp11_to_jmdsApp31_S_storageSettlement", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp11_to_jmdsApp31_S_storageSettlement(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp11_to_jmdsApp31_S_storageSettlement ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp11_to_jmdsApp31_S_storageSettlement ----------End。。。。");
        try {
            app11To31Validate.sStorageSettlementValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        service.jmdsApp11_to_jmdsApp31_S_storageSettlement(req, appkey, requestid);
        //状态码(code):200	描述(msg):操作成功！
        return new BaseResponse(ApiEnum.SUCCESSFUL);
    }
    
    
    /********************一期电商调用********************/
    /**
     * 采购订单（挂网销售）电商订单(异步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     */
    @SuppressWarnings({ "unchecked" })
    @ApiLog
    @RequestMapping(value = "/jmdsApp12_to_jmdsApp31_S_contract", method = RequestMethod.POST)
    public void jmdsApp12_to_jmdsApp31_S_contract(HttpServletRequest request1, HttpServletResponse response1) {
    	//1.读取请求数据流
        List<FdDeliveryRequest> reqList = (List<FdDeliveryRequest>) HttpClientUtils.read(request1, ENCRYPT_KEY, FdDeliveryRequest.class);
        
        List<BaseModel> results = new ArrayList<BaseModel>();//响应数据
        //2.1如果请求数据为空，则发送响应反馈
        if (reqList==null || reqList.size()==0) {
            HttpClientUtils.writeObject(response1, results, ENCRYPT_KEY);
        //2.2如果请求数据不为空，则进行业务处理后发送响应反馈  
        }else {
        	//2.2-1业务处理并组装响应数据
        	for (FdDeliveryRequest req : reqList) {
            	service.jmdsApp12_to_jmdsApp31_S_contract(req, APPKEY, getRequestid());
            	
                BaseModel result = new BaseModel("1", "数据接收成功！", req.getDeliveryno());
                results.add(result);
            }
            
            //2.2-2发送响应数据
            HttpClientUtils.writeObject(response1, results, ENCRYPT_KEY);
        }
    }
	
    /**
     * 电商资金操作 出金(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ApiLog
    @RequestMapping(value = "/jmdsApp12_to_jmdsApp31_S_refund", method = RequestMethod.POST)
    public void jmdsApp12_to_jmdsApp31_S_refund(HttpServletRequest request1, HttpServletResponse response1) {
    	//1.读取请求数据流
    	///List<Map<String, Object>> reqList = (List<Map<String, Object>>) HttpClientUtils.read(request1, ENCRYPT_KEY, Map.class);
    	Object obj = HttpClientUtils.read(request1, ENCRYPT_KEY, Map.class);
    	Map<String, Object> req = (Map<String, Object>) obj;
        
        List<BaseModel> results = new ArrayList<BaseModel>();//响应数据
        //2.1如果请求数据为空，则发送响应反馈
        ///if (reqList==null || reqList.size()==0) {
        if (req==null) {
            HttpClientUtils.writeObject(response1, results, ENCRYPT_KEY);
        //2.2如果请求数据不为空，则进行业务处理后发送响应反馈  
        } else {
        	//2.2-1业务处理并组装响应数据
        	///for (Map<String, Object> req : reqList) {
            	BaseResponse resp = service.jmdsApp12_to_jmdsApp31_S_refund(req, APPKEY, getRequestid());
            	
            	BaseModel result = null;
            	if(ApiEnum.SUCCESSFUL.code().equals(resp.getCode())) {
            		result = new BaseModel("1", resp.getMsg(), req.get("txdjh"));
            	}else {
            		result = new BaseModel("0", resp.getMsg(), req.get("txdjh"));
            	}
                results.add(result);
            ///}
            
            //2.2-2发送响应数据
            HttpClientUtils.writeObject(response1, results, ENCRYPT_KEY);
        }
    }

    /**
     * 电商资金操作 入金(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ApiLog
    @RequestMapping(value = "/jmdsApp12_to_jmdsApp31_S_b2bDeposit", method = RequestMethod.POST)
    public void jmdsApp12_to_jmdsApp31_S_b2bDeposit(HttpServletRequest request1, HttpServletResponse response1) {
    	//1.读取请求数据流
    	///List<Map<String, Object>> reqList = (List<Map<String, Object>>) HttpClientUtils.read(request1, ENCRYPT_KEY, Map.class);
    	Object obj = HttpClientUtils.read(request1, ENCRYPT_KEY, Map.class);
    	Map<String, Object> req = (Map<String, Object>) obj;
    	
        List<BaseModel> results = new ArrayList<BaseModel>();//响应数据
        //2.1如果请求数据为空，则发送响应反馈
        ///if (reqList==null || reqList.size()==0) {
        if (req==null) {
            HttpClientUtils.writeObject(response1, results, ENCRYPT_KEY);
        //2.2如果请求数据不为空，则进行业务处理后发送响应反馈  
        }else {
        	//2.2-1业务处理并组装响应数据
        	///for (Map<String, Object> req : reqList) {
            	BaseResponse resp = service.jmdsApp12_to_jmdsApp31_S_b2bDeposit(req, APPKEY, getRequestid());
            	
            	BaseModel result = null;
            	if(ApiEnum.SUCCESSFUL.code().equals(resp.getCode())) {
            		result = new BaseModel("1", resp.getMsg(), req.get("pzdh"));
            	}else {
            		result = new BaseModel("0", resp.getMsg(), req.get("pzdh"));
            	}
                results.add(result);
            ///}
            
            //2.2-2发送响应数据
            HttpClientUtils.writeObject(response1, results, ENCRYPT_KEY);
        }
    }

    /**
     * 电商资金操作 资金查询(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ApiLog
    @RequestMapping(value = "/jmdsApp12_to_jmdsApp31_S_getFund", method = RequestMethod.POST)
    public void jmdsApp12_to_jmdsApp31_S_getFund(HttpServletRequest request1, HttpServletResponse response1) {
    	//1.读取请求数据流
    	List<Map<String, Object>> reqList = (List<Map<String, Object>>) HttpClientUtils.read(request1, ENCRYPT_KEY, Map.class);
        
        List<BaseModel> results = new ArrayList<BaseModel>();//响应数据
        //2.1如果请求数据为空，则发送响应反馈
        if (reqList==null || reqList.size()==0) {
            HttpClientUtils.writeObject(response1, results, ENCRYPT_KEY);
        //2.2如果请求数据不为空，则进行业务处理后发送响应反馈  
        }else {
        	//2.2-1业务处理并组装响应数据
        	for (Map<String, Object> req : reqList) {
            	BaseResponse resp = service.jmdsApp12_to_jmdsApp31_S_getFund(req, APPKEY, getRequestid());
            	
            	BaseModel result = null;
            	if(ApiEnum.SUCCESSFUL.code().equals(resp.getCode())) {
            		result = new BaseModel("1", resp.getMsg());
            	}else {
            		result = new BaseModel("0", resp.getMsg());
            	}
                results.add(result);
            }
            
            //2.2-2发送响应数据
            HttpClientUtils.writeObject(response1, results, ENCRYPT_KEY);
        }
    }
    
    
    /********************二期加工配送调用********************/
    /**
     * 原料采购合同/原料运杂费合同/物料采购合同/其它合同接口(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp21_to_jmdsApp31_P_contractInfo", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_P_contractInfo(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp21_to_jmdsApp31_P_contractInfo ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp21_to_jmdsApp31_P_contractInfo ----------End。。。。");
        try {
            app21To31Validate.pContractInfoValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        return service.jmdsApp21_to_jmdsApp31_P_contractInfo(req, appkey, requestid);
    }
    
    /**
     * 采购入库/结算(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp21_to_jmdsApp31_P_settlement", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_P_settlement(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp21_to_jmdsApp31_P_settlement ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp21_to_jmdsApp31_P_settlement ----------End。。。。");
        try {
            app21To31Validate.pSettlementValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        return service.jmdsApp21_to_jmdsApp31_P_settlement(req, appkey, requestid);
    }

    /**
     * 采购合同结案(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp21_to_jmdsApp31_P_contractClose", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_P_contractClose(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp21_to_jmdsApp31_P_contractClose ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp21_to_jmdsApp31_P_contractClose ----------End。。。。");
        try {
            app21To31Validate.pContractCloseValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        return service.jmdsApp21_to_jmdsApp31_P_contractClose(req, appkey, requestid);
    }
    
    /**
     * 销售合同(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp21_to_jmdsApp31_S_contractInfo", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_S_contractInfo(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp21_to_jmdsApp31_S_contractInfo ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp21_to_jmdsApp31_S_contractInfo ----------End。。。。");
        try {
            app21To31Validate.sContractInfoValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        return service.jmdsApp21_to_jmdsApp31_S_contractInfo(req, appkey, requestid);
    }

    /**
     * 销售提单(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp21_to_jmdsApp31_S_lading", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_S_lading(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp21_to_jmdsApp31_S_lading ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp21_to_jmdsApp31_S_lading ----------End。。。。");
        try {
            app21To31Validate.sLadingValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        return service.jmdsApp21_to_jmdsApp31_S_lading(req, appkey, requestid);
    }
    
    /**
     * 销售实提结算(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp21_to_jmdsApp31_S_settlement", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_S_settlement(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp21_to_jmdsApp31_S_settlement ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp21_to_jmdsApp31_S_settlement ----------End。。。。");
        try {
            app21To31Validate.sSettlementValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        return service.jmdsApp21_to_jmdsApp31_S_settlement(req, appkey, requestid);
    }
    
    /**
     * 销售合同结案(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp21_to_jmdsApp31_S_contractClose", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_S_contractClose(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp21_to_jmdsApp31_S_contractClose ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp21_to_jmdsApp31_S_contractClose ----------End。。。。");
        try {
            app21To31Validate.sContractCloseValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        return service.jmdsApp21_to_jmdsApp31_S_contractClose(req, appkey, requestid);
    }
    
    /**
     * 物料领料/物料报废(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp21_to_jmdsApp31_M_productionUse", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_M_productionUse(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp21_to_jmdsApp31_M_productionUse ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp21_to_jmdsApp31_M_productionUse ----------End。。。。");
        try {
            app21To31Validate.mProductionUseValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        return service.jmdsApp21_to_jmdsApp31_M_productionUse(req, appkey, requestid);
    }

    /**
     * 成本核算结转(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp21_to_jmdsApp31_C_accounting", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_C_accounting(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp21_to_jmdsApp31_C_accounting ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp21_to_jmdsApp31_C_accounting ----------End。。。。");
        try {
            app21To31Validate.cAccountingValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        return service.jmdsApp21_to_jmdsApp31_C_accounting(req, appkey, requestid);
    }
    
    /**
     * 通用凭证处理(同步请求)
     * @param req
     * @param appkey
     * @param requestid
     * @return
     * @throws ApiException
     */
    @ApiLog
    @ResponseBody
    @RequestMapping(value = "/jmdsApp21_to_jmdsApp31_F_voucher", method = RequestMethod.POST)
    public BaseResponse<Map<String, Object>> jmdsApp21_to_jmdsApp31_F_voucher(@RequestBody Map<String, Object> req, String appkey, String requestid) throws ApiException {
        System.out.println("jmdsApp21_to_jmdsApp31_F_voucher ----------Start。。。。");
        System.out.println("arg ====" + req);
        System.out.println("jmdsApp21_to_jmdsApp31_F_voucher ----------End。。。。");
        /*
        try {
            //app21To31Validate.cAccountingValidate(req);
        } catch (CheckException ce) {
            ce.printStackTrace();
            return new BaseResponse(ce.getCode(), ce.getMessage());
        }
        */
        return service.jmdsApp21_to_jmdsApp31_F_voucher(req, appkey, requestid);
    }
    
    
    /********************二期电商调用********************/
    
    
    
    
}