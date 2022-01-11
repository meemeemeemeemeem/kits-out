package com.bstek.bdf2.core.view.frame.main.register.message;

import com.bstek.bdf2.core.CoreHibernateDao;
import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.model.Message;
import com.bstek.dorado.annotation.Expose;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("bdf2.fetchMessageCount")
public class FetchMessageCount extends CoreHibernateDao{
	@Expose
	public int count() throws Exception{
		IUser user=ContextHolder.getLoginUser();
		/**if(user==null){
			throw new NoneLoginException("Please login first");
		}**/
		if(user!=null){
			String hql="select count(*) from "+Message.class.getName()+" m where m.receiver=:receiver and m.read=:read";
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("receiver", user.getUsername());
			map.put("read",false);
			return this.queryForInt(hql,map);	
		}else{
			return 0;
		}
	}
}
