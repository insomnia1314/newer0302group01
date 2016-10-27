package com.softfactory.core.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softfactory.core.service.ManufactureService;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Manufacture;

public class ManufactureServiceTest {
  private ManufactureService manufactureService;

  @SuppressWarnings("resource")
  @Before
  public void init() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    manufactureService = ctx.getBean("manufactureService", ManufactureService.class);
  }

  @Test
  public void findPager(){
	  Integer page=1;
	  Integer rows=5;
	  String sort="id";
	  String order="asc";
	  Integer id = null;
	  String  pname=null;
	  Integer pageno=(page-1)*rows;
	  Integer pagesize=page*rows;
	  Pager<Manufacture>pager=manufactureService.findPager(pageno, pagesize, sort, order,id,pname);
	  System.out.println(pager.getTotal());
	  for(Manufacture procucts:pager.getRows()){
		  System.out.println(procucts.getAmount()+"-------"+procucts.getId());
	  }
  }
  
  @Test
  public void add(){
	  Manufacture mf = new Manufacture();
	  mf.setAmount(1);
	  mf.setApplyIdGroup("11");
	  mf.setChecker("1");
	  mf.setCheckTag("111");
	  mf.setCheckTime(new Date());
	  mf.setDesigner("22");
	  mf.setLabourCostPriceSum(22);
	  mf.setManufactureId("22");
	  mf.setManufactureProcedureTag("111");
	  mf.setModuleCostPriceSum(22);
	  mf.setProductDescribe("33");
	  mf.setProductId("02020001010100100006 ");
	  mf.setProductName("888");
	  mf.setRealLabourCostPriceSum(99);
	  mf.setRealModuleCostPriceSum(99);
	  mf.setRegister("212");
	  mf.setRemark("remark");
	  mf.setTestedAmount(1);
	  mf.setRegisterTime(new Date());
	  
	  int count = manufactureService.add(mf);
	  if(count>0){
		  System.out.println("1111111111");
	  }else{
		  System.out.println("222222222222");
	  }
  }
}
