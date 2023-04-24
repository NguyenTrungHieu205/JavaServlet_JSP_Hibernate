<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/26/2023
  Time: 8:22 PM
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
    <h3 style="text-align: center">Sản phẩm</h3>
    <form action="/chi-tiet-san-pham/update" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">ID</label>
            <input type="text" class="form-control" id="exampleInputEmail1" name="id" value="${listSP.id}">
        </div>
        <label>ID Sản phẩm</label> <br>
        <select class="form-select" aria-label="Default select example" name="idSP" >
<%--            <c:forEach items="${listSP}" var="sp">--%>
                <option value="${listSP.sanPham.id}">${listSP.sanPham.ma}</option>
<%--            </c:forEach>--%>
        </select>
        <br>
        <label>ID Nhà sản xuất</label><br>
        <select class="form-select" aria-label="Default select example" name="idNSX" >
<%--            <c:forEach items="${listNSX}" var="sp">--%>
                <option value="${listSP.nsx.id}">${listSP.nsx.ma}</option>
<%--            </c:forEach>--%>
        </select>
        <br>
        <label>ID Màu sắc</label><br>
        <select class="form-select" aria-label="Default select example" name="idMX" >
<%--            <c:forEach items="${listMX}" var="sp">--%>
                <option value="${listSP.mauSac.id}">${listSP.mauSac.ma}</option>
<%--            </c:forEach>--%>
        </select>
        <br>
        <label>ID Dòng sản phẩm</label><br>
        <select class="form-select" aria-label="Default select example" name="idDSP" >
<%--            <c:forEach items="${listDSP}" var="sp">--%>
                <option value="${listSP.dongSanPham.id}">${listSP.dongSanPham.ma}</option>
<%--            </c:forEach>--%>
        </select>
        <div class="form-group">
            <label for="exampleInputEmail1">Năm bảo hành</label>
            <input type="text" class="form-control" name="date" value="${listSP.namBH}">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Mô tả</label>
            <input type="text" class="form-control" name="status" value="${listSP.moTa}">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Số lượng tồn</label>
            <input type="text" class="form-control" name="number" value="${listSP.soLuongTon}">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Giá nhập</label>
            <input type="text" class="form-control" name="getMoney" value="${listSP.giaNhap}">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Giá bán</label>
            <input type="text" class="form-control" name="outMoney" value="${listSP.giaBan}">
        </div>
        <button type="submit" class="btn btn-info">Update</button>
    </form>
</div>
</body>
</html>
