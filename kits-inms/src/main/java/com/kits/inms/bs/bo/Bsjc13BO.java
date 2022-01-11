package com.kits.inms.bs.bo;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.data.provider.Page;
import com.kits.inms.bs.domain.Tbprocessdetail;
import com.kits.inms.bs.domain.Tbprocessroute;
import com.kits.inms.utils.AppUtils;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.*;

/**
 *
 * @author 杨旭晖
 * @date 5/18/2018
 */
@Controller
public class Bsjc13BO extends HibernateDao {

    @DataResolver
    public void delTbProcessRoute(Collection<Tbprocessroute> collection,Map<String,Object> map){
        StringBuilder routeNos = new StringBuilder();
        for (Tbprocessroute tbprocessroute : collection){
            EntityState entityState = EntityUtils.getState(tbprocessroute);
            if (entityState.equals(EntityState.DELETED)){
                routeNos.append("'").append(tbprocessroute.getProcessRouteNo()).append("'").append(",");
                this.getSession().delete(tbprocessroute);
            }
        }
        routeNos = new StringBuilder(routeNos.substring(0, routeNos.length() - 1));
        String sql = "delete from TBPROCESSDETAIL where PROCESS_ROUTE_NO_ in ("+ routeNos +")";
        this.getSession().createSQLQuery(sql).executeUpdate();
    }

    @DataProvider
    @SuppressWarnings("unchecked")
    public void queryTbProcessRoute(Page<Tbprocessroute> page,Map<String,Object> map){
        String hql = "select tb1 from Tbprocessroute tb1 where tb1.compId = '"+ AppUtils.getLoginUser().getCompanyId() +"'";
        if (map != null){
            String processIdStart = (String) map.get("processIdStart");
            String processIdEnd = (String) map.get("processIdEnd");
            String processRouteNo = (String) map.get("processRouteNo");

            if ((processIdStart != null && !"".equals(processIdStart)) || (processIdEnd != null && !"".equals(processIdEnd))){
                String join1 = "";
                String join2 = "";
                String cond = "";
                String cond1 = "";
                String cond2 = "";
                if (processRouteNo != null && !"".equals(processRouteNo)){
                    cond = " and t1.PROCESS_ROUTE_NO_ = '"+ processRouteNo +"'";
                }
                if (processIdStart != null && !"".equals(processIdStart)){
                    join1 = " left join TBPROCESSDETAIL t2 " +
                            "on t1.COMP_ID_ = t2.COMP_ID_ and t1.PROCESS_ROUTE_NO_ = t2.PROCESS_ROUTE_NO_ ";
                    cond1 = " and t2.PROCESS_ID_ = '"+ processIdStart +"' and to_number(t2.PROCESS_SEQ_) = " +
                            " (select min(to_number(t4.PROCESS_SEQ_)) from TBPROCESSDETAIL t4 where t4.COMP_ID_ = t1.COMP_ID_ " +
                            " and t4.PROCESS_ROUTE_NO_ = t1.PROCESS_ROUTE_NO_) ";
                }
                if (processIdEnd != null && !"".equals(processIdEnd)){
                    join2 = " left join TBPROCESSDETAIL t3 " +
                            " on t3.COMP_ID_ = t1.COMP_ID_ and t3.PROCESS_ROUTE_NO_ = t1.PROCESS_ROUTE_NO_ ";
                    cond2 = " and t3.PROCESS_ID_ = '"+ processIdEnd +"' and to_number(t3.PROCESS_SEQ_) = " +
                            " (select max(to_number(t5.PROCESS_SEQ_)) from TBPROCESSDETAIL t5 where t5.COMP_ID_ = t1.COMP_ID_ " +
                            " and t5.PROCESS_ROUTE_NO_ = t1.PROCESS_ROUTE_NO_) ";
                }
                String sql1 = " select * from ( " +
                        " select ROWNUM rn,A.* from ( " +
                        "    select t1.* from TBPROCESSROUTE t1 " +
                        "        "+ join1 +" " +
                        "        "+ join2 +" " +
                        "        where 1 = 1 " +
                        "           "+ cond +" " +
                        "           "+ cond1 +" " +
                        "           "+ cond2 +" " +
                    "        order by t1.PROCESS_ROUTE_NO_  ) A " +
                        " where ROWNUM <= "+ page.getPageSize()* page.getPageNo() +" ) B where B.rn > "+ page.getPageSize() * (page.getPageNo() - 1) +" ";
                String sql2 = " select t1.* " +
                        "    from TBPROCESSROUTE t1 " +
                        "      "+ join1 +" " +
                        "      "+ join2 +" " +
                        "       where 1 = 1 " +
                        "         "+ cond1 +" " +
                        "         "+ cond2 +" " +
                        "         "+ cond +" ";

                List list =  this.getSession().createSQLQuery(sql1).list();
                List<Tbprocessroute> lists = new ArrayList<>();
                for (Object obj : list){
                    lists.add(new Tbprocessroute(((Object[]) obj)));
                }
                page.setEntities(lists);
                page.setEntityCount(this.getSession().createSQLQuery(sql2).list().size());
            }else{
                if (processRouteNo != null && !"".equals(processRouteNo)){
                    hql += " and processRouteNo = '"+ processRouteNo +"' ";
                }
                List<Tbprocessroute> list = (List<Tbprocessroute>) this.query(hql,null,page.getPageNo(),page.getPageSize());
                page.setEntities(list);
                page.setEntityCount(this.query(hql).size());
            }
        }
    }

