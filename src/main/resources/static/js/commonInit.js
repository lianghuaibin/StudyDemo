/**
 * 通用js
 * Created by lianghuaibin on 2017/3/20.
 */
var commonInit = {
    /**
     * 跳转url
     * @param url
     */
    skipUrl : function(url){
        window.location.href=url;
    },
    /**
     * 获得html 并赋值JSON类型
     * @param tmpl
     * @param data
     * @returns {*}
     */
    dotHtml : function(tmpl, data) {
        var _html = $(tmpl).html();
        var tpl = doT.template(_html);
        var html = tpl(data);
        return html;
    },
    /**
     * 显示模板
     * @param template
     * @param target
     * @param parameter
     */
    showTip : function(template, target, parameter){
        var html = commonInit.dotHtml(template, parameter);
        //console.log('-showTip-',html);
        $(target).empty();
        $(target).append(html);
    },
    /**
     * post 请求获取参数
     * @param url
     * @param parameter
     * @param callback
     */
    postData : function(url, parameter, callback) {
        console.log(parameter);
        $.ajax({
            type : "POST",
            url : url,
            dataType : "json",
            data : parameter,
            success : function(data) {
                if (callback == null) {
                    return;
                }
                callback(data);
            },
            error : function(error) {
                var msg = error.responseText;
                if(msg==null || msg==undefined || msg==''){
                    msg = '网络不给力:(';
                }
                alert(msg);
                console.log(error);
            }
        });
    },
    getData : function(url, parameter, callback) {
        $.ajax({
            type : "GET",
            url : url,
            dataType : "json",
            data : parameter,
            success : function(data) {
                if (callback == null) {
                    return;
                }
                callback(data);
            },
            error : function(error) {
                var msg = error.responseText;
                if(msg==null || msg==undefined || msg==''){
                    msg = '网络不给力:(';
                }
                alert(msg);
                console.log(error);
            }
        });
    },
    /**
     * 获取下拉菜单中的所有的option的value值
     * @param id  ID
     * @returns {Array}
     */
    getSelectOptionsValue : function(id){
        var value = new Array();
        $($("#" + id)[0].options).each(function(i, o) {
            var param = Number(o.value);
            value.push(param);
        });
        return value;
    },

    /**
     * 验证 是否有重复值
     * @param arr
     */
    isRepeat : function(arr){
        var hash = {};
        for(var i in arr) {
            if(hash[arr[i]]){
                return true;
            }else if(arr[i]!=null && arr[i]!='' && arr[i].length>0){
                hash[arr[i]] = true;// 不存在该元素，则赋值为true，可以赋任意值，相应的修改if判断条件即可
            }
        }
        return false;
    },
    /**
     * 获取表单中所有内容
     * @returns {{}}
     */
    serializeForm:function(formId){
        var map = {};
        $("#"+formId).find('input').each(function(){
            if(typeof($(this).attr('name')) != 'undefined' && $(this).val() != ''){
                map[$(this).attr('name')] = $(this).val();
            }
        }).end().find('select').each(function(){
            if(typeof($(this).attr('name')) != 'undefined' && $(this).val() != ''){
                map[$(this).attr('name')] = $(this).val();
            }
        }).end().find('textarea').each(function(){
            if(typeof($(this).attr('name')) != 'undefined' && $(this).val() != ''){
                map[$(this).attr('name')] = $(this).val();
            }
        });
        //console.log("serializeForm================");
        //console.log(map);
        return map;
    },
    /**
     * 获取表单中所有内容
     * arrayParam 只获取存在的字段
     * @returns {{}}
     */
    serializeForm_array:function(formId,arrayParam){
        var map = {};
        $("#"+formId).find('input').each(function(){
            if(typeof($(this).attr('name')) != 'undefined' && $(this).val() != ''){
                if($.inArray($(this).attr('name'),arrayParam)!=-1){
                    map[$(this).attr('name')] = $(this).val();
                }
            }
        }).end().find('select').each(function(){
            if(typeof($(this).attr('name')) != 'undefined' && $(this).val() != ''){
                if($.inArray($(this).attr('name'),arrayParam)!=-1){
                    map[$(this).attr('name')] = $(this).val();
                }
            }
        }).end().find('textarea').each(function(){
            if(typeof($(this).attr('name')) != 'undefined' && $(this).val() != ''){
                if($.inArray($(this).attr('name'),arrayParam)!=-1){
                    map[$(this).attr('name')] = $(this).val();
                }
            }
        });
        console.log("serializeForm_array================");
        console.log(map);
        return map;
    },
    /**
     * 重置form表单
     */
    doReset:function(formId){
        $(':input','#'+formId)
            .not(':button,:submit,:reset,:hidden')
            .val('')
            .removeAttr('checked');
    },
    /**
     * 获取当前年月日时分秒
     */
    getNowFormatDate:function(){
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + month + strDate + date.getHours() + date.getMinutes() + date.getSeconds();
        console.log("currentdate>>>",currentdate);
        return currentdate;
    }

}

