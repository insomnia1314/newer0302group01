<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../commons/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'mpcrechek.jsp' starting page</title>
<%@ include file="../commons/meta.jsp"%>

</head>

<body>
	<form action="">
		<div>

			<table>
				<tr height="10px">
					<td width="100px"></td>
					<td>派工单编号<input type="hidden" id="passedMprid"
						value="${mpDTO.mprid}" /></td>

					<td><input type="text" value="${mpDTO.manufactureId}" /></td>
					<td width="400px"></td>
					<td>出库单编号</td>
					<td><input type="text" value="略" /></td>
				</tr>
				<tr>
					<td width="10px"></td>
					<td>产品编号</td>
					<td><input type="text" value="${mpDTO.manufactureId}" /></td>
					<td width="400px"></td>
					<td>产品名称</td>
					<td><input type="text" value="${mpDTO.productName }" /></td>

				</tr>
				<tr height="10px">
					<td width="100px"></td>
					<td>描述</td>
					<td><input type="text" value="${mpDTO.productDescribe }" /></td>
					<td width="400px"></td>
					<td>数量</td>
					<td><input type="text" value="${mpDTO.testedAmount }" /></td>

				</tr>
				<tr height="10px">
					<td width="100px"></td>
					<td>设计工时成本</td>
					<td><input type="text" value="${mpDTO.subtotal }" /></td>
					<td width="400px"></td>
					<td>设计物料成本</td>
					<td><input type="text" value="${mpDTO.moduleSubtotal}" /></td>

				</tr>
				<tr height="10px">
					<td width="100px"></td>
					<td>实际工时成本</td>
					<td><input type="text" value="${mpDTO.realSubtotal }" /></td>
					<td width="400px"></td>
					<td>实际物料成本</td>
					<td><input type="text" value="${mpDTO.realModuleSubtotal }" /></td>
				</tr>
				<tr height="10px">
					<td width="100px"></td>
					<td>登记人</td>
					<td><input type="text" value="${mpDTO.register}" /></td>
					<td width="400px"></td>
					<td>登记时间</td>
					<fmt:formatDate value="${mpDTO.registerTime}" pattern="yyyy-MM-dd"
						var="rgsTime" />
					<td><input type="text" value="${rgsTime}" /></td>
				</tr>
				<tr height="10px">
					<td width="100px"></td>
					<td>复核人</td>
					<td><input type="text" value="${mpDTO.checker}" /></td>
					<td width="400px"></td>
					<td>复核时间</td>
					<fmt:formatDate value="${mpDTO.checkTime}" pattern="yyyy-MM-dd"
						var="checkerTime" />
					<td><input type="text" value="${checkerTime}" /></td>
				</tr>
			</table>
			<table id="rechekerTable">
			</table>
			<div id="passedModuleWindows"></div>
		</div>
	</form>
	<script type="text/javascript">
		$(function() {
			var mprid = $("#passedMprid").val();
			$("#rechekerTable").datagrid({
				url : "<%=request.getContextPath()%>/MProceduring/listMProceduring.do?id=" + mprid, //数据请求地址
				title : "生产过程登记", //标题
				fitColumns : true, //真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
				striped : true, //是否显示斑马线效果。
				rownumbers : true, //如果为true，则显示一个行号列。
				columns : [ [
					{
						field : 'procedureName',
						title : '工序名称',
						width : 40,
						align : 'center'
					},
					{
						field : 'labourHourAmount',
						title : '设计工时数',
						width : 30,
						align : 'center'
					},
					{
						field : 'realAmount',
						title : '实际工时数',
						width : 30,
						align : 'center'
					},
					{
						field : 'subtotal',
						title : '设计工时成本',
						width : 30,
						align : 'center'
					},
					{
						field : 'realSubtotal',
						title : '实际工时成本',
						width : 30,
						align : 'center'
					},
					{
						field : 'moduleSubtotal',
						title : '设计物料成本',
						width : 30,
						align : 'center'
					},
					{
						field : 'realModuleSubtotal',
						title : '实际物料成本',
						width : 30,
						align : 'center'
					},
					{
						field : 'itemid',
						title : '登记',
						width : 30,
						align : 'center',
						formatter : function(value, rowData, rowIndex) {
							//工序完成标志
							//G004-0: 未开始
							//G004-1: 已完成
							//G004-2: 未完成
							//G004-3: 已审核
							var finishTag = rowData["procedureFinishTag"];
							/* 工序交接标志
							 						G005-0: 未交接
							G005-1: 已交接
							G005-2: 已审核 */
							var transferTag = rowData["procedureTransferTag"]
							var id = rowData["id"];
							if ("G004-2" == finishTag) {
								return '<a href="#" class="reviewed" onclick="recheck(\'' + id + '\')" >点击复核</a>';
							}
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
						text : '点击复核',
						plain : true,
						iconCls : 'icon-edit',
					});
				}
			});
		});
	</script>
</body>
</html>
