package com.kits.inms.utils;

import com.kits.inms.df.domain.Tbdf02;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppDbUtils{

	/**
	 * 获取参数代码 映射的参数值
	 * @param compId
	 * @param refId
	 * @return
	 * 
	 * valueA:参数值
	 * valueB:参数中文简称
	 * def4:参数中文全称
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> getDataConfigList(String compId,String refId,Session session){
		
		String sql = "select * from Tbdf02 where comp_id_='"+compId+"' and ref_id_='"+refId+"'";
		
		List<Tbdf02> dataList = new ArrayList<Tbdf02>();
		dataList = (List<Tbdf02>)session.createSQLQuery(sql).addEntity(Tbdf02.class).list();
		
		List<Map<String, Object>> mapList = new ArrayList<>();
		if(dataList.isEmpty()){
			throw new RuntimeException("未找到该参数代码【"+refId+"】对应的参数值信息");
		}else{
			for(Tbdf02 data:dataList){
				
				Map<String, Object> map1 = new HashMap<>();
				map1.put("key", data.getValueA());
				map1.put("value", data.getValueB());
				map1.put("desc", data.getDef4());
				map1.put("def1", data.getDef1());
				map1.put("def2", data.getDef2());
				
				mapList.add(map1);
			}
		}
		return mapList;
	}
	
public static Map<String, Object> getMappings(String compId,String refId,Session session){
		
		String sql = "select * from Tbdf02 where comp_id_='"+compId+"' and ref_id_='"+refId+"'";
		
		List<Tbdf02> dataList = new ArrayList<Tbdf02>();
		dataList = (List<Tbdf02>)session.createSQLQuery(sql).addEntity(Tbdf02.class).list();
		
		
		Map<String, Object> mapValue = new HashMap<>();
		if(dataList.isEmpty()){
			throw new RuntimeException("未找到该参数代码【"+refId+"】对应的参数值信息");
		}else{
			for(Tbdf02 data:dataList){
				
				mapValue.put(data.getValueA(), data.getValueB());
			}
		}
		
		return mapValue;
	}
	
	/**
	 * 获取参数代码 映射的参数值
	 * @param compId
	 * @param refId
	 * @return
	 * 
	 * valueA:参数值
	 * valueB:参数中文简称
	 * def4:参数中文全称
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getMappingKeys(String compId,String refId,Session session){
		
		String sql = "select * from Tbdf02 where comp_id_='"+compId+"' and ref_id_='"+refId+"'";
		
		List<Tbdf02> dataList = new ArrayList<Tbdf02>();
		dataList = (List<Tbdf02>)session.createSQLQuery(sql).addEntity(Tbdf02.class).list();
		
		List<String> keyList = new ArrayList<String>();
		if(dataList.isEmpty()){
			throw new RuntimeException("未找到该参数代码对应的参数值信息");
		}else{
			for(Tbdf02 data:dataList){
				String valueA = data.getValueA();
				keyList.add(valueA);
				
			}
		}
		return keyList;
	}
	/**
	 * 根据键查询值
	 * @param map
	 * @param session
	 * @return
	 */
	public static Map<String, Object> getValue(String compId,String refId,String name,Session session){
		
		String sql = "select * from Tbdf02 where comp_id_='"+compId+"' and ref_id_='"+refId+"' and value_a_='"+name+"'";
		if(session.createSQLQuery(sql).addEntity(Tbdf02.class).list().isEmpty()){
			throw new RuntimeException("未找到参数代码【"+refId+"】中【"+name+"】对应的映射值");
		}else{
			Tbdf02 data = (Tbdf02) session.createSQLQuery(sql).addEntity(Tbdf02.class).list().get(0);
			Map<String, Object> results = new HashMap<String, Object>();
			
			results.put("key", data.getValueA());
			results.put("value", data.getValueB());
			results.put("desc", data.getDef4());
			results.put("def1", data.getDef1());
			results.put("def2", data.getDef2());
			
			return results;
		}
		
	}
	
}
