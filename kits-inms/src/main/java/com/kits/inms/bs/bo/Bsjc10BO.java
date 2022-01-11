package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.domain.Tbproductionmill;
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
public class Bsjc10BO extends HibernateDao{

    @SuppressWarnings("unchecked")
    @DataResolver
    @Transactional(rollbackFor = Exception.class)
    public void saveTbproductionmill(Collection<Tbproductionmill> collection, Map<String,Object> map) {
        for (Tbproductionmill tb : collection){
            EntityState entityState = EntityUtils.getState(tb);
            if (entityState.equals(EntityState.NEW)){
                String sql = "select count(PD_MILL_NO_) from TBPRODUCTIONMILL where PD_MILL_NO_ = '"+ tb.getPdMillNo() +"'";
                BigDecimal no = (BigDecimal) this.getSession().createSQLQuery(sql).list().get(0);
                if (no.compareTo(BigDecimal.ZERO) > 0){
                    throw new RuntimeException("机组编号已被使用，请重新输入!");
                }
                tb.setCompId(AppUtils.getLoginUser().getCompanyId());
                tb.setPkProductionMill(AppUtils.getUUIDKey());
                tb.setCreateDate(new Date());
                tb.setCreateEmpNo(AppUtils.getLoginUserName());
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
    public void queryTbproductionmill(Page<Tbproductionmill> page,Map<String,Object> map){
        String hql = "from Tbproductionmill where 1 = 1 and compId = '"+ AppUtils.getLoginUser().getCompanyId() +"'";
        if (map != null){
            String pdMillNo = (String) map.get("pdMillNo");
            String pdMillName = (String) map.get("pdMillName");

            if (pdMillNo != null && !"".equals(pdMillNo)){
                hql += " and pdMillNo like '%"+ pdMillNo +"%'";
            }
            if (pdMillName != null && !"".equals(pdMillName)){
                hql += " and pdMillName like '%"+ pdMillName +"%'";
            }
        }
        List<Tbproductionmill> list = (List<Tbproductionmill>) this.query(hql,null,page.getPageNo(),page.getPageSize());
        page.setEntities(list);
        page.setEntityCount(this.query(hql).size());
    }

}
