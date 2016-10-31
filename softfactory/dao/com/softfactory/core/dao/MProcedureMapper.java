package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.MProcedure;

/**
 * 生产工序记录
 */
@Repository("mprocedureMapper")
public interface MProcedureMapper {
	
	/**
	 * 生产工序表新增数据
	 * @param pd
	 * @return
	 */
	@Insert("insert into M_PROCEDURE(ID,PARENT_ID,DETAILS_NUMBER,PROCEDURE_ID,PROCEDURE_NAME,"
			+ "LABOUR_HOUR_AMOUNT,SUBTOTAL,MODULE_SUBTOTAL,COST_PRICE,DEMAND_AMOUNT,PROCEDURE_FINISH_TAG,"
			+ "PROCEDURE_TRANSFER_TAG) values(#{id},#{parentId},#{detailsNumber},#{procedureId},"
			+ "#{procedureName},#{labourHourAmount},#{subtotal},"
			+ "#{moduleSubtotal},#{costPrice},#{demandAmount},"
			+ "#{procedureFinishTag},#{procedureTransferTag})")
	@SelectKey(statement = "select SEQ_M_PROCEDURE.nextval from dual", keyProperty = "id", resultType = int.class, before = true)
	int add(MProcedure pd);
	
	/**
	 * 分页查询
	 * @param pageno
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @param id
	 * @param procedureName
	 * @return
	 */
	List<MProcedure> findPager(
			@Param("pageno") Integer pageno, 
			@Param("pagesize") Integer pagesize, 
			@Param("sort") String sort,
		    @Param("order") String order,
		    @Param("id") Integer id,
		    @Param("procedureName") String procedureName);
	
	long findPagerTotal(@Param("id") Integer id,@Param("procedureName") String procedureName);
	
	/**
	 * @author GuangxiangLong
	 * @return 
	 */
	List<MProcedure> findByPrentId(Integer prentId);
	
	/**
	 * @author GuangxiangLong
	 * 通过主键加载数据
	 * @param id
	 * @return
	 */
	MProcedure findById(Integer id);
}
