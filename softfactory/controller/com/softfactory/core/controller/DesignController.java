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
import com.softfactory.pojo.ProcedureDTO;

@Controller
public class DesignController {
	@Resource(name = "procedureService")
	private ProcedureService procedureService;

	/**
	 * 点击设计的时候进入
	 * 
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @param response
	 */
	@RequestMapping("/designList")
	public void list(
			@RequestParam(required = true, value = "page") Integer page,
			@RequestParam(required = true, value = "rows") Integer rows,
			@RequestParam(required = true, value = "sort") String sort,
			@RequestParam(required = true, value = "order") String order,
			HttpServletResponse response) {

		int pageno = (page - 1) * rows; // 开始页
		int pagesize = page * rows; // 结束页

		Pager<Procedure> pager = procedureService.findPager(pageno, pagesize,
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
	 * 根据设计单号查找对应工序和
	 * 
	 * @param designId
	 * @param response
	 */
	@RequestMapping("/mapProcedure_view")
	public String MapProcedure(
			@RequestParam(required = true, value = "designId") String designId,
			@RequestParam(required = true, value = "productId") String ProductId,
			ModelMap modelMap) {
		List<Procedure> list = procedureService.MapProcedure(designId);
		Procedure pro = procedureService.findByOne(ProductId);
		if (list != null && pro != null) {
			modelMap.put("list", list);
			modelMap.put("pro", pro);
		}
		return "procedureProDesign/design_decision";
	}

	/**
	 * 通过商品编号找到对应的值
	 */
	@RequestMapping("/findByProductId")
	public String findByProductId(
			@RequestParam(required = true, value = "productId") String productId,
			@RequestParam(required = true, value = "detailsNumber") Integer detailsNumber,
			@RequestParam(required = true, value = "productName") String productName,
			@RequestParam(required = true, value = "designId") String designId,
			@RequestParam(required = true, value = "procedureId") String procedureId,
			@RequestParam(required = true, value = "procedureName") String procedureName,
			ModelMap modelMap) {
		if (productId != null && !productId.equals("")) {
			String type = null;
			if (procedureName.equals("组装")) {
				type = "Y001-2";
			} else if (procedureName.equals("包装")) {
				type = "Y001-3";
			}
			List<Procedure> procedure = procedureService.findByProductId(
					productId, type);
			if (procedure.size() > 0) {
				modelMap.put("procedure", procedure);
				ProcedureDTO dto = new ProcedureDTO();
				dto.setDesignId(designId);
				dto.setProductId(productId);
				dto.setProductName(productName);
				dto.setProcedureId(procedureId);
				dto.setDetailsNumber(detailsNumber);
				dto.setProcedureName(procedureName);
				modelMap.put("dto", dto);
			}
		}
		return "procedureProDesign/procedure_decision";

	}

	/**
	 * 新增物料详细
	 */
	@RequestMapping("/procedureAdd")
	public void add(HttpServletRequest request, HttpServletResponse response) {
		int i = 0;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			String procedureName = request.getParameter("procedureName");
			String designId = request.getParameter("designId");
			String productId = request.getParameter("productId");
			String[] subtotal = request.getParameterValues("using_amount");
			String procedureId = request.getParameter("procedureId");
			Integer detailsNumber = null;
			try {
				detailsNumber = Integer.parseInt(request
						.getParameter("detailsNumber"));
			} catch (NumberFormatException e) {
				out.print("<script language='javascript'>alert('你可能还有工序未完成设计失败"
						+ i + "！');history.go(-2);</script>");
				out.flush();
				out.close();
			}
			if (productId != null && !"".equals(productId) && subtotal != null) {
				procedureService.update(procedureId, detailsNumber);
				i += procedureService.add(procedureId, designId, productId,
						subtotal, detailsNumber, procedureName);
				out.print("<script language='javascript'>alert('设计成功" + i
						+ "！');window.location='mapProcedure_view.do?"
						+ "productId=" + productId + "&&designId=" + designId
						+ "" + "';</script>");
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 新增物料详细完成后根据总的改物料的设计状态
	 */
	@RequestMapping("/UpdateState")
	public void UpdateState(
			@RequestParam(required = true, value = "designId") String designId,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			List<Procedure> list = procedureService.MapProcedure(designId);
			System.out.println(list.size());
			if (list.size() <= 0) {
				procedureService.updateState(designId);
				out.print(0);
				out.flush();
				out.close();
			}
			out.print(1);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
