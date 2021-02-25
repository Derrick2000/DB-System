package com.cy.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.sys.entity.SysLog;

@Mapper
public interface SysLogDao {
	int getRowCount(@Param("username") String username);
	List<SysLog> findPageObjects(@Param("username")String username);
	
	int deleteObjects(@Param("ids")Integer...ids);
	int insertObject(SysLog entity);
}
