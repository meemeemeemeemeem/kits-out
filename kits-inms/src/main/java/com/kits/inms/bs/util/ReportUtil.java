package com.kits.inms.bs.util;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.google.common.collect.Maps;
import com.kits.inms.utils.AppUtils;
import com.kits.inms.utils.QueryUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ReportUtil extends HibernateDao {
    private static final Logger logger = LoggerFactory.getLogger(ReportUtil.class);

    private static final SimpleDateFormat sdf = new SimpleDateFormat(
            "yyyy-MM-dd", Locale.ENGLISH);

    /**
     * 获取公共参数值
     *
     * @param valueA
     * @param refId
     * @return
     */
    public String getShowValue(Object valueA, String refId) {
        Session session = getSession();
        String str = "无";
        String sql = "select VALUE_B_ from TBDF02" +
                " where REF_ID_ = '" + refId + "' and VALUE_A_='" + valueA + "'";
        List list = session.createSQLQuery(sql).list();
        if (list != null && list.size() > 0) {
            str = (String) list.get(0);
        }
        return str;
    }

    /**
     * 获取客商信息
     *
     * @return
     */
    public List<Map<String,Object>> getCust(String dsName, String datasetName,
                             Map<String, Object> map) {
        Map<String, Object> mapa = null;
        String custNo = (String) map.get("custNo");
        // 名称 地址 法定代表人 电话/传真 开户银行 税号 帐号 邮政编码
        String sql = "select"
                + " t1.COMP_CHIN_ COMP_CHIN_,"
                + // 名称
                "	t2.COMP_PHONE_ COMP_PHONE_,"
                + // 电话
                "	t1.DUTY_PERSON_ DUTY_PERSON_,"
                + // 法定代表人
                "	t2.COMP_ADDR_ COMP_ADDR_,"
                + // 地址
                "	t2.ZIPE_CODE_ ZIPE_CODE_,"
                + // 邮编
                "	t2.TAX_NUMBER_ TAX_NUMBER_, "
                + // 税号
                "	t2.BANK_NO_ BANK_NO_, "
                + // 开户银行
                "	t2.BANK_ACCOUNT_ BANK_ACCOUNT_ "
                + // 税号
                "	from Tbcm011 t1 left join Tbbs012 t2 on t1.cust_no_=t2.cust_no_ where t2.CUST_NO_='"
                + custNo + "'";

        List<Map<String,Object>> list = new QueryUtil.Builder(sql, getSession()).build()
                .getList();

        List<Map<String,Object>> listA = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (Map map2 : list) {
                mapa = new HashMap();
                mapa.put("compChin", map2.get("compChin"));
                mapa.put("compPhone", map2.get("compPhone"));
                mapa.put("dutyPerson", map2.get("dutyPerson"));
                mapa.put("compAddr", map2.get("compAddr"));
                mapa.put("zipCode", map2.get("zipeCode"));
                mapa.put("taxNumber", map2.get("taxNumber"));
                mapa.put("bankNo", map2.get("bankNo"));
                mapa.put("bankAccount", map2.get("bankAccount"));

                listA.add(mapa);
            }

            return listA;
        }
        return new ArrayList<>();
    }

    /**
     * 获取客商信息
     *
     * @return
     */
    public List<Map<String,Object>> getMyCust(String dsName, String datasetName,
                               Map<String, Object> map) {
        Map<String, Object> mapa = null;
        String flag="Y";
        // 名称 地址 法定代表人 电话/传真 开户银行 税号 帐号 邮政编码
        String sql = "select"
                + " t1.COMP_CHIN_ COMP_CHIN_,"
                + // 名称
                "	t2.COMP_PHONE_ COMP_PHONE_,"
                + // 电话
                "	t1.DUTY_PERSON_ DUTY_PERSON_,"
                + // 法定代表人
                "	t2.COMP_ADDR_ COMP_ADDR_,"
                + // 地址
                "	t2.ZIPE_CODE_ ZIPE_CODE_,"
                + // 邮编
                "	t2.TAX_NUMBER_ TAX_NUMBER_, "
                + // 税号
                "	t2.BANK_NO_ BANK_NO_, "
                + // 开户银行
                "	t2.BANK_ACCOUNT_ BANK_ACCOUNT_ "
                + // 税号
                "	from Tbcm011 t1 left join Tbbs012 t2 on t1.cust_no_=t2.cust_no_ where "
                +"t1.defs02_='"+flag+"'";

        List<Map<String,Object>> list = new QueryUtil.Builder(sql, getSession()).build()
                .getList();

        List<Map<String,Object>> listA = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (Map map2 : list) {
                mapa = new HashMap();
                mapa.put("compChin", map2.get("compChin"));
                mapa.put("compPhone", map2.get("compPhone"));
                mapa.put("dutyPerson", map2.get("dutyPerson"));
                mapa.put("compAddr", map2.get("compAddr"));
                mapa.put("zipCode", map2.get("zipeCode"));
                mapa.put("taxNumber", map2.get("taxNumber"));
                mapa.put("bankNo", map2.get("bankNo"));
                mapa.put("bankAccount", map2.get("bankAccount"));

                listA.add(mapa);
            }

            return listA;
        }
        return new ArrayList<>();
    }


    public List<Map<String, Object>> getLoginUser(String dsName,
                                                  String datasetName, Map<String, Object> map) {
        String hql = "select t1.USERNAME_," + " t1.CNAME_ "
                + " from bdf2_user t1 " + " left join BDF2_USER_PROFILE t2 "
                + " on t1.USERNAME_=t2.USERNAME_	" + " where t1.COMPANY_ID_='"
                + AppUtils.getLoginUser().getCompanyId()
                + "' and t2.DEL_FLAG='0'";

        @SuppressWarnings("unchecked")
        List<Object> list = this.getSession().createSQLQuery(hql).list();

        List<Map<String, Object>> list1 = new ArrayList<>();

        for (Object o : list) {
            Object[] obj = (Object[]) o;
            String key = (String) obj[0];
            String value = (String) obj[1];

            Map<String, Object> mapValue = new HashMap<String, Object>();

            if (AppUtils.isNotEmpty(value)) {
                mapValue.put("userName", key);
                mapValue.put("cName", value);
            } else {
                mapValue.put("userName", key);
                mapValue.put("cName", key);
            }

            list1.add(mapValue);

        }
        return list1;
    }

    /**
     * 将对象转换为map
     *
     * @param bean
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将结构相似的dto转化为bean
     * 仅处理String,BigDecimal,Date,Timestamp类型
     *
     * @param dto
     * @param bean
     * @param <T>
     * @param <U>
     * @return
     * @throws Exception
     */
    public static <T, U> U dtoToBean(T dto, U bean) throws Exception {
        // 获取dto实体类的所有属性，返回Field数组
        Field[] dtoField = dto.getClass().getDeclaredFields();
        Field[] beanField = bean.getClass().getDeclaredFields();
        Set set = new HashSet();
        for (Field field : beanField) {
            set.add(field.getName());
        }

        // 遍历所有属性
        for (int j = 0; j < dtoField.length; j++) {
            // 获取属性的名字
            String name = dtoField[j].getName();

            //dto的属性名不在bean中,跳过当前循环
            if (!set.contains(name)) {
                continue;
            }

            // 获取属性的类型
            String type = dtoField[j].getGenericType().toString();
            // 将属性的首字符大写，方便构造get，set方法
            String UpperName = name.substring(0, 1).toUpperCase() + name.substring(1);
            if (type.equals("class java.lang.String")) {
                Method m = dto.getClass().getDeclaredMethod("get" + UpperName);
                // 调用getter方法获取属性值
                String value = (String) m.invoke(dto);
                if (value != null) {
                    // 调用setter方法装载属性值
                    m = bean.getClass().getDeclaredMethod("set" + UpperName, String.class);
                    doMethod(m, bean, value);
                }
            } else if (type.equals("class java.util.Date")) {
                Method m = dto.getClass().getMethod("get" + UpperName);
                Date value = (Date) m.invoke(dto);
                if (value != null) {
                    m = bean.getClass().getDeclaredMethod("set" + UpperName, Date.class);
                    doMethod(m, bean, value);
                }
            } else if (type.equals("class java.sql.Timestamp")) {
                Method m = dto.getClass().getMethod("get" + UpperName);
                Timestamp value = (Timestamp) m.invoke(dto);
                if (value != null) {
                    m = bean.getClass().getDeclaredMethod("set" + UpperName, Timestamp.class);
                    doMethod(m, bean, value);
                }
            } else if (type.equals("class java.math.BigDecimal")) {
                Method m = dto.getClass().getMethod("get" + UpperName);
                BigDecimal value = (BigDecimal) m.invoke(dto);
                if (value != null) {
                    m = bean.getClass().getDeclaredMethod("set" + UpperName, BigDecimal.class);
                    doMethod(m, bean, value);
                }
            }
        }
        return bean;
    }

    private static void doMethod(Method m, Object obj, Object value) throws Exception {
        m.invoke(obj, value);
    }


}
