<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>菜单管理</title>
<%@ include file="../commons/meta.jsp"%>
</head>

<body>
	<div style="margin: 10px 30px;">
		<!-- 新增 -->
		<div id="editMenu1"></div>
	</div>

	<!-- 显示 -->
	<div style="margin-top: 20px;">
		<table id="menuDataGrid1">

		</table>

	</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#menuDataGrid1").datagrid(
					{
						url : "designCheckList.do",
						title : "制定工序物料设计单",
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
									field : "designer",
									title : "设计人",
									width : 100,
									sortable : true
								},
								{
									field : "registerTime",
									title : "设计时间",
									width : 100,
									sortable : true
								},
								{
									field : "costPriceSum",
									title : "工时总计",
									width : 100,
									sortable : true
								},
								{
									field : "op1",
									title : "操作",
									width : 100,
									formatter : function(value, rowData,
											rowIndex) {
										var menuId = rowData["designId"];
										var productId = rowData["productId"];
										return "<a href='#' onclick=getMenu('"
												+ menuId + "','" + productId
												+ "')>审核</a>";
									}
								}, ] ],
						toolbar : "#searchMenuForm",
						pagination : true,
						pageSize : 2,
						pageList : [ 2, 5, 10, 15, 20 ],
						sortName : "id",
						sortOrder : "asc",
					});
		});

		//查看指定菜单
		function getMenu(menuId, productId) {
			var href = "CheckDesign_view.do?designId=" + menuId + "&productId="
					+ productId;
			$('#divtabs')
					.tabs(
							'add',
							{
								title : '工序物料审核',
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
