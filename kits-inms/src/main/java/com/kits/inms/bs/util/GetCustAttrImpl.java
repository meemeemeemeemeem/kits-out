package com.kits.inms.bs.util;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.kits.inms.utils.AppUtils;
import org.springframework.stereotype.Service;

@Service("getCustAttrITF")
public class GetCustAttrImpl extends HibernateDao implements GetCustAttrITF {

	@Override
	public String getCustAttr(String custNo) {

		String sql = " select YONGYOU_CUST_NO_ from Tbcm011 where CUST_NO_ = '"
				+ custNo + "' and comp_id_='"
				+ AppUtils.getLoginUser().getCompanyId() + "'";

		String  custAttr = (String) this.getSession().createSQLQuery(sql).uniqueResult();
		
		return custAttr;
		
		}
}
