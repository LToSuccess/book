<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/common/login_success_menu.jsp" %>
</div>
<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5">购物车空空如也，<a href="index.jsp">快去浏览商品吧！</a></td>
            </tr>
        </c:if>
        <c:forEach items="${sessionScope.cart.items}" var="entry">
            <tr>
                <td>${entry.value.name}</td>
                <td>
                    <input bookId="${entry.value.id}" class="updateCount" type="text" style="width: 50px" value="${entry.value.count}">
                </td>
                <td>${entry.value.price}</td>
                <td>${entry.value.totalPrice}</td>
                <td><a class="deleteItem" href="cartServlet?way=deleteItem&id=${entry.value.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clearItems" href="cartServlet?way=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?way=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<%@include file="/pages/common/footer.jsp" %>
<script type="text/javascript">
    $(function () {
        $("a.deleteItem").click(function () {
            var itemName = $(this).parent().parent().find("td:first").text()
            return confirm("你确认删除【" + itemName + "】吗？")
        });
        $("#clearItems").click(function () {
            return confirm("你确认清空购物车吗")
        });
        $(".updateCount").change(function () {
            var name = $(this).parent().parent().find("td:first").text()
            var count = $(this).val();
            var bookId=$(this).attr("bookId")
            if (confirm("你确认将【" + name + "】的数量改变为【" + count + "】吗？")) {
                location.href = "cartServlet?way=updateCount&count="+count+"&id="+bookId
            } else {
                this.value = this.defaultValue
            }
        });
    })
</script>
</body>
</html>