package com.softfactory.core.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softfactory.core.service.MdetailsService;
import com.softfactory.pojo.Mdetails;

public class MdetailsServiceTest {
  private MdetailsService mdetailsService;

  @SuppressWarnings("resource")
  @Before
  public void init() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    mdetailsService = ctx.getBean("mdetailsService", MdetailsService.class);
  }
  
  @Test
  public void findByPId(){
	 List<Mdetails> list = mdetailsService.findByPId(2);
	 for(Mdetails p : list){
		System.out.println(p.getProductName()+"-----"+p.getId());
	 }
  }
}
