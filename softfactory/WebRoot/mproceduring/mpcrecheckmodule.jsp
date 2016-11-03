<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<style type="text/css">
body {
	font-size: 12px;
	font-family: tahoma;
}

div {
	height: 25px;
	line-height: 25px;
	border: 1px solid #FF0099;
	background-color: #FFCCFF;
}

input {
	border-style: solid;
	border-width: 0;
}
</style>
<title>物料复核</title>

</head>

<body>
	<form id="changeMPMing" action="">
		<div align="center">
			<input type="hidden" id="manid" name="parentId"
				value="${requestScope.mpDTO.manid}" /> <input type="hidden"
				id="mprid" name="id" value="${requestScope.mpDTO.mprid }" /> <input
				type="hidden" id="MPMingjsonObj" name="MPMingjsonObj" />
			<table>
				<tr>
					<td>派工单编号</td>
					<td><input type="text" name=""
						value="${requestScope.mpDTO.manufactureId }" /></td>
				</tr>
				<tr>
					<td>工序编号</td>
					<td><input type="text" name="procedureId"
						value="${requestScope.mpDTO.procedureId }" /></td>
				</tr>
				<tr>
					<td>工序名称</td>
					<td><input type="text"
						value="${requestScope.mpDTO.procedureName }" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>负责人</td>
					<td><input type="text" value="${requestScope.mpDTO.register }"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>设计工时数</td>
					<td><input type="text"
						value="${requestScope.mpDTO.labourHourAmount }"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>本次工时数</td>
					<td><input type="text" name="realLabourHourAmount"
						value="${requestScope.mpDTO.realLabourHourAmount }" /></td>
				</tr>
				<tr>
					<td>本次工时数</td>
					<td><input type="text" name="realAmount" value="" /></td>
				</tr>
				<tr>
					<td>复核人</td>
					<td><input type="text" name="checker"
						value="${sessionScope.NEWER_USER_LOGIN_INFO.username}"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>复核时间</td>
					<td><input name="checkTime"
						<%String datetime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间%>
						value="<%out.print(new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));%>"
						class="input" readonly="readonly" /></td>
				</tr>
			</table>
		</div>
		<table id="reckerModuleTable">
		</table>
		<hr>
		<div align="center">
			<a id="savebtn1" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-save'">提交</a>
		</div>

	</form>
	<script type="text/javascript">
		$(function() {
			var id = $("#mprid").val();
			alert(id);
			//加载物料记录
			$("#reckerModuleTable").datagrid({
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
							return '<input id="\'' + id + '\'" name="procedureModuling" type="text" style="border:0;width:200px;height=50px;" />'
						}
					},
				] ]
			});
	
			$('#savebtn1').bind('click', function() {
				$("#changeMPMing").submit();
			});
	
			$("#changeMPMing").form({
				url : "<%=request.getContextPath()%>/MProceduring/changeProceduring.do",
				onSubmit : function() {
					//表单提交前触发
					var procedureModules = $("input[name='procedureModuling']");
					var flag = true;
					var jsonStr = "[";
					for (var i = 0; i < procedureModules.length; i++) {
						if (null == procedureModules[i].value || "" == procedureModules[i].value) {
							$.messager.alert("警告", "请填写序号为" + procedureModules[i].id + "的本次数量值", "warning");
							flag = false;
							return false;
						}{
						if (i == (procedureModules.length - 1)) {
							jsonStr += "{\"id\":" + procedureModules[i].id + ",\"val\":\"" + procedureModules[i].value + "\"}"
						}
						else {
							jsonStr += "{\"id\":" + procedureModules[i].id + ",\"val\":\"" + procedureModules[i].value + "\"},"
						}
						}
					}
					if (flag) {
						jsonStr += "]";
						$("#MPMingjsonObj").val(jsonStr);
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
						$("#passedModuleWindows").window("close", true);
					}
				}
			});
		});
	</script>
</body>
</html>
