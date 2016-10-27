package com.softfactory.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.MProcedureModuleMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MProcedureModule;

@Service("mprocedureModuleService")
public class MProcedureModuleService {

	@Resource(name = "mprocedureModuleMapper")
	private MProcedureModuleMapper procedureModuleMapper;

	public Pager<MProcedureModule> findPager(Integer pageno, Integer pagesize, String sort, String order, Integer id,
			String productName) {
		Pager<MProcedureModule> pager = new Pager<MProcedureModule>();
		pager.setRows(procedureModuleMapper.findPager(pageno, pagesize, sort, order, id, productName));
		pager.setTotal(procedureModuleMapper.findPagerTotal(id, productName));
		return pager;
	}

	public int add(MProcedureModule pd) {
		return procedureModuleMapper.add(pd);
	}
}
