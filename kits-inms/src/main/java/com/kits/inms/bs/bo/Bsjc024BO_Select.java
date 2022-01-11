package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.domain.Tbbs021;
import com.kits.inms.bs.domain.Tbbs024;
import com.kits.inms.utils.AppUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;



@Controller
public class Bsjc024BO_Select extends HibernateDao{

    @SuppressWarnings("unchecked")
    @DataProvider
    public void queryBs024(Page<Tbbs024> page, Map<String, Object> map) throws Exception {
    	String hql = " from Tbbs024 where 1=1 ";
        if (map != null) {
            String productName = (String) map.get("productName") == null ? "" : (String) map.get("productName");
            if (StringUtils.isNotBlank(productName)) {
                hql += " and productName  like '%" + productName + "%' ";
            }
            String status = (String) map.get("status");
			if (AppUtils.isNotEmpty(status)) {
				hql += " and status = '" + status + "'";
			}
			 //产品大类
            String tradeName = (String) map.get("tradeName") == null ? "" : (String) map.get("tradeName");
            if (StringUtils.isNotBlank(tradeName)) {
            	hql += " and tradeName like '%" + tradeName + "%'";
            }
        }

        List<Tbbs024> list = (List<Tbbs024>) this.query(hql, null, page.getPageNo(), page.getPageSize());
        page.setEntities(list);
        page.setEntityCount(this.query(hql).size());
    }
    
	/**
	 * 查询品名信息
	 * 
	 * @param page
	 * @param pid
	 */
	@DataProvider
	public void queryBs021(Page<Tbbs021> page, String pid) {

		String sql = "";
		if (AppUtils.isNotEmpty(pid)) {
			sql = " from Tbbs021 where pid ='" + pid + "'";
		} else {
			sql = "  from Tbbs021 where pid is null";
		}

		sql += " order by createDate asc,updDate desc";
		@SuppressWarnings("unchecked")
		List<Tbbs021> dataList = (List<Tbbs021>) this.query(sql, null,
				page.getPageNo(), page.getPageSize());

		page.setEntities(dataList);
	}
    
    
    
    

}
