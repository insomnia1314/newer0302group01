package com.softfactory.core.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softfactory.core.service.ApplyService;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Apply;

public class ApplyServiceTest {
	private ApplyService applyService;

	@SuppressWarnings("resource")
	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		applyService = ctx.getBean("applyService", ApplyService.class);
	}

	@Test
	public void findByPId() {
		List<Apply> list = applyService.findByTag();
		for (Apply p : list) {
			System.out.println(p.getProductName() + "-----" + p.getAmount() + p.getRegister());
		}
	}

	@Test
	public void modify() {
		Apply a = new Apply();
		a.setId(1);
		a.setRegister("newer");
		int count = 0;
		count = applyService.modify(a);
		if (count > 0) {
			System.out.println("1111111111111");
		} else {
			System.out.println("失败");
		}

	}

	@Test
	public void findPager() {
		Integer page = 1;
		Integer rows = 5;
		String sort = "id";
		String order = "asc";
		Integer id = null;
		Integer pageno = (page - 1) * rows;
		Integer pagesize = page * rows;
		Pager<Apply> pager = applyService.findPager(pageno, pagesize, sort, order, id);
		System.out.println(pager.getTotal());
		for (Apply procucts : pager.getRows()) {
			System.out.println(procucts.getRegister() + "-------" + procucts.getId());
		}
	}
	
	@Test
	public void findById(){
		Apply a = applyService.findById(1);
		System.out.println(a.getRegister()+a.getRegisterTime());
	}
}
