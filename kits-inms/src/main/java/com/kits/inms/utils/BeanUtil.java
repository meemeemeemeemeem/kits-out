package com.kits.inms.utils;

import com.bstek.dorado.data.entity.EntityUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 杨旭晖
 * @date 6/1/2018
 */
public class BeanUtil {

    private Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    private static BeanUtil instance = null;

    private BeanUtil() {

    }

    public static BeanUtil getInstance() {
        if (instance == null) {
            return new BeanUtil();
        }
        return instance;
    }

    public <T> T transMap2Bean2(Map<String, Object> map, T t) {
        if (map == null || t == null) {
            return null;
        }
        try {
            BeanUtils.populate(t, map);
        } catch (Exception e) {
            logger.error("transMap2Bean2 Error " + e);
            return null;
        }
        return t;
    }

    public <T> List<T> transMap2List(List<Map<String, Object>> mapList, Class<T> tClass) {
        List<T> list = new ArrayList<>(mapList.size());
        for (Map<String, Object> map : mapList) {
            list.add(transMap2Bean(map, tClass));
        }
        return list;
    }

    public <T> T transMap2Bean(Map<String, Object> map, Class<T> tClass) {
        if (map == null) {
            return null;
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(tClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            T t = tClass.newInstance();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(t, value);
                }
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("transMap2Bean Error " + e);
            return null;
        }
    }

    public Map<String, Object> transBean2Map(Object obj) {

        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (!"class".equals(key)) {
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);

                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            logger.error("transBean2Map Error " + e);
        }

        return map;

    }

    public <T> T replaceNullToZero(T t) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                if (property.getPropertyType().equals(BigDecimal.class)) {
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(t) == null ? BigDecimal.ZERO : getter.invoke(t);
                    Method setter = property.getWriteMethod();
                    setter.invoke(t, value);
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    public <T> T transD7EntityToJEntity(Object o, Class<T> tClass) {
        T t = null;
        try {
            t = tClass.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(tClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                Method setter = property.getWriteMethod();
                if (setter != null) {
                    setter.invoke(t, EntityUtils.getValue(o, property.getName()));
                }
            }
        } catch (IntrospectionException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    public Map<String, Object> transD7MapToJMap(Map<String, Object> map) {
        Map<String, Object> result = new HashMap<>(map.size());
        result.putAll(map);
        return result;
    }

}
