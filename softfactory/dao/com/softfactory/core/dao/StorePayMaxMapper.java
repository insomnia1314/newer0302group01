package com.softfactory.core.dao;

import org.springframework.stereotype.Repository;

import com.softfactory.pojo.StoreMaxPay;

@Repository("storePayMaxMapper")
public interface StorePayMaxMapper {
	/**
	 * 查询最大编号
	 */
	String findByMax();
	
	/**
	 * 根据派工单编号查询出库表一条数据
	 */
	StoreMaxPay findByPname(String manufactureId);
	
}
