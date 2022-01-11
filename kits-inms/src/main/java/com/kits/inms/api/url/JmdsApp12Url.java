package com.kits.inms.api.url;

import com.bstek.dorado.core.Configure;

/**
 * 金贸一期电商系统提供接口的Url
 * @author zhangcheng
 */
public class JmdsApp12Url {
	//public static final String JMDS_APP31_IP = "http://47.101.47.238:8088/jmds";
	public static final String JMDS_APP12_IP = Configure.getString("inms.jmdsApp12.ip");
	
	/******************************贸易系统访问******************************/
	
	
	
	/******************************加工配送系统访问******************************/
	
	
	
	/******************************加工电商系统访问******************************/
	
	
	
	/******************************三期财务系统访问******************************/
	/*****发票模块*****/
	//销售发票反填(开票信息同步)接口
	public static final String IV_TRADE_E_01 = JMDS_APP12_IP + "/iwservices/delivery/sync/invoice.htm";
	/*****资金操作模块*****/
	//电商入金（充值）接口
	public static final String IV_TRADE_E_02 = JMDS_APP12_IP + "/iwservices/fund/sync/inoutfund.htm";

	//提单货齐接口
	public static final String AR_TRADE_E_01 = JMDS_APP12_IP + "/iwservices/delivery/sync/finish.htm";

	
	
}