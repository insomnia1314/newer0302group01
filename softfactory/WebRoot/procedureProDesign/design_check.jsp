<%--
	autdor:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>菜单管理</title>
<%@ include file="../commons/meta.jsp"%>
<style>
.resizeDivClass {
	position: relative;
	background-color: #DEDBD6;
	width: 2;
	z-index: 1;
	left: expression(tdis.parentElement.offsetwidth-1);
	cursor: e-resize;
}
</style>

<script language="javascript">
	function MouseDownToResize(obj) {
		obj.mouseDownX = event.clientX;
		obj.pareneTdW = obj.parentElement.offsetwidth;
		obj.pareneTableW = tdeObjTable.offsetwidth;
		obj.setCapture();
	}
	function MouseMoveToResize(obj) {
		if (!obj.mouseDownX)
			return false;
		var newwidth = obj.pareneTdW * 1 + event.clientX * 1 - obj.mouseDownX;
		if (newwidth > 0) {
			obj.parentElement.style.width = newwidth;
			tdeObjTable.style.width = obj.pareneTableW * 1 + event.clientX * 1
					- obj.mouseDownX;
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
<body bgcolor="#ebf3fb" oncontextmenu="event.returnValue=true"
	style="filter:progid:DXImageTransform.microsoft.gradient(gradienttype=0,startColorStr=#83c6e0,endColorStr=#ffffff">
	<div class="DIV_STYLE2">
		<table width=1000 border=0 bgcolor="#FFFFFF">
			<tbody>
				<tr>
					<td valign=bottom align=center class="TABLE_STYLE6" rowspan=2>
						<table cellspacing=0 cellpadding=0 width=700 border=0
							style="BORDER-RIGHT: #333333 1px solid; BORDER-TOP: #333333 1px solid; BORDER-LEFT: #333333 1px solid; BORDER-BOTTOM: #333333 1px solid;">
							<tbody>
								<tr>
									<td colspan="4" height="10"><table width="100%">
											<tr>
												<td>
													<table align=center class="TABLE_STYLE4">
														<tr height=20 class="TR_STYLE1">
															<td align=center height=5 class="TD_STYLE5"></td>
															<a href="updateStateCheck.do?designId=${pro.designId}"
																class="easyui-linkbutton" iconCls="icon-edit"
																plain="true" style="">通过</a>
															<form action="unClick.do" method="post">
																<input type="submit" value="不通过">
														</tr>
													</table>
													<table align=center class="TABLE_STYLE4">
														<tr height=20 class="TR_STYLE1">
															<td align=center height=5 class="TD_STYLE5"><font
																size="4"><b>工序物料设计单</b></font></td>
														</tr>
													</table>
													<table align=center class="TABLE_STYLE4">
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="10%">设计单编号：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="40%">${pro.designId}</td>
															<input type="hidden" name="designId"
																value="${pro.designId }">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="10%">产品名称：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="40%">${pro.productName}</td>
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="10%">产品编号：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="40%">${pro.productId}</td>
															<input type="hidden" name="productId"
																value="${pro.productId}">
														</tr>
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="20%">设计人：${pro.designer}</td>
														</tr>
													</table>
													<table align=center class="TABLE_STYLE4">
														<tr height=20 class="TR_STYLE1">
															<td align=center height=5 class="TD_STYLE5"></td>
														</tr>
													</table>
													<table bordercolor=#000000 bordercolorlight=#848284
														bordercolordark=#eeeeee border=1 cellspacing=0
														cellpadding=0 align=center class="TABLE_STYLE5"
														id=tdeObjTable>
														<tr height=20 bgcolor=#D2E9FF class="TR_STYLE2">
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="10%">序号</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="13%">工序名称</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="11%">工序编号</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="13%">描述</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="11%">工时数(小时)</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="13%">工时成本小计(元)</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="13%">物料成本小计</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="8%">操作</td>
															<c:forEach items="${list}" var="str" varStatus="rows">
														</tr>
														<tr height=20 class="TR_STYLE1">
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${rows.index + 1 }</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.procedureName }</td>
															<input type="hidden" name="detailsNumber"
																value="${str.detailsNumber }">
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.detailsNumber }</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.productName1 }</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.labourHourAmount }</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.subtotal }</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">${str.moduleSubtotal }</td>
															<input type="hidden" name="prcedureId"
																value="${str.prcedureId}">
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2">
																<a
																href="findByID1.do?productId=${pro.productId }&&procedureName=${str.procedureName }">
																	查看 </a>
															</td>
														</tr>
														</c:forEach>
														</form>
													</table>
													<table align=center class="TABLE_STYLE4">
														<tr height=20 class="TR_STYLE1">
															<td align=center height=5 class="TD_STYLE5"></td>
														</tr>
													</table>
													<TABLE align=center class="TABLE_STYLE4">
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="20%">工时总成本：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="40%">${pro.costPriceSum}</td>
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="20%">物料总成本：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="40%">${pro.moduleCostPriceSum}</td>
														</tr>
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="20%">设计要求：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="89%" colspan="3">${pro.procedureDescribe}</td>
														</tr>
														<tr height=20 class="TR_STYLE1">
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="20%">审核人：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="40%">${pro.checker }</td>
															<td bordercolorlight=#848284 bordercolordark=#eeeeee
																align=right class="TD_STYLE8" width="20%">审核时间：</td>
															<td bordercolor=#DEDBD6 align=left class="TD_STYLE2"
																width="40%"><fmt:formatDate
																	value="${pro.checkTime }"
																	pattern="yyyy年MM月dd日HH点mm分ss秒" /></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
						</table>
						</div>
</body>
</html>