package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Manufacture;

@Repository("manufactureMapper")
public interface ManufactureMapper {
	
	@Update("update M_MANUFACTURE set CHECK_TAG=#{checkTag} where ID = #{id}")
	int modify(Manufacture mf);
	
	@Insert("insert into M_MANUFACTURE values(#{id},#{manufactureId},#{productId},#{productName},"
			+ "#{amount},#{testedAmount},#{applyIdGroup},#{productDescribe},#{moduleCostPriceSum},"
			+ "#{realModuleCostPriceSum},#{labourCostPriceSum},#{realLabourCostPriceSum},#{designer},"
			+ "#{register},#{registerTime},#{checker},#{checkTime},#{remark},#{checkTag},"
			+ "#{manufactureProcedureTag})")
	 @SelectKey(statement = "select SEQ_M_MANUFACTURE.nextval from dual", keyProperty = "id", resultType = int.class, before = true)
	int add(Manufacture mf);
	
	List<Manufacture> findPager(
			@Param("pageno") Integer pageno, 
			@Param("pagesize") Integer pagesize, 
			@Param("sort") String sort,
		    @Param("order") String order,
		    @Param("id") Integer id,
		    @Param("productName") String productName);

	long findPagerTotal(@Param("id") Integer id,@Param("productName") String productName);
	
	/**
	 * 通过主键加载记录
	 * @param id
	 * @return
	 */
	Manufacture findById(Integer id);
	/**
	 * author 龙光祥
	 * @return 查找通过审核的生产计划
	 *
	 */
	List<Manufacture> findPassedMFG(
			@Param("pageno") Integer pageno, 
			@Param("pagesize") Integer pagesize, 
			@Param("sort") String sort,
		    @Param("order") String order,
		    @Param("manufacture") Manufacture manufacture);
	
	/**
	 * 通过审核的生产计划总记录数
	 * @author GuangxiangLong
	 * @param manufacture
	 * @return
	 */
	long findPassedMFGTotal(@Param("manufacture") Manufacture manufacture);
}
