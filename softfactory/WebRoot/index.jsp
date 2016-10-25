﻿<%--
	author:SONG
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglib.jsp"%>

<!DOCTYPE html>

<html>
	<head>
		<TITLE>工厂实训框架 by SONG</TITLE>
		<%@ include file="commons/meta.jsp"%>
		<script src="js/Clock.js"></script>
		<script src="js/index.js"></script>
		<style>
#logorighttop {
	PADDING-RIGHT: 50px;
	BACKGROUND-POSITION: right 50%;
	DISPLAY: block;
	PADDING-LEFT: 0px;
	BACKGROUND-IMAGE: url(images/bg_banner_menu.gif);
	PADDING-BOTTOM: 0px;
	PADDING-TOP: 3px;
	BACKGROUND-REPEAT: no-repeat;
	HEIGHT: 30px;
	TEXT-ALIGN: right;
	position: absolute;
	top: 0px;
	right: 0px;
	width: 345px;
}

#logorighttop A {
	color: white;
	text-decoration: none;
}

#logomenu {
	BACKGROUND-IMAGE: url(images/bg_nav.gif);
	BACKGROUND-REPEAT: repeat-x;
	HEIGHT: 30px;
	color: white;
}

#logomenu A {
	color: white;
}
</style>
		<script type="text/javascript">
	//询问是否退出系统
	function exitSystem() {
		var flag = confirm("真的要退出系统吗？");
		if (flag)
			window.location = "userController_logout.do";
	}

	function showDivChangePassword(){
		$("#passDiv").window({
			title : "修改密码",
			width : 550,
			height : 250,
			modal : true,
			minimizable : false,
			href : "changePassUI.jsp"
		});
	}
</script>
	</head>
	
	<c:if test="${empty sessionScope['NEWER_USER_LOGIN_INFO']}">
	  <c:redirect url="login.jsp"/>
	</c:if>
	
	
	<body class="easyui-layout">
		<div data-options="region:'north',split:true"
			style="height: 133px; BACKGROUND-IMAGE: url(images/bg.gif);">
			<img src="images/logo.png" border="0" />
			<DIV id="logorighttop">
				<IMG src="images/menu_seprator.gif" align=absMiddle>
				<A id=HyperLink2 href="javascript:showDivChangePassword()">修改密码</A>
				<IMG src="images/menu_seprator.gif" align=absMiddle>
				<A id=HyperLink3 href="javascript:exitSystem()">退出系统</A>
			</DIV>
			<!-- 显示修改密码div -->
			<div id="passDiv"></div>
			<DIV id="logomenu">
				<TABLE cellSpacing="0" cellPadding="0" width="100%">
					<TBODY>
						<TR>
							<TD>
								<DIV>
									<IMG src="images/nav_pre.gif" align=absMiddle>
									欢迎
									<SPAN id=lblBra>牛耳软件工厂</SPAN>
									[${sessionScope["NEWER_USER_LOGIN_INFO"].username} ] 光临
								</DIV>
							</TD>
							<TD align=right width="70%">
								<SPAN style="PADDING-RIGHT: 50px"><%--<A href="" target=_top>
										
										<IMG src="images/nav_changePassword.gif" align=absMiddle
											border=0>重新登录 </A> 
										 --%>
										<IMG src="images/menu_seprator.gif" align=absMiddle><SPAN
									id="clock"></SPAN>
								</SPAN>

							</TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
			<SCRIPT type=text/javascript>
	var clock = new Clock();
	clock.display(document.getElementById("clock"));
</SCRIPT>
		</div>
		<!-- 左边导航菜单 -->
		<div data-options="region:'west',title:'导航菜单',split:true"
			style="width: 240px;">
			<ul id="tree" class="easyui-tree">

			</ul>
		</div>
		<!-- 右边内容部分 -->
		<div data-options="region:'center'"
			style="padding: 5px; background: #eee;">
			<div id="divtabs" class="easyui-tabs"
				data-options="fit:true,border:false">

			</div>

		</div>
	</body>
</html>
