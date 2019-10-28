<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/users.js"></script>
</head>
<body>
<table id="dg"></table>

<div id="ToolBar">
        用户名:<input type="text" name="name" id="sname">
        电话:<input type="text" name="telephone" id="stelephone">
        <a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
</div>

</body>
</html>
