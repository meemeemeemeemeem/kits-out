package com.kits.inms.api.url;

import com.bstek.dorado.core.Configure;

/**
 * 金贸三期财务系统提供接口的Url
 * @author zhangcheng
 */
public class JmdsApp31Url {
	//public static final String JMDS_APP31_IP = "http://47.101.47.238:8088/jmds";
	public static final String JMDS_APP31_IP = Configure.getString("inms.jmdsApp31.ip");
	
	/******************************贸易系统访问******************************/
	/*****应付模块*****/
	//<贸易系统>采购合同应付接口
	public static final String TRADE_AP_01 = JMDS_APP31_IP + "/itf/api/tradeCalled/tradePurchaseContractToAp";
	//<贸易系统>采购入库与应付接口
	public static final String  TRADE_AP_02 = JMDS_APP31_IP + "/itf/api/tradeCalled/tradePurchaseInStorageToAp";

	//<贸易系统>采购合信息接口
	public static final String TRADE_AP_03 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_P_contractInfo";
	//<贸易系统>采购结案接口
	public static final String TRADE_AP_04 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_P_contractClose";
	//<贸易系统>采购入库接口
	public static final String  TRADE_AP_05 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_P_storage";
	//<贸易系统>采购运费结算接口
	public static final String  TRADE_AP_06 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_P_carriage";//
    //<贸易系统>采购结算调整与应付接口
    public static final String  TRADE_AP_07 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_P_settlement";//
	/*****应收模块*****/
	//<贸易系统>销售合同与应收接口
	public static final String TRADE_AR_01 = JMDS_APP31_IP + "/itf/api/tradeCalled/tradeSalesContractToAr";
	//<贸易系统>销售提单与应收接口
	public static final String TRADE_AR_02 = JMDS_APP31_IP + "/itf/api/tradeCalled/tradeSalesLadingToAr";
	//<贸易系统>销售结算与应收接口
	public static final String TRADE_AR_03 = JMDS_APP31_IP + "/itf/api/tradeCalled/tradeSalesSettlementToAr";

	//<贸易系统>销售合同信息接口
	public static final String TRADE_AR_04 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_S_contractInfo";
	//<贸易系统>销售合同结案接口
	public static final String TRADE_AR_05 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_S_contractClose";
	//<贸易系统>销售提单接口
	public static final String TRADE_AR_06 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_S_lading";
	//<贸易系统>销售提单货齐接口
	public static final String TRADE_AR_06LC = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_S_ladingComplete";
	//<贸易系统>销售结算接口
	public static final String TRADE_AR_07 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_S_storage";
	
    //<贸易系统>销售运费结算接口
    public static final String TRADE_AR_08 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_S_carriage";//
    //<贸易系统>销售结算调整接口
    public static final String TRADE_AR_09 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_S_settlement";//
    /*****库存管理模块*****/
    //<贸易系统>盘盈盘亏
    public static final String TRADE_MP_0 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_I_profitAndLoss";//
    //<贸易系统>库存调拨（调出）
    public static final String TRADE_MP_1 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_I_transferOut";//
    //<贸易系统>库存调拨（调入）
    public static final String TRADE_MP_2 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_I_transferIn";//
    //<贸易系统>物资调整
    public static final String TRADE_MP_3 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_I_adjustment";//
    //<贸易系统>翻包/切割
	public static final String TRADE_MP_4 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_I_split";//
	//<贸易系统>品名相关信息接口
	public static final String TRADE_MP_5 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_I_goodsName";//
	//<贸易系统>仓储结算接口
	public static final String TRADE_MP_6 = JMDS_APP31_IP + "/itf/api/tradeCalled/jmdsApp11_to_jmdsApp31_S_ccSettlement";//

    /*****总账模块*****/
	//<贸易系统>销售与总账支撑接口
	public static final String TRADE_GL_01 = JMDS_APP31_IP + "/itf/api/tradeCalled/tradeSalesToGl";
	//<贸易系统>采购与总账支撑接口
	public static final String TRADE_GL_02 = JMDS_APP31_IP + "/itf/api/tradeCalled/tradePurchaseToGl";
	//<贸易系统>库存管理与总账支撑接口
	public static final String TRADE_GL_03 = JMDS_APP31_IP + "/itf/api/tradeCalled/tradeStockManageToGl";
	//<贸易系统>费用报销与总账支撑接口
	public static final String TRADE_GL_04 = JMDS_APP31_IP + "/itf/api/tradeCalled/tradeCostsReimbursementToGl";
	//<贸易系统>人资管理与总账支撑接口
	public static final String TRADE_GL_05 = JMDS_APP31_IP + "/itf/api/tradeCalled/tradeHumanResourceManageToGl";
	/*****发票模块*****/
	//<贸易系统>销售结算与发票接口
	public static final String TRADE_IV_01 = JMDS_APP31_IP + "/itf/api/tradeCalled/tradeSalesSettlementToIv";
	//<贸易系统>采购结算与发票接口
	public static final String TRADE_IV_02 = JMDS_APP31_IP + "/itf/api/tradeCalled/tradePurchaseSettlementToIv";
	
	
	/******************************贸易电商系统访问******************************/
	/*****应收模块*****/
	//<贸易电商系统>余额充值与应收接口
	public static final String TRADE_E_AR_01 = JMDS_APP31_IP + "/itf/api/tradeECalled/tradeEBalanceRechargeToAr";
	//<贸易电商系统>客户提现与应收接口
	public static final String TRADE_E_AR_02 = JMDS_APP31_IP + "/itf/api/tradeECalled/tradeECustomerWithdrawalToAr";
	//<贸易电商系统>订单支付与应收接口
	public static final String TRADE_E_AR_03 = JMDS_APP31_IP + "/itf/api/tradeECalled/tradeEOrderPaymentToAr";
	//<贸易电商系统>白条消费与应收接口
	public static final String TRADE_E_AR_04 = JMDS_APP31_IP + "/itf/api/tradeECalled/tradeEChargeSalesExpenseToAr";
	//<贸易电商系统>白条还款与应收接口
	public static final String TRADE_E_AR_05 = JMDS_APP31_IP + "/itf/api/tradeECalled/tradeEChargeSalesRepaymentToAr";

