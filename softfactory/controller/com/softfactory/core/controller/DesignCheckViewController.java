package com.softfactory.core.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softfactory.core.service.ProcedureService;
import com.softfactory.core.util.JsonDateValueProcessor;
import com.softfactory.core.util.Pager;
import com.softfactory.pojo.Procedure;

@Controller
public class DesignCheckViewController {
	@Resource(name = "procedureService")
	private ProcedureService procedureService;

	/**
	 * 点击进入查看已经通过审核的产品
	 * 
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param response
	 */
	@RequestMapping("/designCheckView")
	public void Checker(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			HttpServletResponse response) {

		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页

		Pager<Procedure> pager = procedureService.findPager2(pageno, pagesize,
				sort, order);
		JsonConfig jsonConfig = new JsonConfig();
		try {
			PrintWriter out = response.getWriter();
			// 处理日期类型的数据
			jsonConfig.registerJsonValueProcessor(Date.class,
					new JsonDateValueProcessor());
			// 把 Java对象转换为json对象(json格式的数据)
			JSONObject json = (JSONObject) JSONSerializer.toJSON(pager,
					jsonConfig);
			// 向客户端响应json数据
			out.println(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据设计单号查找对应工序和明细
	 * 
	 * @param designId
	 * @param response
	 */
	@RequestMapping("/CheckDesign_view_Checker")
	public String MapProcedure(
			@RequestParam(required = true, value = "designId") String designId,
			@RequestParam(required = true, value = "productId") String ProductId,
			ModelMap modelMap) {
		List<Procedure> list = procedureService.MapProcedure1(designId);
		Procedure pro = procedureService.findByOne2(ProductId);
		if (list != null && pro != null) {
			modelMap.put("list", list);
			modelMap.put("pro", pro);
		}
		return "procedureProDesign/Check_View";
	}
}
