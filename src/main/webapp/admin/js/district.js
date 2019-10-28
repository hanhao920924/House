//加载显示区域
$(function(){  //加载事件
    //显示数据
    $('#dg').datagrid({
        title:'区域信息',
        toolbar:'#ToolBar',
        url:'getDistrictByPage',
        pagination:true,
        pageSize:3,
        pageList: [3,5,10,20],
        columns:[[
            {checkbox:true},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'区域名称',width:100},
            {field:'cz',title:'操作',width:100,
                formatter: function(value,row,index){
                    //同步
                    return "<a href='javascript:delDistrict("+row.id+");'>删除</a> | <a href='javascript:selectStreetInfo("+row.id+");'>显示街道</a>";
                }}

        ]]
    });
});

//街道详情
function selectStreetInfo(id) {
    $("#streetDialog").dialog("open");
    $('#sss').datagrid({
        title:'街道信息',
        url:'streetShow',
        pagination:true,
        queryParams:{"id":id},
        pageSize:3,
        pageList: [3,5,10,20],
        columns:[[
            {checkbox:true},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'街道名称',width:100}

        ]]
    });
}

function add() {
    $("#AddDialog").dialog("setTitle","添加区域");
    $("#AddDialog").dialog("open");
}

function closeDistrict(id) {
    $("#"+id).dialog("close");
}

function addDistrict() {
    $('#add').form('submit',{   //提交按钮
        url:"addDistrict",
        success:function(data){ //获得是json字符串
            //将json字符串转化为json对象
            data=$.parseJSON(data);
            if(data.result){
                $("#dg").datagrid('reload'); //刷新
                $("#AddDialog").dialog("close");//关闭窗口
            }else{
                alert("添加失败!!!");
            }
        }
    });
}

//修改的url
function District(){
    //获取选中的行
    var SelectRows = $("#dg").datagrid('getSelections');
    if( 1 != SelectRows.length ){
        $.messager.alert('提示信息','你没有选中行或者选中多行','warning');
        return;
    }
    var SelectRow = SelectRows[0];
    //打开编辑对话框
    $("#upDialog").dialog('open').dialog('setTitle',"编辑数据");
    //获得行对象的数据加载到表单中显示
    $("#up").form('load',SelectRow);

}

function upDistrict(){
    $('#up').form('submit',{   //提交按钮
        url:"upDistrict",
        success:function(data){ //获得是json字符串
            //将json字符串转化为json对象
            data=$.parseJSON(data);
            if(data.result){
                $("#dg").datagrid('reload'); //刷新
                $("#upDialog").dialog("close");//关闭窗口

            }else{
                $.messager.alert('提示信息','修改失败','warning');
            }
        }
    });
}

function delDistrict(id){
    //确认提示框
    $.messager.confirm('删除区域', '真的想删除吗?', function(r){
        if (r){
            //删除
            $.post("delDistrict",{"id":id},function(data){
                if(data.result){
                    $("#dg").datagrid('reload'); //刷新
                }else{
                    $.messager.alert('提示信息','删除失败!','error');
                }
            },"json");
        }
    });
}

function delBatches() {
    //获取选择行
    var SelectRows = $("#dg").datagrid('getSelections');
    //alert(SelectRows.length);
    if( 0 == SelectRows.length ){
        $.messager.alert("系统提示", "请选择要删除的数据");
        return;
    }
    var SelectIndexArr = [];
    for( var i = 0 ; i < SelectRows.length; i++ ){
        SelectIndexArr.push(SelectRows[i].id);
    }
    var SelectIndexToString = SelectIndexArr.join(",");
    $.messager.confirm("系统提示", "你确定要删除<font color=red> " + SelectRows.length + " </font>条数据吗?", function(xo){
        if( xo ){
            $("#dg").datagrid('reload');
            //支持多项删除
            //alert(SelectIndexToString);
            $.post("delMoreDis",{ids:SelectIndexToString},function(result){
                if( result.result >0 ){
                    $.messager.alert("系统提示", "你已成功删除 <font color=green> " + result.result + " </font>条数据!~");
                    $("#dg").datagrid('reload');
                }
                else{
                    $.messager.alert("系统提示", "<font color=red>删除失败</font>");
                }
            },"json");
        }
    });
}
