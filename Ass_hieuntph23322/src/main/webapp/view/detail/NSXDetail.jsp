<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/25/2023
  Time: 10:23 AM
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
        <h3 style="text-align: center">Nhà Sản Xuất</h3>
        <form action="/nha-san-xuat/update" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">ID</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="id" value="${listN.id}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Mã</label>
                <input type="text" class="form-control" id="exampleInputPassword1" name="pass" value="${listN.ma}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Tên</label>
                <input type="text" class="form-control" id="" name="name" value="${listN.ten}">
            </div>
            <button type="submit" class="btn btn-info">Update</button>
        </form>
    </div>
</body>
</html>
