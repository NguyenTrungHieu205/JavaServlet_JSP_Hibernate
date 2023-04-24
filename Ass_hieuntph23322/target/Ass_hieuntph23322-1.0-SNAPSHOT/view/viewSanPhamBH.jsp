<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/5/2023
  Time: 9:49 PM
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
<%--    <link rel="stylesheet" href="/view/css/TrangCuaToi.css">--%>
    <link rel="stylesheet" href="/view/css/trangChu.css">
</head>
<body>
<%@include file="layout/header.jsp" %>
<div class="container">
    <div class="row">
<%--        <div class="col-3" id="menudoc">--%>
<%--            <!-- As a link -->--%>
<%--            <nav class="navbar ">--%>
<%--                <c:forEach items="${listCTSP}" var="ctsp">--%>
<%--                    <a class="navbar-brand" href="" >${ctsp.dongSanPham.ma}</a>--%>
<%--                </c:forEach>--%>
<%--            </nav>--%>
<%--        </div>--%>
<%--        <div class="col-9">--%>
            <div class="row" id="timKiem">

                <input
                        class="form-control me-2"
                        type="search"
                        placeholder="Nhập vào đây...."
                        aria-label="Search"
                        ng-model="searchText"
                />


<%--            </div>--%>
            <h3 id="title">Tất cả sản phẩm</h3>

            <!-- Crad sản phẩm -->
            <div class="row">
                <c:forEach items="${listCTSP}" var="ctsp">
                    <div class="col-4" id="cardSP">

                        <div class="card" style="" id="card-SP">
                            <a href="#dentail/{{dt.id}}"
                            ><img
                                    id="img"
                                    src="/view/assets/a4.jpg"
                                    class="card-img-top"
                                    alt="..."
                            /></a>
                            <div class="card-body">
                                <div class="row">
                                    <p class="card-text" id="tenSP" name="tenSP">${ctsp.sanPham.ten} | Chính Hãng VNA</p>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <p class="card-text" id="giaSP">${ctsp.giaBan} VNĐ</p>
                                    </div>
                                    <div class="col-6">
                                        <img src="/view/assets/img10.gif" alt="" id="icon-hot"/>
                                    </div>
                                </div>
                                <a href="/gio-hang/addGH?id=${ctsp.id}" type="button" class="btn btn-warning">THÊM VÀO
                                    GIỎ HÀNG</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
    </div>
</div>
<%@include file="layout/footer.jsp" %>
</body>
</html>
