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
    <title>Chức Vụ</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

</head>
<body>
<%@include file="layout/header.jsp" %>
    <div class="container">

        <h3 style="text-align: center">Chức Vụ</h3>
        <form action="/chuc-vu/add" method="post">
<%--            <div class="form-group">--%>
<%--                <label for="exampleInputEmail1">ID</label>--%>
<%--                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="id">--%>
<%--            </div>--%>
            <div class="form-group">
                <label for="exampleInputPassword1">Mã</label>
                <input type="text" class="form-control" id="exampleInputPassword1" name="pass">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Tên</label>
                <input type="text" class="form-control" id="" name="name">
            </div>
            <button type="submit" class="btn btn-info">Thêm</button>
        </form>
        <table class="table table-dark table-striped-columns">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCV}" var="cv">
                <tr>
                    <th scope="row">${cv.id}</th>
                    <td>${cv.ma}</td>
                    <td>${cv.ten}</td>
                    <td>
                        <a href="/chuc-vu/delete?id=${cv.id}" type="button" class="btn btn-danger">Remove</a>
                        <a href="/chuc-vu/detail?id=${cv.id}" type="button" class="btn btn-warning">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="/nhan-vien/hien-thi" type="button" class="btn btn-warning">QUAY LẠI</a>
    </div>

    <%@include file="layout/footer.jsp" %>
</body>
</html>
