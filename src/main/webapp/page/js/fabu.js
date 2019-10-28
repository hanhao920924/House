$(function () {
    $.post("getAllType",null,function (data) {
        for (var i = 0; i < data.length; i++) {
            var option=$("<option value="+data[i].id+">"+data[i].name+"</option>");
            //添加节点
            $("#type_id").append(option);
        }
    },"json")
});

$(function () {
    $.post("getAllDistrict",null,function (data) {
        for (var i = 0; i < data.length; i++) {
            var option=$("<option value="+data[i].id+">"+data[i].name+"</option>");
            //添加节点
            $("#district_id").append(option);
        }
    },"json")
});

$(function () {
    $("#district_id").change(function(){  //触发区域的改变事件
        var did=$(this).val();
        //发送异步请求获取街道
        //清空选项
        $("#street_id>option:gt(0)").remove();
        //加载数据
        $.post("getStreetByDid",{"did":did},function(data){
            //循环一次一行对就一个选项
            for (var i=0;i<data.length;i++){
                //创建dom节点
                var option=$("<option value="+data[i].id+">"+data[i].name+"</option>");
                //添加节点
                $("#street_id").append(option);
            }
        },"json");
    });
});
