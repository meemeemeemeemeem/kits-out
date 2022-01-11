package com.kits.inms.df.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.df.domain.Tbdf01;
import com.kits.inms.utils.AppUtils;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class Dfjc01bBO extends HibernateDao {

	@DataProvider
	public void queryDf01(Page<Tbdf01> page, String pid) {

		String sql = "";
		if (AppUtils.isNotEmpty(pid)) {
			sql = " from Tbdf01 where def2 ='" + pid + "'";
		} else {
			sql = "  from Tbdf01 where def2 is null";
		}
		
		sql += " and type = 'B'  order by createDate asc,updDate desc";
		@SuppressWarnings("unchecked")
		List<Tbdf01> dataList = (List<Tbdf01>) this.query(sql, null,
				page.getPageNo(), page.getPageSize());
		page.setEntities(dataList);
	}

	@DataResolver
	public void saveDf01(Collection<Tbdf01> dataList) {
		for (Tbdf01 ch01 : dataList) {
			EntityState state = EntityUtils.getState(ch01);
			if (state.equals(EntityState.NEW)) {

				ch01.setPkDf01(AppUtils.getUUIDKey());
				ch01.setType("B");
				ch01.setCreateDate(new Date());
				ch01.setCreateEmp(AppUtils.getLoginUserName());

				this.getSession().save(ch01);
			} else if (state.equals(EntityState.MODIFIED)) {

				String refId = ch01.getRefId();
				
				String refIdOld = EntityUtils.getOldString(ch01, "refId");
				String sql = "update Tbdf02 set ref_id_='" + refId
						+ "' where  ref_id_='" + refIdOld + "' and type_='B'";
				
				this.getSession().createSQLQuery(sql).executeUpdate();
				
				ch01.setUpdDate(new Date());
				ch01.setUpdEmp(AppUtils.getLoginUserName());
				this.getSession().update(ch01);

			}
		}
	}

	@Expose
	public boolean delNodes(Map<String, Object> map) {
		String refId = (String) map.get("refId");

		String sql = "delete from Tbdf01 where  ref_id_='"
				+ refId + "' and type_='B'";
		String sql2 = "delete from Tbdf01 where  def2_='"
				+ refId + "' and type_='B'";
		String sql1 = "delete from Tbdf02 where  ref_id_='"
				+ refId + "' and type_='B' ";
		this.getSession().createSQLQuery(sql1).executeUpdate();
		this.getSession().createSQLQuery(sql).executeUpdate();
		this.getSession().createSQLQuery(sql2).executeUpdate();

		return true;
	}

	@Expose
	public boolean getRefId(Map<String, Object> map) {

		// String compId = (String) map.get("compId");
		String refId = (String) map.get("refId");

		String sql = "select ref_id_ from Tbdf01 where ref_id_='"
				+ refId + "' and type_='B'";

		String refId1 = (String) this.getSession().createSQLQuery(sql)
				.uniqueResult();

		if (AppUtils.isNotEmpty(refId1)) {
			return false;
		} else {
			return true;
		}
	}

}
