package com.kits.inms.api.url;

import com.bstek.dorado.core.Configure;

/**
 * 金贸二期加工配送系统提供接口的Url
 * @author zhangcheng
 */
public class JmdsApp21Url {
	//public static final String JMDS_APP21_IP = "http://47.101.47.238:8088/jmds";
	public static final String JMDS_APP21_IP = Configure.getString("inms.jmdsApp21.ip");
	
	
	/******************************贸易系统访问******************************/
	
	
	
	/******************************贸易电商系统访问******************************/
	
	
	
	/******************************加工电商系统访问******************************/
	
	
	
	/******************************三期财务系统访问******************************/
	//采购发票报账回写接口
	public static final String AP_C2M_01 = JMDS_APP21_IP + "/itf/api/called/jmdsApp31_to_jmdsApp21_P_invoice";
	//销售发票开票回写接口
	public static final String IV_C2M_01 = JMDS_APP21_IP + "/itf/api/called/jmdsApp31_to_jmdsApp21_S_invoice";
	
	
	
}