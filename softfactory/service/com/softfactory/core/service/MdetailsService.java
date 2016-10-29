package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.MdetailsMapper;
import com.softfactory.pojo.Mdetails;

@Service("mdetailsService")
public class MdetailsService {

	@Resource(name = "mdetailsMapper")
	private MdetailsMapper mdetailsMapper;

	public List<Mdetails> findByPId(Integer id) {
		return mdetailsMapper.findByPId(id);
	}
	
	public Mdetails findById(Integer id){
		return mdetailsMapper.findById(id);
	}
}
