package com.bstek.bdf2.core.view.frame;

import com.bstek.bdf2.core.service.IUserService;
import com.bstek.dorado.annotation.Expose;
import com.kits.core.utils.DateUtil;
import com.kits.core.utils.ToolKits;
import com.kits.orm.entity.system.Bdf2UserProfile;
import com.kits.platform.dao.Bdf2UserProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ResetPWService {
	
	@Autowired
	private Bdf2UserProfileDao userProfileDao; 
	
	@Autowired
	@Qualifier("bdf2.userService")
	private IUserService userService;
	
	@Expose
	public String genCode(String username){
		if(ToolKits.isNotEmpty(username)){
			int code = (int)(Math.random()*(9999-1000+1))+1000;//产生1000-9999的随机数
			Bdf2UserProfile up = userProfileDao.getBdf2UserProfileByUserName(username);
			if(up != null){
				up.setVerificationCode(code+"");
				up.setExpirationTime(DateUtil.nowDate());
				userProfileDao.update(up);
				return "验证码已经发送！";
			}else{
				return "当前账号不存在！";
			}
			
		}
		return null;
	}
	
	@Expose
	public String verfiyCode(String username, String code){
		if(ToolKits.isNotEmpty(username)&&ToolKits.isNotEmpty(code)){
			Bdf2UserProfile up = userProfileDao.getBdf2UserProfileByUserName(username);
			String vCode = up.getVerificationCode();
			Date eTime = up.getExpirationTime();
			if(code.equals(vCode)){
				long time = new Date().getTime() - eTime.getTime();// 得出的时间间隔是毫秒
				if (time / 60000 > 10){
					return "验证码过期";
				}else
					return null;
			}
		}
		return "验证码无效";
	}
	
	@Expose
	public String resetPassword(String username, String pwd) {
//		Integer newPassword = (int) (Math.random() * 900000 + 100000);
		userService.changePassword(username, pwd);
		String content = "尊敬的"+username+"用户，您的密码已经重置为["+pwd+"]，请登录系统！";
		return "重置密码成功！";
	}
}
