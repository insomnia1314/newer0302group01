<%--
	author ：long
 --%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../commons/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>PassedMFG</title>
<%@ include file="../commons/meta.jsp"%>

</head>
<body>

	<div style="margin: 10px 30px;">
		
		<div id="instockNumWindows" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true"></div>
		<!-- 设定用户角色信息窗口 -->
		<div id="userRole"></div>
		<table id="mpcinstockrechek">
		</table>
		
	</div>
	<script type="text/javascript">
		$(function() {
			// 加载数据表格
			$("#mpcinstockrechek").datagrid({
				url : "<%=request.getContextPath()%>/MProcedureModuling/listrecheckerManufacture.do", //数据请求地址
				title : "待生产工单", //标题
				fitColumns : true, //真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
				striped : true, //是否显示斑马线效果。
				rownumbers : true, //如果为true，则显示一个行号列。
				columns : [ [
					{
						//Integer id;  序号
						field : 'id',
						title : '序号',
						width : 100,
						align : 'center'
					},
					{
						// private String manufactureId;派工单编号
						field : 'manufactureId',
						title : '派工单编号',
						width : 200,
						align : 'center'
					},
					// private String productName; 产品名称
					{
						field : 'productName',
						title : '产品名称',
						width : 100,
						align : 'center'
					},
					{
						//productDescribe; 
						field : 'productDescribe',
						title : '产品简介',
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
						field : 'designer',
						title : '工单制定人',
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
						title : '入库审核',
						width : 100,
						align : 'center',
						formatter : function(value, rowData, rowIndex) {
							var id = rowData["id"];
							//alert("Id="+Id);
							return '<a href="#" class="reviewed" onclick="instockCheck(\'' + id + '\')" >入库审核</a>';
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
						text : '入库通知登记',
						plain : true,
						iconCls : 'icon-add',
					});
				}
			});
			
		});
	</script>
</body>
</html>
