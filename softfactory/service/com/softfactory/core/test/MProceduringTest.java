package com.softfactory.core.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softfactory.core.service.MProceduringService;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MProceduring;

public class MProceduringTest {
	private MProceduringService mProceduringService;

	@SuppressWarnings("resource")
	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		mProceduringService = (MProceduringService) ctx.getBean("mProceduringService");
	}

	@Test
	public void testAdd() {
		MProceduring m = new MProceduring();
		m.setChecker("Checker");
		m.setCheckTime(new Date());
		m.setCostPrice(200.0d);
		m.setDetailsNumber(1);
		m.setLabourHourAmount(11);
		m.setParentId(1);
		m.setProcedureDescribe("ProcedureDescribe");
		m.setProcedureId("ProcedureId");
		m.setProcedureName("ProcedureNam");
		m.setProcedureResponsiblePerson("procedureResponsiblePerson");
		m.setRegCount(11);
		m.setRegister("register");
		m.setRegisterTime(new Date());
		m.setSubtotal(2);
		mProceduringService.add(m);
	}

	@Test
	public void testFindById() {
		MProceduring m = mProceduringService.findById(13);
		System.out.println(m);
	}

	@Test
	public void testFindPager() {
		Integer page = 1;
		Integer rows = 5;
		String sort = "asc";
		String order = "asc";
		Integer pagesize = page * rows;
		page = (page - 1) * rows;
		Pager<MProceduring> p = mProceduringService.findPager(page, pagesize, sort, order);
		List<MProceduring> l = p.getRows();
		System.out.println("总记录数字：" + p.getTotal());
		for (MProceduring m : l) {
			System.out.println(m);
		}
	}

	@Test
	public void testUpdate() {
		MProceduring m = new MProceduring();
		m.setmPMId(13);
		m.setChecker("Checker");
		m.setCheckTime(new Date());
		m.setCostPrice(200.0d);
		m.setDetailsNumber(1);
		m.setLabourHourAmount(11);
		m.setParentId(1);
		m.setProcedureDescribe("ProcedureDescribe");
		m.setProcedureId("ProcedureId");
		m.setProcedureName("ProcedureNam");
		m.setProcedureResponsiblePerson("procedureResponsiblePerson");
		m.setRegCount(11);
		m.setRegister("register");
		m.setRegisterTime(new Date());
		m.setSubtotal(2);
		mProceduringService.update(m);
	}

	@Test
	public void testDel() {
		mProceduringService.del(8);
	}
	
//	@Test
//	public void testPassesMFG(){
//		List<Manufacture> l = mProceduringService.findPassedMFG();
//		for(Manufacture m : l){
//			System.out.println(m);
//		}
//	}
}
