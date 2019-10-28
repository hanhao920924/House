//加载显示类型
$(function(){  //加载事件
    //使用datagrid绑异服务器数据展示
    $('#dg').datagrid({
        title:"出租房信息",
        url:'getHousePass',
        toolbar:"#tb",  //绑定工具栏
        pagination:true,
        pageSize:10,
        pageList:[10,20,30,40],
        columns:[[
            {field:'opt',checkbox:"true",width:100},
            {field:'id',title:'编号',width:100},
            {field:'title',title:'标题',width:100},
            {field:'dname',title:'区域名称',width:100},
            {field:'sname',title:'街道名称',width:100},
            {field:'tname',title:'类型名称',width:100},
            {field:'floorage',title:'面积',width:100},
            {field:'price',title:'价格',width:100},
            {field:'contact',title:'电话',width:100},
            {field:'dd',title:'操作',width:100,
                formatter: function(value,row,index){
                    //同步
                    return "<a href='javascript:HousePass("+row.id+");'>取消审核</a>";
                }
            },
        ]]
    });
});

//审核出租房信息
function HousePass(id){
   //发送异步请求审核
    $.post("goHouseNotPass",{"id":id},function(data){
       if(data.result>0)
           $('#dg').datagrid("reload");   //刷新
           else
               $.messager.alert("提示信息","取消审核失败!","error");
    },"json");
}