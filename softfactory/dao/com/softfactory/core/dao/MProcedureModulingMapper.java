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

/**
 * 生产工序物料过程记录 DAO对象
 * 
 * @author GuangxiangLong
 *
 */
@Repository("mProcedureModulingMapper")
public interface MProcedureModulingMapper {

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param pagesize
	 * @param sort
	 * @param order
	 * @return
	 */
	List<MProcedureModuling> findPager(@Param("page") Integer page, @Param("pagesize") Integer pagesize,
			@Param("sort") String sort, @Param("order") String order);

	/**
	 * 分页总记录数
	 * 
	 * @return
	 */
	long findPagerTotal();

	/**
	 * 增加
	 * 
	 * @param m
	 *            持久化对象
	 * @return 数据库影响记录数
	 */
	@Insert("INSERT INTO M_PROCEDURE_MODULING(ID,PARENT_ID,DETAILS_NUMBER,PRODUCT_ID,PRODUCT_NAME,COST_PRICE,AMOUNT,SUBTOTAL)"
			+ "values(#{mPId},#{parentId},#{detailsNumber},#{producId},#{productName},#{costPrice},#{amount},#{subtotal})")
	@SelectKey(statement = "SELECT SEQ_M_PROCEDURE_MODULING.NEXTVAL FROM DUAL", before = true, keyProperty = "mPId", resultType = int.class)
	int add(MProcedureModuling m);

	/**
	 * 修改
	 * 
	 * @param m
	 *            持久化对象
	 * @return 数据库影响记录数
	 */
	@Update("UPDATE M_PROCEDURE_MODULING SET PARENT_ID=#{parentId},DETAILS_NUMBER = #{detailsNumber},PRODUCT_ID=#{producId},PRODUCT_NAME=#{productName},COST_PRICE=#{costPrice},AMOUNT=#{amount},SUBTOTAL=#{subtotal} WHERE ID=#{mPId}")
	int update(MProcedureModuling m);

	/**
	 * 根据主键删除记录
	 * 
	 * @param mPId
	 *            需要匹配的主键
	 * @return
	 */
	@Delete("delete from M_PROCEDURE_MODULING WHERE ID=#{mPId}")
	int remove(Integer mPId);

	/**
	 * 主键寻找单挑记录
	 * 
	 * @param mPId
	 * @return
	 */
	@Select("select ID mPId,PARENT_ID parentId,DETAILS_NUMBER detailsNumber,PRODUCT_ID producId,PRODUCT_NAME productName,COST_PRICE costPrice,AMOUNT amount,SUBTOTAL subtotal"
			+ " from M_PROCEDURE_MODULING where ID=#{mPId}")
	MProcedureModuling findById(Integer mPId);
	
	/**
	 * 通过父类ID和商品ID加载单挑记录
	 * @param parentId
	 * @param ProductId
	 * @return
	 */
	MProcedureModuling findByParentIdAndProductId(@Param("parentId")Integer parentId,@Param("ProductId")String ProductId);
	
}
