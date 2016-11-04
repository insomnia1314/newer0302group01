<%--
	author ：long
 --%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../commons/taglib.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<style>
.resizeDivClass {
	position: relative;
	background-color: #DEDBD6;
	width: 2;
	z-index: 1;
	left: expression(this.parentElement.offsetWidth-1);
	cursor: e-resize;
}
</style>

<script language="javascript">

	function MouseDownToResize(obj) {
		obj.mouseDownX = event.clientX;
		obj.pareneTdW = obj.parentElement.offsetWidth;
		obj.pareneTableW = theObjTable.offsetWidth;
		obj.setCapture();
	}
	function MouseMoveToResize(obj) {
		if (!obj.mouseDownX) return false;
		var newWidth = obj.pareneTdW * 1 + event.clientX * 1 - obj.mouseDownX;
		if (newWidth > 0) {
			obj.parentElement.style.width = newWidth;
			theObjTable.style.width = obj.pareneTableW * 1 + event.clientX * 1 - obj.mouseDownX;
		}
	}
	function MouseUpToResize(obj) {
		obj.releaseCapture();
		obj.mouseDownX = 0;
	}
</script>


<STYLE>
A:visited {
	TEXT-DECORATION: none
}

A:active {
	TEXT-DECORATION: none
}

A:hover {
	TEXT-DECORATION: underline overline
}

A:link {
	TEXT-DECORATION: none
}

.t {
	LINE-HEIGHT: 1.4
}

