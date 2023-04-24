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
    <title>Nhân Viên</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

</head>
<body>
<%@include file="layout/header.jsp" %>
<div class="container">
    <h3 style="text-align: center">Nhân Viên</h3>
    <form action="/nhan-vien/add" method="post">
        <div class="form-group">
            <label for="exampleInputPassword1">Mã</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="pass">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Tên</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Tên Đệm</label>
            <input type="text" class="form-control" name="firtname">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Họ</label>
            <input type="text" class="form-control" name="lastname">
        </div>
        <br>
        <label>Giới tính</label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gender" id="flexRadioDefault1" value="Nam">
            <label class="form-check-label" for="flexRadioDefault1">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gender" id="flexRadioDefault2" checked value="Nữ">
            <label class="form-check-label" for="flexRadioDefault2">
                Nữ
            </label>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Ngày sinh</label>
            <input type="date" class="form-control" name="date">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Địa chỉ</label>
            <input type="text" class="form-control" name="address">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">SĐT</label>
            <input type="text" class="form-control" name="phonenumber">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Mật khẩu</label>
            <input type="text" class="form-control" name="password">
        </div>
        <br>
        <label>Cửa hàng</label>
        <select class="form-select" aria-label="Default select example" name="idCH">
            <c:forEach items="${listCH}" var="ch">
                <option value="${ch.id}">${ch.ma} - ${ch.ten}</option>
            </c:forEach>

        </select>
        <br>
        <label>Chức Vụ</label>
        <select class="form-select" aria-label="Default select example" name="idCV">
            <c:forEach items="${listCV}" var="ch">
                <option value="${ch.id}">${ch.ma} - ${ch.ten}</option>
            </c:forEach>
        </select>
<%--        <br>--%>
<%--        <div class="form-group">--%>
<%--            <label for="exampleInputPassword1">Gửi BC</label>--%>
<%--            <input type="text" class="form-control" name="idGuiBc" disabled>--%>
<%--        </div>--%>
        <br>
        <label>Trạng thái</label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="status" id="flexRadioDefault3" value="0">
            <label class="form-check-label" for="flexRadioDefault1">
                Online
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="status" id="flexRadioDefault4" checked value="1">
            <label class="form-check-label" for="flexRadioDefault2">
                Offline
            </label>
        </div>
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
        <th scope="col">Giới Tính</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">SĐT</th>
        <th scope="col">Mật khẩu</th>
        <th scope="col">Cửa hàng</th>
        <th scope="col">Công việc</th>
<%--        <th scope="col">Gui BC</th>--%>
        <th scope="col">Trạng thái</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNV}" var="nv">
        <tr>
            <th scope="row">${nv.id}</th>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDem}</td>
            <td>${nv.ho}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.SDT}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.cuaHang.ma} - ${nv.cuaHang.ten}</td>
            <td>${nv.chucVu.ma} - ${nv.chucVu.ten}</td>
<%--            <td>${nv.idGuiBC}</td>--%>
            <td>
                <c:if test="${nv.trangThai == 0}">Online</c:if>
                <c:if test="${nv.trangThai == 1}">Offline</c:if>
            </td>

            <td>
                <a href="/nhan-vien/delete?id=${nv.id}" type="button" class="btn btn-danger">Delete</a>
                <a href="/nhan-vien/detail?id=${nv.id}" type="button" class="btn btn-warning">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/chuc-vu/hien-thi" type="button" class="btn btn-success">ChucVu</a>
<a href="/cua-hang/hien-thi" type="button" class="btn btn-success">CuaHang</a>
<%@include file="layout/footer.jsp" %>
</body>
</html>
