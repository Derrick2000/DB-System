package com.cy.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.common.vo.Node;
import com.cy.sys.vo.SysDept;

public interface SysDeptService {
	 List<Map<String,Object>> findObjects();
	 List<Node> findZTreeNodes();
	 int saveObject(SysDept entity);
	 int updateObject(SysDept entity);
	 int deleteObject(Integer id);
}
