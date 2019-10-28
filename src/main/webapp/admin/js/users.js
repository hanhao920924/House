//加载显示类型
$(function(){  //加载事件
    //显示数据
    $('#dg').datagrid({
        title:'用户信息',
        toolbar:'#ToolBar',
        url:'getUserByPage',
        pagination:true,
        pageSize:3,
        pageList: [3,5,10,20],
        columns:[[
            {field:'opt',checkbox:"true",title:'编号',width:100},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'用户名称',width:100},
            {field:'telephone',title:'用户电话',width:100},
            {field:'age',title:'用户年龄',width:100},
            {field:'cz',title:'操作',width:100,
                formatter: function(value,row,index){
                    //同步
                    return "<a href=''>删除</a> | <a href=''>修改</a>";
                }}
        ]]
    });
});

//搜索
function search() {
    var telephone = $("#stelephone").val();
    var name = $("#sname").val();
    $("#dg").datagrid("load",{"name":name,"telephone":telephone});
}




