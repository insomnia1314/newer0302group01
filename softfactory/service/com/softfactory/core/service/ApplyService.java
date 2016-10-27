package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.ApplyMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Apply;

@Service("applyService")
public class ApplyService {

	@Resource(name = "applyMapper")
	private ApplyMapper applyMapper;

	/**
	 * 查询已审核未派单的数据
	 * 
	 * @return
	 */
	public List<Apply> findByTag() {
		return applyMapper.findByTag();
	}

	public int modify(Apply mf) {
		return applyMapper.modify(mf);
	}

	public Pager<Apply> findPager(Integer pageno, Integer pagesize, String sort, String order, Integer id) {
		Pager<Apply> pager = new Pager<Apply>();
		pager.setRows(applyMapper.findPager(pageno, pagesize, sort, order, id));
		pager.setTotal(applyMapper.findPagerTotal(id));
		return pager;
	}

	public Apply findById(Integer id) {
		return applyMapper.findById(id);
	}
}
