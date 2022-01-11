package com.kits.inms.bs.dao;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.Expose;
import com.kits.inms.bs.bo.Bsjc30BO;
import com.kits.inms.bs.domain.Tbdf05;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NewNoDaoImp extends HibernateDao implements NewNoDao{
	@Autowired
	Bsjc30BO bsjc30bo;
	
	/*单号规则建立*/
	@Override
	@Expose
	public void ruleNoDef(String compId,String noId,String ruleString,String ruleConstant) throws Exception {
		//公司别，单号代码，规则字串，字串常数
		bsjc30bo.ruleNoDef(compId, noId, ruleString, ruleConstant);
	}
	@Override
	@Expose
	public void ruleNoDef(String compId, String noId, String ruleString,String ruleConstant, String operator) throws Exception {
		//公司别，单号代码，规则字串，字串常数，操作人(对外接口被调用时使用)
		bsjc30bo.ruleNoDef(compId, noId, ruleString, ruleConstant,operator);
	}
	@Override
	@Expose
	public void ruleNoDef(String compId, String noId,String noDesc,String groupId, String ruleString,String ruleConstant, String operator) throws Exception {
		//公司别，单号代码，单号名称，资料授权群组，规则字串，字串常数，操作人
		bsjc30bo.ruleNoDef(compId, noId, noDesc, groupId, ruleString, ruleConstant, operator);
	}
	
	
	/*生成新单号*/
	@Override
	@Expose	
	public String getNewNo(String noId) throws Exception {
		Map<String,Object> mapIn = new HashMap<String, Object>();
		mapIn.put("noId", noId);				//单号代码
		mapIn.put("flag", "+1");				//用于判断增号
		
		Tbdf05 df05 = bsjc30bo.getNew(mapIn);
		return df05.getNoStyle();
	}
	@Override
	@Expose
	public String getNewNo(String noId, String variable) throws Exception {
		Map<String,Object> mapIn = new HashMap<String, Object>();
		mapIn.put("noId", noId);				//单号代码
		mapIn.put("variable", variable);		//变量
		mapIn.put("flag", "+1");				//用于判断增号

		Tbdf05 df05 = bsjc30bo.getNew(mapIn);
		return df05.getNoStyle();
	}
	@Override
	@Expose
	public String getNewNo1(String noId, String operator) throws Exception {
		Map<String,Object> mapIn = new HashMap<String, Object>();
		mapIn.put("noId", noId);				//单号代码
		mapIn.put("operator", operator);		//操作人
		mapIn.put("flag", "+1");				//用于判断增号
		
		Tbdf05 df05 = bsjc30bo.getNew(mapIn);
		return df05.getNoStyle();
	}
	@Override
	@Expose
	public String getNewNo1(String noId, String variable, String operator) throws Exception {
		Map<String,Object> mapIn = new HashMap<String, Object>();
		mapIn.put("noId", noId);				//单号代码
		mapIn.put("variable", variable);		//变量
		mapIn.put("operator", operator);		//操作人
		mapIn.put("flag", "+1");				//用于判断增号
		
		Tbdf05 df05 = bsjc30bo.getNew(mapIn);
		return df05.getNoStyle();
	}

	
	

	
}
