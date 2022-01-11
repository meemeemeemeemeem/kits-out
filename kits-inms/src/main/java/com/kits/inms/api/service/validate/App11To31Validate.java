package com.kits.inms.api.service.validate;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.kits.inms.api.expection.CheckException;

/**
 * 一期供应链系统调用三期系统参数验证
 *
 * @author 张成
 */
@Controller
public class App11To31Validate {
    /**
     * 采购合同信息(异步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({})
    public void pContractInfoValidate(Map<String, Object> req) throws CheckException {
        //try {
        //公司别
        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(req.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(req.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //合同大类
        CheckTool.checkNotNull(req.get("contractClass"), "contractClass(合同大类)为必填项，不能为null也不能为空！");
        //合同类型
        CheckTool.checkNotNull(req.get("contractType"), "contractType(合同类型)为必填项，不能为null也不能为空！");
        //合同编号
        CheckTool.checkNotNull(req.get("contractNo"), "contractNo(合同编号)为必填项，不能为null也不能为空！");
        //供应商编码
        CheckTool.checkNotNull(req.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
        //合同总金额
        CheckTool.checkNotNull(req.get("contractAmt"), "contractAmt(合同总金额)为必填项，不能为null也不能为空！");
        //预付款金额
        if (req.get("advanceAmt")==null || "".equals(req.get("advanceAmt"))) {
        	req.put("advanceAmt", "0");
        }
        //CheckTool.checkNotNull(req.get("advanceAmt"), "advanceAmt(预付款金额)为必填项，不能为null也不能为空！");
        //付款方式
        CheckTool.checkNotNull(req.get("settlementType"), "settlementType(付款方式)为必填项，不能为null也不能为空！");
        //业务部门
        CheckTool.checkNotNull(req.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
        //业务员
        CheckTool.checkNotNull(req.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(req.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");

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
     * 采购合同结案(同步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({})
    public void pContractCloseValidate(Map<String, Object> req) throws CheckException {
        //公司别
        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(req.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(req.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //合同大类
        CheckTool.checkNotNull(req.get("contractClass"), "contractClass(合同大类)为必填项，不能为null也不能为空！");
        //合同编号
        CheckTool.checkNotNull(req.get("contractNo"), "contractNo(合同编号)为必填项，不能为null也不能为空！");
        //供应商编码
        CheckTool.checkNotNull(req.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(req.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
    }

    /**
     * 采购入库(异步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void pStorageValidate(Map<String, Object> req) throws CheckException {
        //公司别
        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(req.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(req.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //入库单号
        CheckTool.checkNotNull(req.get("stockNo"), "stockNo(入库单号)为必填项，不能为null也不能为空！");
        //供应商编码
        CheckTool.checkNotNull(req.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
        //业务部门
        CheckTool.checkNotNull(req.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
        //业务员
        CheckTool.checkNotNull(req.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
        //业务日期
        CheckTool.checkNotNull(req.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(req.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
        //入库明细
        CheckTool.checkNotNull(req.get("storageDetail"), "storageDetail(入库明细)为必填项，不能为null也不能为空！");
        List<Map<String, Object>> storageDetail = (List<Map<String, Object>>) req.get("storageDetail");
        for (Map m : storageDetail) {
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //入库单号
            CheckTool.checkNotNull(m.get("stockNo"), "stockNo(入库单号)为必填项，不能为null也不能为空！");
            //单据批号
            CheckTool.checkNotNull(m.get("itemNo"), "itemNo(单据批号)为必填项，不能为null也不能为空！");
            //合同编号
            //CheckTool.checkNotNull(m.get("contractNo"), "contractNo(合同编号)为必填项，不能为null也不能为空！");
            //供应商编码
            CheckTool.checkNotNull(m.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
            //子板号
            //CheckTool.checkNotNull(m.get("goodsDetailNo"), "goodsDetailNo(子板号)为必填项，不能为null也不能为空！");
            //品名
            CheckTool.checkNotNull(m.get("goodsName"), "goodsName(品名)为必填项，不能为null也不能为空！");
            //材质
            CheckTool.checkNotNull(m.get("goodsMaterial"), "goodsMaterial(材质)为必填项，不能为null也不能为空！");
            //规格
            CheckTool.checkNotNull(m.get("goodsSpec"), "goodsSpec(规格)为必填项，不能为null也不能为空！");
            //产地
            CheckTool.checkNotNull(m.get("productArea"), "productArea(产地)为必填项，不能为null也不能为空！");
            //仓库
            CheckTool.checkNotNull(m.get("wareHouse"), "wareHouse(仓库)为必填项，不能为null也不能为空！");
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

    /**
     * 采购运费结算(异步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({})
    public void pCarriageValidate(Map<String, Object> req) throws CheckException {
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) req.get("dataList");
        for (Map m : dataList) {
            //公司别
            CheckTool.checkNotNull(m.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
            //操作标识
            CheckTool.checkNotNull(m.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
            //操作类型
            CheckTool.checkNotNull(m.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //结算单号
            CheckTool.checkNotNull(m.get("settlementNo"), "settlementNo(结算单号)为必填项，不能为null也不能为空！");
            //供应商编码
            CheckTool.checkNotNull(m.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
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
            //业务部门
            CheckTool.checkNotNull(m.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
            //业务员
            CheckTool.checkNotNull(m.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
            //业务日期
            CheckTool.checkNotNull(m.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
            //操作人
            CheckTool.checkNotNull(m.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
        }

    }


    /**
     * 采购结算调整（补差）(异步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({})
    public void pSettlementValidate(Map<String, Object> req) throws CheckException {
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) req.get("dataList");
        for (Map m : dataList) {
            //公司别
            CheckTool.checkNotNull(m.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
            //操作标识
            CheckTool.checkNotNull(m.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
            //操作类型
            CheckTool.checkNotNull(m.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //单号
            CheckTool.checkNotNull(m.get("billNo"), "billNo(单号)为必填项，不能为null也不能为空！");
            //合同编号
            //CheckTool.checkNotNull(m.get("contractNo"), "contractNo(合同编号)为必填项，不能为null也不能为空！");
            //供应商编码
            CheckTool.checkNotNull(m.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
            //业务部门
            CheckTool.checkNotNull(m.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
            //业务员
            CheckTool.checkNotNull(m.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
            //业务日期
            CheckTool.checkNotNull(m.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
            //操作人
            CheckTool.checkNotNull(m.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
            //结算调整类型
            CheckTool.checkNotNull(m.get("settlementType"), "settlementType(结算调整类型)为必填项，不能为null也不能为空！");
            //品名
            //CheckTool.checkNotNull(m.get("goodsName"), "goodsName(品名)为必填项，不能为null也不能为空！");
            //材质
            CheckTool.checkNotNull(m.get("goodsMaterial"), "goodsMaterial(材质)为必填项，不能为null也不能为空！");
            //规格
            CheckTool.checkNotNull(m.get("goodsSpec"), "goodsSpec(规格)为必填项，不能为null也不能为空！");
            //产地
            CheckTool.checkNotNull(m.get("productArea"), "productArea(产地)为必填项，不能为null也不能为空！");
            //含税金额
            CheckTool.checkNotNull(m.get("totalAmt"), "totalAmt(含税金额)为必填项，不能为null也不能为空！");
            //不含税金额
            CheckTool.checkNotNull(m.get("notaxAmt"), "notaxAmt(不含税金额)为必填项，不能为null也不能为空！");
            //税率
            CheckTool.checkNotNull(m.get("taxRate"), "taxRate(税率)为必填项，不能为null也不能为空！");
            //税额
            CheckTool.checkNotNull(m.get("taxAmt"), "taxAmt(税额)为必填项，不能为null也不能为空！");
        }

    }

    /**
     * 销售合同信息(同步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({})
    public void sContractInfoValidate(Map<String, Object> req) throws CheckException {
        //公司别
        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(req.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(req.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //合同大类
        CheckTool.checkNotNull(req.get("contractClass"), "contractClass(合同大类)为必填项，不能为null也不能为空！");
        //合同类型
        CheckTool.checkNotNull(req.get("contractType"), "contractType(合同类型)为必填项，不能为null也不能为空！");
        //合同编号
        CheckTool.checkNotNull(req.get("contractNo"), "contractNo(合同编号)为必填项，不能为null也不能为空！");
        //客商编码
        CheckTool.checkNotNull(req.get("vendorNo"), "vendorNo(客商编码)为必填项，不能为null也不能为空！");
        //合同总金额
        CheckTool.checkNotNull(req.get("contractAmt"), "contractAmt(合同总金额)为必填项，不能为null也不能为空！");
        //保证金金额
        //CheckTool.checkNotNull(req.get("depositAmt"), "depositAmt(保证金金额)为必填项，不能为null也不能为空！");
        //预收款金额
        //CheckTool.checkNotNull(req.get("advanceAmt"), "advanceAmt(预收款金额)为必填项，不能为null也不能为空！");
        //付款方式
        CheckTool.checkNotNull(req.get("settlementType"), "settlementType(结算方式)为必填项，不能为null也不能为空！");
        //付款条件
        CheckTool.checkNotNull(req.get("paymentCondition"), "paymentCondition(付款条件)为必填项，不能为null也不能为空！");
        //业务部门
        CheckTool.checkNotNull(req.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
        //业务员
        CheckTool.checkNotNull(req.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(req.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
    }

    /**
     * 销售合同结案(同步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({})
    public void sContractCloseValidate(Map<String, Object> req) throws CheckException {
        //公司别
        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(req.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(req.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //合同大类
        CheckTool.checkNotNull(req.get("contractClass"), "contractClass(合同大类)为必填项，不能为null也不能为空！");
        //合同编号
        CheckTool.checkNotNull(req.get("contractNo"), "contractNo(合同编号)为必填项，不能为null也不能为空！");
        //客商编码
        CheckTool.checkNotNull(req.get("vendorNo"), "vendorNo(客商编码)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(req.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
    }

    /**
     * 销售提单(同步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void sLadingValidate(Map<String, Object> req) throws CheckException {
        //公司别
        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(req.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(req.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //提单编号
        CheckTool.checkNotNull(req.get("ladingNo"), "ladingNo(提单编号)为必填项，不能为null也不能为空！");
        //销售厂商
        CheckTool.checkNotNull(req.get("vendorNo"), "vendorNo(销售厂商)为必填项，不能为null也不能为空！");
        //业务部门
        CheckTool.checkNotNull(req.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
        //业务员
        CheckTool.checkNotNull(req.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
        //提单明细
        CheckTool.checkNotNull(req.get("ladingDetail"), "ladingDetail(提单明细)为必填项，不能为null也不能为空！");
        
        List<Map<String, Object>> ladingDetail = (List<Map<String, Object>>) req.get("ladingDetail");
        for (Map m : ladingDetail) {
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //销售合同编号
            //CheckTool.checkNotNull(m.get("contractNo"), "contractNo(销售合同编号)为必填项，不能为null也不能为空！");
            //销售金额（含税）
            CheckTool.checkNotNull(m.get("totalAmt"), "totalAmt(销售金额（含税）)为必填项，不能为null也不能为空！");
        }
    }
    
    /**
     * 销售提单货齐(同步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void sLadingCompleteValidate(Map<String, Object> req) throws CheckException {
    	//货齐明细
        CheckTool.checkNotNull(req.get("ladingDetail"), "ladingDetail(货齐明细)为必填项，不能为null也不能为空！");
        
        List<Map<String, Object>> ladingDetail = (List<Map<String, Object>>) req.get("ladingDetail");
        for (Map m : ladingDetail) {
            //公司别
            CheckTool.checkNotNull(m.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
            //操作标识
            CheckTool.checkNotNull(m.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
            //操作类型
            CheckTool.checkNotNull(m.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //提单编号
            CheckTool.checkNotNull(m.get("ladingNo"), "ladingNo(提单编号)为必填项，不能为null也不能为空！");
            //提单批号
            CheckTool.checkNotNull(m.get("ladingBatch"), "ladingBatch(提单批号)为必填项，不能为null也不能为空！");
            //操作日期
            CheckTool.checkNotNull(m.get("operatDate"), "operatDate(操作日期)为必填项，不能为null也不能为空！");
        }
    }

    /**
     * 销售结算(同步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void sStorageValidate(Map<String, Object> req) throws CheckException {
        //公司别
        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(req.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(req.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //出库单号
        CheckTool.checkNotNull(req.get("stockNo"), "stockNo(出库单号)为必填项，不能为null也不能为空！");
        //结算单位编码
        CheckTool.checkNotNull(req.get("vendorNo"), "vendorNo(结算单位编码)为必填项，不能为null也不能为空！");
        //业务部门
        CheckTool.checkNotNull(req.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
        //业务员
        CheckTool.checkNotNull(req.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
        //业务日期
        CheckTool.checkNotNull(req.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(req.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
        //出库明细
        CheckTool.checkNotNull(req.get("storageDetail"), "storageDetail(出库明细)为必填项，不能为null也不能为空！");
        List<Map<String, Object>> storageDetail = (List<Map<String, Object>>) req.get("storageDetail");
        for (Map m : storageDetail) {
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //单据批号
            CheckTool.checkNotNull(m.get("itemNo"), "itemNo(单据批号)为必填项，不能为null也不能为空！");
            //单据号
            CheckTool.checkNotNull(m.get("billNo"), "billNo(单据号)为必填项，不能为null也不能为空！");
            //合同编号
            //CheckTool.checkNotNull(m.get("contractNo"), "contractNo(合同编号)为必填项，不能为null也不能为空！");
            //供应商编码
            CheckTool.checkNotNull(m.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
            //子板号
            //CheckTool.checkNotNull(m.get("goodsDetailNo"), "goodsDetailNo(子板号)为必填项，不能为null也不能为空！");
            //品名
            CheckTool.checkNotNull(m.get("goodsName"), "goodsName(品名)为必填项，不能为null也不能为空！");
            //材质
            CheckTool.checkNotNull(m.get("goodsMaterial"), "goodsMaterial(材质)为必填项，不能为null也不能为空！");
            //规格
            CheckTool.checkNotNull(m.get("goodsSpec"), "goodsSpec(规格)为必填项，不能为null也不能为空！");
            //产地
            CheckTool.checkNotNull(m.get("productArea"), "productArea(产地)为必填项，不能为null也不能为空！");
            //仓库
            CheckTool.checkNotNull(m.get("wareHouse"), "wareHouse(仓库)为必填项，不能为null也不能为空！");
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

    /**
     * 销售运费结算(异步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({})
    public void sCarriageValidate(Map<String, Object> req) throws CheckException {
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) req.get("dataList");
        for (Map m : dataList) {
            //公司别
            CheckTool.checkNotNull(m.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
            //操作标识
            CheckTool.checkNotNull(m.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
            //操作类型
            CheckTool.checkNotNull(m.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //结算单号
            CheckTool.checkNotNull(m.get("settlementNo"), "settlementNo(结算单号)为必填项，不能为null也不能为空！");
            //供应商编码
            CheckTool.checkNotNull(m.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
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
            //业务部门
            CheckTool.checkNotNull(m.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
            //业务员
            CheckTool.checkNotNull(m.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
            //业务日期
            CheckTool.checkNotNull(m.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
            //操作人
            CheckTool.checkNotNull(m.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
        }
    }

    /**
     * 销售结算调整(异步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({})
    public void sSettlementValidate(Map<String, Object> req) throws CheckException {
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) req.get("dataList");
        for (Map m : dataList) {
            //公司别
            CheckTool.checkNotNull(m.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
            //操作标识
            CheckTool.checkNotNull(m.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
            //操作类型
            CheckTool.checkNotNull(m.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //单号
            CheckTool.checkNotNull(m.get("billNo"), "billNo(单号)为必填项，不能为null也不能为空！");
            //合同编号
            //CheckTool.checkNotNull(req.get("contractNo"), "contractNo(合同编号)为必填项，不能为null也不能为空！");
            //供应商编码
            CheckTool.checkNotNull(m.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
            //业务部门
            CheckTool.checkNotNull(m.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
            //业务员
            CheckTool.checkNotNull(m.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
            //业务日期
            CheckTool.checkNotNull(m.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
            //操作人
            CheckTool.checkNotNull(m.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
            //结算调整类型
            CheckTool.checkNotNull(m.get("settlementType"), "settlementType(结算调整类型)为必填项，不能为null也不能为空！");
            //品名
            //CheckTool.checkNotNull(req.get("goodsName"), "goodsName(品名)为必填项，不能为null也不能为空！");
            //材质
            CheckTool.checkNotNull(m.get("goodsMaterial"), "goodsMaterial(材质)为必填项，不能为null也不能为空！");
            //规格
            CheckTool.checkNotNull(m.get("goodsSpec"), "goodsSpec(规格)为必填项，不能为null也不能为空！");
            //产地
            CheckTool.checkNotNull(m.get("productArea"), "productArea(产地)为必填项，不能为null也不能为空！");
            //仓库
            CheckTool.checkNotNull(m.get("wareHouse"), "wareHouse(仓库)为必填项，不能为null也不能为空！");
            //含税金额
            CheckTool.checkNotNull(m.get("totalAmt"), "totalAmt(含税金额)为必填项，不能为null也不能为空！");
            //不含税金额
            CheckTool.checkNotNull(m.get("notaxAmt"), "notaxAmt(不含税金额)为必填项，不能为null也不能为空！");
            //税率
            CheckTool.checkNotNull(m.get("taxRate"), "taxRate(税率)为必填项，不能为null也不能为空！");
            //税额
            CheckTool.checkNotNull(m.get("taxAmt"), "taxAmt(税额)为必填项，不能为null也不能为空！");
        }
    }

    /**
     * 同步库存盘盈盘亏(同步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void iProfitAndLossValidate(Map<String, Object> req) throws CheckException {
        //公司别
        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(req.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(req.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //出库单号
        //CheckTool.checkNotNull(req.get("stockNo"), "stockNo(出库单号)为必填项，不能为null也不能为空！");
        //结算单位编码
        //CheckTool.checkNotNull(req.get("vendorNo"), "vendorNo(结算单位编码)为必填项，不能为null也不能为空！");
        //业务部门
        CheckTool.checkNotNull(req.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
        //业务员
        CheckTool.checkNotNull(req.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
        //业务日期
        CheckTool.checkNotNull(req.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(req.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
        //出库明细
        CheckTool.checkNotNull(req.get("storageDetail"), "storageDetail(出库明细)为必填项，不能为null也不能为空！");
        List<Map<String, Object>> storageDetail = (List<Map<String, Object>>) req.get("storageDetail");
        for (Map m : storageDetail) {
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //单据批号
            CheckTool.checkNotNull(m.get("itemNo"), "itemNo(单据批号)为必填项，不能为null也不能为空！");
            //单据号
            CheckTool.checkNotNull(m.get("billNo"), "billNo(单据号)为必填项，不能为null也不能为空！");
            //供应商编码
            CheckTool.checkNotNull(m.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
            //子板号
            //CheckTool.checkNotNull(m.get("goodsDetailNo"), "goodsDetailNo(子板号)为必填项，不能为null也不能为空！");
            //品名
            CheckTool.checkNotNull(m.get("goodsName"), "goodsName(品名)为必填项，不能为null也不能为空！");
            //材质
            CheckTool.checkNotNull(m.get("goodsMaterial"), "goodsMaterial(材质)为必填项，不能为null也不能为空！");
            //规格
            CheckTool.checkNotNull(m.get("goodsSpec"), "goodsSpec(规格)为必填项，不能为null也不能为空！");
            //产地
            CheckTool.checkNotNull(m.get("productArea"), "productArea(产地)为必填项，不能为null也不能为空！");
            //调整数量
            CheckTool.checkNotNull(m.get("settleNum"), "settleNum(调整数量)为必填项，不能为null也不能为空！");
            //调整数量
            CheckTool.checkNotNull(m.get("settleWeight"), "settleWeight(调整数量)为必填项，不能为null也不能为空！");
        }
    }

    /**
     * 库存调拨（调出）(异步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void iTransferOutValidate(Map<String, Object> req) throws CheckException {
        //公司别
        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(req.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(req.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //调拨单号
        CheckTool.checkNotNull(req.get("transferNo"), "transferNo(调拨单号)为必填项，不能为null也不能为空！");
        //业务部门
        CheckTool.checkNotNull(req.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
        //业务员
        CheckTool.checkNotNull(req.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
        //业务日期
        CheckTool.checkNotNull(req.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(req.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
        //调拨明细
        CheckTool.checkNotNull(req.get("storageDetail"), "storageDetail(调拨明细)为必填项，不能为null也不能为空！");
        List<Map<String, Object>> storageDetail = (List<Map<String, Object>>) req.get("storageDetail");
        for (Map m : storageDetail) {
            ///系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //单据号
            CheckTool.checkNotNull(m.get("transferNo"), "transferNo(单据号)为必填项，不能为null也不能为空！");
            //单据批号
            CheckTool.checkNotNull(m.get("itemNo"), "itemNo(单据批号)为必填项，不能为null也不能为空！");
            //供应商编码
            //CheckTool.checkNotNull(m.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
            //子板号
            //CheckTool.checkNotNull(m.get("goodsDetailNo"), "goodsDetailNo(子板号)为必填项，不能为null也不能为空！");
            //品名
            CheckTool.checkNotNull(m.get("goodsName"), "goodsName(品名)为必填项，不能为null也不能为空！");
            //材质
            CheckTool.checkNotNull(m.get("goodsMaterial"), "goodsMaterial(材质)为必填项，不能为null也不能为空！");
            //规格
            CheckTool.checkNotNull(m.get("goodsSpec"), "goodsSpec(规格)为必填项，不能为null也不能为空！");
            //产地
            CheckTool.checkNotNull(m.get("productArea"), "productArea(产地)为必填项，不能为null也不能为空！");
            //仓库
            CheckTool.checkNotNull(m.get("wareHouse"), "wareHouse(仓库)为必填项，不能为null也不能为空！");
            //调拨数量
            CheckTool.checkNotNull(m.get("settleNum"), "settleNum(调拨数量)为必填项，不能为null也不能为空！");
            //调拨重量
            CheckTool.checkNotNull(m.get("settleWeight"), "settleWeight(调拨重量)为必填项，不能为null也不能为空！");
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

    /**
     * 库存调拨（调入）(异步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void iTransferInValidate(Map<String, Object> req) throws CheckException {
        //公司别
        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(req.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(req.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //调拨单号
        CheckTool.checkNotNull(req.get("transferNo"), "transferNo(调拨单号)为必填项，不能为null也不能为空！");
        //业务部门
        CheckTool.checkNotNull(req.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
        //业务员
        CheckTool.checkNotNull(req.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
        //业务日期
        CheckTool.checkNotNull(req.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(req.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
        //调拨明细
        CheckTool.checkNotNull(req.get("storageDetail"), "storageDetail(调拨明细)为必填项，不能为null也不能为空！");
        List<Map<String, Object>> storageDetail = (List<Map<String, Object>>) req.get("storageDetail");
        for (Map m : storageDetail) {
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //单据号
            CheckTool.checkNotNull(m.get("transferNo"), "transferNo(单据号)为必填项，不能为null也不能为空！");
            //单据批号
            CheckTool.checkNotNull(m.get("itemNo"), "itemNo(单据批号)为必填项，不能为null也不能为空！");
            //供应商编码
            //CheckTool.checkNotNull(m.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
            //子板号
           // CheckTool.checkNotNull(m.get("goodsDetailNo"), "goodsDetailNo(子板号)为必填项，不能为null也不能为空！");
            //品名
            CheckTool.checkNotNull(m.get("goodsName"), "goodsName(品名)为必填项，不能为null也不能为空！");
            //材质
            CheckTool.checkNotNull(m.get("goodsMaterial"), "goodsMaterial(材质)为必填项，不能为null也不能为空！");
            //规格
            CheckTool.checkNotNull(m.get("goodsSpec"), "goodsSpec(规格)为必填项，不能为null也不能为空！");
            //产地
            CheckTool.checkNotNull(m.get("productArea"), "productArea(产地)为必填项，不能为null也不能为空！");
            //仓库
            CheckTool.checkNotNull(m.get("wareHouse"), "wareHouse(仓库)为必填项，不能为null也不能为空！");
            //调拨数量
            CheckTool.checkNotNull(m.get("settleNum"), "settleNum(调拨数量)为必填项，不能为null也不能为空！");
            //调拨重量
            CheckTool.checkNotNull(m.get("settleWeight"), "settleWeight(调拨重量)为必填项，不能为null也不能为空！");
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

    /**
     * 物资调整(异步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void iAdjustmentValidate(Map<String, Object> req) throws CheckException {
        //公司别
        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
        //操作类型
        CheckTool.checkNotNull(req.get("actionType"), "actionType(操作类型)为必填项，不能为null也不能为空！");
        //系统键值
        CheckTool.checkNotNull(req.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
        //调整单号
        CheckTool.checkNotNull(req.get("adjustNo"), "adjustNo(调整单号)为必填项，不能为null也不能为空！");
        //业务部门
        CheckTool.checkNotNull(req.get("deptCode"), "deptCode(业务部门)为必填项，不能为null也不能为空！");
        //业务员
        CheckTool.checkNotNull(req.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
        //业务日期
        CheckTool.checkNotNull(req.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(req.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
        //调拨明细
        CheckTool.checkNotNull(req.get("storageDetail"), "storageDetail(调拨明细)为必填项，不能为null也不能为空！");
        List<Map<String, Object>> storageDetail = (List<Map<String, Object>>) req.get("storageDetail");
        for (Map m : storageDetail) {
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //单据号
            CheckTool.checkNotNull(m.get("transferNo"), "transferNo(单据号)为必填项，不能为null也不能为空！");
            //单据批号
            CheckTool.checkNotNull(m.get("itemNo"), "itemNo(单据批号)为必填项，不能为null也不能为空！");
            //调整标识
            CheckTool.checkNotNull(m.get("adjustFlag"), "adjustFlag(调整标识)为必填项，不能为null也不能为空！");
            //供应商编码
            //CheckTool.checkNotNull(m.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
            //子板号
            //CheckTool.checkNotNull(m.get("goodsDetailNo"), "goodsDetailNo(子板号)为必填项，不能为null也不能为空！");
            //品名
            CheckTool.checkNotNull(m.get("goodsName"), "goodsName(品名)为必填项，不能为null也不能为空！");
        }
    }

    /**
     * 翻包/切割(异步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({})
    public void iSplitValidate(Map<String, Object> req) throws CheckException {
        //公司别
        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
        //操作标识
        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
    }

    /**
     * 品名相关信息接口(异步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({})
    public void iGoodsNameValidate(Map<String, Object> req) throws CheckException {

    }

    /**
     * 品名相关信息接口(异步请求)参数验证
     *
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({})
    public void sStorageSettlementValidate(Map<String, Object> req) throws CheckException {

    }

}