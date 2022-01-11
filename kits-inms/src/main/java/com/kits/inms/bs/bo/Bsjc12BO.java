package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.domain.Tbqualitygrade;
import com.kits.inms.utils.AppUtils;
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
public class Bsjc12BO extends HibernateDao {

    @SuppressWarnings("unchecked")
    @DataResolver
    @Transactional(rollbackFor = Exception.class)
    public void saveTbqualitygrade(Collection<Tbqualitygrade> collecion, Map<String,Object> map) {
        for (Tbqualitygrade tb : collecion){
            EntityState entityState = EntityUtils.getState(tb);
            if (entityState.equals(EntityState.NEW)){
                String sql = "select count(QUALITY_GRADE_CODE_) from TBQUALITYGRADE where QUALITY_GRADE_CODE_ = '"+ tb.getQualityGradeCode() +"'";
                BigDecimal no = (BigDecimal) this.getSession().createSQLQuery(sql).list().get(0);
                if (no.compareTo(BigDecimal.ZERO) > 0){
                    throw new RuntimeException("质量等级代码已被使用，请重新输入!");
                }
                tb.setCompId(AppUtils.getLoginUser().getCompanyId());
                tb.setCreateDate(new Date());
                tb.setCreateEmpNo(AppUtils.getLoginUserName());
                tb.setPkQualityGrade(AppUtils.getUUIDKey());
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
    public void queryTbqualitygrade(Page<Tbqualitygrade> page,Map<String,Object> map){
        String hql = "from Tbqualitygrade where compId = '"+ AppUtils.getLoginUser().getCompanyId() +"'";
        if (map != null){
            String qualityGradeCode = (String) map.get("qualityGradeCode");
            String qualityGradeName = (String) map.get("qualityGradeName");

            if (qualityGradeCode != null && !"".equals(qualityGradeCode)){
                hql += " and qualityGradeCode like '%"+ qualityGradeCode +"%'";
            }
            if (qualityGradeName != null && !"".equals(qualityGradeName)){
                hql += " and qualityGradeName like '%"+ qualityGradeName +"%'";
            }
        }
        List<Tbqualitygrade> list = (List<Tbqualitygrade>) this.query(hql,null,page.getPageNo(),page.getPageSize());
        page.setEntities(list);
        page.setEntityCount(this.query(hql).size());
    }

}
