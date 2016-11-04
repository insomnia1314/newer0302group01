<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<base href="<%=basePath%>">
<title>生产登记单</title>

<%@ include file="../commons/meta.jsp"%>
<style>
.input {
	width: 300px;
	height: 30px;
	border: 1px solid #95B8E7;
}
</style>
</head>
<body>
	<div align="center">
		<h2 align="center">生产登记单</h2>
		<form action="" id="createMPMLing" method="post">
			<table width="300" height="150" id="userTable"
				style="margin: 10px auto;">
				<tr>
					<td>工序序号</td>
					<td><input id="detailsNumber"
						name="detailsNumber" value="${requestScope.mprocedure.detailsNumber}"
						class="input" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>工序编号</td>
					<td><input type="hidden" name="MPMjsonObj" id="MPMjsonObj" /> <input
						id="myMProcedureModuleID" type="hidden" name="mpprentId"
						value="${requestScope.mprocedure.id}" /> 
						<input type="hidden" name="parentId" value="${requestScope.mprocedure.parentId }" />
						<input id="procedureId"
						name="procedureId" value="${requestScope.mprocedure.procedureId }"
						class="input" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>工序名称</td>
					<td><input id="procedureName" name="procedureName"
						value="${requestScope.mprocedure.procedureName }" class="input"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>设计工时数</td>
					<td><input id="" name=""
						value="${requestScope.mprocedure.labourHourAmount }" class="input"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>本次工时数</td>
					<td><input id="labourHourAmount" name="labourHourAmount"
						value="${requestScope.mprocedure.realLabourHourAmount }"
						class="input" /></td>
				</tr>
				<tr>
					<td>登记人</td>
					<td><input id="register" name="register"
						value="${sessionScope.NEWER_USER_LOGIN_INFO.username}"
						class="input" readonly="readonly" /></td>
				</tr>

				<tr>
					<td>登记时间</td>
					<td><input id="registerTime" name="registerTime"
						<%String datetime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间%>
						value="<%out.print(new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));%>"
						class="input" readonly="readonly" /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>
			<hr />
			<table id="showMProcedureModule">

			</table>
			<hr />
			<a id="savebtn" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-save'">提交</a>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
	
			var id = $("#myMProcedureModuleID").val();
	
			//加载物料记录
			$("#showMProcedureModule").datagrid({
				title : "物料记录",
				url : "<%=request.getContextPath()%>/MProceduring/listProceduringModule.do?id=" + id,
				fitColumns : true, //真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
				striped : true, //是否显示斑马线效果。
				rownumbers : true, //如果为true，则显示一个行号列。
				columns : [ [
					{
						field : 'id',
						title : '序号',
						width : 30,
						align : 'center'
					},
					{
						field : 'productName',
						title : '物料名称',
						width : 100,
						align : 'center'
					},
					{
						field : 'productId',
						title : '物料编号',
						width : 100,
						align : 'center'
					},
					{
						field : 'amount',
						title : '设计数量',
						width : 100,
						align : 'center'
					},
					{
						field : 'renewAmount',
						title : '补充数量',
						width : 100,
						align : 'center'
					},
					{
						field : 'realAmount',
						title : '已经使用数量',
						width : 100,
						align : 'center'
					},
					{
						field : 'itemid',
						title : '本次数量',
						width : 100,
						align : 'center',
						formatter : function(value, rowData, rowIndex) {
							var id = rowData["id"];
							return '<input id="\'' + id + '\'" name="procedureModule" type="text" style="border:0;width:200px;height=50px;" />'
						}
					},
				]]
			});
			$('#savebtn').bind('click', function() {
				$("#createMPMLing").submit();
			});
	
			$("#createMPMLing").form({
				url : "<%=request.getContextPath()%>/MProceduring/registerProceduring.do",
				onSubmit : function() { //表单提交前触发
					//负责人
					var procedureResponsiblePerson = $("#procedureResponsiblePerson").val();
					var procedureModules = $("input[name='procedureModule']");
					var flag = true;
					var jsonStr = "[";
					for (var i = 0; i < procedureModules.length; i++) {
						if (null == procedureModules[i].value || "" == procedureModules[i].value) {
							$.messager.alert("警告", "请填写序号为" + procedureModules[i].id + "的本次数量值", "warning");
							flag = false;
							return false;
						}{
							if (i == (procedureModules.length - 1)) {
								jsonStr += "{\"id\":" + procedureModules[i].id +  ",\"val\":\"" + procedureModules[i].value + "\"}"
							}
							else {
								jsonStr += "{\"id\":" + procedureModules[i].id +  ",\"val\":\"" + procedureModules[i].value + "\"},"
							}
						}
					}
					if (null == procedureResponsiblePerson || "" == procedureResponsiblePerson) {
						$.messager.alert("警告", "请填写负责人", "warning");
						return false;
					}
					if (flag) {
						jsonStr += "]";
						$("#MPMjsonObj").val(jsonStr);
					}
				},
				success : function(data) {
					if (data) {
						$.messager.show({
							title : "提示",
							width : 450,
							height : 300,
							msg : data
						});
						//$("#empDataGrid").datagrid('load', {});
						$("#Myprocedure").window("close", true);
					}
				}
			});
		});
	</script>
</body>
</html>
