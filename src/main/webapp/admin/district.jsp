<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/district.js"></script>
</head>
<body>
<table id="dg"></table>

<div id="ToolBar">
        <a href="javascript:add()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:District()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:delBatches()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
</div>

<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true"
     data-options="modal:true">
    <form id="add" method="post">
        <table>
            <tr>
                <td>区域:</td>
                <td>
                    <input type="hidden" name="id"/>
                    <input type="text" class="easyui-validatebox" required name="name" id="dname" /></td>
            </tr>
        </table>
    </form>
</div>

<div id="AddDialogButtons">
    <a href="javascript:addDistrict()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeDistrict('AddDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>



<div id="upDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true"
     data-options="modal:true">
    <form id="up" method="post">
        <table>
            <tr>
                <td>区域:</td>
                <td>
                    <input type="hidden" name="id"/>
                    <input type="text" class="easyui-validatebox" required name="name" id="uname" /></td>
            </tr>
        </table>
    </form>
</div>

<div id="upDialogButtons">
    <a href="javascript:upDistrict()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeDistrict('upDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

<div id="streetDialog" class="easyui-dialog"
     style="width: 500px; height: 500px; padding: 10px 20px;" closed="true"
     data-options="modal:true">
    <table id="sss"></table>
</div>


</body>
</html>
