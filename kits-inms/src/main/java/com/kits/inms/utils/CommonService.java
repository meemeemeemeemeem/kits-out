package com.kits.inms.utils;

import java.util.Map;

public interface CommonService {

	/**
	 * 获取料号信息
	 * @param map
	 * @return
	 */
	public Map<String, Object> getMatrl(Map<String, Object> map);
	
	/**
	 * 获取映射信息
	 * @param map
	 * @return
	 */
	public Map<String, Object> getMapping(Map<String, Object> map);
	
	/**
	 * 获取键值信息
	 * @param map
	 * @return
	 */
	public Map<String, Object> getValue(Map<String, Object> map);
	
	/**
	 *获取客商信息
	 * @param map
	 * @return
	 */
	public Map<String, Object> getVendor(Map<String, Object> map);
	
}
