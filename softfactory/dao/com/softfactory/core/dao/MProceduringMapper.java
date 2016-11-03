package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.MProcedureModuling;
import com.softfactory.pojo.MProceduring;

/**
 * 生产工序记录
 * 
 * @author GuangxiangLong
 *
 */

@Repository("mProceduringMapper")
public interface MProceduringMapper {

	/**
	 * 分页
	 * 
	 * @param page
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @return
	 */
	List<MProceduring> findPager(@Param("page") Integer page, @Param("pagesize") Integer pagesize,
			@Param("sort") String sort, @Param("order") String order);

	/**
	 * 分页总记录数
	 */
	long findPagerTotal();

	/**
	 * 增加方法
	 * 
	 * @param m
	 * @return
	 */
	@Insert("INSERT INTO M_PROCEDURING(ID,PARENT_ID,DETAILS_NUMBER,PROCEDURE_ID,PROCEDURE_NAME,"
			+ "LABOUR_HOUR_AMOUNT,COST_PRICE,SUBTOTAL,PROCEDURE_DESCRIBE,REG_COUNT,PROCEDURE_RESPONSIBLE_PERSON,"
			+ "REGISTER,REGISTER_TIME) "
			+ "VALUES(#{mPMId},#{parentId},#{detailsNumber},#{procedureId},#{procedureName},"
			+ "#{labourHourAmount},#{costPrice},#{subtotal},#{procedureDescribe},#{regCount},"
			+ "#{procedureResponsiblePerson},#{register},#{registerTime})")
	@SelectKey(before = true, keyProperty = "mPMId", resultType = int.class, statement = "SELECT SEQ_M_PROCEDURING.NEXTVAL FROM DUAL")
	int add(MProceduring m);

	/**
	 * 修改方法
	 * 
	 * @param m
	 * @return
	 */
	@Update("update M_PROCEDURING set PARENT_ID=#{parentId},DETAILS_NUMBER=#{detailsNumber},PROCEDURE_ID=#{procedureId},"
			+ "PROCEDURE_NAME=#{procedureName},LABOUR_HOUR_AMOUNT=#{labourHourAmount},COST_PRICE=#{costPrice},SUBTOTAL=#{subtotal},"
			+ "PROCEDURE_DESCRIBE=#{procedureDescribe},REG_COUNT=#{regCount},PROCEDURE_RESPONSIBLE_PERSON=#{procedureResponsiblePerson},"
			+ "REGISTER=#{register},REGISTER_TIME=#{registerTime},CHECKER=#{checker},CHECK_TIME=#{checkTime} "
			+ "WHERE ID=#{mPMId}")
	int update(MProceduring m);

	/**
	 * 通过主键寻找方法
	 * 
	 * @param mPMId
	 * @return
	 */
	@Select("select ID mPMId, PARENT_ID parentId,DETAILS_NUMBER detailsNumber,PROCEDURE_ID procedureId,PROCEDURE_NAME ProcedureName,"
			+ " LABOUR_HOUR_AMOUNT labourHourAmount,COST_PRICE costPrice,SUBTOTAL subtotal,PROCEDURE_DESCRIBE procedureDescribe,"
			+ "  REG_COUNT regCount, PROCEDURE_RESPONSIBLE_PERSON procedureResponsiblePerson,REGISTER register,REGISTER_TIME registerTime,"
			+ " CHECKER checker ,CHECK_TIME checkTime from M_PROCEDURING WHERE ID=#{mPMId}")
	MProceduring findById(Integer mPMId);

	/**
	 * 删除
	 * 
	 * @param mPMId
	 * @return
	 */
	@Delete("DELETE FROM M_PROCEDURING WHERE ID=#{MPMID}")
	int del(Integer mPMId);

	/**
	 * 
	 * @param parentid
	 * @param procedureId
	 * @return
	 */
	MProceduring findByPrentIdAndProcedureId(@Param("parentid") Integer parentid,
			@Param("procedureId") String procedureId);

}
