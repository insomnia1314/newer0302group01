package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.MProcedureMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MProcedure;
import com.softfactory.pojo.MProcedureDTO;

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
	
	/**
	 * @author GuangxiangLong
	 * @param prentId
	 * @return 
	 */
	public List<MProcedure> findByPrentId(Integer prentId){
		return procedureMapper.findByPrentId(prentId);
	}
	
	/**
	 * @author GuangxiangLong
	 * @param id
	 * @return
	 */
	public MProcedure findById(Integer id){
		return procedureMapper.findById(id);
	}
	
	/**
	 * 
	 * @param finishTag
	 * @return
	 */
	public List<MProcedureDTO> findByFinishTag(String finishTag){
		return procedureMapper.findByFinishTag(finishTag);
	}
	
	/**
	 * 
	 * @param pd
	 * @return
	 */
	public int update(MProcedure pd){
		return procedureMapper.update(pd);
	}
	
	public int seachMaxDN(Integer parentId){
		return procedureMapper.seachMaxDN(parentId);
	}
}
