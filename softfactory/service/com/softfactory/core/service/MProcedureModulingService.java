package com.softfactory.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.MProcedureModulingMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MProcedureModuling;

@Service("mProcedureModulingService")
public class MProcedureModulingService {

	@Resource(name = "mProcedureModulingMapper")
	private MProcedureModulingMapper mProcedureModulingMapper;

	public Pager<MProcedureModuling> findPager(Integer page, Integer pagesize, String sort, String order) {
		Pager<MProcedureModuling> p = new Pager<MProcedureModuling>();
		p.setRows(mProcedureModulingMapper.findPager(page, pagesize, sort, order));
		p.setTotal(mProcedureModulingMapper.findPagerTotal());
		return p;
	}

	public int add(MProcedureModuling m) {
		return mProcedureModulingMapper.add(m);
	}

	public int update(MProcedureModuling m) {
		return mProcedureModulingMapper.update(m);
	}

	public int remove(Integer mPId) {
		return mProcedureModulingMapper.remove(mPId);
	}

	public MProcedureModuling findById(Integer mPId) {
		return mProcedureModulingMapper.findById(mPId);
	}
	
	public MProcedureModuling findByParentIdAndProductId(Integer parentId,String ProductId){
		return mProcedureModulingMapper.findByParentIdAndProductId(parentId, ProductId);
	}
	
}
