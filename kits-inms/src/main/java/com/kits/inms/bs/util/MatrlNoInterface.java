package com.kits.inms.bs.util;

import com.kits.inms.bs.domain.Tbbs022;
import com.kits.inms.bs.domain.Tbbs023;
import com.kits.inms.bs.domain.Tbdm01;

public interface MatrlNoInterface {

	/**
	 * 获取料号
	 * @param inv 料别
	 * @param pdType 生产类型
	 * @param matrlName 钢种
	 * @param thick 厚度
	 * @return
	 */
	public abstract String getMatrlNo(Tbdm01 dm01);
	
	/**
	 * 获取尺寸信息
	 * @param dm01
	 * @return
	 */
	public abstract String getSizeInfo(Tbbs022 bs022);
	
	/**
	 * 获取材质信息
	 * @param dm01
	 * @return
	 */
	public abstract String getMatInfo(Tbbs022 bs022);
	
	/**
	 * 获取质量信息
	 * @param dm01
	 * @return
	 */
	public abstract String getQualityInfo(Tbbs023 bs023);

}
