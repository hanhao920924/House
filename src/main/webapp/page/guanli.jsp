<%@ page pageEncoding="utf-8" language="java" contentType="text/html;utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   //判断有没有session
  Object o=session.getAttribute("userinfo");
  if(o==null){
      //1.没有登入  2.登入过，但时间超过有效期
     out.print("<script>alert('你还没有登入，或者过期，可以滚去登入，不许进');location.href='login.jsp';</script>");
  }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
  <LINK rel=stylesheet type=text/css href="../css/style.css">
  <script src="../scripts/jquery-1.8.3.js"></script>
  <script>

        function del(obj,id){
            $.post("delHouse",{"id":id},function(data){
                if(data.result>0)
                {
                    //移除当前行
                    $(obj).parent().parent().parent().remove();
                }
                else
                    alert("失败");
            },"json");
        }

  </script>

<META name=GENERATOR ></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
<DIV class=search>欢迎${sessionScope.userinfo.name}.<LABEL class="ui-green searchs"><a href="fabu.jsp" title="">发布房屋信息</a></LABEL>
<LABEL class=ui-green><INPUT onclick='document.location="login.jsp"' value="退       出" type=button name=search></LABEL>
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
<TABLE class=house-list>
  <TBODY>

  <c:forEach items="${houseList}" var="h">
    <TR>
      <TD class=house-thumb><SPAN><A href="details.htm" target="_blank">

        <img src="http://localhost:80/${h.path}" width="100" height="75" alt=""></A></SPAN></TD>
      <TD>
        <DL>
          <DT><A href="details.htm" target="_blank">${h.title}</A></DT>
          <DD>${h.dname}=${h.sname},类型:${h.tname}=面积:${h.floorage}平米<BR>联系方式：${h.contact} </DD></DL></TD>
      <TD class=house-type>
        <c:if test="${h.ispass==0}"> 审核中... </c:if>
        <c:if test="${h.ispass==1}"> 已审核 </c:if>
      </TD>
      <TD class=house-type>
        <LABEL class=ui-green>
          <INPUT onclick="location.href='showHouse?id=${h.id}';" value="修    改" type=button name=search>
        </LABEL>
      </TD>
      <TD class=house-price>
        <LABEL class=ui-green><input value="删    除" onclick="del(this,${h.id});" id="delButton2" type="button">
          <input type="hidden" value="${h.id}">
        </LABEL>
      </TD>
    </TR>
  </c:forEach>

  </TBODY></TABLE></DIV>
<DIV class=pager>
<UL>
  <LI class=current><A id=widget_338868862 
  href="http://localhost:8080/HouseRent/manage!ajaxList.action?number=1" 
  parseContent="true" showError="true" targets="houseArea" 
  ajaxAfterValidation="false" validate="false" 
dojoType="struts:BindAnchor">1</A>
   </LI>
  <LI class=current><A id=widget_1160989910 
  href="http://localhost:8080/HouseRent/manage!ajaxList.action?number=2" 
  parseContent="true" showError="true" targets="houseArea" 
  ajaxAfterValidation="false" validate="false" 
dojoType="struts:BindAnchor">2</A>
   </LI></UL><SPAN class=total>1/2页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
