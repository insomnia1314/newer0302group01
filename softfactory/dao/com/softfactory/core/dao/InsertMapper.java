package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Insert;

@Repository("insertMapper")
public interface InsertMapper {

	List<Insert> findByInsert(@Param("productId") String productId,
			@Param("type") String type);

	@org.apache.ibatis.annotations.Insert("Insert into M_DESIGN_PROCEDURE_MODULE(ID,PARENT_ID,DETAILS_NUMBER,PRODUCT_ID,PRODUCT_NAME,TYPE,AMOUNT,PRODUCT_DESCRIBE,AMOUNT_UNIT,COST_PRICE,SUBTOTAL)values(#{Id},#{parentId},#{detailsNumber},#{productId},#{productName1},#{type},#{amount},#{productName},#{amountUnit},#{costPrice},#{subtotal})")
	@SelectKey(statement = "select SEQ_M_DESIGN_PROCEDURE_MODULE.nextval from dual", before = true, keyProperty = "Id", resultType = int.class)
	int add(Insert add);
}
