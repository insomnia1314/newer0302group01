package com.softfactory.core.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softfactory.core.service.MProcedureService;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MProcedure;
import com.softfactory.pojo.MProcedureDTO;

public class MProcedureServiceTest {
  private MProcedureService procedureService;

  @SuppressWarnings("resource")
  @Before
  public void init() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    procedureService = ctx.getBean("mprocedureService", MProcedureService.class);
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
	  Pager<MProcedure> pager=procedureService.findPager(pageno, pagesize, sort, order, id, pname);
	  System.out.println(pager.getTotal());
	  for(MProcedure procucts:pager.getRows()){
		  System.out.println(procucts.getCostPrice()+"-------"+procucts.getId());
	  }
  }
  
  @Test
  public void add(){
	  MProcedure mf = new MProcedure();
	  mf.setCostPrice(100);
	  mf.setDemandAmount(20);
	  mf.setDetailsNumber(20);
	  mf.setLabourHourAmount(20);
	  mf.setModuleSubtotal(22);
	  mf.setParentId(2);
	  mf.setProcedureFinishTag("sss");
	  mf.setProcedureId("qqq");
	  mf.setProcedureName("www");
	  mf.setProcedureTransferTag("wwwww");
	  mf.setRealAmount(20);
	  mf.setRealLabourHourAmount(20);
	  mf.setRealModuleSubtotal(20);
	  mf.setRealSubtotal(20);
	  mf.setSubtotal(20);
	  
	  int count = procedureService.add(mf);
	  if(count>0){
		  System.out.println("1111111111");
	  }else{
		  System.out.println("222222222222");
	  }
  }
  

  @Test
  public void testprentId(){
	  Integer prentId = 1;
	  List<MProcedure> l = procedureService.findByPrentId(prentId);
	  for(MProcedure procucts:l){
		  System.out.println(procucts.getCostPrice()+"-------"+procucts.getId());
	  }
  }
  @Test
  public void testFindById(){
	  Integer id = 1;
	  MProcedure m = procedureService.findById(id);
	  System.out.println(m.getProcedureName());
  }
  
  @Test
  public void testfindByFinishTag(){
	  String finishTag = "G004-2";
	  List<MProcedureDTO> l = procedureService.findByFinishTag(finishTag);
	  for(MProcedureDTO procucts:l){
		  System.out.println(procucts.toString());
	  }
  }
}
