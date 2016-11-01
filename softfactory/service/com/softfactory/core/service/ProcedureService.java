package com.softfactory.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.softfactory.core.dao.InsertMapper;
import com.softfactory.core.dao.ProcedureMapper;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Insert;
import com.softfactory.pojo.Procedure;

@Service("procedureService")
public class ProcedureService {

	@Resource(name = "procedureMapper")
	private ProcedureMapper procedureMapper;
	@Resource(name = "insertMapper")
	private InsertMapper insertMapper;

	public Pager<Procedure> findPager(Integer pageno, Integer pagesize,
			String sort, String order) {
		Pager<Procedure> pager = new Pager<Procedure>();
		pager.setRows(procedureMapper.findPager(pageno, pagesize, sort, order));
		pager.setTotal(procedureMapper.findPagerTotal());
		return pager;
	}

	public int count() {
		return procedureMapper.count();
	}

	public List<Procedure> MapProcedure(String designId) {
		return procedureMapper.MapProcedure(designId);
	}

	/**
	 * 根据产品编号和工序号查找到对应的物料 稍后的插入也要用到
	 * 
	 * @param productId
	 * @param detailsNumber
	 * @return
	 */
	public List<Procedure> findByProductId(String productId, String type) {
		return procedureMapper.findByProductId(productId, type);
	}

	/**
	 * 根据商品编号找到对应的商品名 商品编号等
	 */
	public Procedure findByOne(String productId) {
		return procedureMapper.findByOne(productId);
	};

	/**
	 * 当完成一个工序的时候 修改当前工序的物料完成状态
	 * 
	 * @return
	 */
	public int update(String procedureId, Integer detailsNumber) {
		return procedureMapper.update(procedureId, detailsNumber);
	}

	/**
	 * 审核页面
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @return
	 */
	public Pager<Procedure> reviewPage(Integer pageno, Integer pagesize,
			String sort, String order) {
		Pager<Procedure> pager = new Pager<Procedure>();
		pager.setRows(procedureMapper.reviewPage(pageno, pagesize, sort, order));
		pager.setTotal(procedureMapper.findPagerTotal1());
		return pager;
	}

	/**
	 * 统计总记录条数
	 * 
	 * @return
	 */
	public long findPagerTotal1() {
		return procedureMapper.findPagerTotal1();
	}

	/**
	 * 新增
	 * 
	 * @param productId
	 * @param id
	 * @param parentId
	 * @param subtotal
	 * @return
	 */
	public int add(String procedureId, String designId, String productId,
			String[] subtotal, Integer detailsNumber, String procedureName) {
		int count = 0;
		if (productId != null) {
			String type = null;
			if (procedureName.equals("组装")) {
                  type="Y001-2";
			} else if (procedureName.equals("包装")) {
				type="Y001-3";
			}
			List<Insert> list = insertMapper.findByInsert(productId, type);
			if (list != null && list.size() > 0) {
				Double j = 0.00;
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setParentId(list.get(i).getId());
					list.get(i).setDetailsNumber(detailsNumber);
					list.get(i).setSubtotal(
							list.get(i).getCostPrice()
									* NumberUtils.createDouble(subtotal[i]));
					j += (list.get(i).getCostPrice() * NumberUtils
							.createDouble(subtotal[i]));
					count += insertMapper.add(list.get(i));
					procedureMapper.updatePro(j, procedureId, list.get(i)
							.getDetailsNumber());
				}
				try {
					j += procedureMapper.findBySum(designId);
				} catch (NullPointerException e) {
					System.out.println("异常出现咯");
				} finally {
					procedureMapper.updateSum(designId, j);
					System.out.println(j);
					procedureMapper.UpdateWSum(j, productId);
				}
			}
		}
		return count;
	}

	/**
	 * 点击审核的时候查询出来 需要审核的详细信息 根据设计单号
	 * 
	 * @param designId
	 * @return
	 */
	public List<Procedure> clickreview(@Param("designId") String designId) {
		return procedureMapper.clickreview(designId);
	}

	/**
	 * 根据产品编号查询出所对应物料
	 */

	public List<Procedure> findByProductId1(
			@Param("productId") String productId, String type) {
		return procedureMapper.findByProductId1(productId, type);
	}

	/**
	 * 点击通过审核
	 */
	public int click(@Param("designId") String designId) {
		return procedureMapper.click(designId);
	}

	/**
	 * 点击物料设计的时候查询出
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @return
	 */
	public Pager<Procedure> findPager2(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order) {
		Pager<Procedure> pager = new Pager<Procedure>();
		pager.setRows(procedureMapper.findPager2(pageno, pagesize, sort, order));
		pager.setTotal(procedureMapper.findPagerTotal2());
		return pager;

	}

	/**
	 * 统计
	 */
	public List<Procedure> groupByCount() {
		return procedureMapper.groupByCount();
	}

	/**
	 * 根据总设计单号修改状态
	 */

	public void updateState(String designId) {
		procedureMapper.updateState(designId);
	}

	public List<Procedure> MapProcedure1(String designId) {
		return procedureMapper.MapProcedure1(designId);
	}

	/**
	 * 根据商品编号找到对应的商品名 商品编号等
	 */
	public Procedure findByOne1(String productId) {
		return procedureMapper.findByOne1(productId);
	}

	/**
	 * 点击不通过的时候全部流程重置
	 * 
	 * @param procedureId
	 * @param detailsNumber
	 * @param designId
	 * @param productId
	 */
	public void updatePro1(String[] procedureId, String[] detailsNumber,
			String designId, String productId) {
		List<Integer> list = procedureMapper.findByDelete(productId);
		for (int i = 0; i < list.size(); i++) {
			procedureMapper.updatePro1(procedureId[i],
					Integer.parseInt(detailsNumber[i]));
			procedureMapper.delete(list.get(i));
		}
		procedureMapper.updateSum1(designId);
	}

	public Procedure findByOne2(String productId) {
		return procedureMapper.findByOne2(productId);
	}

}
