package com.kits.inms.api.service.validate;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.kits.inms.api.expection.CheckException;

/**
 * 二期加工配送系统调用三期系统参数验证
 * @author 张成
 */
@Controller
public class App21To31Validate {
	/**
	 * 原料采购合同/原料运杂费合同/物料采购合同/其他合同接口(同步请求)参数验证
	 * @param req
	 * @return
	 * @throws CheckException 
	 */
	@SuppressWarnings({ })
	public void pContractInfoValidate(Map<String, Object> req) throws CheckException {
		//try {
//			//公司别
//			CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
//			//操作标识
//			CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
			
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
	 * 采购入库/结算(同步请求)参数验证
	 * @param req
	 * @return
	 * @throws CheckException
	 */
	@SuppressWarnings({"unchecked", "rawtypes" })
	public void pSettlementValidate(Map<String, Object> req) throws CheckException {
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
        //入库类别
        CheckTool.checkNotNull(req.get("instockType"), "instockType(入库类别)为必填项，不能为null也不能为空！");
        //入库用途
        CheckTool.checkNotNull(req.get("endUse"), "endUse(入库用途)为必填项，不能为null也不能为空！");
        //采购合同号
        CheckTool.checkNotNull(req.get("poNo"), "poNo(采购合同号)为必填项，不能为null也不能为空！");
        //业务员
        CheckTool.checkNotNull(req.get("employeeCode"), "employeeCode(业务员)为必填项，不能为null也不能为空！");
        //业务日期
        CheckTool.checkNotNull(req.get("contractDate"), "contractDate(业务日期)为必填项，不能为null也不能为空！");
        //操作人
        CheckTool.checkNotNull(req.get("operatorCode"), "operatorCode(操作人)为必填项，不能为null也不能为空！");
        //操作日期
        CheckTool.checkNotNull(req.get("operatDate"), "operatDate(操作日期)为必填项，不能为null也不能为空！");
        //入库明细
        CheckTool.checkNotNull(req.get("settlementDetail"), "settlementDetail(入库明细)为必填项，不能为null也不能为空！");
       
        List<Map<String, Object>> settlementDetail = (List<Map<String, Object>>) req.get("settlementDetail");
        for (Map m : settlementDetail) {
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //入库单号
            CheckTool.checkNotNull(m.get("stockNo"), "stockNo(入库单号)为必填项，不能为null也不能为空！");
            //单据批号
            CheckTool.checkNotNull(m.get("itemNo"), "itemNo(单据批号)为必填项，不能为null也不能为空！");
            //合同编号
            CheckTool.checkNotNull(m.get("contractNo"), "contractNo(合同编号)为必填项，不能为null也不能为空！");
            //合同项次号
            CheckTool.checkNotNull(m.get("contractItem"), "contractItem(合同项次号)为必填项，不能为null也不能为空！");
            //供应商编码
            CheckTool.checkNotNull(m.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
            //子板号/钢品编号
            CheckTool.checkNotNull(m.get("goodsDetailNo"), "goodsDetailNo(子板号/钢品编号)为必填项，不能为null也不能为空！");
            //入库日期
            CheckTool.checkNotNull(m.get("instockDate"), "instockDate(入库日期)为必填项，不能为null也不能为空！");
            //品名
            CheckTool.checkNotNull(m.get("goodsName"), "goodsName(品名)为必填项，不能为null也不能为空！");
            //材质
            //CheckTool.checkNotNull(m.get("goodsMaterial"), "goodsMaterial(材质)为必填项，不能为null也不能为空！");
            //规格
            //CheckTool.checkNotNull(m.get("goodsSpec"), "goodsSpec(规格)为必填项，不能为null也不能为空！");
            //产地
            //CheckTool.checkNotNull(m.get("productArea"), "productArea(产地)为必填项，不能为null也不能为空！");
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
	 * 采购合同结案(同步请求)参数验证
	 * @param req
	 * @return
	 * @throws CheckException
	 */
	@SuppressWarnings({ })
	public void pContractCloseValidate(Map<String, Object> req) throws CheckException {
//		//公司别
//		CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
//		//操作标识
//		CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
	}
	
    /**
     * 销售合同(同步请求)参数验证
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({ })
    public void sContractInfoValidate(Map<String, Object> req) throws CheckException {
//        //公司别
//        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
//        //操作标识
//        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
    }
    
    /**
     * 销售提单(同步请求)参数验证
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({ })
    public void sLadingValidate(Map<String, Object> req) throws CheckException {
//        //公司别
//        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
//        //操作标识
//        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
    }
    
    /**
	 * 销售实提结算(同步请求)参数验证
	 * @param req
	 * @return
	 * @throws CheckException
	 */
	@SuppressWarnings({"unchecked", "rawtypes" })
	public void sSettlementValidate(Map<String, Object> req) throws CheckException {
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
        //操作日期
        CheckTool.checkNotNull(req.get("operatDate"), "operatDate(操作日期)为必填项，不能为null也不能为空！");
        //出库明细
        CheckTool.checkNotNull(req.get("storageDetail"), "storageDetail(出库明细)为必填项，不能为null也不能为空！");
       
        List<Map<String, Object>> storageDetail = (List<Map<String, Object>>) req.get("storageDetail");
        for (Map m : storageDetail) {
            //系统键值
            CheckTool.checkNotNull(m.get("dataId"), "dataId(系统键值)为必填项，不能为null也不能为空！");
            //单据批号
            CheckTool.checkNotNull(m.get("itemNo"), "itemNo(单据批号)为必填项，不能为null也不能为空！");
            //应收凭单号
            CheckTool.checkNotNull(m.get("revenueNo"), "revenueNo(应收凭单号)为必填项，不能为null也不能为空！");
            //应收凭单项次
            CheckTool.checkNotNull(m.get("revenueItem"), "revenueItem(应收凭单项次)为必填项，不能为null也不能为空！");
            //销售类别
            CheckTool.checkNotNull(m.get("saleType"), "saleType(销售类别)为必填项，不能为null也不能为空！");
            //出货日期
            CheckTool.checkNotNull(m.get("shipDate"), "shipDate(出货日期)为必填项，不能为null也不能为空！");
            //提单号
            CheckTool.checkNotNull(m.get("ladingNo"), "ladingNo(提单号)为必填项，不能为null也不能为空！");
            //出货销账单号
            CheckTool.checkNotNull(m.get("settlementNo"), "settlementNo(出货销账单号)为必填项，不能为null也不能为空！");
            //合同编号
            CheckTool.checkNotNull(m.get("contractNo"), "contractNo(合同编号)为必填项，不能为null也不能为空！");
            //合同项次号
            CheckTool.checkNotNull(m.get("contractItem"), "contractItem(合同项次号)为必填项，不能为null也不能为空！");
            //供应商编码
            CheckTool.checkNotNull(m.get("vendorNo"), "vendorNo(供应商编码)为必填项，不能为null也不能为空！");
            //料号
            //CheckTool.checkNotNull(m.get("prodCode"), "prodCode(料号)为必填项，不能为null也不能为空！");
            //品名
            CheckTool.checkNotNull(m.get("goodsName"), "goodsName(品名)为必填项，不能为null也不能为空！");
            //材质
            //CheckTool.checkNotNull(m.get("goodsMaterial"), "goodsMaterial(材质)为必填项，不能为null也不能为空！");
            //规格
            //CheckTool.checkNotNull(m.get("goodsSpec"), "goodsSpec(规格)为必填项，不能为null也不能为空！");
            //产地
            //CheckTool.checkNotNull(m.get("productArea"), "productArea(产地)为必填项，不能为null也不能为空！");
            //仓库
            //CheckTool.checkNotNull(m.get("wareHouse"), "wareHouse(仓库)为必填项，不能为null也不能为空！");
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
            //税别
            CheckTool.checkNotNull(m.get("taxType"), "taxType(税别)为必填项，不能为null也不能为空！");
        }
	}
	
	/**
     * 销售合同结案(同步请求)参数验证
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({ })
    public void sContractCloseValidate(Map<String, Object> req) throws CheckException {
//        //公司别
//        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
//        //操作标识
//        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
    }

    /**
     * 物料领料/物料报废(同步请求)
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({ })
    public void mProductionUseValidate(Map<String, Object> req) throws CheckException {
//        //公司别
//        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
//        //操作标识
//        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
    }

    /**
     *  成本核算结转(同步请求)
     * @param req
     * @return
     * @throws CheckException
     */
    @SuppressWarnings({ })
    public void cAccountingValidate(Map<String, Object> req) throws CheckException {
//        //公司别
//        CheckTool.checkNotNull(req.get("compId"), "compId(公司别)为必填项，不能为null也不能为空！");
//        //操作标识
//        CheckTool.checkNotNull(req.get("actionFlag"), "actionFlag(操作标识)为必填项，不能为null也不能为空！");
    }
}