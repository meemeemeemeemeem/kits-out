package com.kits.inms.bs;

import com.bstek.dorado.common.proxy.PatternMethodInterceptor;
import com.bstek.dorado.view.resolver.ClientRunnableException;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author 杨旭晖(yangxuhui @ whknow.cn)
 * @version 1.0.0
 * @date 8/21/18
 */
public class AjaxServiceInterceptor extends PatternMethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            return methodInvocation.proceed();
        } catch (Exception e1) {
            String script = "dorado.MessageBox.alert('" + e1.getMessage() + "\\n',{icon: \"WARNING\"})";
            throw new ClientRunnableException(script);
        }

    }

}