    @DataProvider
    @SuppressWarnings("unchecked")
    public void queryTbprocessDetal(Page<Tbprocessdetail> page,Map<String,Object> map){
        String hql = "from Tbprocessdetail where compId = '"+ AppUtils.getLoginUser().getCompanyId() +"'";
        if (map != null){
            String processRouteNo = (String) map.get("processRouteNo");

            if (processRouteNo != null && !"".equals(processRouteNo)){
                hql += "and processRouteNo = '"+ processRouteNo +"'";
                hql += " order by processSeq ";
                List<Tbprocessdetail> list = (List<Tbprocessdetail>) this.query(hql,null,page.getPageNo(),page.getPageSize());
                page.setEntities(list);
                page.setEntityCount(this.query(hql).size());
            }
     
        }
        
    }

    @DataResolver
    public String saveTbprocessRoute(Tbprocessroute tbprocessroute,Map<String,Object> map){
        EntityState entityState = EntityUtils.getState(tbprocessroute);
        String type = "";
        switch (tbprocessroute.getProcessRouteType()){
            case "01" : type = "A";break;
            case "02" : type = "B";break;
            case "03" : type = "C";break;
            case "04" : type = "D";break;
            case "05" : type = "E";break;
            default:
        }
        if (entityState.equals(EntityState.NEW)){
            String sql = "select MAX(CAST(SUBSTR(PROCESS_ROUTE_NO_,2) AS INT)) FROM TBPROCESSROUTE WHERE PROCESS_ROUTE_TYPE_ LIKE '%"+ tbprocessroute.getProcessRouteType() +"'";
            List result = this.getSession().createSQLQuery(sql).list();
            String routeNo;
            if (result.get(0) != null){
                BigDecimal temp = (BigDecimal)result.get(0);
                routeNo = String.valueOf(temp.intValue());
                routeNo = type + String.format("%04d",Integer.parseInt(routeNo)+1);
            }else {
                routeNo = type + "0000";
            }
            tbprocessroute.setPkProcessRoute(AppUtils.getUUIDKey());
            tbprocessroute.setProcessRouteNo(routeNo);
            tbprocessroute.setCompId(AppUtils.getLoginUser().getCompanyId());
            tbprocessroute.setCreateDate(new Date());
            tbprocessroute.setCreateEmpNo(AppUtils.getLoginUserName());
            this.getSession().save(tbprocessroute);
            return routeNo;
        }else if (entityState.equals(EntityState.MODIFIED)){
            String t1 = tbprocessroute.getProcessRouteType();
            String t2 = "";
            switch (tbprocessroute.getProcessRouteNo().subSequence(0,1).toString()){
                case "A" : t2 = "01";break;
                case "B" : t2 = "02";break;
                case "C" : t2 = "03";break;
                case "D" : t2 = "04";break;
                case "E" : t2 = "05";break;
                default:
            }
            String routeNo;
            if (!t2.equals(t1)){
                String sql = "select MAX(CAST(SUBSTR(PROCESS_ROUTE_NO_,2) AS INT)) FROM TBPROCESSROUTE WHERE PROCESS_ROUTE_TYPE_ LIKE '%"+ tbprocessroute.getProcessRouteType() +"'";
                List result = this.getSession().createSQLQuery(sql).list();
                if (result.get(0) != null){
                    BigDecimal temp = (BigDecimal)result.get(0);
                    routeNo = String.valueOf(temp.intValue());
                    routeNo = type + String.format("%04d",Integer.parseInt(routeNo)+1);
                }else {
                    routeNo = type + "0000";
                }
                tbprocessroute.setProcessRouteNo(routeNo);
            }else {
                routeNo = tbprocessroute.getProcessRouteNo();
            }
            tbprocessroute.setModifyDate(new Date());
            tbprocessroute.setModifyEmpNo(AppUtils.getLoginUserName());
            this.getSession().update(tbprocessroute);
            return routeNo;
        }else if (entityState.equals(EntityState.DELETED)){
            this.getSession().delete(tbprocessroute);
            return tbprocessroute.getProcessRouteNo();
        }
        return null;
    }

    @DataResolver
    public void saveTbprocessDetail(Collection<Tbprocessdetail> collection,Map<String,Object> map){
        String routeNo = (String) map.get("routeNo");
        for (Tbprocessdetail tbprocessdetail : collection){
            EntityState entityState = EntityUtils.getState(tbprocessdetail);
            if (entityState.equals(EntityState.NEW)){
                tbprocessdetail.setPkProcessDetail(AppUtils.getUUIDKey());
                tbprocessdetail.setCompId(AppUtils.getLoginUser().getCompanyId());
                tbprocessdetail.setProcessRouteNo(routeNo);
                tbprocessdetail.setCreateDate(new Date());
                tbprocessdetail.setCreateEmpNo(AppUtils.getLoginUserName());
                this.getSession().save(tbprocessdetail);
            }else if (entityState.equals(EntityState.MODIFIED)){
                tbprocessdetail.setProcessRouteNo(routeNo);
                tbprocessdetail.setModifyDate(new Date());
                tbprocessdetail.setModifyEmpNo(AppUtils.getLoginUserName());
                this.getSession().update(tbprocessdetail);
            }else if (entityState.equals(EntityState.DELETED)){
                this.getSession().delete(tbprocessdetail);
            }
        }
    }

}
