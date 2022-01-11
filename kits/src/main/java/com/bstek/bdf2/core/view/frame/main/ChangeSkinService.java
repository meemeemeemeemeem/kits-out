package com.bstek.bdf2.core.view.frame.main;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.view.View;
import com.bstek.dorado.web.DoradoContext;
import com.bstek.dorado.web.WebConfigure;
import com.kits.core.utils.Constants;
import com.kits.orm.entity.system.Bdf2UserProfile;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Component
public class ChangeSkinService extends HibernateDao{
	@Transactional
	@Expose
	public void changeSkin(String skin) {
		skin = "danyahui002";
		WebConfigure.set(DoradoContext.SESSION, "view.skin", skin);
		Criteria criteria = this.getSession().createCriteria(Bdf2UserProfile.class);
		criteria.add(Restrictions.eq("username", ContextHolder.getLoginUserName()));
		criteria.add(Restrictions.eq("delFlag", Constants.CORE_ENTITY_SAVE_STATE));
		criteria.add(Restrictions.eq("userSource", "1"));
		Bdf2UserProfile userProfile = (Bdf2UserProfile) criteria.uniqueResult();
		if(userProfile != null){
			userProfile.setSkin(skin);
			this.getSession().save(userProfile);
		}
	}
	
	public void onInitView(View view){
		Criteria criteria = this.getSession().createCriteria(Bdf2UserProfile.class);
		criteria.add(Restrictions.eq("username", ContextHolder.getLoginUserName()));
		criteria.add(Restrictions.eq("delFlag", Constants.CORE_ENTITY_SAVE_STATE));
		criteria.add(Restrictions.eq("userSource", "1"));
		Bdf2UserProfile userProfile = (Bdf2UserProfile) criteria.uniqueResult();
		if(userProfile != null){
			String skin = userProfile.getSkin();
			if(StringUtils.hasText(skin)){
				WebConfigure.set(DoradoContext.SESSION, "view.skin", skin);
			}
		}
	}
}
