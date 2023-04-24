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
    <title>Sản phẩm</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<%@include file="layout/header.jsp" %>
<div class="container">

    <h3 style="text-align: center">Sản phẩm</h3>
    <form action="/chi-tiet-san-pham/add" method="post">
        <%--        <div class="form-group">--%>
        <%--            <label for="exampleInputEmail1">ID</label>--%>
        <%--            <input type="text" class="form-control" id="exampleInputEmail1" name="id">--%>
        <%--        </div>--%>
        <label>ID Sản phẩm</label> <br>
        <select class="form-select" aria-label="Default select example" name="idSP">
            <c:forEach items="${listSP}" var="sp">
                <option value="${sp.id}">${sp.ma} - ${sp.ten}</option>
            </c:forEach>
        </select>
        <br>
        <label>ID Nhà sản xuất</label><br>
        <select class="form-select" aria-label="Default select example" name="idNSX">
            <c:forEach items="${listNSX}" var="sp">
                <option value="${sp.id}">${sp.ma} - ${sp.ten}</option>
            </c:forEach>
        </select>
        <br>
        <label>ID Màu sắc</label><br>
        <select class="form-select" aria-label="Default select example" name="idMX">
            <c:forEach items="${listMX}" var="sp">
                <option value="${sp.id}">${sp.ma} - ${sp.ten}</option>
            </c:forEach>
        </select>
        <br>
        <label>ID Dòng sản phẩm</label><br>
        <select class="form-select" aria-label="Default select example" name="idDSP">
            <c:forEach items="${listDSP}" var="sp">
                <option value="${sp.id}">${sp.ma} - ${sp.ten}</option>
            </c:forEach>
        </select>
        <div class="form-group">
            <label for="exampleInputEmail1">Năm bảo hành</label>
            <input type="text" class="form-control" name="date">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Mô tả</label>
            <input type="text" class="form-control" name="status">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Số lượng tồn</label>
            <input type="text" class="form-control" name="number">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Giá nhập</label>
            <input type="text" class="form-control" name="getMoney">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Giá bán</label>
            <input type="text" class="form-control" name="outMoney">
        </div>
        <button type="submit" class="btn btn-info">Thêm</button>
    </form>
</div>
<table class="table table-dark table-striped-columns">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">ID Sản phẩm</th>
        <th scope="col">Id NSX</th>
        <th scope="col">Id Màu Sắc</th>
        <th scope="col">ID Dòng SP</th>
        <th scope="col">Năm BH</th>
        <th scope="col">Mô tả</th>
        <th scope="col">Số lượng tồn</th>
        <th scope="col">Giá nhập</th>
        <th scope="col">Giá bán</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCTSP}" var="ctsp">
        <tr>
            <th scope="row">${ctsp.id}</th>
            <td>${ctsp.sanPham.ma}-${ctsp.sanPham.ten}</td>
            <td>${ctsp.mauSac.ma}-${ctsp.mauSac.ten}</td>
            <td>${ctsp.nsx.ma}-${ctsp.nsx.ten}</td>
            <td>${ctsp.dongSanPham.ma}-${ctsp.dongSanPham.ten}</td>
            <td>${ctsp.namBH}</td>
            <td>${ctsp.moTa}</td>
            <td>${ctsp.soLuongTon}</td>
            <td>${ctsp.giaNhap}</td>
            <td>${ctsp.giaBan}</td>
            <td>
                <a href="/chi-tiet-san-pham/delete?id=${ctsp.id}" type="button" class="btn btn-danger">Delete</a>
                <a href="/chi-tiet-san-pham/detail?id=${ctsp.id}" type="button" class="btn btn-warning">Edit</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="container">
    <a href="/san-pham/hien-thi" type="button" class="btn btn-success">SanPham</a>
    <a href="/nha-san-xuat/hien-thi" type="button" class="btn btn-success">NSX</a>
    <a href="/mau-sac/hien-thi" type="button" class="btn btn-success">MauSac</a>
    <a href="/dong-sp/hien-thi" type="button" class="btn btn-success">DongSP</a>
</div>
<%@include file="layout/footer.jsp" %>
</body>
</html>
