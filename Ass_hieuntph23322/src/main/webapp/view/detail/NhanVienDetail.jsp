<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/26/2023
  Time: 9:12 PM
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
        <h3 style="text-align: center">Nhân Viên</h3>
        <form action="/nhan-vien/update" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">ID</label>
                <input type="text" class="form-control" id="exampleInputEmail1" name="id" value="${lisNV.id}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Mã</label>
                <input type="text" class="form-control" id="exampleInputPassword1" name="pass" value="${lisNV.ma}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Tên</label>
                <input type="text" class="form-control" name="name" value="${lisNV.ten}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Tên Đệm</label>
                <input type="text" class="form-control" name="firtname" value="${lisNV.tenDem}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Họ</label>
                <input type="text" class="form-control" name="lastname" value="${lisNV.ho}">
            </div>
            <br>
            <label>Giới tính</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gender" id="flexRadioDefault1" value="Nam" ${lisNV.gioiTinh == "Nam"?"checked":""}>
                <label class="form-check-label" for="flexRadioDefault1">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gender" id="flexRadioDefault2" value="Nữ" ${lisNV.gioiTinh == "Nữ"?"checked":""}>
                <label class="form-check-label" for="flexRadioDefault2">
                    Nữ
                </label>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Ngày sinh</label>
                <input type="date" class="form-control" name="date" value="${ngaySinh}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Địa chỉ</label>
                <input type="text" class="form-control" name="address" value="${lisNV.diaChi}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">SĐT</label>
                <input type="text" class="form-control" name="phonenumber" value="${lisNV.SDT}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Mật khẩu</label>
                <input type="text" class="form-control" name="password" value="${lisNV.matKhau}">
            </div>
            <br>
            <label>Cửa hàng</label>
            <select class="form-select" aria-label="Default select example" name="idCH">
<%--                <c:forEach items="${lisNV}" var="ch">--%>
                    <option value="${lisNV.cuaHang.id}">${lisNV.cuaHang.ma}</option>
<%--                </c:forEach>--%>

            </select>
            <br>
            <label>Chức Vụ</label>
            <select class="form-select" aria-label="Default select example" name="idCV">
<%--                <c:forEach items="${lisNV}" var="ch">--%>
                    <option value="${lisNV.chucVu.id}">${lisNV.chucVu.ma}</option>
<%--                </c:forEach>--%>
            </select>
            <br>
            <div class="form-group">
                <label for="exampleInputPassword1">Gửi BC</label>
                <input type="text" class="form-control" name="idGuiBc" disabled>
            </div>
            <br>
            <label>Trạng thái</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="status" id="flexRadioDefault3" value="0" ${lisNV.trangThai == "0"?"checked":""}>
                <label class="form-check-label" for="flexRadioDefault1">
                    Online
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="status" id="flexRadioDefault4" value="1" ${lisNV.trangThai == "1"?"checked":""}>
                <label class="form-check-label" for="flexRadioDefault2">
                    Offline
                </label>
            </div>
            <button type="submit" class="btn btn-info">Update</button>
        </form>
    </div>
</body>
</html>
