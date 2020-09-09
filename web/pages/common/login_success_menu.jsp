<%--
  Created by IntelliJ IDEA.
  User: hlx
  Date: 2020/8/7
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.uname}</span>光临尚硅谷书城</span>
    <a href="pages/order/order.jsp">我的订单</a>
    <a href="login?way=loginOut">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
