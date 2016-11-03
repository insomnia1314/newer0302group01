package com.softfactory.core.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softfactory.core.service.MProcedureModulingService;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MProcedureModuling;

/**
 * 龙光祥的产品物料测试
 * 
 * @author GuangxiangLong
 *
 */
public class MProcedureModulingTest {

	private MProcedureModulingService mProcedureModulingService;

	@SuppressWarnings("resource")
	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		mProcedureModulingService = (MProcedureModulingService) ctx.getBean("mProcedureModulingService");
	}

	@Test
	public void testAdd() {
		MProcedureModuling m = new MProcedureModuling();
		m.setAmount(1);
		m.setCostPrice(20);
		m.setDetailsNumber(1);
		m.setParentId(8);
		m.setProducId("0001");
		m.setProductName("三星Boom7");
		m.setSubtotal(600);
		mProcedureModulingService.add(m);
	}

	@Test
	public void testSearch() {
		MProcedureModuling m = mProcedureModulingService.findById(10);
		System.out.println(m);
	}

	@Test
	public void testPager() {

		Integer page = 1;
		Integer rows = 5;
		String sort = "asc";
		String order = "asc";
		Integer pagesize = page * rows;
		page = (page - 1) * rows;
		Pager<MProcedureModuling> p = mProcedureModulingService.findPager(page, pagesize, sort, order);
		List<MProcedureModuling> l = p.getRows();
		System.out.println("总记录数字：" + p.getTotal());
		for (MProcedureModuling m : l) {
			System.out.println(m);
		}
	}

	@Test
	public void testUpdate() {
		MProcedureModuling m = new MProcedureModuling();
		m.setmPId(10);
		m.setAmount(1);
		m.setCostPrice(20);
		m.setDetailsNumber(1);
		m.setParentId(8);
		m.setProducId("0001");
		m.setProductName("三星Noot7");
		m.setSubtotal(600);
		mProcedureModulingService.update(m);
	}

	@Test
	public void testDel() {
		mProcedureModulingService.remove(9);
	}
	
	@Test
	public void testfindByParentIdAndProductId(){
		Integer parentId = 8;
		String ProductId = "0001";
		MProcedureModuling m = mProcedureModulingService.findByParentIdAndProductId(parentId, ProductId);
		System.out.println(m);
	}
}
