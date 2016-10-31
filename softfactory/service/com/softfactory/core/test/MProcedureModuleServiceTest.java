package com.softfactory.core.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softfactory.core.service.MProcedureModuleService;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MProcedureModule;

public class MProcedureModuleServiceTest {
	private MProcedureModuleService procedureModuleService;

	@SuppressWarnings("resource")
	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		procedureModuleService = ctx.getBean("mprocedureModuleService", MProcedureModuleService.class);
	}

	@Test
	public void findPager() {
		Integer page = 1;
		Integer rows = 5;
		String sort = "id";
		String order = "asc";
		Integer id = null;
		String pname = null;
		Integer pageno = (page - 1) * rows;
		Integer pagesize = page * rows;
		Pager<MProcedureModule> pager = procedureModuleService.findPager(pageno, pagesize, sort, order, id, pname);
		System.out.println(pager.getTotal());
		for (MProcedureModule procucts : pager.getRows()) {
			System.out.println(procucts.getAmount() + "-------" + procucts.getId());
		}
	}

	@Test
	public void add() {
		MProcedureModule mf = new MProcedureModule();
		mf.setAmount(1);
		mf.setCostPrice(100);
		mf.setDetailsNumber(22);
		mf.setParentId(2);
		mf.setProductId("22");
		mf.setProductName("223");
		mf.setRealAmount(1);
		mf.setRealSubtotal(15);
		mf.setRenewAmount(20);
		mf.setSubtotal(30);

		int count = procedureModuleService.add(mf);
		if (count > 0) {
			System.out.println("1111111111");
		} else {
			System.out.println("222222222222");
		}
	}
	
	/**
	 * 
	 * @author GuangxiangLong
	 * 
	 */
	@Test
	public void testfindPrentID(){
		Integer prentId = 1;
		List<MProcedureModule> l = procedureModuleService.findByPrentId(prentId);
		for (MProcedureModule procucts : l) {
			System.out.println(procucts.getAmount() + "-------" + procucts.getId());
		}
	}
}
