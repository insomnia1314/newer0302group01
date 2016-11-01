package com.softfactory.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
public class DesignCheckController {

	@Resource(name = "procedureService")
	private ProcedureService procedureService;

	/**
	 * 点击审核的时候进入
	 * 
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param response
	 */
	@RequestMapping("/designCheckList")
	public void list(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			HttpServletResponse response) {

		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页

		Pager<Procedure> pager = procedureService.reviewPage(pageno, pagesize,
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
	@RequestMapping("/CheckDesign_view")
	public String MapProcedure(
			@RequestParam(required = true, value = "designId") String designId,
			@RequestParam(required = true, value = "productId") String ProductId,
			ModelMap modelMap) {
		List<Procedure> list = procedureService.MapProcedure1(designId);
		Procedure pro = procedureService.findByOne1(ProductId);
		if (list != null && pro != null) {
			modelMap.put("list", list);
			modelMap.put("pro", pro);
		}
		return "procedureProDesign/design_check";
	}

	/**
	 * 点击通过审核进入此操作
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/updateStateCheck")
	public void UpdateState(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		String designId = request.getParameter("designId");
		if (designId != null && !designId.equals("")) {
			procedureService.click(designId);
			out.print("<script language='javascript'>alert('审核通过,页面即将刷新！');parent.location.reload();</script>");
			out.flush();
			out.close();
		}

	}

	/**
	 * 不通过审核的时候
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/unClick")
	public void MapProcedure(HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		String[] prcedureId = request.getParameterValues("prcedureId");
		String productId = request.getParameter("productId");
		String[] detailsNumber = request.getParameterValues("detailsNumber");
		String designId = request.getParameter("designId");
		try {
			procedureService.updatePro1(prcedureId, detailsNumber, designId,
					productId);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		out.print("<script language='javascript'>alert('审核不通过工序物料被重置请重新设计！');parent.location.reload();</script>");
		out.flush();
		out.close();
	}

	/**
	 * 点击单个工序查出详细
	 */
	@RequestMapping("/findByID1")
	public String findByID1(
			@RequestParam(required = true, value = "procedureName") String procedureName,
			@RequestParam(required = true, value = "productId") String productId,
			ModelMap modelMap) {
		String type = null;
		if (procedureName.equals("组装")) {
			type = "Y001-2";
		} else if (procedureName.equals("包装")) {
			type = "Y001-3";
		}
		List<Procedure> list = procedureService.findByProductId1(productId,
				type);
		modelMap.put("list", list);
		return "procedureProDesign/procedure_decisionCheck";
	}
}
