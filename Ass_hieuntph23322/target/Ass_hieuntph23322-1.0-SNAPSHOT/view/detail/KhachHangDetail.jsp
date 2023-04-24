<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/24/2023
  Time: 10:52 PM
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
</head>
<body>
    <div class="container">
        <h3 style="text-align: center">Khách hàng</h3>
        <form action="/khach-hang/update" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">ID</label>
                <input type="text" class="form-control" id="exampleInputEmail1" name="id" value="${listKH.id}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Mã</label>
                <input type="text" class="form-control" id="exampleInputPassword1" name="pass" value="${listKH.ma}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Tên</label>
                <input type="text" class="form-control"  name="name" value="${listKH.ten}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Tên Đệm</label>
                <input type="text" class="form-control"  name="fistname" value="${listKH.tenDem}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Họ</label>
                <input type="text" class="form-control"  name="lastname" value="${listKH.ho}">
            </div>
            <br>
            <div class="form-group">
                <label for="exampleInputPassword1">Ngày sinh</label>
                <input type="date" class="form-control"  name="date" value="${ngaySinh}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">SĐT</label>
                <input type="text" class="form-control"  name="phonenumber" value="${listKH.SDT}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Địa chỉ</label>
                <input type="text" class="form-control"  name="address" value="${listKH.diaChi}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Thành phố</label>
                <input type="text" class="form-control"  name="city" value="${listKH.thanhPho}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Quốc gia</label>
                <input type="text" class="form-control"  name="country" value="${listKH.quocGia}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Mật khẩu</label>
                <input type="text" class="form-control"  name="password" value="${listKH.matKhau}">
            </div>
            <br>
            <button type="submit" class="btn btn-info">Update</button>
        </form>
    </div>
</body>
</html>
