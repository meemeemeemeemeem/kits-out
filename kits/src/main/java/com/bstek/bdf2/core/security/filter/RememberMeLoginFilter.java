package com.bstek.bdf2.core.security.filter;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.security.ISecurityInterceptor;
import com.bstek.bdf2.core.security.InterceptorType;
import com.bstek.bdf2.core.service.IDeptService;
import com.bstek.bdf2.core.service.IGroupService;
import com.bstek.bdf2.core.service.IPositionService;
import com.bstek.bdf2.core.service.IUserService;
import com.kits.core.utils.ToolKits;
import com.kits.orm.entity.system.*;
import com.kits.platform.service.Bdf2CompanyService;
import com.kits.platform.service.Bdf2DeptService;
import com.kits.platform.service.Bdf2UserProfileService;
import com.kits.util.XytContextHolder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;


/**
 * @author Jacky.gao
 * @since 2013-2-24
 */
public class RememberMeLoginFilter extends RememberMeAuthenticationFilter implements ApplicationContextAware{
	private IUserService userService;
	private IDeptService deptService;
	private IPositionService positionService;
	private IGroupService groupService;
	private Collection<ISecurityInterceptor> securityInterceptors;
	private SimpleUrlAuthenticationFailureHandler authenticationFailureHandler;
	
	@Resource
	private Bdf2UserProfileService userProfileService;
	
	@Resource
	private Bdf2CompanyService companyService;
	
	@Resource
	private Bdf2DeptService bdf2deptService;
	
	public RememberMeLoginFilter(AuthenticationManager authenticationManager,
			RememberMeServices rememberMeServices) {
		super(authenticationManager, rememberMeServices);
	}

	@Override
	protected void onSuccessfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, Authentication authResult) {
		Object user=authResult.getPrincipal();
		Assert.notNull(user,"通过Remember Me方式登录成功后未获取到用户信息");
		HttpSession session=ContextHolder.getHttpSession();
		Bdf2User loginUser=null;
		if(user instanceof Bdf2User){
			loginUser=(Bdf2User)user;
		}else if(user instanceof String){
			loginUser=(Bdf2User)userService.loadUserByUsername((String)user);
		}else{
			throw new RuntimeException("Unsupport current principal["+user+"]");
		}
		if(loginUser instanceof Bdf2User){
			Bdf2User u=(Bdf2User)loginUser;
			u.setDepts(deptService.loadUserDepts(u.getUsername()));
			u.setPositions(positionService.loadUserPositions(u.getUsername()));
			u.setGroups(groupService.loadUserGroups(u.getUsername()));
			
			Bdf2UserProfile userProfile = userProfileService.getBdf2UserProfileByUserName(u.getUsername());
			if(userProfile != null){
				ContextHolder.getHttpSession().setAttribute(
						XytContextHolder.LOGIN_USER_PROFILE_SESSION_KEY, userProfile);
				
				String baseDeptId = userProfile.getBaseDeptId();
				if(ToolKits.isNotEmpty(baseDeptId)){
					Bdf2DeptProfile deptProfile = bdf2deptService.queryProfileById(baseDeptId);
					ContextHolder.getHttpSession().setAttribute(
							XytContextHolder.LOGIN_USER_DEPT_PROFILE_SESSION_KEY, deptProfile);
					//当用户登录时，默认将用户的baseDeptId所查询到的部门对象以及部门附加属性对象放到session
					ContextHolder.getHttpSession().setAttribute(
							XytContextHolder.LOGIN_USER_CURRENT_DEPT_PROFILE_SESSION_KEY, deptProfile);
					
					Bdf2Dept currentDept = bdf2deptService.queryById(baseDeptId);
					ContextHolder.getHttpSession().setAttribute(
							XytContextHolder.LOGIN_USER_CURRENT_DEPT_SESSION_KEY, currentDept);
					
					//将当前的baseDeptId查询到的所有子部门放入session
					Collection<Bdf2Dept> childs = bdf2deptService.getCurrentChildrenDept(baseDeptId);
					ContextHolder.getHttpSession().setAttribute(
							XytContextHolder.LOGIN_USER_CURRENTCHILDREN_DEPT_SESSION_KEY, childs);
				}
				
				String companyId = u.getCompanyId();
				if(ToolKits.isNotEmpty(companyId)){
					Bdf2CompanyProfile companyProfile = companyService.queryCompanyProfileById(companyId);
					ContextHolder.getHttpSession().setAttribute(
							XytContextHolder.LOGIN_USER_COMPANY_PROFILE_SESSION_KEY, companyProfile);
				}
			}
		}
		session.setAttribute(ContextHolder.USER_LOGIN_WAY_KEY, "rememberMe");
		session.setAttribute(ContextHolder.LOGIN_USER_SESSION_KEY, loginUser);
		this.doInterceptor(InterceptorType.success, new HttpRequestResponseHolder(request,response));
	}

	@Override
	protected void onUnsuccessfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException failed) {
		try {
			this.doInterceptor(InterceptorType.failure, new HttpRequestResponseHolder(request,response));
			authenticationFailureHandler.onAuthenticationFailure(request, response, failed);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ServletException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	private void doInterceptor(InterceptorType type,HttpRequestResponseHolder holder){
		for(ISecurityInterceptor intercepor:securityInterceptors){
			if(type.equals(InterceptorType.before)){
				intercepor.beforeLogin(holder);
			}else if(type.equals(InterceptorType.success)){
				intercepor.loginSuccess(holder);
			}else if(type.equals(InterceptorType.failure)){
				intercepor.loginFailure(holder);
			}
		}
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IDeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	public IPositionService getPositionService() {
		return positionService;
	}

	public void setPositionService(IPositionService positionService) {
		this.positionService = positionService;
	}

	public IGroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	public void setAuthenticationFailureHandler(
			SimpleUrlAuthenticationFailureHandler authenticationFailureHandler) {
		this.authenticationFailureHandler = authenticationFailureHandler;
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		securityInterceptors=applicationContext.getBeansOfType(ISecurityInterceptor.class).values();
	}
}
