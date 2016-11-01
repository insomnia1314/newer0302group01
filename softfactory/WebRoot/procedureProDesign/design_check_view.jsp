<%--
	author:SONG
--%>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>查询已成功用户</title>
<%@ include file="../commons/meta.jsp"%>
<script type="text/javascript">
	
</script>
</head>

<body>
	<!-- 审核成功列表显示 -->
	<div style="margin-top: 20px;">
		<table id="userRoleDataGrid3">

		</table>

	</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#userRoleDataGrid3")
					.datagrid(
							{
								url : "designCheckView.do",
								title : "审核成功查询",
								fitColumns : true,
								striped : true,
								rownumbers : true,
								columns : [ [
										{
											field : "id",
											title : "序号",
											width : 100,
											sortable : true
										},
										{
											field : "designId",
											title : "设计单编号",
											width : 100,
											sortable : true
										},
										{
											field : "productId",
											title : "产品编号",
											width : 100,
											sortable : true
										},
										{
											field : "productName",
											title : "产品名称",
											width : 100,
											sortable : true
										},
										{
											field : "costPriceSum",
											title : "工时总价",
											width : 100,
											sortable : true
										},
										{
											field : "moduleCostPriceSum",
											title : "物料总价",
											width : 100,
											sortable : true
										},
										{
											field : "authorize",
											title : "审核状态",
											width : 100,
											formatter : function(value,
													rowData, rowIndex) {
												var temp = rowData["procedureDescribe"];
												if (temp == "G002-2") {
													return "通过";
												} else {
													return "未通过";
												}
											}
										},
										{
											field : "op1",
											title : "查看",
											width : 100,
											formatter : function(value,
													rowData, rowIndex) {
												var menuId = rowData["designId"];
												var productId = rowData["productId"];
												return "<a href='#' onclick=getMenu('"
														+ menuId
														+ "','"
														+ productId
														+ "')>查看</a>";
											}
										} ] ],
								toolbar : "#searchUserRoleForm",
								pagination : true,
								pageSize : 2,
								pageList : [ 2, 5, 10, 15, 20 ],
								sortName : "id",
								sortOrder : "asc",
							});

			$.parser.parse($('#divBody').parent());
			//查看指定菜单
		});
		function getMenu(menuId, productId) {
			var href = "CheckDesign_view_Checker.do?designId=" + menuId
					+ "&productId=" + productId;
			$('#divtabs')
					.tabs(
							'add',
							{
								title : '工序物料查询',
								content : '<iframe frameborder="0" scrolling="true" src="'
										+ href
										+ '" style="width:100%;height:100%;position:relative;"></iframe>',
								closable : true,
								tools : [ {
									iconCls : 'icon-mini-refresh',
									handler : function() {
										alert('refresh');
									}
								} ]
							});
		}
	</script>
</body>
</html>
