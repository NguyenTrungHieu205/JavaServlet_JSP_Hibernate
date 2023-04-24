<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/22/2023
  Time: 8:26 PM
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
<div class="container">
    <div class="row" id="timKiem">

        <input
                class="form-control me-2"
                type="search"
                placeholder="Nhập vào đây...."
                aria-label="Search"
                ng-model="search"
        />


    </div>
    <div class="row" id="banner">
        <div id="carouselExample" class="carousel slide">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="/view/assets/banner1.png" class="d-block w-100" alt="..." />
                </div>
                <div class="carousel-item">
                    <img src="/view/assets/banner2.png" class="d-block w-100" alt="..." />
                </div>
                <div class="carousel-item">
                    <img src="/view/assets/banner3.png" class="d-block w-100" alt="..." />
                </div>
            </div>
            <button
                    class="carousel-control-prev"
                    type="button"
                    data-bs-target="#carouselExample"
                    data-bs-slide="prev"
            >
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button
                    class="carousel-control-next"
                    type="button"
                    data-bs-target="#carouselExample"
                    data-bs-slide="next"
            >
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
    <h3 id="tieude-dienthoai">MẪU ĐIỆN THOẠI BÁN CHẠY</h3>
    <hr id="duongKe" />
    <div class="row">
    <c:forEach items="${listCTSP}" var="ctsp">
        <div class="col-4" id="cardSP" >

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
                                <img src="/view/assets/img10.gif" alt="" id="icon-hot" />
                            </div>
                        </div>
                        <a href="/gio-hang/addGH?id=${ctsp.id}" type="button" class="btn btn-warning">THÊM VÀO GIỎ HÀNG</a>
                    </div>
                </div>
        </div>
        </c:forEach>
    </div>

    <div class="row">
        <h4 id="tenqc">CHUYÊN TRANG THƯƠNG HIỆU</h4>
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
    <div class="row">
        <h4 id="tenqc">ƯU ĐÃI THANH TOÁN</h4>
    </div>
    <div class="row">
        <div class="col-3">
            <img src="/view/assets/thanhtoan1.jpg" alt="" id="bn" />
        </div>
        <div class="col-3">
            <img src="/view/assets/thanhtoan2.jpg" alt="" id="bn" />
        </div>
        <div class="col-3">
            <img src="/view/assets/thanhtoan3.jpg" alt="" id="bn" />
        </div>
        <div class="col-3">
            <img src="/view/assets/thanhtoan4.png" alt="" id="bn" />
        </div>
    </div>

</div>
<%@include file="layout/footer.jsp" %>
</body>
</html>
