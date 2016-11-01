function eviewed(data) {
	$("#divtabs").tabs("add", {
		title : '审核页面',
		closable : true,
		href : "MProceduring/showManufacture.do?id=1"
	});
}

function changeFinishTag(data) {
	$("#Myprocedure").window({
		title : "生产记录",
		width : 900,
		height : 700,
		modal : true,
		minimizable : false,
		href : "MProceduring/jumpChangeFinishTag.do?id="+data,
//		onClose : function() {
//			user_obj.search();
//		}
	});
}

function changeTransferTag() {
	$("#Myprocedure").alert("this changeTransferTag");
}