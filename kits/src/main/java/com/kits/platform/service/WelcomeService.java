package com.kits.platform.service;

import com.bstek.dorado.annotation.Expose;
import com.kits.core.utils.ToolKits;
import com.kits.orm.entity.system.Bdf2Company;
import com.kits.platform.dao.NoticeInfoDao;
import com.kits.util.XytContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class WelcomeService {
	
	@Resource
	private NoticeInfoDao noticeInfoDao;
	
	@Resource
	private CommonService commonService;
	
	
	/**
	 * 获取工作台信息
	 */
	@Expose
	public Collection<Map<String,Object>> getMyWorkInfo(){
		return null;
	}
	
	/**
	 * 获取当前登录用户信息
	 */
	@Expose
	public Map<String, Object> getUserInfo(){
		String userName = XytContextHolder.getLoginUserName();
		String userDept = commonService.getCurrentDeptName();
		Bdf2Company company = commonService.getCompanyByLoginUser();
		if(ToolKits.isEmpty(userName) || ToolKits.isEmpty(userDept)){
			return null;
		}
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("userName", userName);
		user.put("userDept", userDept);
		
		if(ToolKits.isNotEmpty(company)){
			user.put("companyName", company.getName());
		}
		
		return user;
	}
	
	/**
	 * 获取前三条公告信息
	 */
	@Expose
	public Collection<Map<String,Object>> getWelcomeNotice(){
		String companyId = XytContextHolder.getLoginUser().getCompanyId();
		Collection<Map<String, Object>> notice = new ArrayList<Map<String, Object>>();
		if(StringUtils.isNotBlank(companyId)){
			notice = noticeInfoDao.getWelcomeNotice(companyId);
		}
		return notice;
	}

	
	/**
	 * 系统消息提示
	 */
	@Expose
	public Map<String,Object> getDialogNotice(){
		String userId = XytContextHolder.getLoginUserProfile().getUserId();
		Map<String, Object> map = null;
		Map<String, Object> notice = noticeInfoDao.getDialogNotice();
		
		if(ToolKits.isNotEmpty(notice)){
			String noticeId = (String) notice.get("ID");
			int num = noticeInfoDao.isNoticeRead(userId, noticeId);
			if(num == 0){
				map = notice;
			}
		}
		return map;		
	}
	
}