BODY {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt;
	scrollbar-face-color: #F1F1F1;
	SCROLLBAR-HIGHLIGHT-COLOR: #F1F1F1;
	SCROLLBAR-SHADOW-COLOR: buttonface;
	SCROLLBAR-3DLIGHT-COLOR: buttonhighlight;
	SCROLLBAR-TRACK-COLOR: #868686 SCROLLBAR-DARKSHADOW-COLOR: buttonshadow;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

TD {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}

DIV {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}

FORM {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}

OPTION {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}

P {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}

TD {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}

BR {
	FONT-FAMILY: å®ä½;
	FONT-SIZE: 9pt
}
</STYLE>

<STYLE>
.gray {
	CURSOR: hand;
	FILTER: gray
}

.style3 {
	font-size: 16px;
	font-weight: bold;
}

.TABLE_STYLE11 {
	border: 1px solid;
	border-collapse: collapse;
	width: 95%;
}

.TABLE_STYLE1 {
	border: 1px solid;
	border-collapse: collapse;
	width: 95%;
}

.TABLE_STYLE2 {
	width: 95%;
}

.TABLE_STYLE3 {
	width: 100%;
}

.TABLE_STYLE4 {
	width: 95%;
}

.TABLE_STYLE5 {
	border: 1px solid;
	border-collapse: collapse;
	width: 95%;
}

.TABLE_STYLE6 {
	width: 820;
}

.TABLE_STYLE7 {
	border: 1px solid;
	border-collapse: collapse;
	width: 100%;
}

.ALL-STYLE {
	border: 1px ridge #666666;
	border-color: #DEDBD6;
}

.TR_STYLE1 {
	
}

.TR_STYLE2 {
	
}

.style8 {
	color: #000066
}

.TD_HANDBOOK_STYLE1 {
	vertical-align: top;
	width: 100%;
	color: #0000FF;
}

.TD_STYLE1 {
	background-image: url(/erp/images/line7.gif);
}

.TD_STYLE2 {
	border-spacing: 1px;
}

.TD_STYLE3 {
	
}

.TD_STYLE4 {
	
}

.TD_STYLE5 {
	
}

.TD_STYLE6 {
	
}

.TD_STYLE7 {
	background-image: url(/erp/images/line4.gif);
}

.TD_STYLE8 {
	
}

.SUBMIT_STYLE1 {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}

.BUTTON_STYLE1 {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}

.RESET_STYLE1 {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}

.RADIO_STYLE1 {
	
}

.CHECKBOX_STYLE1 {
	
}

.SELECT_STYLE1 {
	width: 100%;
}

.SELECT_STYLE2 {
	width: 100%;
}

.TEXTAREA_STYLE1 {
	width: 100%;
}

.DIV_STYLE1 {
	float: right;
	vertical-align: top;
}

.DIV_STYLE2 {
	float: center;
	vertical-align: top;
}

.INPUT_STYLE1 {
	width: 100%
}

.INPUT_STYLE3 {
	BORDER-BOTTOM: 1px solid #000000;
	BORDER-left: 0px;
	BORDER-right: 0px;
	BORDER-top: 0px;
	width: 100%
}

.INPUT_STYLE4 {
	BORDER-BOTTOM: 0px;
	BORDER-left: 0px;
	BORDER-right: 0px;
	BORDER-top: 0px;
	width: 100%
}

.INPUT_STYLE5 {
	background-color: #FFFFCC;
	BORDER-BOTTOM: 0px;
	BORDER-left: 0px;
	BORDER-right: 0px;
	BORDER-top: 0px;
	width: 100%
}

.INPUT_STYLE6 {
	background-color: #FFFAAA;
	BORDER-BOTTOM: 0px;
	BORDER-left: 0px;
	BORDER-right: 0px;
	BORDER-top: 0px;
	width: 100%
}

.FILE_STYLE1 {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}

.btn3_mouseout {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}

.btn3_mouseover {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#D7E7FA);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}

.btn3_mousedown {
	BORDER-RIGHT: #FFE400 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #FFE400 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #FFE400 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #FFE400 1px solid
}

.btn3_mouseup {
	BORDER-RIGHT: #2C59AA 1px solid;
	PADDING-RIGHT: 2px;
	BORDER-TOP: #2C59AA 1px solid;
	PADDING-LEFT: 2px;
	FONT-SIZE: 12px;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,
		StartColorStr=#ffffff, EndColorStr=#C3DAF5);
	BORDER-LEFT: #2C59AA 1px solid;
	CURSOR: hand;
	COLOR: black;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #2C59AA 1px solid
}
</STYLE>
</head>

<body bgcolor="#ebf3fb">
	<table class="TABLE_STYLE3">
		<tr height=20 class="TR_STYLE1">
			<td class="TD_HANDBOOK_STYLE1">您正在做的业务是：生产管理--内部生产管理--生产登记</td>
		</tr>
	</table>
	<table align=center class="TABLE_STYLE6">
		<tr height=20 class="TR_STYLE1">
			<td bordercolorlight=#848284 bordercolordark=#eeeeee align=right
				class="TD_STYLE8"><input type="button" value="返回" /></td>
		</tr>
	</table>

	<div class="DIV_STYLE2">
		<table cellspacing=0 cellpadding=0 width=350 align=center border=0
			bgcolor="#FFFFFF">
			<tbody>
				<tr>
					<td valign=bottom align=center class="TABLE_STYLE6" rowspan=2>
						<table cellspacing=0 cellpadding=0 width="1000" border=0
							style="BORDER-RIGHT: #333333 1px solid; BORDER-TOP: #333333 1px solid; BORDER-LEFT: #333333 1px solid; BORDER-BOTTOM: #333333 1px solid;">
							<tbody>
								<tr>
									<td colspan="4" height="10"><table width="100%">
											<tr>
												<td>
													<table align=center class="TABLE_STYLE4">
														<tr height=20 class="TR_STYLE1">
															<td align=center height=5 class="TD_STYLE5">&nbsp;</td>
														</tr>
													</table>
													<table align=center class="TABLE_STYLE4">
														<tr height=20 class="TR_STYLE1">
															<td align=center height=5 class="TD_STYLE5"><font
																size="4"><b>生产派工单</b></font></td>
														</tr>
													</table>
													<table align=center class="TABLE_STYLE4">
														<tr height=20 class="TR_STYLE1">
															<td align=center height=5 class="TD_STYLE5">&nbsp;</td>
														</tr>
													</table>
													<table align=center class="TABLE_STYLE4" id=theObjTable>
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">派工单编号：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%"><input type="hidden" id="mfgid"
																value="${manufacture.id}" />
																${manufacture.manufactureId}</td>
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">出库单编号：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%">略</td>
														</tr>
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">产品编号：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%">${manufacture.productId}</td>
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">产品名称：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%">${manufacture.productName}</td>
														</tr>
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">描述&nbsp;&nbsp;&nbsp;&nbsp;：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%">${manufacture.productDescribe}</td>
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">数量&nbsp;&nbsp;&nbsp;&nbsp;：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%">${manufacture.amount}</td>
														</tr>
													</table> <%-- 这里是esayui加载对应数据 --%>
													<table align=center class="TABLE_STYLE4">
														<tr height=20 class="TR_STYLE1">
															<td align=center height=5 class="TD_STYLE5"></td>
														</tr>
													</table>
													<table id="registerMProceduring" bordercolor=#000000
														bordercolorlight=#848284 bordercolordark=#eeeeee border=1
														cellspacing=0 cellpadding=0 align=center
														class="TABLE_STYLE5">

													</table>
													<table id="register" align=center class="TABLE_STYLE4">
														<tr height=20 class="TR_STYLE1">
															<td align=center height=5 class="TD_STYLE5">&nbsp;</td>
														</tr>
													</table>
													<table align=center class="TABLE_STYLE4">
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">设计工时总成本：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%">${manufacture.labourCostPriceSum}</td>
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">设计物料总成本：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%">${manufacture.moduleCostPriceSum}</td>
														</tr>
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">实际工时总成本：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%">${manufacture.realLabourCostPriceSum}</td>
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">实际物料总成本：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%">${manufacture.realModuleCostPriceSum}</td>
														</tr>
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">登记人&nbsp;&nbsp;：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%">${manufacture.register}</td>
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">登记时间：</td>

															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%"><fmt:formatDate
																	value="${manufacture.registerTime}"
																	pattern="yyyy-MM-dd HH:mm:ss" /></td>
														</tr>
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">复核人&nbsp;&nbsp;：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%">${manufacture.checker}</td>
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">复核时间：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="37%"><fmt:formatDate
																	value="${manufacture.checkTime}"
																	pattern="yyyy-MM-dd HH:mm:ss" /></td>
														</tr>
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="13%">备注&nbsp;&nbsp;&nbsp;&nbsp;：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																colspan="3" width="87%">${manufacture.manufactureProcedureTag}</textarea>

															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table></td>
								</tr>
								<tr>
									<td colspan="3" nowrap width="56"></td>
									</td>
								</tr>
								<tr>
									<td colspan="3" nowrap height="100"></td>
									<td></td>
								</tr>

								<tr valign="bottom">
									<td colspan="4" nowrap align="center"></td>
								</tr>
								</td>
								<tr>
									<td colspan="4" nowrap align="right"></td>
								</tr>
							</tbody>
						</table>
					</td>
					<td width=1 bgcolor=#ffffff height=2></td>
					<td width=1 bgcolor=#ffffff height=2></td>
					<td width=1 bgcolor=#ffffff height=2></td>
				</tr>
				<tr>
					<td width=1 bgcolor=#333333 height=120></td>
					<td width=1 bgcolor=#666666 height=120></td>
					<td width=1 bgcolor=#999999 height=120></td>
				</tr>
				<tr valign=top align=right>
					<td colspan=4>
						<table cellspacing=0 cellpadding=0 align=center
							class="TABLE_STYLE6" border=0>
							<tbody>
								<tr>
									<td bgcolor=#333333 height=1></td>
								</tr>
								<tr>
									<td bgcolor=#666666 height=1></td>
								</tr>
								<tr>
									<td bgcolor=#999999 height=1></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr valign=center align=right>
					<td colspan=4></td>
				</tr>
			</tbody>
		</table>
		
		<div id="Myprocedure">
			
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			var mfgid = $("#mfgid").val();
			$("#registerMProceduring").datagrid({
				url : "<%=request.getContextPath()%>/MProceduring/listMProceduring.do?id=" + mfgid, //数据请求地址
				title : "生产过程登记", //标题
				fitColumns : true, //真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动。
				striped : true, //是否显示斑马线效果。
				rownumbers : true, //如果为true，则显示一个行号列。
				columns : [[
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
						if("G004-0"==finishTag){
							return '<a href="#" class="" onclick="changeFinishTag(\''+id+'\')" >开始登记</a>';					
						}
						if("G004-2"==finishTag){
							return '请等待审核';
						}
						if("G004-3"==finishTag){
							return '工序完成';
						}
					},
				},
			]],
		});
	});
</script>