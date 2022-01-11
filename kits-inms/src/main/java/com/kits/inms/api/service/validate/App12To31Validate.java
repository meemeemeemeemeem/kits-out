package com.kits.inms.api.service.validate;

import java.util.Map;

import org.springframework.stereotype.Controller;

import com.kits.inms.api.expection.CheckException;

/**
 * 一期电商系统调用三期系统参数验证
 * @author 张成
 */
@Controller
public class App12To31Validate {
	/**
	 * 采购合同信息(异步请求)参数验证
	 * @param req
	 * @return
	 * @throws CheckException 
	 */
	@SuppressWarnings({ })
	public void pContractInfoValidate(Map<String, Object> req) throws CheckException {
		//try {
			//公司别
			CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
			//操作标识
			CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
			
			/*
			//申请时间:时间戳字符串(由Date类型转换)
			CheckTool.checkNotNull(req.get("applyTime"), "applyTime(申请时间)为必填项，不能为null也不能为空！");
			CheckTool.checkDateCast(CheckTool.fmtToDate(req.get("applyTime")), "applyTime(申请时间)类型转换失败！");
			//申请金额:BigDecimal类型
			CheckTool.checkNotNull(req.get("applyAmt"), "applyAmt(申请金额)为必填项，不能为null也不能为空！");
			CheckTool.checkBigDecimal(CheckTool.fmtToBigDecimal(req.get("applyAmt")), "applyAmt(申请金额)类型转换失败！", "applyAmt(申请金额)小于等于0！");
			//备注:String类型(没有则空字符串)
			//CheckTool.checkNotNull(req.get("remark"), "remark(备注)为必填项，不能为null也不能为空！");
			//开始时间:时间戳字符串(由Date类型转换,针对授信额度使用期限)
			CheckTool.checkNotNull(req.get("startDate"), "startDate(开始时间)为必填项，不能为null也不能为空！");
			//结束时间:时间戳字符串(由Date类型转换,针对授信额度使用期限)
			CheckTool.checkNotNull(req.get("endDate"), "endDate(结束时间)为必填项，不能为null也不能为空！");
			CheckTool.checkDateStartAndEnd(CheckTool.fmtToDate(req.get("startDate")), 
										   CheckTool.fmtToDate(req.get("endDate")), 
										   "startDate(开始时间)类型转换失败！", 
										   "endDate(结束时间)类型转换失败！");
			*/
		//} catch (CheckException e) {
			//log.error(e.getMessage(), e);
		//	e.printStackTrace();
		//	return new BaseResponse(e.getCode(), e.getMessage());
		//}
		//return null;
	}
	
	
	
	
	
}