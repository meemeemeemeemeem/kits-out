package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.domain.Tbpr01;
import com.kits.inms.utils.QueryUtil;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class Bsjc32BO extends HibernateDao {
    /**
     * @param page
     * @param map
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @DataProvider
    public void loadTbpr01(Page<Tbpr01> page, Map<String, Object> map) throws Exception {
        String hql = " from Tbpr01 where 1=1";

        if (map != null) {
            String compId = (String) map.get("compId") == null ? "" : (String) map.get("compId");                    //公司别
            String processCode = (String) map.get("processCode") == null ? "" : (String) map.get("processCode");    //工序代码
            String processName = (String) map.get("processName") == null ? "" : (String) map.get("processName");    //工序名称
            if (StringUtils.isNotBlank(compId)) {
                hql += " and compId = '" + compId + "'";
            }
            if (StringUtils.isNotBlank(processCode)) {
                hql += " and processCode like '%" + processCode + "%'";
            }
            if (StringUtils.isNotBlank(processName)) {
                hql += " and processName like '%" + processName + "%'";
            }
        }

        hql += " order by createDate desc";        //根据创建日期降序排列
        List<Tbpr01> list = (List<Tbpr01>) this.query(hql, null, page.getPageNo(), page.getPageSize());
        page.setEntities(list);
        page.setEntityCount(this.query(hql).size());
    }

    /**
     * 保存数据到表Tbmw000
     *
     * @param collection
     * @throws Exception
     */
    @DataResolver
    @Transactional
    public void saveTbpr01(Collection<Tbpr01> collection) throws Exception {
        Session session = this.getSession();
        for (Tbpr01 tbpr01 : collection) {
            EntityState entityState = EntityUtils.getState(tbpr01);
            /*新增*/
            if (entityState.equals(EntityState.NEW)) {
                //tbia011.setCreateEmpNo(AppUtils.getLoginUserName());	//创建者
                //tbia011.setCreateDate(new Date());					//创建时间
                //tbia011.setModifyEmpNo(null);							//修改者
                //tbia011.setModifyDate(null);							//修改时间
                session.save(tbpr01);
                /*删除*/
            } else if (entityState.equals(EntityState.DELETED)) {
                session.delete(tbpr01);
                /*修改*/
            } else if (entityState.equals(EntityState.MODIFIED)) {
                //tbia011.setModifyEmpNo(AppUtils.getLoginUserName());	//修改者
                //tbia011.setModifyDate(new Date());					//修改时间
                session.update(tbpr01);
            }
        }
    }

    @DataProvider
    @Expose
    public List<Map> queryBs32() {
        String sql = "select PROCESS_CODE_ key_,PROCESS_NAME_ value_ from TBPR01";
        return new QueryUtil.Builder(sql, getSession()).build().getList();
    }

    @Expose
    public Map<String, Object> queryMapBs32() {
        String sql = "select PROCESS_CODE_ key_,PROCESS_NAME_ value_ from TBPR01";
        try {
            return new QueryUtil.Builder(sql, getSession()).build().getMap();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
