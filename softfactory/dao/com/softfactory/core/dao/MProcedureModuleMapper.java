package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.MProcedureModule;

@Repository("mprocedureModuleMapper")
public interface MProcedureModuleMapper {
	
	@Insert("insert into M_PROCEDURE_MODULE(ID,PARENT_ID,DETAILS_NUMBER,PRODUCT_ID,PRODUCT_NAME,COST_PRICE,AMOUNT,SUBTOTAL) values(#{id},#{parentId},#{detailsNumber},#{productId},#{productName},#{costPrice},#{amount},#{subtotal})")
	@SelectKey(statement = "select SEQ_M_PROCEDURE_MODULE.nextval from dual", keyProperty = "id", resultType = int.class, before = true)
	int add(MProcedureModule pm);
	
	List<MProcedureModule> findPager(
			@Param("pageno") Integer pageno, 
			@Param("pagesize") Integer pagesize, 
			@Param("sort") String sort,
		    @Param("order") String order,
		    @Param("id") Integer id,
		    @Param("productName") String productName);
	
	long findPagerTotal(@Param("id") Integer id,@Param("productName") String productName);
	
	/**
	 * @author GuangxiangLong
	 * @param prentId
	 * @return
	 */
	List<MProcedureModule> findByPrentId(Integer prentId);
}
