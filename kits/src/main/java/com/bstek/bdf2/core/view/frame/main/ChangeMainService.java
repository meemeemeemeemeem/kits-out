package com.bstek.bdf2.core.view.frame.main;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.Expose;
import com.kits.core.utils.Constants;
import com.kits.orm.entity.system.Bdf2UserProfile;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ChangeMainService extends HibernateDao{
	@Transactional
	@Expose
	public void changeMain(String main) {
		Criteria criteria = this.getSession().createCriteria(Bdf2UserProfile.class);
		criteria.add(Restrictions.eq("username", ContextHolder.getLoginUserName()));
		criteria.add(Restrictions.eq("delFlag", Constants.CORE_ENTITY_SAVE_STATE));
		criteria.add(Restrictions.eq("userSource", "1"));
		Bdf2UserProfile userProfile = (Bdf2UserProfile) criteria.uniqueResult();
		if(userProfile != null){
			userProfile.setMain(main);
			this.getSession().save(userProfile);
		}
	}
}
