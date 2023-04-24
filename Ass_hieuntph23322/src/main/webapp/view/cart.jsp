<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/3/2023
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="/view/css/trangChu.css">
</head>
<body>
<%@include file="layout/header.jsp" %>
<h3 style="text-align: center">GIO HANG</h3>
<table class="table table-dark table-striped-columns">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Tên sản phẩm</th>
        <th scope="col">Số lượng</th>
        <th scope="col">Giá bán</th>
        <th scope="col">Thành tiền</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach  var="items" items="${cart.items}">
        <tr>
            <td>${items.id}</td>
            <td>${items.ten}</td>
            <td>${items.soLuong}</td>
            <td>${items.giaBan}</td>
            <td>${items.giaBan*items.soLuong}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="container">
    <a href="/san-pham" type="button" class="btn btn-warning">TIẾP TỤC MUA HÀNG</a>
</div>
<div class="row">
    <div class="col-3">
        <img src="/view/assets/bn1.jpg" alt="" id="bn" />
    </div>
    <div class="col-3">
        <img src="/view/assets/bn3.png" alt="" id="bn" />
    </div>
    <div class="col-3">
        <img src="/view/assets/bn2.png" alt="" id="bn" />
    </div>
    <div class="col-3">
        <img src="/view/assets/bn4.png" alt="" id="bn" />
    </div>
</div>
<%@include file="layout/footer.jsp" %>
</body>
</html>
