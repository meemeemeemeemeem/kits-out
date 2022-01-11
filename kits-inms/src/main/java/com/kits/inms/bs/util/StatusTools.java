
package com.kits.inms.bs.util;

/**
 * Copyright: Copyright (c) 2018 KnowLedge IT Service Co.,Ltd.
 *
 * @ClassName: StatusTools.java
 * @Description: 状态常量
 * @author: Administrator
 */
public class StatusTools {

	// 出入库状态

	/** 采购入库 */
	public final static String MW000_PURCHASING = "A";
	/** 退货入库 */
	public final static String MW000_RETURNED = "B";
	/** 销售出库 */
	public final static String MW000_SALES = "C";
	/** 取消入库(出库) */
	public final static String MW000_CANCEL = "D";
	/** 转库出库 */
	public final static String MW000_CHANGE_OUT = "E";
	/** 转库入库 */
	public final static String MW000_CHANGE_IN = "F";
	/** 取消转库出库 */
	public final static String MW000_CANCEL_CHANGE_OUT = "G";
	/** 取消转库入库 */
	public final static String MW000_CANCEL_CHANGE_IN = "H";
	/** 调整入库*/
	public final static String MW000_ADJUST_IN = "I";
	/** 调整出库 */
	public final static String MW000_ADJUST_OUT = "J";


	// mw121状态
	/** 已建立 */
	public static final String MW121_STATUS_CREATE = "00";
	/** 已确认 */
	public static final String MW121_STATUS_COMFIRM = "01";
	/** 已取消确认 */
	public static final String MW121_STATUS_CANCELCOMFIRM = "02";
	/** 转库 */
	public static final String MW121_TRANSFER_CATEGORY = "91";

	// 出入库标记
	/** 入 */
	public static final String INOUTTYPE_IN = "I";
	/** 出 */
	public static final String INOUTTYPE_OUT = "O";

	// mp041状态
	/** 已建立 */
	public static final String MP041_STATUS_CREATE = "00";
	/** 已确认 */
	public static final String MP041_STATUS_COMFIRM = "01";
	/** 已取消确认 */
	public static final String MP041_STATUS_CANCELCOMFIRM = "02";
	/** 已入库 */
	public static final String MP041_STATUS_STORAGE = "07";
	/** 已取消入库 */
	public static final String MP041_STATUS_CANCELSTORAGE = "08";
	/** 已报账 */
	public static final String MP041_STATUS_SETTLED = "11";
	/** 待报账 */
	public static final String MP041_STATUS_WAITSETTLE = "12";
	/** 已作废 */
	public static final String MP041_STATUS_OBSOLETE = "13";

	//Mp41入库类别
	//采购入库
	public static final String MP041_INBOUND_CATEGORY_PURCHASING = "A12";
	//运杂费入库
	public static final String MP041_INBOUND_CATEGORY_TRANSPORT = "A13";
	//期初入库
	public static final String MP041_INBOUND_CATEGORY_BEGIN = "A92";
	//虚拟入库
	public static final String MP041_INBOUND_CATEGORY_VIRTUAL = "A99";

	// mp051状态
	/** 已建立 */
	public static final String MP051_STATUS_CREATE = "00";
	/** 已确认 */
	public static final String MP051_STATUS_COMFIRM = "01";
	/** 已取消确认 */
	public static final String MP051_STATUS_CANCELCOMFIRM = "02";
	/** 已入库 */
	public static final String MP051_STATUS_STORAGE = "07";
	/** 已取消入库 */
	public static final String MP051_STATUS_CANCELSTORAGE = "08";
	/** 已报账 */
	public static final String MP051_STATUS_SETTLED = "11";

	//报账类型
	/** 采购报账 */
	public static final String MP051_BILL_TYPE_PURCHASING = "01";
	/** 运杂费报账 */
	public static final String MP051_BILL_TYPE_TRANSPORT = "02";

	// mp031状态
    /**已建立*/
	public static final String MP031_STATUS_CREATE = "00";
    /**已确认*/
	public static final String MP031_STATUS_COMFIRM = "01";
    /**已取消确认*/
	public static final String MP031_STATUS_CANCELCOMFIRM = "02";
    /**已结案*/
	public static final String MP031_STATUS_CASECLOSED = "04";
    /**已作废*/
	public static final String MP031_STATUS_INVALID = "06";
    /**已入库*/
	public static final String MP031_STATUS_STORAGE = "07";
    /**已取消入库*/
	public static final String MP031_STATUS_CANCELSTORAGE = "08";
    /**待报账*/
	public static final String MP031_STATUS_WAITSETTLE = "12";
	/**已报账*/
	public static final String MP031_STATUS_SETTLED = "11";
	/**重量计价*/
	public static final String MP031_STATUS_PRICETYPE_WEIGHT = "01";
	/**数量计价*/
	public static final String MP031_STATUS_PRICETYPE_QUANLITY = "02";
	
	public static final String MP031_CONTRATYPE_CG = "01";//采购合同
	public static final String MP031_CONTRATYPE_YZ = "02";//运费合同
	

	// SO031状态
	/**已建立*/
	public final static String SO031_CREATE = "01";
	/**已确认*/
	public final static String SO031_CONFIRMED = "02";
	/**已结案*/
	public final static String SO031_SETTLE = "03";

	// SO032状态
	/**已建立*/
	public final static String SO032_CREATE = "01";
	/**已确认*/
	public final static String SO032_CONFIRMED = "02";
	/**已结案*/
	public final static String SO032_SETTLE = "03";
	/**已提单量*/
	public final static String SO032_THISQTY = "T";
	/**已出库量*/
	public final static String SO032_OUTQTY = "O";
	/**已退货量*/
	public final static String SO032_RNTQTY = "R";

	// 确认类型
	/**确认操作*/
	public final static String SODATATYPE_CONFIRM = "02";
	/**取消操作*/
	public final static String SODATATYPE_CANCEL = "01";

	/** 库存和盘点明细相等 */
	public final static String MP114_STATUS_EQUALITY = "A";
	/** 库存有,盘点明细没有 */
	public final static String MP114_STATUS_MW_INDEP = "B";
	/** 库存没有,盘点明细有 */
	public final static String MP114_STATUS_MP_INDEP = "C";
	/** 库存和盘点明细不相等 */
	public final static String MP114_STATUS_UNEQUALITY = "D";

}
