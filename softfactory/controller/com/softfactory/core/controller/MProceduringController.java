package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.MProcedureModuleService;
import com.softfactory.core.service.MProcedureModulingService;
import com.softfactory.core.service.MProcedureService;
import com.softfactory.core.service.MProceduringService;
import com.softfactory.core.service.ManufactureService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.MProcedure;
import com.softfactory.pojo.MProcedureModule;
import com.softfactory.pojo.MProcedureModuling;
import com.softfactory.pojo.MProceduring;
import com.softfactory.pojo.Manufacture;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

/** 
 * 生产工序记录
 * 
 * @author GuangxiangLong
 *
 */
@RequestMapping("/MProceduring")
@Controller
public class MProceduringController {

	@Resource(name = "mProceduringService")
	private MProceduringService mProceduringService;
	
	@Resource(name="mProcedureModulingService")
	private MProcedureModulingService mProcedureModulingService;
	
	@Resource(name = "manufactureService")
	private ManufactureService manufactureService;

	@Resource(name = "mprocedureService")
	private MProcedureService mProcedureService;

	@Resource(name = "mprocedureModuleService")
	private MProcedureModuleService mProcedureModuleService;
	
	
	/**
	 * EasyUI加载通过审核的生产计划
	 * 
	 * @param response
	 */
	@RequestMapping("/listPassedManufacture")
	public void listPassedManufacture(@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order, HttpServletResponse response) {

		Integer pagesize = page * rows;
		page = (page - 1) * rows;
		Manufacture manufacture = new Manufacture();
		manufacture.setCheckTag("S001-1");
		try {
			Pager<Manufacture> p = manufactureService.findPassedMFG(page, pagesize, sort, order, manufacture);
			JsonConfig jsonConfig = new JsonConfig();
			// 处理日期类型的数据
			jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
			// 排除 某个/多个 字段(这些字段不在 json 数据中显示)
			// jsonConfig.set (new String[]{"hiredate"});
			// 把 Java集合转换为json格式的数据
			// JSONArray json = JSONArray.fromObject(, jsonConfig);
			JSONObject jsonObj = (JSONObject) JSONSerializer.toJSON(p, jsonConfig);
			// 实例化打印流
			PrintWriter out = response.getWriter();
			System.out.println(jsonObj.toString());
			// 向客户端响应json数据
			out.println(jsonObj.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 跳转生产记录
	 * 
	 * @return
	 */
	@RequestMapping("/showManufacture")
	public String showManufacture(Manufacture manufacture, ModelMap map) {
		Integer id = manufacture.getId();
		if (null != id) {
			Manufacture m = manufactureService.findById(id);
			if (null != m) {
				map.addAttribute("manufacture", m);
			}
		}
		return "mproceduring/mpcshowManufacture";
	}

	/**
	 * esayUi加载某个通过审核计划的详细信息
	 */
	@RequestMapping("/listMProceduring")
	public void listMProceduring(HttpServletResponse response, Manufacture manufacture) {
		try {
			Integer id = manufacture.getId();
			if (null != id) {
				List<MProcedure> l = mProcedureService.findByPrentId(id);
				JsonConfig jsonConfig = new JsonConfig();
				// 处理日期类型的数据
				jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
				// 排除 某个/多个 字段(这些字段不在 json 数据中显示)
				// jsonConfig.set (new String[]{"hiredate"});
				// 把 Java集合转换为json格式的数据
				JSONArray jsonObj = JSONArray.fromObject(l, jsonConfig);
				// JSONObject jsonObj = (JSONObject) JSONSerializer.toJSON(p,
				// jsonConfig);
				// 实例化打印流
				PrintWriter out = response.getWriter();
				// 向客户端响应json数据
				out.println(jsonObj.toString());
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 跳转到物料记录页面
	 * 
	 * @param modelMap
	 * @param id
	 * @return
	 */
	@RequestMapping("/jumpChangeFinishTag")
	public String jumpChangeFinishTag(ModelMap modelMap, Integer id) {
		MProcedure m = mProcedureService.findById(id);
		modelMap.put("mprocedure", m);
		return "mproceduring/mpcfinishtag";
	}

	/**
	 * 加载某个工序下所需物料
	 * 
	 * @param response
	 * @param id
	 */
	@RequestMapping("/listProceduringModule")
	public void listProceduringModule(HttpServletResponse response, Integer id) {
		try {
			if (null != id) {
				List<MProcedureModule> l = mProcedureModuleService.findByPrentId(id);
				JsonConfig jsonConfig = new JsonConfig();
				// 处理日期类型的数据
				jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
				// 排除 某个/多个 字段(这些字段不在 json 数据中显示)
				// jsonConfig.set (new String[]{"hiredate"});
				// 把 Java集合转换为json格式的数据
				JSONArray jsonObj = JSONArray.fromObject(l, jsonConfig);
				// JSONObject jsonObj = (JSONObject) JSONSerializer.toJSON(p,
				// jsonConfig);
				// 实例化打印流
				PrintWriter out = response.getWriter();
				// 向客户端响应json数据
				out.println(jsonObj.toString());
				System.out.println(jsonObj.toString());
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 产生一条生产记录
	 * @param response
	 * @param m
	 * @param MPMjsonObj
	 */
	@RequestMapping("/registerProceduring")																	
	public void registerProceduring(HttpServletResponse response, MProceduring m, String MPMjsonObj,Integer mpprentId) {
		if(null != m){
			if(null == m.getProcedureDescribe()){
				m.setProcedureDescribe("没有描述信息");
			}
			mProceduringService.add(m);
		}
		try {
			List<MProcedureModule> l = mProcedureModuleService.findByPrentId(mpprentId);
			JSONArray jsonArray = JSONArray.fromObject(MPMjsonObj);
			int iSize = jsonArray.size();
			for (int i = 0; i < iSize; i++) {
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				Integer id = Integer.valueOf((String) jsonObj.get("id")) ;
				Integer num = Integer.valueOf((String) jsonObj.get("val")) ;
				for(int j =0;j<l.size();j++){
					if(l.get(j).getId()==id){
						MProcedureModuling mml = new MProcedureModuling();
						mml.setParentId(m.getmPMId());
						mml.setDetailsNumber(m.getDetailsNumber());
						mml.setProducId(m.getProcedureId());
						mml.setProductName(m.getProcedureName());
						mml.setCostPrice(m.getCostPrice());
						mml.setSubtotal((num*m.getCostPrice()));
						mml.setAmount(num);
						mProcedureModulingService.add(mml);
						break;
					}
				}
			}
			PrintWriter out = response.getWriter();
			// 向客户端响应json数据
			out.println("登记成功，请等待审核");
			out.flush();
			out.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
