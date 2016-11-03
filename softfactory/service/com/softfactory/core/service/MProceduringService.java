package com.softfactory.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.MProceduringMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MProcedureModuling;
import com.softfactory.pojo.MProceduring;

@Service("mProceduringService")
public class MProceduringService {

	@Resource(name = "mProceduringMapper")
	private MProceduringMapper mProceduringMapper;

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @return
	 */
	public Pager<MProceduring> findPager(Integer page, Integer pagesize, String sort, String order) {
		Pager<MProceduring> p = new Pager<MProceduring>();
		p.setRows(mProceduringMapper.findPager(page, pagesize, sort, order));
		p.setTotal(mProceduringMapper.findPagerTotal());
		return p;
	}

	/**
	 * 增加一条生产记录
	 * 
	 * @param m
	 * @return
	 */
	public int add(MProceduring m) {
		return mProceduringMapper.add(m);
	}

	/**
	 * 修改一条生产记录
	 * 
	 * @param m
	 * @return
	 */
	public int update(MProceduring m) {

		return mProceduringMapper.update(m);
	}

	/**
	 * 通过主键查询一条生产记录
	 * 
	 * @param m
	 * @return
	 */
	public MProceduring findById(Integer mPMId) {

		return mProceduringMapper.findById(mPMId);
	}

	/**
	 * 删除一条生产记录
	 * 
	 * @param m
	 * @return
	 */
	public int del(Integer mPMId) {
		return mProceduringMapper.del(mPMId);
	}
	
	/**
	 * 
	 * @param parentid
	 * @param procedureId
	 * @return
	 */
	public MProceduring findByPrentIdAndProcedureId(Integer parentid,String procedureId){
		return mProceduringMapper.findByPrentIdAndProcedureId(parentid, procedureId);
	}
}
