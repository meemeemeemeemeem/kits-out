package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.domain.Tbqualitydefects;
import com.kits.inms.utils.AppUtils;
import com.kits.inms.utils.QueryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 杨旭晖
 * @date 4/28/2018
 */
@Controller
public class Bsjc11BO extends HibernateDao{

    @SuppressWarnings("unchecked")
    @DataResolver
    @Transactional(rollbackFor = Exception.class)
    public void saveTbqualitydefects(Collection<Tbqualitydefects> collection, Map<String,Object> map) {
        for (Tbqualitydefects tb : collection){
            EntityState entityState = EntityUtils.getState(tb);
            if (entityState.equals(EntityState.NEW)){
                String sql = "select count(QUALITY_DEFECTS_CODE_) from TBQUALITYDEFECTS where QUALITY_DEFECTS_CODE_ = '"+ tb.getQualityDefectsCode() +"'";
                BigDecimal no = (BigDecimal) this.getSession().createSQLQuery(sql).list().get(0);
                if (no.compareTo(BigDecimal.ZERO) > 0){
                    throw new RuntimeException("质量缺陷代码已被使用，请重新输入!");
                }
                tb.setCompId(AppUtils.getLoginUser().getCompanyId());
                tb.setCreateDate(new Date());
                tb.setCreateEmpNo(AppUtils.getLoginUserName());
                tb.setPkQualityDefects(AppUtils.getUUIDKey());
                this.getSession().save(tb);
            }else if (entityState.equals(EntityState.MODIFIED)){
                tb.setModifyDate(new Date());
                tb.setModifyEmpNo(AppUtils.getLoginUserName());
                this.getSession().update(tb);
            }else if (entityState.equals(EntityState.DELETED)){
                this.getSession().delete(tb);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @DataProvider
    public void queryTbqualitydefects(Page<Tbqualitydefects> page, Map<String,Object> map){
        String hql = "from Tbqualitydefects where compId = '"+ AppUtils.getLoginUser().getCompanyId() +"'";
        if (map != null){
            String qualityDefectsCode = (String) map.get("qualityDefectsCode");
            String qualityDefectsName = (String) map.get("qualityDefectsName");

            if (qualityDefectsCode != null && !"".equals(qualityDefectsCode)){
                hql += " and qualityDefectsCode like '%"+ qualityDefectsCode +"%'";
            }
            if (qualityDefectsName != null && !"".equals(qualityDefectsName)){
                hql += " and qualityDefectsName like '%"+ qualityDefectsName +"%'";
            }
        }
        List<Tbqualitydefects> list = (List<Tbqualitydefects>) this.query(hql,null,page.getPageNo(),page.getPageSize());
        page.setEntities(list);
        page.setEntityCount(this.query(hql).size());
    }

    @DataProvider
    @Expose
    public List<Map> queryBs011(){
        String sql = "select PD_MILL_NO_ key_,PD_MILL_NAME_ value_ from TBPRODUCTIONMILL " +
                " where COMP_ID_ = '"+ AppUtils.getLoginUser().getCompanyId() +"'";
        return new QueryUtil.Builder(sql, getSession()).build().getList();
    }

}
