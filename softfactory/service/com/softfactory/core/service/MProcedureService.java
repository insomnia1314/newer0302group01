package com.softfactory.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.MProcedureMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MProcedure;

@Service("mprocedureService")
public class MProcedureService {

	@Resource(name = "mprocedureMapper")
	private MProcedureMapper procedureMapper;

	public Pager<MProcedure> findPager(Integer pageno, Integer pagesize, String sort, String order, Integer id,
			String procedureName) {
		Pager<MProcedure> pager = new Pager<MProcedure>();
		pager.setRows(procedureMapper.findPager(pageno, pagesize, sort, order, id, procedureName));
		pager.setTotal(procedureMapper.findPagerTotal(id, procedureName));
		return pager;
	}

	public int add(MProcedure pd) {
		return procedureMapper.add(pd);
	}
}
