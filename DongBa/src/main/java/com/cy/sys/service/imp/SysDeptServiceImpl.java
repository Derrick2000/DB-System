package com.cy.sys.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;



import com.cy.common.exception.ServiceException;
import com.cy.common.vo.Node;
import com.cy.sys.dao.SysDeptDao;
import com.cy.sys.vo.SysDept;
import com.cy.sys.service.SysDeptService;

@Service
public class SysDeptServiceImpl implements SysDeptService {
	@Autowired
	private SysDeptDao sysDeptDao;
	
	
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> list=
		sysDeptDao.findObjects();
		if(list==null||list.size()==0)
			throw new ServiceException("No information about this department");
		return list;
	}
	@Override
	public List<Node> findZTreeNodes() {
		List<Node> list = sysDeptDao.findZTreeNodes();
		if(list==null||list.size()==0)
			throw new ServiceException("No information about this department");
		return list;
	}
	
	
	@Override
	public int updateObject(SysDept entity) {
		//1.合法验证
		if(entity==null)
			throw new ServiceException("Saved object cannot be empty");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("Department cannot be empty");
		int rows;
		//2.更新数据
		try{
		rows=sysDeptDao.updateObject(entity);
		}catch(Exception e){
		e.printStackTrace();
			throw new ServiceException("Update failed");
		}
		//3.返回数据
		return rows;
	}
	
	
	@Override
	public int saveObject(SysDept entity) {
		//1.合法验证
		if(entity==null)
			throw new ServiceException("Saved object cannot be empty");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("Department cannot be empty");
		//2.保存数据
		int rows=sysDeptDao.insertObject(entity);
		//if(rows==1)
		//throw new ServiceException("save error");
		//3.返回数据
		return rows;
	}
	
	
	@Override
	public int deleteObject(Integer id) {
		//1.合法性验证
		if(id==null||id<=0)
			throw new ServiceException("Invalid data,id="+id);
		//2.执行删除操作
		//2.1判定此id对应的菜单是否有子元素
		int childCount=sysDeptDao.getChildCount(id);
		if(childCount>0)
			throw new ServiceException("This element has a child, cannot delete");
		//2.2判定此部门是否有用户
		//int userCount=sysUserDao.getUserCountByDeptId(id);
		//if(userCount>0)
		//throw new ServiceException("此部门有员工，不允许对部门进行删除");
		//2.2判定此部门是否已经被用户使用,假如有则拒绝删除
		//2.3执行删除操作
		int rows=sysDeptDao.deleteObject(id);
		if(rows==0)
			throw new ServiceException("This record may not exist");
		return rows;
	}


}
