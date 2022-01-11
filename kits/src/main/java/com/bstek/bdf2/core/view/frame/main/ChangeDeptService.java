package com.bstek.bdf2.core.view.frame.main;

import com.bstek.bdf2.core.business.IDept;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.bdf2.core.service.IDeptService;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.view.widget.form.TextEditor;
import com.kits.core.utils.ToolKits;
import com.kits.orm.entity.system.Bdf2Dept;
import com.kits.orm.entity.system.Bdf2DeptProfile;
import com.kits.platform.dao.Bdf2DeptDao;
import com.kits.util.XytContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Component
public class ChangeDeptService extends HibernateDao{
	@Resource
    private Bdf2DeptDao bdf2DeptDao;
	
	@Autowired
	@Qualifier("bdf2.deptService")
	private IDeptService deptService;
	
	@Transactional
	@Expose
	public void changeDept(String deptId) {
		if(ToolKits.isNotEmpty(deptId)){
			Bdf2Dept currentDept = bdf2DeptDao.queryById(deptId);
			Bdf2DeptProfile deptProfile = bdf2DeptDao.queryProfileById(deptId);
			Set<Bdf2Dept> result = new HashSet<Bdf2Dept>();
	    	bdf2DeptDao.getCurrentChildrenDept(result, deptId);
			Collection<Bdf2Dept> childs = result;
			//切换当前部门
			ContextHolder.getHttpSession().setAttribute(
					XytContextHolder.LOGIN_USER_CURRENT_DEPT_SESSION_KEY, currentDept);
			//查询当前部门的附加属性
			ContextHolder.getHttpSession().setAttribute(
					XytContextHolder.LOGIN_USER_CURRENT_DEPT_PROFILE_SESSION_KEY, deptProfile);
			//查询当前部门的所有下级部门对象集合
			ContextHolder.getHttpSession().setAttribute(
					XytContextHolder.LOGIN_USER_CURRENTCHILDREN_DEPT_SESSION_KEY, childs);
		}
	}
	
	@DataProvider
	public Collection<IDept> loadUserDepts() {
		Collection<IDept> depts = deptService.loadUserDepts(ContextHolder.getLoginUserName());
		if(ToolKits.isNotEmpty(depts)){
			Bdf2Dept cdept = XytContextHolder.getLoginUserCurrentDept();
			if(ToolKits.isNotEmpty(cdept)){
				boolean flag = true;
				for(IDept dept : depts){
					if(cdept.getId().equals(dept.getId())){
						flag = false;
					}
				}
				if(flag){
					depts.add(cdept);
				}
				/**
				String baseDeptId = XytContextHolder.getLoginUserProfile().getBaseDeptId();
				Bdf2Dept baseDept = (Bdf2Dept) deptService.loadDeptById(baseDeptId);
				if(!cdept.getId().equals(baseDept.getId())){
					depts.add(baseDept);
				}
				**/
				return depts;
			}
		}
		return null;
	}
	
	public void onInitTextEditor(TextEditor teCurrentDept){
		Bdf2Dept cdept = XytContextHolder.getLoginUserCurrentDept();
		if(cdept != null){
			teCurrentDept.setText(cdept.getName());
		}
	}
}

