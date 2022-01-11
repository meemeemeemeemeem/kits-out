package com.kits.inms.api.entity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented//文档  
@Retention(RetentionPolicy.RUNTIME)//在运行时可以获取  
@Target(ElementType.FIELD) //作用到属性上面
@Inherited //子类会继承  
public @interface ColumnVerify {
    public String name() default "";
    
    /** 是否可空 **/
    public boolean nullable() default true;
    
    /** 字符串最大长度(仅字符串类型生效) **/
    public int maxlen() default 0;
    
    /** 最大值 **/
    public int max() default 2147483647;
    
    /** 最小值 **/
    public int min() default -1;
    
    
    
}