package com.kits.inms.df.utils;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.kits.orm.entity.system.Bdf2User;
import org.hibernate.annotations.common.util.StringHelper;
import org.hibernate.id.UUIDHexGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppUtils {

    public static Logger log4j = LoggerFactory.getLogger(AppUtils.class);

    /**
     * @return 长度32的唯�?字符�?
     */
    public static String getUUIDKey() {
        return new UUIDHexGenerator().generate(null, null).toString();
    }

    /**
     * 判断�?个String是否为空（NULL/null/""�?
     * 该方法�?�助了Hibernate的StringHelper.isNotEmpty(str)
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        boolean result = false;
        if (StringHelper.isNotEmpty(str) && !"null".equals(str)
                && !"".equals(str)) {
            result = true;
        }
        return result;
    }

    /**
     * 获取当前已登录的用户编号
     *
     * @return String 返回已登录的用户�?
     */
    public static String getLoginUserName() {
        IUser user = getLoginUser();
        return user.getUsername();
    }

    /**
     * 从Session当中取到User对象
     *
     * @return
     */
    public static IUser getLoginUser() {
        IUser loginUser = ContextHolder.getLoginUser();
        if (loginUser == null) {
            loginUser = new Bdf2User();
            ((Bdf2User) loginUser).setCompanyId("xyt");
        }
        return loginUser;
    }

}
