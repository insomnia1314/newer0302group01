function eviewed(data) {
	$("#divtabs").tabs("add", {
		title : '登记页面',
		closable : true,
		href : "MProceduring/showManufacture.do?id="+data
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

function mpcrecheck(data){
	$("#divtabs").tabs("add", {
		title : '复核',
		closable : true,
		href : "MProceduring/jumpChangeRechekerFinishTag.do?id="+data,
	});
}

function recheck(data){
	$("#passedModuleWindows").window({
		title : "生产记录",
		width : 900,
		height : 700,
		modal : true,
		minimizable : false,
		href : "MProceduring/loadChangeFinishTag.do?id="+data,
//		onClose : function() {
//			user_obj.search();
//		}
	});
}
function changeTransferTag() {
	$("#Myprocedure").alert("this changeTransferTag");
}
function instockCheck(data){
	$('#instockNumWindows').window({
	    title: '入库数量登记',    
	    width: 400,    
	    height: 200,
	});  
}