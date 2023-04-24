<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/21/2023
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Khách hàng</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

</head>
<body>
<%@include file="layout/header.jsp" %>
<div class="container">
    <h3 style="text-align: center">Khách hàng</h3>
    <form action="/khach-hang/add" method="post">
<%--        <div class="form-group">--%>
<%--            <label for="exampleInputEmail1">ID</label>--%>
<%--            <input type="text" class="form-control" id="exampleInputEmail1" name="id">--%>
<%--        </div>--%>
        <div class="form-group">
            <label for="exampleInputPassword1">Mã</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="pass">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Tên</label>
            <input type="text" class="form-control"  name="name">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Tên Đệm</label>
            <input type="text" class="form-control"  name="fistname">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Họ</label>
            <input type="text" class="form-control"  name="lastname">
        </div>
        <br>
        <div class="form-group">
            <label for="exampleInputPassword1">Ngày sinh</label>
            <input type="date" class="form-control"  name="date">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">SĐT</label>
            <input type="text" class="form-control"  name="phonenumber">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Địa chỉ</label>
            <input type="text" class="form-control"  name="address">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Thành phố</label>
            <input type="text" class="form-control"  name="city">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Quốc gia</label>
            <input type="text" class="form-control"  name="country">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Mật khẩu</label>
            <input type="text" class="form-control"  name="password">
        </div>
        <br>
        <button type="submit" class="btn btn-info">Thêm</button>
    </form>
</div>
<table class="table table-dark table-striped-columns">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Tên Đệm</th>
        <th scope="col">Họ</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">SĐT</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Thành phố</th>
        <th scope="col">Quốc gia</th>
        <th scope="col">Mật khẩu</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKH}" var="kh">
    <tr>
        <th scope="row">${kh.id}</th>
        <td>${kh.ma}</td>
        <td>${kh.ten}</td>
        <td>${kh.tenDem}</td>
        <td>${kh.ho}</td>
        <td>${kh.ngaySinh}</td>
        <td>${kh.SDT}</td>
        <td>${kh.diaChi}</td>
        <td>${kh.thanhPho}</td>
        <td>${kh.quocGia}</td>
        <td>${kh.matKhau}</td>
        <td>
            <a href="/khach-hang/delete?id=${kh.id}" type="button" class="btn btn-danger">Delete</a>
           <a href="/khach-hang/detail?id=${kh.id}" type="button" class="btn btn-warning">Edit</a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<%@include file="layout/footer.jsp" %>
</body>
</html>
