package com.softfactory.core.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softfactory.core.service.PdetailsService;
import com.softfactory.pojo.Pdetails;

public class PdetailsServiceTest {
  private PdetailsService pdetailsService;

  @SuppressWarnings("resource")
  @Before
  public void init() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    pdetailsService = ctx.getBean("pdetailsService", PdetailsService.class);
  }
  
  @Test
  public void findByPId(){
	 List<Pdetails> list = pdetailsService.findByPId("02020001010100100006");
	 for(Pdetails p : list){
		System.out.println(p.getProcedureName()+"-----"+p.getId());
	 }
  }
}
