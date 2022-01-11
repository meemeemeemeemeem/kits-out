package com.kits.inms.api.service.validate;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.kits.inms.api.expection.CheckException;

/**
 * 三期系统调用二期加工配送系统参数验证
 * @author 张成
 */
@Controller
public class App31To21Validate {
	/**
	 * 参数验证范例
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

	/**
	 * 采购发票报账回写(同步请求)参数验证
	 * @param req
	 * @return
	 * @throws CheckException
	 */
	@SuppressWarnings({"unchecked", "rawtypes" })
	public void pInvoiceValidate(Map<String, Object> req) throws CheckException {
		Map<String, Object> pay_Main = (Map<String, Object>) req.get("pay_Main");
		//公司别
        CheckTool.checkNotNull(pay_Main.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(pay_Main.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(pay_Main.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(pay_Main.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //报账单号
        CheckTool.checkNotNull(pay_Main.get("payNo"), "payNo(报账单号)为必填项，不能为null也不能为空！");
        //报账类别
        CheckTool.checkNotNull(pay_Main.get("payKind"), "payKind(报账类别)为必填项，不能为null也不能为空！");
        //报账类型
        //CheckTool.checkNotNull(pay_Main.get("payType"), "payType(报账类型)为必填项，不能为null也不能为空！");
        //采购类型
        CheckTool.checkNotNull(pay_Main.get("poType"), "poType(采购类型)为必填项，不能为null也不能为空！");
        //供应商编码
        CheckTool.checkNotNull(pay_Main.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
        //业务部门
        CheckTool.checkNotNull(pay_Main.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
        //业务员
        CheckTool.checkNotNull(pay_Main.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
        //业务日期
        CheckTool.checkNotNull(pay_Main.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(pay_Main.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
        //操作日期
        CheckTool.checkNotNull(pay_Main.get("operatDate"), "operatDate(操作日期)为必填项，不能为null也不能为空！");
        //付款约定天数
        CheckTool.checkNotNull(pay_Main.get("payDay"), "payDay(付款约定天数)为必填项，不能为null也不能为空！");
        //付款方式
        //CheckTool.checkNotNull(pay_Main.get("payMethod"), "payMethod(付款方式)为必填项，不能为null也不能为空！");
        //报支人编码
        CheckTool.checkNotNull(pay_Main.get("payEmpNo"), "payEmpNo(报支人编码)为必填项，不能为null也不能为空！");
        //报账日期
        CheckTool.checkNotNull(pay_Main.get("payDate"), "payDate(报账日期)为必填项，不能为null也不能为空！");
        //确认人员
        CheckTool.checkNotNull(pay_Main.get("confirmEmpNo"), "confirmEmpNo(确认人员)为必填项，不能为null也不能为空！");
        //确认日期
        CheckTool.checkNotNull(pay_Main.get("confirmDate"), "confirmDate(确认日期)为必填项，不能为null也不能为空！");
        //预计付款日期
        CheckTool.checkNotNull(pay_Main.get("paymentDate"), "paymentDate(预计付款日期)为必填项，不能为null也不能为空！");
        //未税金额
        CheckTool.checkNotNull(pay_Main.get("taxfreeAmount"), "taxfreeAmount(未税金额)为必填项，不能为null也不能为空！");
        //税率
        //CheckTool.checkNotNull(pay_Main.get("taxRate"), "taxRate(税率)为必填项，不能为null也不能为空！");
        //税额
        CheckTool.checkNotNull(pay_Main.get("taxAmt"), "taxAmt(税额)为必填项，不能为null也不能为空！");
        //含税金额
        CheckTool.checkNotNull(pay_Main.get("taxableAmount"), "taxableAmount(含税金额)为必填项，不能为null也不能为空！");
        
        if (!"03".equals(pay_Main.get("payKind"))) {
        	//入库明细
            CheckTool.checkNotNull(req.get("settle_Detail"), "settle_Detail(入库明细)为必填项，不能为null也不能为空！");
            List<Map<String, Object>> settle_Detail = (List<Map<String, Object>>) req.get("settle_Detail");
            for (Map m : settle_Detail) {
                //系统键值
                CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
                //明细序号
                CheckTool.checkNotNull(m.get("seqNo"), "seqNo(明细序号)为必填项，不能为null也不能为空！");
                //入库单号
                CheckTool.checkNotNull(m.get("stockNo"), "stockNo(入库单号)为必填项，不能为null也不能为空！");
                //合同编号
                CheckTool.checkNotNull(m.get("contractNo"), "contractNo(合同编号)为必填项，不能为null也不能为空！");
                //合同项次号
                CheckTool.checkNotNull(m.get("itemNo"), "itemNo(合同项次号)为必填项，不能为null也不能为空！");
                //子板号/钢品编号
                //CheckTool.checkNotNull(m.get("goodsDetailNo"), "goodsDetailNo(子板号/钢品编号)为必填项，不能为null也不能为空！");
                //结算数量
                CheckTool.checkNotNull(m.get("settleNum"), "settleNum(结算数量)为必填项，不能为null也不能为空！");
                //结算重量
                CheckTool.checkNotNull(m.get("settleWeight"), "settleWeight(结算重量)为必填项，不能为null也不能为空！");
                //含税单价
                CheckTool.checkNotNull(m.get("goodsInprice"), "goodsInprice(含税单价)为必填项，不能为null也不能为空！");
                //含税金额
                CheckTool.checkNotNull(m.get("totalAmt"), "totalAmt(含税金额)为必填项，不能为null也不能为空！");
                //不含税单价
                CheckTool.checkNotNull(m.get("goodsExprice"), "goodsExprice(不含税单价)为必填项，不能为null也不能为空！");
                //不含税金额
                CheckTool.checkNotNull(m.get("notaxAmt"), "notaxAmt(不含税金额)为必填项，不能为null也不能为空！");
                //税率
                CheckTool.checkNotNull(m.get("taxRate"), "taxRate(税率)为必填项，不能为null也不能为空！");
                //税额
                CheckTool.checkNotNull(m.get("taxAmt"), "taxAmt(税额)为必填项，不能为null也不能为空！");
            }
        }
        
        //发票明细
        CheckTool.checkNotNull(req.get("bill_Detail"), "bill_Detail(发票明细)为必填项，不能为null也不能为空！");
        List<Map<String, Object>> bill_Detail = (List<Map<String, Object>>) req.get("bill_Detail");
        for (Map m : bill_Detail) {
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //明细序号
            CheckTool.checkNotNull(m.get("seqNo"), "seqNo(发票明细序号)为必填项，不能为null也不能为空！");
            //发票号码
            CheckTool.checkNotNull(m.get("billNo"), "billNo(发票号码)为必填项，不能为null也不能为空！");
            //部门编号
            CheckTool.checkNotNull(m.get("deptId"), "deptId(部门编号)为必填项，不能为null也不能为空！");
            //发票格式
            CheckTool.checkNotNull(m.get("billFormat"), "billFormat(发票格式)为必填项，不能为null也不能为空！");
            //发票日期
            CheckTool.checkNotNull(m.get("billDate"), "billDate(发票日期)为必填项，不能为null也不能为空！");
            //不含税金额
            CheckTool.checkNotNull(m.get("notaxAmt"), "notaxAmt(不含税金额)为必填项，不能为null也不能为空！");
            //税额
            CheckTool.checkNotNull(m.get("taxAmt"), "taxAmt(税额)为必填项，不能为null也不能为空！");
            //含税金额
            CheckTool.checkNotNull(m.get("totalAmt"), "totalAmt(含税金额)为必填项，不能为null也不能为空！");
        }
	}

	/**
	 * 销售发票开票回写(同步请求)参数验证
	 * @param req
	 * @return
	 * @throws CheckException
	 */
	@SuppressWarnings({"rawtypes", "unchecked" })
	public void sInvoiceValidate(Map<String, Object> req) throws CheckException {
		Map<String, Object> invoice_Main = (Map<String, Object>) req.get("invoice_Main");
		//公司别
        CheckTool.checkNotNull(invoice_Main.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(invoice_Main.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(invoice_Main.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(invoice_Main.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //开票申请单号
        CheckTool.checkNotNull(invoice_Main.get("invoiceApplyNo"), "invoiceApplyNo(开票申请单号)为必填项，不能为null也不能为空！");
        //结算单位编码
        CheckTool.checkNotNull(invoice_Main.get("vendorNo"), "vendorNo(结算单位编码)为必填项，不能为null也不能为空！");
        //业务部门
        CheckTool.checkNotNull(invoice_Main.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
        //业务员
        CheckTool.checkNotNull(invoice_Main.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
        //业务日期
        CheckTool.checkNotNull(invoice_Main.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(invoice_Main.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
        //操作日期
        CheckTool.checkNotNull(invoice_Main.get("operatDate"), "operatDate(操作日期)为必填项，不能为null也不能为空！");
        
        //开票明细
        CheckTool.checkNotNull(req.get("invoice_Detail"), "invoice_Detail(开票明细)为必填项，不能为null也不能为空！");
        List<Map<String, Object>> invoice_Detail = (List<Map<String, Object>>) req.get("invoice_Detail");
        for (Map m : invoice_Detail) {
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //明细序号
            //CheckTool.checkNotNull(m.get("seqNo"), "seqNo(明细序号)为必填项，不能为null也不能为空！");
            //应收凭单号
            //CheckTool.checkNotNull(m.get("revenueNo"), "revenueNo(应收凭单号)为必填项，不能为null也不能为空！");
            //应收凭单项次
            //CheckTool.checkNotNull(m.get("revenueItem"), "revenueItem(应收凭单项次)为必填项，不能为null也不能为空！");
        }
	}
}