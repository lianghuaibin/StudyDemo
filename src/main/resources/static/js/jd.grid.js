/**
 * Created by .
 * User: songxiuliang
 * Date: 15-1-21
 * Time: 下午16:45
 */

(function($){
	var pageNo = 1;	//当前页码
	var pageSize = 10;
	var totalPage = 1;	//总页数
	var rowCount = 0;		//记录总数(为翻页加速)
	var p;		//参数
	var checkedRows = new Object();		//CheckBox选中的行
	var checkedRowsDatas = new Object(); // 选中行数据
	var $container;
	var $pager;
	var loadParams;
	var loadUrl;
	var loadSuccessFunc;
	var loadFailedFunc;
	var currentDatas;
	
	$.fn.ideagrid = function(params){
		p = $.extend({
				height:'100%',
				width:'100%',
				checkbox:false,
				clickToSelect:false,
				dbclick:false,
				autoLoad:true,       //是否自动加载表格内容（如果为true，则需增加url属性才行）
				autoRender:true,
				usepager:true,     //废弃参数
                pagerAjax:true,    //是否异步加载分页
				rowSelectedCallback:function(){},
				rowDbclickCallback:function(params){},
				rowCancelSelectedCallback:function(){},
				checkAllCallback:function(){},
				successCallback:function(){},
				titleAlign:'left',
				checkValue:'',
			    id:"tbl"
		}, params);
				
		return this.each(function(){
			$container = $(this);
			createTable($container, p);
			createPager($container, p);//无论是否异步都加载分页
			/*if(p.pagerAjax) {
				createPager($container, p);
			}*/
		});
	};
	
	//初始化列表
	$.fn.load = function(url, params, successCallback, failedCallBack) {
		$(".selected").removeClass("selected");
		loadUrl = url + "?" + Math.random();
		loadParams = params;
		loadSuccessFunc = successCallback;
		loadFailedFunc = failedCallBack;
		if(params!=undefined){
			params.rowCount = -1;
			clearCheckedRows();
			//clearBatchRows();
			rowCount = 0;
			loadData(1,loadUrl);
		}
	};
	
	$.fn.getCheckRows = function() {
		return checkedRows;
	};
	
	$.fn.getP = function() {
		return p;
	};
	
	$.fn.getCheckedRowsDatas = function() {
		return checkedRowsDatas;
	};
	
	$.fn.getCurrentDatas = function() {
		return currentDatas;
	};
	
	$.fn.setSelectRowStyle = function(rowId) {
		setSelectRowStyle(rowId);
	};
	
	$.fn.clearTr = function() {
		$(this).find('tr').remove();
	};
	
	//创建表格
	function createTable(t, p){
		t.append('<table id="' + p.id + '" width="'+p.width+'" class="table table-striped" cellpadding="0" cellspacing="0"></table>');
		//t.append('<table id="' + p.id + '" width="'+p.width+'" cellpadding="0" cellspacing="0"></table>');
		if(p.autoRender) {
			var table = $('#' + p.id);
			if(p.autoLoad) {
				loadData(pageNo, p.url);
			}else{
				createHeader(table, p);
			}
		}
	}
	//创建表头
	function createHeader(t, p) {
		var headerRenderer = '<thead><tr>';
		if(p.checkbox) {
			headerRenderer = headerRenderer + '<th style="width:45px;text-align:center;"><input id="' + p.id + '_checkall" type="checkbox"/></th>';
		}
		var cols = p.cols;
		for(var i=0; i<cols.length; i++) {
			var col = cols[i];
			var th_field = '';
			if(typeof(col.width) != 'undefined') {
				th_field += ' style="width:' + col.width + 'px;text-align:' + p.titleAlign + '"';
			}else{
				th_field += ' style="text-align:' + p.titleAlign + '"';
			}
			if(typeof(col.orderField) != 'undefined'){
				th_field += ' orderField="' + col.orderField + '"';
			}
			if(typeof(col.orderClass) != 'undefined'){
				th_field += ' class="' + col.orderClass + '"';
			}
			headerRenderer = headerRenderer + '<th' + th_field + '>' + col.display + '</th>';
		}
		headerRenderer += '</tr></thead>';
		t.append(headerRenderer + '<tbody id="' + p.id + 'tbody"></tbody>');
	}
	
	//加载表格内容
	function renderContent(datas, p) {
		var checkAllBox = $('#' + p.id + '_checkall');
		if(checkAllBox.length > 0 && !checkAllBox.data("events")) {//没有绑定事件
			checkAllBox.bind('click', {relid: p.id}, checkAllClickHandler);
		}
		currentDatas = datas;
	
		//clearCheckedRows();
		
		var contentArea = $('#' + p.id +'tbody');
		contentArea.clearTr();
		
		var contentRenderer = '';
		
		var cols = p.cols;
		var bgcolor;
		if(datas.length > 0){
			//行添加
			for(var i=0; i<datas.length; i++) {
			    bgcolor = i % 2 == 0 ? '' : 'evenColor';
				contentRenderer = contentRenderer + '<tr class="' + bgcolor + '" id="' + p.id + '_tr_' + i + '" rel="' + p.id + '_tr">';
				var data = datas[i];
				if(p.checkbox) {
					contentRenderer = contentRenderer + '<td style="text-align:center;"><input id="' + p.id + '_tr_' + data[p.checkValue] + '_' + i  + '_cb" name="dataId" type="checkbox" value="'+data[p.checkValue]+'" rel="' + p.id + '"/></td>';
				}
				var col;
				var alignStyle;
				var title;
				for(var j=0; j<cols.length; j++) {
					col = cols[j];
					alignStyle = col.align;
					if(typeof(alignStyle) == 'undefined') {
						alignStyle = 'left';
					}
					title = '';
					if(col.type == 'subStr'){
						title = ' title="' + data[col.name] + '"';
					}
					contentRenderer = contentRenderer + '<td'+ title + ' style="text-align:' + alignStyle + ';">' + getTdInfo(data,col,i) + '</td>';
				}
				contentRenderer = contentRenderer + '</tr>';
			}
			contentArea.append(contentRenderer);
		}
		
		var checkSingleBox = $('input[rel="' + p.id + '"]');
		if(checkSingleBox.length > 0) {
			checkSingleBox.bind('click', {datarows:datas}, checkSingleHandler);
		}

		bindingTrEvent(p, datas);
	}
	
	//获取当前格的日期
	function getTdInfo(data,col,i){
		//回调函数开始      songxl增加
		var callbackFunction = "";
		if(col.callback){
			var param = col.param;
			if(param){
				var paramStr = "";
				for(var pp = 0; pp < param.length; pp++){
					paramStr += "'"+data[param[pp]]+"',";
				}
				callbackFunction = 'onclick = "' + col.callback + '('+paramStr.substring(0, paramStr.length - 1)+');"';
			}else{
				callbackFunction = 'onclick = "' + col.callback + '();"';
			}
		}
		//回调函数结束
		var tdInfo;
		var type = col.type;
		if(typeof(type) == 'undefined') {
			type = 'data';
		}
		if(type == 'data') {
			var data_val = data[col.name];
			if(typeof(data_val) == 'undefined'){ data_val = ''; }
			tdInfo = data_val;
		} else if(type == 'serial') {//序列号
			tdInfo = (i+1);
		} else if(type == 'mapped') {//映射输出    
			tdInfo = buildMappedParams(col, data);
		} else if(type == 'constant') {//常量输出     
			tdInfo = col.constantValue;
		} else if(type == 'replace') {//替换输出      
			tdInfo = buildReplaceParams(col, data);
		} else if(type == 'subStr') {//截取长度输出    
			tdInfo = subStrParams(col, data);
		} else if(type == 'fix') {//前缀（后缀）   
			tdInfo = fixParams(col, data);
		} else if(type == 'time') {//时间   
			if(data[col.name]){
				tdInfo = new Date(data[col.name]).format(col.format);	
			}else{
				tdInfo = "";
			}
		} else if(type.indexOf("userCustom")>-1){
			var funcBB = eval(type);
			tdInfo = funcBB(data);
		}
		
		if(callbackFunction.length > 1){
			tdInfo = '<a href="#" ' + callbackFunction + ' style="vertical-align:middle;">' + tdInfo + '</a>';
		}
		return tdInfo;	
	}
	
	function bindingTrEvent(p, datas) {
		if(p.clickToSelect) {
			$('tr[rel="' + p.id + '_tr"]').bind('click', {rowdatas:datas}, setSelectRowStyleOnRowClick);
		}
		if(p.dbclick) {
			$('tr[rel="' + p.id + '_tr"]').bind('dblclick', {rowdatas:datas}, setDbclick);
		}
	}
	
	//创建分页
	function createPager(t, p) {
		var pager = "pager";
		if(p.pageID){
			pager = p.pageID;
		}
		t.append('<div id='+pager+' class="fr" ><img src="/img/wait.gif"></div>\n');
		$pager = $('#'+pager);
		//renderPager(p);
	}
	
	//加载分页
	function renderPager(p){
		var prev = pageNo - 3;
		var next = pageNo + 3;
		
		var pagerRenderer = '<div id="page_div" class="pages">';
		if(pageNo == 1){
			pagerRenderer += '<a href="javascript:;" class="disable">上一页</a> ';
		}else{
			pagerRenderer += '<a href="javascript:;" data="prev">上一页</a> ';
		}
		if(prev > 1){
			pagerRenderer += '<a href="javascript:;">1</a> .. ';
			pagerRenderer += '<a href="javascript:;">'+(pageNo - 2)+'</a> <a href="javascript:;">'+(pageNo - 1)+'</a> ';
		}else{
			for ( var int = 1; int < pageNo; int++) {
				pagerRenderer += '<a href="javascript:;">'+int+'</a> ';
			}
		}
		pagerRenderer += '<span>'+pageNo+'</span> ';
		if(next < totalPage){
			pagerRenderer += '<a href="javascript:;">'+(pageNo + 1)+'</a> <a href="javascript:;">'+(pageNo + 2)+'</a> .. ';
			pagerRenderer += '<a href="javascript:;">'+totalPage+'</a> ';
		}else{
			for ( var int = pageNo + 1; int <= totalPage; int++) {
				pagerRenderer += '<a href="javascript:;">'+int+'</a> ';
			}
		}
		if(pageNo == totalPage || totalPage == 0){
			pagerRenderer += '<a href="javascript:;" class="disable">下一页</a> ';
		}else{
			pagerRenderer += '<a href="javascript:;" data="next">下一页</a> ';
		}
		pagerRenderer += '<em> 每页<input type="text" name="pageSize" id="pageSize_1" class="input40" value="'+pageSize+'"> 条</em>';
		pagerRenderer += '<em class="sum">共'+rowCount+'条'+totalPage+'页</em>';
		pagerRenderer += '到第 <INPUT id="gotoInput" class="input40" value="' + pageNo + '"> 页 <INPUT id="goto_page" class="btn btn-default btn-xs button_page"  value="确 定" type="button"></div>';
		$pager.empty();
		$pager.append(pagerRenderer);
		bindingPagerEvent(p);
	}
	
	function setDbclick(event) {
		var thisid = this.id;
		var idSplit = thisid.split("_");
		var index = idSplit[idSplit.length - 1];
		p.rowDbclickCallback(event.data.rowdatas[index]);
	}
	function setSelectRowStyleOnRowClick(event) {
		/*var $trs = $('tr[rel="' + p.id + '_tr"]');
		$trs.each(function(){
			clearSelectRowStyle(this.id);
		});
		clearCheckedRows();
		var thisid = this.id;
		var idSplit = thisid.split("_");
		var index = idSplit[idSplit.length - 1];
		checkedRows[thisid] = event.data.rowdatas[index][p.checkValue];
		checkedRowsDatas[thisid] = event.data.rowdatas[index];
		setSelectRowStyle(thisid);
		p.rowSelectedCallback(index);  */
	}
	
	function setSelectRowStyle(rowId) {
		$('#' + rowId).removeClass().addClass('selected');
	}
	
	function clearSelectRowStyle(rowId) {
		var idSplit = rowId.split("_");
		var index = idSplit[idSplit.length - 1];
		$('#' + rowId).removeClass();
		if(index%2 != 0) {
			$('#' + rowId).addClass('evenColor');
		}
	}
	
	function bindingPagerEvent(p) {
		$('#page_div').find('a').click(function(){
			var page_No;
			if(typeof($(this).attr("data"))=="undefined"){
				page_No = $(this).html();
			}else{
				var data = $(this).attr("data");
				if(data == 'next'){
					page_No = pageNo+1;
				}
				if(data == 'prev'){
					page_No = pageNo-1;
				}
			}
			
			var checkAllBox = $('#' + p.id + '_checkall');
			checkAllBox.prop("checked",false);
			loadData(page_No,loadUrl);
			//clearCheckedRows();
		});
		
		$('#goto_page').click(function(){
			var checkAllBox = $('#' + p.id + '_checkall');
			checkAllBox.prop("checked",false);
			loadData($("#gotoInput").val(),loadUrl);
		});
		
		$('#pageSize_1').change(function(){
			pageSize = $(this).val();
		});
	}
	
	function loadData(currentPage,loadUrl){
		//console.log("loadData========");
		//console.log(currentPage+"========"+loadUrl);
		loadParams.pageNo = currentPage;
		loadParams.rowCount = rowCount;
		loadParams.pageSize = pageSize;
		//console.log("loadParams======"+loadParams);
		//console.log(loadParams);
		$.getJSON(loadUrl,
			  loadParams,
			  function(result) {
				  //console.log("result======"+result);
				  //console.log(result);
			      renderContent(result.values, p);
                  try{
					  //console.log("p======"+p);
					  //console.log(p);
                      if(p.pagerAjax){
                          var pageUrl = loadUrl.substring(0,loadUrl.indexOf('.do')) + '_page.do?' + Math.random();
                          $.getJSON(pageUrl,
                              loadParams,
                              function(re) {
								  //console.log(pageUrl+"result:");
								  //console.log(re)
                                  pageNo = re.value.pageNo; //重置当前页码
                                  totalPage = re.value.pageCount;
                                  rowCount = re.value.itemCount;
                                  renderPager(p);
                              });
                      }else{
                          pageNo = result.value.pageNo; //重置当前页码
                          totalPage = result.value.pageCount;
                          rowCount = result.value.itemCount;
                          renderPager(p);
                      }
                  }catch (e){}
			      if(typeof(p.successCallback) != 'undefined' && p.successCallback != null) {
			    	  p.successCallback();
			      }
		      }
		);
	}
	
	function checkAllClickHandler(event) {
		if(!this.checked) {
			var checkboxes = $('input[rel="' + event.data.relid + '"]');
			checkboxes.prop('checked', false);
			checkboxes.each(function(){
				var thisid = this.id;
				var rowId = thisid.substr(0, thisid.length - 3);
				clearSelectRowStyle(rowId);
			});
			clearCheckedRows();
		}else{
			var checkboxes = $('input[rel="' + event.data.relid + '"]');
			checkboxes.prop('checked', true);
			for(var i=0; i<checkboxes.length; i++) {
				if(checkedRows[checkboxes[i].id] == undefined) {
					checkedRows[checkboxes[i].id] = currentDatas[i][p.checkValue];
					checkedRowsDatas[checkboxes[i].id] = currentDatas[i];
				}
				
				var thisid = checkboxes[i].id;
				var rowId = thisid.substr(0, thisid.length - 3);
				setSelectRowStyle(rowId);
			}
		}
		p.checkAllCallback();
	}
	
	function checkSingleHandler(event) {
		var thisid = this.id;
		var rowId = thisid.substr(0, thisid.length - 3);
		var idSplit = rowId.split("_");
		var index = idSplit[idSplit.length - 1];
		var idValue= event.data.datarows[index][p.checkValue];
		if(this.checked) {
			if(typeof(checkedRows[thisid]) == 'undefined') {
				checkedRows[thisid] = idValue;
				checkedRowsDatas[thisid] = event.data.datarows[index];
			}
			setSelectRowStyle(rowId);
			p.rowSelectedCallback();
		}else{
			if(checkedRows[thisid]) {
				delete checkedRows[thisid];
				delete checkedRowsDatas[thisid];
			}
			clearSelectRowStyle(rowId);
			p.rowCancelSelectedCallback();
		}
		event.stopImmediatePropagation();

	}
	
	function clearCheckedRows() {
		for(var key in checkedRows) {
			delete checkedRows[key];
			delete checkedRowsDatas[key];
		}
	}
	
	function buildActionParams(actionStr, data) {
		var reg = /\$\{\w+\}/g;
		var result;
		while ((result = reg.exec(actionStr)) != null)  {
			var datakey = result + '';
			actionStr = actionStr.replace(datakey, data[datakey.substring(2, datakey.length-1)]);
		}
		return actionStr;
	}
	
	//songxl增加数据映射显示
	function buildMappedParams(col, data){
		if(!col.mapped){
			return data[col.name];
		}
		var map = col.mapped;
		var val = map[data[col.name]];
		if(val){//如果存在值则返回，如果不存在，则取other的值
			return val;
		}
		return map['other'];
	}
	//songxl增加数据替换显示
	function buildReplaceParams(col, data){
		if(data[col.name] == col.key){
			return col.value;
		}else{
			return data[col.name];
		}
	}
	
	//字符前缀，后缀
	function fixParams(col, data){
		var fixType = col.fixType;
		if(fixType == 'suf'){
			return data[col.name] + col.fixValue;
		}else{
			return col.fixValue + data[col.name];
		}
	}
	//字符串截取
	function subStrParams(col, data){
		return subStrByLength(data[col.name],col.length);
	}
	//截取字符串，返回n个长度
	function subStrByLength(memo,n) {
		if(memo == null) {
			return "";
		}
		var len = memo.replace(/[^\x00-\xff]/g, "**" ).length;
		if(len <= n) {
			return memo;
		} else if(len > n){
			n = n-3;
			var r = Math.floor(n/2);
			for(var i = 0; i < memo.length; i++) {
				if( memo.substring(0,r+i).replace(/[^\x00-\xff]/g, "**" ).length <= n && memo.substring(0,r+i+1).replace(/[^\x00-\xff]/g, "**" ).length > n){
					return memo.substring(0,r+i) + "...";
				} 
			}
			return memo;
		}
	}
	
	Date.prototype.format = function(format){ 
		var o = { 
			"M+" : this.getMonth()+1, //month 
			"d+" : this.getDate(), //day 
			"h+" : this.getHours(), //hour 
			"m+" : this.getMinutes(), //minute 
			"s+" : this.getSeconds(), //second 
			"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
			"S" : this.getMilliseconds() //millisecond 
		}; 
		if(/(y+)/.test(format)) {
			format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
		} 
		for(var k in o) {
			if(new RegExp("("+ k +")").test(format)) { 
				format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
			} 
		} 
		return format; 
	}; 
})(jQuery);