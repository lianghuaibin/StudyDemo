<!DOCTYPE html>
<html>
<head>
    <title>用户列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.0.3/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/css/common.css" />
    <script type="text/javascript" src="/webjars/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/jd.grid.js"></script>
    <script type="text/javascript" src="/js/commonInit.js"></script>
</head>
<body>
<form method="post"  id="formSubmit">
    <div style="padding: 50px">
        <div id="billTable" class="contentList"></div>
    </div>
</form>
</body>
<script>
    $(function(){
        var userData = {cols: [
            {display:'id',name:'id'},
            {display:'账号',name:'account'},
            {display:'姓名',name:'username'},
            {display:'性别',name:'sex'},
            {display:'年龄',name:'age'},
            {display:'收款时间',name:'modifiedTime',type:'time',format:'yyyy-MM-dd hh:mm:ss'},// hh:mm:ss
            {display:'操作',type:'userCustom'}
        ],
            autoLoad: false,
            checkbox: true,
            checkValue:'id',//checkbox绑定的值
            successCallback:successCallback//表格加载成功回调函数
        };
        $('#billTable').ideagrid(userData);//生成表
        queryAuto();//加载列表数据
    });
    function queryAuto(){
        $('#billTable').load('../user/user_ajax.do',commonInit.serializeForm("formSubmit"));//加载列表数据
    }
    //表格加载成功回调函数
    function successCallback(){
        var checkRows = $('#billTable').getCheckRows();
        for(var key in checkRows)  {
            $('#'+key).attr('checked',true);
        }
    }
    function userCustom(user){
        var html = "";
        html += '<a href="javascript:void(0);" onclick="alert(\'待开发：id='+user.id+'\')">详情</a>';
        return html;
    }

</script>
</html>
