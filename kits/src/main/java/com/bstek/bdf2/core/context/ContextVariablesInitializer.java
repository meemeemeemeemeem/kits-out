package com.bstek.bdf2.core.context;

import com.bstek.dorado.core.el.ContextVarsInitializer;
import com.kits.orm.entity.system.Bdf2UserProfile;
import com.kits.util.XytContextHolder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.security.web.WebAttributes;

import java.util.Map;


public class ContextVariablesInitializer implements ContextVarsInitializer,
		BeanFactoryAware {

	public void initializeContext(Map<String, Object> contextVarsMap)
			throws Exception {
		contextVarsMap.put("loginUser", ContextHolder.getLoginUser());
		contextVarsMap.put("loginUsername",
				ContextHolder.getLoginUser() == null ? null : ContextHolder.getLoginUser().getUsername());
		contextVarsMap.put("authenticationExceptionMessage",
				this.getAuthenticationExceptionMessage());
		contextVarsMap.put("loginUserCurrentDept", XytContextHolder.getLoginUserCurrentDept());
		Bdf2UserProfile up = XytContextHolder.getLoginUserProfile();
		if(up != null){
			contextVarsMap.put("baseDeptId", up.getBaseDeptId());
		}
	}

	private String getAuthenticationExceptionMessage() {
		Exception exp = (Exception) ContextHolder.getHttpSession()
				.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (exp == null) {
			exp = (Exception) ContextHolder.getRequest().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
		if (exp != null) {
			return exp.getMessage();
		}
		return null;

	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

	}
}