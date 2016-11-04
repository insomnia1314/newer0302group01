package com.softfactory.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softfactory.core.dao.ManufactureMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Manufacture;
import com.softfactory.pojo.StoreMaxPay;
import com.softfactory.pojo.StorePayDetails;

@Service("manufactureService")
public class ManufactureService {

	@Resource(name = "manufactureMapper")
	private ManufactureMapper manufactureMapper;

	public Pager<Manufacture> findPager(Integer pageno, Integer pagesize, String sort, String order, Integer id,
			String productName) {
		Pager<Manufacture> pager = new Pager<Manufacture>();
		pager.setRows(manufactureMapper.findPager(pageno, pagesize, sort, order, id, productName));
		pager.setTotal(manufactureMapper.findPagerTotal(id, productName));
		return pager;
	}
	
	public int add(Manufacture mf){
		return manufactureMapper.add(mf);
	}
	/**
	 * 修改生产总表
	 * @param mf
	 * @return
	 */
	public int modify(Manufacture mf){
		return manufactureMapper.modify(mf);
	}
	/**
	 * 添加出库
	 * @param sp
	 * @return
	 */
	public int addStorePay(StoreMaxPay sp){
		return manufactureMapper.addStorePay(sp);
	}
	/**
	 * 添加出库明细
	 * @param spd
	 * @return
	 */
	public int addStorePayDetails(StorePayDetails spd){
		return manufactureMapper.addStorePayDetails(spd);
	}
	
	public String findByMax(){
		return manufactureMapper.findByMax();
	}
	/**
	 * 
	 * 加载通过审核的生产计划
	 * @author GuangxiangLong
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param manufacture 查询参数
	 * @return 返回分页对象
	 * 
	 */
	
	public Pager<Manufacture> findPassedMFG(Integer pageno, Integer pagesize, String sort, String order,Manufacture manufacture){
		Pager<Manufacture> pager = new Pager<Manufacture>();
		pager.setRows(manufactureMapper.findPassedMFG(pageno, pagesize, sort, order, manufacture));
		pager.setTotal(manufactureMapper.findPassedMFGTotal(manufacture));
		return pager;
	}
	
	public Pager<Manufacture> findByTag(Integer pageno, Integer pagesize, String sort, String order,Manufacture manufacture){
		Pager<Manufacture> pager = new Pager<Manufacture>();
		pager.setRows(manufactureMapper.findByTag(pageno, pagesize, sort, order, manufacture));
		pager.setTotal(manufactureMapper.findPassedMFGTotal(manufacture));
		return pager;
	}
	
	/**
	 * 通过ID加载单条数据
	 * @author GuangxiangLong
	 * @param id
	 * @return 
	 */
	public Manufacture findById(Integer id){
		return manufactureMapper.findById(id);
	}
	
}
