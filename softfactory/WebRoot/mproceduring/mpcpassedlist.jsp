<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>复核页面</title>
<%@ include file="../commons/meta.jsp"%>
</head>

<body>
	<div style="margin: 10px 30px;">
		<table id="mpcPasses">

		</table>
	</div>
	<script type="text/javascript">
		$(function() {
			// 加载数据表格
			$("#mpcPasses").datagrid({
				url : "<%=request.getContextPath()%>/MProceduring/listPassedMProceduring.do", //数据请求地址
				title : "待审核工单", //标题
				fitColumns : true, //真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
				striped : true, //是否显示斑马线效果。
				rownumbers : true, //如果为true，则显示一个行号列。
				columns : [ [
					{
						//Integer id;  序号
						field : 'manufactureId',
						title : '派工单号',
						width : 100,
						align : 'center'
					},
					{
						// private String manufactureId;派工单编号
						field : 'procedureId',
						title : '工序编号',
						width : 200,
						align : 'center'
					},
					// private String productName; 产品名称
					{
						field : 'procedureName',
						title : '产品名称',
						width : 100,
						align : 'center'
					},
					{
						//productDescribe; 
						field : 'demandAmount',
						title : '需求数量',
						width : 100,
						align : 'center'
					},
					{
						// amount;  投产数量
						field : 'amount',
						title : '投产数量',
						width : 100,
						align : 'center'
					},
					{
						//String designer; // 
						field : 'registerTime',
						title : '登记时间',
						width : 100,
						align : 'center'
					},
					{
						//private String register; // 登记人
						field : 'register',
						title : '登记人',
						width : 100,
						align : 'center'
					},
					{
						field : 'itemid',
						title : '复核',
						width : 100,
						align : 'center',
						formatter : function(value, rowData, rowIndex) {
							var mprid = rowData["mprid"];
							//alert("Id="+Id);mpcpassedlist.jsp/softfactory/WebRoot/mproceduring/mpcpassedlist.jsp
							return '<a href="#" class="reviewed" onclick="mpcrecheck(\'' + mprid + '\')" >审核</a>';
						},
					},
	
				] ],
				pagination : true,
				pageSize : 10,
				pageList : [ 5, 10, 15, 20 ],
				sortName : "id",
				sortOrder : "asc",
				onLoadSuccess : function(data) {
					$('.reviewed').linkbutton({
						text : '点击审核',
						plain : true,
						iconCls : 'icon-edit',
					});
				}
			});
		});
	</script>
</body>
</html>
