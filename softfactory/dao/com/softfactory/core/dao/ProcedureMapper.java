package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Procedure;

@Repository("procedureMapper")
public interface ProcedureMapper {
	/**
	 * 点击物料设计的时候查询出
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @return
	 */
	List<Procedure> findPager(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order);

	/**
	 * 统计总记录条数
	 * 
	 * @return
	 */
	long findPagerTotal();

	/**
	 * 统计总共有多少可以制定
	 * 
	 * @return
	 */
	int count();

	/**
	 * 根据设计单号查找对应的工序
	 * 
	 * @param designId
	 * @return
	 */
	List<Procedure> MapProcedure(@Param("designId") String designId);

	/**
	 * 根据产品编号查找对应的一条记录
	 */
	Procedure findByOne(@Param("productId") String productId);

	/**
	 * 根据产品编号和工序号查找到对应的物料 稍后的插入也要用到
	 * 
	 * @param productId
	 * @param detailsNumber
	 * @return
	 */
	List<Procedure> findByProductId(@Param("productId") String productId,
			@Param("type") String type);

	/**
	 * 当完成一个工序的时候 修改当前工序的物料完成状态
	 * 
	 * @return
	 */
	@Update("Update  M_DESIGN_PROCEDURE_DETAILS  set DESIGN_MODULE_TAG='D002-1' where PROCEDURE_ID= #{procedureId} and DETAILS_NUMBER= #{detailsNumber}")
	int update(@Param("procedureId") String procedureId,
			@Param("detailsNumber") Integer detailsNumber);

	/**
	 * 根据设计单编号修改总价
	 * 
	 * @param designId
	 * @param modulePrice
	 */
	@Update("Update M_DESIGN_PROCEDURE d set d.module_cost_price_sum=#{modulePrice} where  d.design_id=#{designId}")
	void updateSum(@Param("designId") String designId,
			@Param("modulePrice") Double modulePrice);

	/**
	 * 修改总的设计单完成状态
	 */
	@Update("Update M_DESIGN_PROCEDURE d set d.DESIGN_MODULE_TAG='G002-1',d.check_time=sysdate where  d.design_id=#{designId}")
	void updateState(@Param("designId") String designId);

	/**
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @return
	 */
	List<Procedure> reviewPage(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order);

	/**
	 * 统计总记录条数
	 * 
	 * @return
	 */
	long findPagerTotal1();

	/**
	 * 点击审核的时候查询出来 需要审核的详细信息 根据设计单号
	 * 
	 * @param designId
	 * @return
	 */
	List<Procedure> clickreview(@Param("designId") String designId);

	/**
	 * 根据产品编号查询出所对应物料
	 */

	List<Procedure> findByProductId1(@Param("productId") String productId,
			@Param("type") String type);

	/**
	 * 点击通过审核
	 */
	@Update("update M_DESIGN_PROCEDURE d set d.design_module_tag='G002-2',d.check_time=sysdate where d.design_id=#{designId}")
	int click(@Param("designId") String designId);

	/**
	 * 点击物料设计的时候查询出
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @return
	 */
	List<Procedure> findPager2(@Param("pageno") Integer pageno,
			@Param("pagesize") Integer pagesize, @Param("sort") String sort,
			@Param("order") String order);

	/**
	 * 统计总记录条数
	 * 
	 * @return
	 */
	long findPagerTotal2();

	/**
	 * procedureName--fk用来显示
	 */
	List<Procedure> groupByCount();

	/**
	 * 上一次的价格在基础上加
	 */
	Double findBySum(@Param("designId") String designId);

	/**
	 * 根据工序设计单号算价格
	 */
	@Update("update  M_DESIGN_PROCEDURE_DETAILS s set  s.module_subtotal=${subtotal} where s.procedure_id=${procedureId} and s.DETAILS_NUMBER=${detailsNumber}")
	void updatePro(@Param("subtotal") double subtotal,
			@Param("procedureId") String procedureId,
			@Param("detailsNumber") Integer detailsNumber);

	/**
	 * 根据设计单号查找对应的工序
	 * 
	 * @param designId
	 * @return
	 */
	List<Procedure> MapProcedure1(@Param("designId") String designId);

	/**
	 * 根据产品编号查找对应的一条记录
	 */
	Procedure findByOne1(@Param("productId") String productId);

	/**
	 * 如果不通过审核
	 * 
	 * @param subtotal
	 * @param procedureId
	 * @param detailsNumber
	 */
	@Update("update  M_DESIGN_PROCEDURE_DETAILS s set  s.design_module_tag='D002-0',s.module_subtotal=0.00 where s.procedure_id=${procedureId} and s.DETAILS_NUMBER=${detailsNumber}")
	void updatePro1(@Param("procedureId") String procedureId,
			@Param("detailsNumber") Integer detailsNumber);

	/**
	 * 根据设计单编号修改总价
	 * 
	 * @param designId
	 * @param modulePrice
	 */
	@Update("Update M_DESIGN_PROCEDURE d set d.module_cost_price_sum=0.00,d.DESIGN_MODULE_TAG='G002-0',d.check_time=sysdate where  d.design_id=#{designId}")
	void updateSum1(@Param("designId") String designId);

	/**
	 * 根据ID查找为删除做准备
	 */
	@Select("select md.id from M_DESIGN_PROCEDURE m,M_DESIGN_PROCEDURE_DETAILS md where m.product_id=#{productId} and  m.id=md.parent_id")
	List<Integer> findByDelete(@Param("productId") String productId);

	/**
	 * 根据ID删除
	 * 
	 * @param parentId
	 * @return
	 */
	@Delete("delete from M_DESIGN_PROCEDURE_MODULE m where m.parent_id=#{parentId} ")
	int delete(@Param("parentId") Integer parentId);

	/**
	 * 根据产品编号查找对应的一条记录
	 */
	Procedure findByOne2(@Param("productId") String productId);

	/**
	 * 修改物料总价
	 */
	@Update("update D_MODULE e set e.cost_price_sum=#{costpricesum} where e.product_id=#{productId}")
	void UpdateWSum(@Param("costpricesum") Double costpricesum,
			@Param("productId") String productId);
}
