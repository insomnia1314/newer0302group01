package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.PdetailsMapper;
import com.softfactory.pojo.Pdetails;

@Service("pdetailsService")
public class PdetailsService {
	@Resource(name = "pdetailsMapper")
	private PdetailsMapper pdetailsMapper;

	public List<Pdetails> findByPId(String productId) {
		return pdetailsMapper.findByPId(productId);
	}
	
	public Pdetails findById(Integer id){
		return pdetailsMapper.findById(id);
	}
}