    //<贸易电商系统>采购订单（挂网销售）
    public static final String TRADE_E_AR_06 = JMDS_APP31_IP + "/itf/api/tradeECalled/jmdsApp12_to_jmdsApp31_S_contract";
    //<贸易电商系统>资金操作出金
    public static final String TRADE_E_AR_07 = JMDS_APP31_IP + "/itf/api/tradeECalled/jmdsApp12_to_jmdsApp31_S_refund";
    //<贸易电商系统>B2B入金
    public static final String TRADE_E_AR_08 = JMDS_APP31_IP + "/itf/api/tradeECalled/jmdsApp12_to_jmdsApp31_S_b2bDeposit";
    //<贸易电商系统>资金查询
    public static final String TRADE_E_AR_09 = JMDS_APP31_IP + "/itf/api/tradeECalled/jmdsApp12_to_jmdsApp31_S_getFund";
	
	
	/******************************加工配送系统访问******************************/
	/*****应付模块*****/
	//<加工配送系统>采购合同与应付接口
	public static final String C2M_AP_01 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mPurchaseContractToAp";
	//<加工配送系统>采购入库与应付接口
	public static final String C2M_AP_02 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mPurchaseInStorageToAp";

	//<加工配送系统>采购入库/结算
	public static final String C2M_IV_03 = JMDS_APP31_IP + "/itf/api/c2mCalled/jmdsApp21_to_jmdsApp31_P_settlement";//
	//<加工配送系统>原料采购合同/原料运杂费合同/物料采购合同/其他合同接口
	public static final String C2M_IV_05 = JMDS_APP31_IP + "/itf/api/c2mCalled/jmdsApp21_to_jmdsApp31_P_contractInfo";//
	// <加工配送系统>采购合同结案
	public static final String C2M_IV_06 = JMDS_APP31_IP + "/itf/api/c2mCalled/jmdsApp21_to_jmdsApp31_P_contractClose";//

	/*****应收模块*****/
	//<加工配送系统>销售合同与应收接口
	public static final String C2M_AR_01 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mSalesContractToAr";
	//<加工配送系统>销售提单与应收接口
	public static final String C2M_AR_02 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mSalesLadingToAr";
	//<加工配送系统>销售结算与应收接口
	public static final String C2M_AR_03 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mSalesSettlementToAr";

	//<加工配送系统>销售实提结算
	public static final String C2M_AR_04 = JMDS_APP31_IP + "/itf/api/c2mCalled/jmdsApp21_to_jmdsApp31_S_settlement";//
	//<加工配送系统>销售合同
	public static final String C2M_AR_06 = JMDS_APP31_IP + "/itf/api/c2mCalled/jmdsApp21_to_jmdsApp31_S_contractInfo";//
	//<加工配送系统>销售合同结案
	public static final String C2M_AR_07 = JMDS_APP31_IP + "/itf/api/c2mCalled/jmdsApp21_to_jmdsApp31_S_contractClose";//
	//<加工配送系统>销售提单
	public static final String C2M_AR_08 = JMDS_APP31_IP + "/itf/api/c2mCalled/jmdsApp21_to_jmdsApp31_S_lading";//

	/*****总账模块*****/
	//<加工配送系统>销售与总账支撑接口
	public static final String C2M_GL_01 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mSalesToGl";
	//<加工配送系统>采购与总账支撑接口
	public static final String C2M_GL_02 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mPurchaseToGl";
	//<加工配送系统>库存管理与总账支撑接口
	public static final String C2M_GL_03 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mStockManageToGl";
	//<加工配送系统>生产领用与总账支撑接口
	public static final String C2M_GL_04 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mManufactureConsumingToGl";
	//<加工配送系统>生产入库与总账支撑接口
	public static final String C2M_GL_05 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mProduceInStorageToGl";
	//<加工配送系统>成本与总账支撑接口
	public static final String C2M_GL_06 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mCostToGl";
	
	//<加工配送系统>通用凭证处理接口
	public static final String C2M_GL_07 = JMDS_APP31_IP + "/itf/api/c2mCalled/jmdsApp21_to_jmdsApp31_F_voucher";
	
	/*****发票模块*****/
	//<加工配送系统>销售结算与发票接口
	public static final String C2M_IV_01 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mSalesSettlementToIv";
	//<加工配送系统>采购结算与发票接口
	public static final String C2M_IV_02 = JMDS_APP31_IP + "/itf/api/c2mCalled/c2mPurchaseSettlementToIv";

	/*****物料模块*****/
    //<加工配送系统>物料领料/物料报废
    public static final String C2M_M_01 = JMDS_APP31_IP + "/itf/api/c2mCalled/jmdsApp21_to_jmdsApp31_M_productionUse";//
    //<加工配送系统>成本核算结转
    public static final String C2M_M_02 = JMDS_APP31_IP + "/itf/api/c2mCalled/jmdsApp21_to_jmdsApp31_C_accounting";//

    

}