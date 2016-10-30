package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.MProceduringService;
import com.softfactory.core.service.ManufactureService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Manufacture;

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

	@Resource(name = "manufactureService")
	private ManufactureService manufactureService;

	/**
	 * EasyUI加载通过审核的生产计划
	 * @param response
	 */
	@RequestMapping("/listPassedManufacture")
	public void listPassedManufacture(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order, 
			HttpServletResponse response) {
		
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
	 * esayUi加载某个通过审核计划的其生产工序
	 */
	@RequestMapping("listMProceduring")
	public void listMProceduring(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			HttpServletResponse response,
			Manufacture manufacture
			){
		Integer id = manufacture.getId();
		if (null != id) {
			
		}
	};
}
