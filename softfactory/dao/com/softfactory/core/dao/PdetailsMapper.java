package com.softfactory.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Pdetails;

@Repository("pdetailsMapper")
public interface PdetailsMapper {
	
	List<Pdetails> findByPId(String productId);
	
	Pdetails findById(Integer id);
}
