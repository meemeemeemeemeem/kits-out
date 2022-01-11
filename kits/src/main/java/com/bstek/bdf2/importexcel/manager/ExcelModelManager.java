package com.bstek.bdf2.importexcel.manager;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.importexcel.ImportExcelHibernateDao;
import com.bstek.bdf2.importexcel.model.ExcelModel;
import com.bstek.bdf2.importexcel.model.ExcelModelDetail;
import com.bstek.bdf2.importexcel.utils.ConnectionHelper;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.utils.AppUtils;
import com.kits.util.XytContextHolder;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.*;


@Service(ExcelModelManager.BEAN_ID)
public class ExcelModelManager extends ImportExcelHibernateDao {

	public static final String BEAN_ID = "bdf2.ExcelModelManager";

	private ConnectionHelper connectionHelper = new ConnectionHelper();

	public void loadExcelModels(Page<ExcelModel> page, DetachedCriteria detachedCriteria) throws Exception {
		detachedCriteria.add(Restrictions.eq("companyId", ContextHolder.getLoginUser().getCompanyId()));
		findPageByCriteria(detachedCriteria, page);
	}

	public void insertExcelModel(ExcelModel excelModel) throws Exception {
		excelModel.setId(AppUtils.getUUIDKey());
		excelModel.setCreateDate(new Date());
		excelModel.setCompanyId(ContextHolder.getLoginUser().getCompanyId());
		save(excelModel);
	}

	public void deleteExcelModelById(String excelModelId) throws Exception {
		Session session = this.getSessionFactory().openSession();
		String hqlDelete = "delete ExcelModel e where e.id = :excelModelId";
		try {
			session.createQuery(hqlDelete).setString("excelModelId", excelModelId).executeUpdate();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void updateExcelModel(ExcelModel excelModel) throws Exception {
		update(excelModel);
	}

	@SuppressWarnings("rawtypes")
	public ExcelModel findExcelModelById(String excelModelId) throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ExcelModel.class, "m");
		detachedCriteria.add(Restrictions.eq("excelCode", excelModelId));
		List list = findByCriteria(detachedCriteria);
		if (list.isEmpty()) {
			return null;
		} else {
			return (ExcelModel) list.get(0);
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ExcelModelDetail> findExcelModelDetailByModelId(String modelId) throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ExcelModelDetail.class, "m");
		detachedCriteria.add(Restrictions.eq("excelModelId", modelId));
		detachedCriteria.addOrder(Order.asc("excelColumn"));
		List list = findByCriteria(detachedCriteria);
		return list;
	}

	public void insertExcelModelDetail(ExcelModelDetail excelModelDetail) throws Exception {
		save(excelModelDetail);
	}

	public void deleteExcelModelDetailById(String excelModelDetailId) throws Exception {
		Session session = this.getSessionFactory().openSession();
		String hqlDelete = "delete ExcelModelDetail e where e.id = :excelModelDetailId";
		try {
			session.createQuery(hqlDelete).setString("excelModelDetailId", excelModelDetailId).executeUpdate();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void deleteExcelModelDetailByModelId(String excelModelId) throws Exception {
		Session session = this.getSessionFactory().openSession();
		String hqlDelete = "delete ExcelModelDetail e where e.excelModelId = :excelModelId";
		try {
			session.createQuery(hqlDelete).setString("excelModelId", excelModelId).executeUpdate();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void updateExcelModelDetail(ExcelModelDetail excelModelDetail) throws Exception {
		update(excelModelDetail);
	}

	@SuppressWarnings("rawtypes")
	public ExcelModelDetail findExcelModelDetail(String modelId, int excelColumn) throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ExcelModelDetail.class, "m");
		detachedCriteria.add(Restrictions.eq("excelModelId", modelId));
		detachedCriteria.add(Restrictions.eq("excelColumn", excelColumn));
		List list = findByCriteria(detachedCriteria);
		if (list.isEmpty()) {
			return null;
		} else {
			return (ExcelModelDetail) list.get(0);
		}
	}

	@SuppressWarnings("rawtypes")
	public ExcelModelDetail findExcelModelDetailByModelIdAndPrimaryKey(String modelId, String tableColumn)
			throws Exception {
		
		// 考虑公司架构较多，同一模板允许在不同公司出现，前端引用excelCode，通过companyId反推模板id
		String companyId = XytContextHolder.getLoginUser().getCompanyId();
		String hql = " from ExcelModel t where t.companyid_ =:companyId and t.excel_code = :excelCode ";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		map.put("excelCode", modelId);
		List<ExcelModel> excelModels =  this.query(hql, map);
		if(excelModels.size()>0){
			ExcelModel excelModel = excelModels.get(0);
			modelId = excelModel.getId();
		}
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ExcelModelDetail.class, "m");
		detachedCriteria.add(Restrictions.eq("excelModelId", modelId));
		detachedCriteria.add(Restrictions.eq("tableColumn", tableColumn));
		List list = findByCriteria(detachedCriteria);
		if (list.isEmpty()) {
			return null;
		} else {
			return (ExcelModelDetail) list.get(0);
		}
	}

	public List<String> findAllTables(String dataSourceName) throws Exception {
		List<String> tablesList = new ArrayList<String>();
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = connectionHelper.getConnection(dataSourceName);
			DatabaseMetaData metaData = conn.getMetaData();
			String url = metaData.getURL();
			String schema = null;
			if (url.toLowerCase().contains("oracle")) {
				schema = metaData.getUserName();
			}
			rs = metaData.getTables(null, schema, "%", new String[] { "TABLE" });
			while (rs.next()) {
				tablesList.add(rs.getString("TABLE_NAME").toLowerCase());
			}
			return tablesList;
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
	}

	public List<String> findTablePrimaryKeys(String dataSourceName, String tableName) throws Exception {
		List<String> primaryKeys = new ArrayList<String>();
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = connectionHelper.getConnection(dataSourceName);
			DatabaseMetaData metaData = conn.getMetaData();
			rs = metaData.getPrimaryKeys(null, null, tableName.toUpperCase());
			while (rs.next()) {
				primaryKeys.add(rs.getString("COLUMN_NAME").toLowerCase());
			}
			return primaryKeys;
		} finally {
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
	}

	public List<String> findTableColumnNames(String dataSourceName, String tableName) throws Exception {
		List<String> list = new ArrayList<String>();
		if (StringUtils.isNotEmpty(tableName)) {
			Connection conn = null;
			ResultSet rs = null;
			try {
				conn = connectionHelper.getConnection(dataSourceName);
				DatabaseMetaData metaData = conn.getMetaData();
				rs = metaData.getColumns(null, null, tableName.toUpperCase(), "%");
				while (rs.next()) {
					list.add(rs.getString("COLUMN_NAME").toLowerCase());
				}
				return list;
			} finally {
				if (conn != null) {
					conn.close();
				}
				if (rs != null) {
					rs.close();
				}
			}
		}
		return list;
	}

}
