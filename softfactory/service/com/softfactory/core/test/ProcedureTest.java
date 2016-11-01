package com.softfactory.core.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softfactory.core.service.ProcedureService;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Insert;
import com.softfactory.pojo.Procedure;

public class ProcedureTest {
	private ProcedureService procedureService;

	@SuppressWarnings("resource")
	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		procedureService = ctx.getBean("procedureService",
				ProcedureService.class);
	}

	@Test
	public void findPager() {
		// easyi 必需的参数
		Integer page = 1;
		Integer rows = 5;
		String sort = "id";
		String order = "asc";

		// 条件查询的参数
		String ename = null;
		// ename = "%S%";

		// 处理记录的开始页/结束页
		Integer pageno = (page - 1) * rows;
		Integer pagesize = page * rows;

	Pager<Procedure> pager = procedureService.findPager2(pageno, pagesize, sort, order);
	System.out.println("总记录数: " + pager.getTotal());
	for (Procedure emp : pager.getRows()) {
		System.out.println(emp.toString());
	}

//	List<Procedure> pro = procedureService.findByProductId("020200101010010008", 1);
//	for (Procedure li :pro) {
//		System.out.println(li.toString());
//		}

//		int i = procedureService.add("020200101010010008", new String[] { "1",
//				"3" });
//		System.out.println(i);
//		List<Integer> list=procedureService.findByDelete("020200101010010008");
//		for(Integer i:list){
//			System.out.println(i);
//		}
		
	}

}
