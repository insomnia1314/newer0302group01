package com.softfactory.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Mdetails;

@Repository("mdetailsMapper")
public interface MdetailsMapper {
	
	List<Mdetails> findByPId(Integer id);
	
	Mdetails findById(Integer id);
	
	Mdetails findByPname(String productName);
}
