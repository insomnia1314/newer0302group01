package com.softfactory.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.softfactory.pojo.Apply;

@Repository("applyMapper")
public interface ApplyMapper {
	
	/**
	 * 查询已审核未派单数据
	 * @return
	 */
	List<Apply> findByTag();
	
	/**
	 * 将未派单修改为已派单
	 * @param mf
	 * @return
	 */
	@Update("update M_APPLY set REGISTER = #{register}, MANUFACTURE_TAG = 'P001-1' where ID = #{id}")
	int modify(Apply mf);
	
	
	List<Apply> findPager(
			@Param("pageno") Integer pageno, 
			@Param("pagesize") Integer pagesize, 
			@Param("sort") String sort,
		    @Param("order") String order,
		    @Param("id") Integer id);

	long findPagerTotal(@Param("id") Integer id);
	
	/**
	 * 根据ID查询单条数据
	 * @param id
	 * @return
	 */
	Apply findById(Integer id);
}
