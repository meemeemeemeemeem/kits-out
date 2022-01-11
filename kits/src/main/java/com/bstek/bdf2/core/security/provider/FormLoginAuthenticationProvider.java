package com.bstek.bdf2.core.security.provider;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.security.ISecurityInterceptor;
import com.bstek.bdf2.core.security.InterceptorType;
import com.bstek.bdf2.core.service.IFrameworkService;
import com.kits.core.utils.ToolKits;
import com.kits.orm.entity.system.*;
import com.kits.platform.service.Bdf2CompanyService;
import com.kits.platform.service.Bdf2DeptService;
import com.kits.platform.service.Bdf2UserProfileService;
import com.kits.util.XytContextHolder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpRequestResponseHolder;

import javax.annotation.Resource;
import java.util.Collection;




/**
 * @since 2013-1-22
 * @author Jacky.gao
 */
public class FormLoginAuthenticationProvider extends DaoAuthenticationProvider
		implements ApplicationContextAware {
	private Collection<ISecurityInterceptor> securityInterceptors;
	private IFrameworkService frameworkService;
	
	@Resource
	private Bdf2UserProfileService userProfileService;
	
	@Resource
	private Bdf2CompanyService companyService;
	
	@Resource
	private Bdf2DeptService deptService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		Bdf2User user = (Bdf2User)userDetails;;
		HttpRequestResponseHolder holder = new HttpRequestResponseHolder(
				ContextHolder.getRequest(), ContextHolder.getResponse());
		this.doInterceptor(InterceptorType.before, holder);
		try {
			frameworkService.authenticate(user, authentication);
		} catch (Exception ex) {
			this.doInterceptor(InterceptorType.failure, holder);
			throw new AuthenticationServiceException(ex.getMessage());
		}
		
		Bdf2UserProfile userProfile = userProfileService.getBdf2UserProfileByUserName(user.getUsername());
		if(userProfile != null){
			ContextHolder.getHttpSession().setAttribute(
					XytContextHolder.LOGIN_USER_PROFILE_SESSION_KEY, userProfile);
			
			String baseDeptId = userProfile.getBaseDeptId();
			if(ToolKits.isNotEmpty(baseDeptId)){
				Bdf2DeptProfile deptProfile = deptService.queryProfileById(baseDeptId);
				ContextHolder.getHttpSession().setAttribute(
						XytContextHolder.LOGIN_USER_DEPT_PROFILE_SESSION_KEY, deptProfile);
				//当用户登录时，默认将用户的baseDeptId所查询到的部门对象以及部门附加属性对象放到session
				ContextHolder.getHttpSession().setAttribute(
						XytContextHolder.LOGIN_USER_CURRENT_DEPT_PROFILE_SESSION_KEY, deptProfile);
				
				Bdf2Dept currentDept = deptService.queryById(baseDeptId);
				ContextHolder.getHttpSession().setAttribute(
						XytContextHolder.LOGIN_USER_CURRENT_DEPT_SESSION_KEY, currentDept);
				
				//将当前的baseDeptId查询到的所有子部门放入session
				Collection<Bdf2Dept> childs = deptService.getCurrentChildrenDept(baseDeptId);
				ContextHolder.getHttpSession().setAttribute(
						XytContextHolder.LOGIN_USER_CURRENTCHILDREN_DEPT_SESSION_KEY, childs);
			}
			
			String companyId = user.getCompanyId();
			if(ToolKits.isNotEmpty(companyId)){
				Bdf2CompanyProfile companyProfile = companyService.queryCompanyProfileById(companyId);
				ContextHolder.getHttpSession().setAttribute(
						XytContextHolder.LOGIN_USER_COMPANY_PROFILE_SESSION_KEY, companyProfile);
			}
		}
		
		ContextHolder.getHttpSession().setAttribute(
				ContextHolder.LOGIN_USER_SESSION_KEY, user);
		this.doInterceptor(InterceptorType.success, holder);
	}

	public IFrameworkService getFrameworkService() {
		return frameworkService;
	}

	public void setFrameworkService(IFrameworkService frameworkService) {
		this.frameworkService = frameworkService;
	}

	private void doInterceptor(InterceptorType type,
			HttpRequestResponseHolder holder) {
		for (ISecurityInterceptor intercepor : securityInterceptors) {
			if (type.equals(InterceptorType.before)) {
				intercepor.beforeLogin(holder);
			} else if (type.equals(InterceptorType.success)) {
				intercepor.loginSuccess(holder);
			} else if (type.equals(InterceptorType.failure)) {
				intercepor.loginFailure(holder);
			}
		}
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		securityInterceptors = applicationContext.getBeansOfType(
				ISecurityInterceptor.class).values();
	}
}
