<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/24/2023
  Time: 3:17 PM
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
    <link rel="stylesheet" href="/view/css/TrangCuaToi.css">
</head>
<body>
<%@include file="layout/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-3" id="menudoc">
            <nav class="navbar">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/trang-chu">Trang Chủ</a>
                </div>
            </nav>
            <nav class="navbar">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/chi-tiet-san-pham/hien-thi">Quản lý Sản Phẩm</a>
                </div>
            </nav>
            <nav class="navbar">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/khach-hang/hien-thi">Quản lý Khách Hàng</a>
                </div>
            </nav>
            <nav class="navbar">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/nhan-vien/hien-thi">Quản lý Nhân Viên</a>
                </div>
            </nav>
            <nav class="navbar">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#dangXuat" ng-click="dangXat($event)">Đăng Xuất</a>
                </div>
            </nav>

        </div>
        <div class="col-9">
            <div class="row">
                <div class="col-sm-6 mb-3 mb-sm-0" id="member">
                    <div class="card" >
                        <img src="/view/assets/av-member.jpg" alt="" id="avata-member">
                        <div id="name-member"></div>
                        <div class="row">
                            <div class="col-4">
                                <h6 id="icon">Ngày tham gia</h6>
                                <img id="icon-member" src="/view/assets/icon-lich.png" alt="">
                                <h6 id="icon">8/1/2023</h6>
                            </div>
                            <div class="col-4">
                                <h6 id="icon">Hạng thành viên</h6>
                                <img id="icon-member" src="/view/assets/icon-huychuong.png" alt="">
                                <h6 id="icon">SNull</h6>
                            </div>
                            <div class="col-4">
                                <h6 id="icon">Điểm tích lũy
                                    từ 01/01/2022</h6>
                                <img id="icon-member" src="/view/assets/icon-tien.png" alt="">
                                <h6 id="icon">230,000 đ</h6>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6" >
                    <div class="card" id="chuongtrinhuudai">
                        <button type="button" class="btn btn-danger" id="chuongtrinh">
                            CHƯƠNG TRÌNH NỔI BẬT
                        </button>
                        <img id="banner-chuongtrinh" src="/view/assets/bn1.jpg" id="bn-trangcuatoi" alt="" width="320px" height="190px"/>
                        <h4 id="tenChuongTrinh">UƯ ĐÃI CỰC SỐC</h4>
                    </div>
                </div>
            </div>
            <div class="row">
                <h4 id="tenqc">ƯU ĐÃI THANH TOÁN</h4>
            </div>
            <div class="row">
                <div class="col-4">
                    <img src="/view/assets/thanhtoan1.jpg" alt="" id="bn" />
                </div>
                <div class="col-4">
                    <img src="/view/assets/thanhtoan2.jpg" alt="" id="bn" />
                </div>
                <div class="col-4">
                    <img src="/view/assets/thanhtoan3.jpg" alt="" id="bn" />
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="layout/footer.jsp" %>
</body>
</html>
