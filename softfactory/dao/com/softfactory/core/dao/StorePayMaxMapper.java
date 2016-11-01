package com.softfactory.core.dao;

import org.springframework.stereotype.Repository;

@Repository("storePayMaxMapper")
public interface StorePayMaxMapper {
	/**
	 * 查询最大编号
	 */
	String findByMax();
	
}
