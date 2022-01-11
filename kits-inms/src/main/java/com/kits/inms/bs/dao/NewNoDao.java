package com.kits.inms.bs.dao;

public interface NewNoDao {
	/*单号规则创建*/
	//公司别，单号代码，规则字串，字串常数
	abstract void ruleNoDef(String compId,String noId,String ruleString,String ruleConstant) throws Exception;
	//公司别，单号代码，规则字串，字串常数，操作人(对外接口被调用时使用)
	abstract void ruleNoDef(String compId,String noId,String ruleString,String ruleConstant,String operator) throws Exception;
	//公司别，单号代码，单号名称，资料授权群组，规则字串，字串常数，操作人
	abstract void ruleNoDef(String compId,String noId,String noDesc,String groupId,String ruleString,String ruleConstant,String operator) throws Exception;
	
	
	/*单号生成*/
	//单号代码
	abstract String getNewNo(String noId) throws Exception;	
	//单号代码，变量
	abstract String getNewNo(String noId,String variable) throws Exception;	
	//单号代码，操作人(对外接口被调用时使用)
	abstract String getNewNo1(String noId, String operator) throws Exception;
	//单号代码，变量，操作人(对外接口被调用时使用)
	abstract String getNewNo1(String noId, String variable, String operator) throws Exception;
	
	
}
