package com.kits.inms.bs.util;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.kits.inms.bs.domain.Tbdm11;
import com.kits.inms.bs.domain.Tbdm12;
import com.kits.inms.df.domain.Tbdf02;
import com.kits.util.UserUtil;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王森浩
 */
@Controller
public class CommonUtils extends HibernateDao {


    /**
     * 查询公共参数
     *
     * @param map 获取固定参数值
     * @return
     */
    @DataProvider
    public Map<String, Object> getIventoryMappings(Map<String, Object> map) {
        String refId = (String) map.get("refId");
        String hql = "from " + Tbdf02.class.getName() + " where refId = '" + refId + "' order by orderNum ";
        List<Tbdf02> tbdf02List = ListUtils.emptyIfNull(this.query(hql));
        if (tbdf02List.isEmpty()) {
            throw new RuntimeException("未找到该参数代码【" + refId + "】对应的参数值信息");
        }
        Map<String, Object> mapValue = new LinkedHashMap<>();
        for (Tbdf02 tbdf02 : tbdf02List) {
            mapValue.put(tbdf02.getValueA(), tbdf02.getValueB());
        }
        return mapValue;
    }
    @DataProvider
    public Map<String, Object> getStockName() {
    	String hql = " from Tbdm11";
    	List<Tbdm11> tbdm11List = this.query(hql);
    	Map<String, Object> mapValue = new LinkedHashMap<>();
        for (Tbdm11 tbdm11 : tbdm11List) {
            mapValue.put(tbdm11.getStockId(), tbdm11.getStockName());
        }
        return mapValue;
    }
    @DataProvider
    public Map<String, Object> getLocName() {
    	String hql = " from Tbdm12";
    	List<Tbdm12> tbdm12List = this.query(hql);
    	Map<String, Object> mapValue = new LinkedHashMap<>();
        for (Tbdm12 tbdm12 : tbdm12List) {
            mapValue.put(tbdm12.getLocNo(), tbdm12.getLocName());
        }
        return mapValue;
    }
    
    @SuppressWarnings("unchecked")
	@DataProvider
	public Map<String, Object> getLoginUser() {

		String hql = "select t1.USERNAME_, t1.CNAME_\n" +
				"from bdf2_user t1\n" +
				"       left join BDF2_USER_PROFILE t2 on t1.USERNAME_ = t2.USERNAME_ and t1.TENANT_ID_ = t2.TENANT_ID_\n" +
				"where t1.COMPANY_ID_ = '" + UserUtil.getLoginCompanyId() + "'\n" +
				"  and t2.DEL_FLAG = '0'";
		List<Object> list = this.getSession().createSQLQuery(hql).list();
		Map<String, Object> mapValue = new LinkedHashMap<>();
		for (Object o : list) {
			Object[] obj = (Object[]) o;
			String key = (String) obj[0];
			String value = (String) obj[1];
			if (StringUtils.isNotEmpty(value)) {
				mapValue.put(key, value);
			} else {
				mapValue.put(key, key);
			}

		}
		return mapValue;
	}
    
    
}
