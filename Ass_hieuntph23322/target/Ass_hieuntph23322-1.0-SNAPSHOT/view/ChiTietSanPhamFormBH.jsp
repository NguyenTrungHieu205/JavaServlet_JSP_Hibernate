<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/29/2023
  Time: 2:35 PM
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
    <link rel="stylesheet" href="/view/css/ChiTietSanPhamFormBH.css">
</head>
<body>
<div id="container">

    <!-- Start	Product details -->
    <div class="product-details">

        <!-- 	Product Name -->
        <h1>Biru Putaran</h1>
        <!-- 		<span class="hint new">New</span> -->
        <!-- 		<span class="hint free-shipping">Free Shipping</span> -->
        <!-- 		the Product rating -->
        <span class="hint-star star">
		<i class="fa fa-star" aria-hidden="true"></i>
		<i class="fa fa-star" aria-hidden="true"></i>
		<i class="fa fa-star" aria-hidden="true"></i>
		<i class="fa fa-star-half-o" aria-hidden="true"></i>
		<i class="fa fa-star-o" aria-hidden="true"></i>
	</span>


        <!-- The most important information about the product -->
        <p class="information">" Especially good for container gardening, the Angelonia will keep blooming all summer even if old flowers are removed. Once tall enough to cut, bring them inside and you'll notice a light scent that some say is reminiscent of apples. "</p>



        <!-- 		Control -->
        <div class="control">

            <!-- Start Button buying -->
            <button class="btn">
                <!-- 		the Price -->
                <span class="price">49 $</span>
                <!-- 		shopping cart icon-->
                <span class="shopping-cart"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>
                <!-- 		Buy Now / ADD to Cart-->
                <span class="buy">Buy Now</span>
            </button>
            <!-- End Button buying -->

        </div>

    </div>

    <!-- 	End	Product details   -->



    <!-- 	Start product image & Information -->

    <div class="product-image">

        <img src="https://sc01.alicdn.com/kf/HTB1Cic9HFXXXXbZXpXXq6xXFXXX3/200006212/HTB1Cic9HFXXXXbZXpXXq6xXFXXX3.jpg" alt="Omar Dsoky">

        <!-- 	product Information-->
        <div class="info">
            <h2>The Description</h2>
            <ul>
                <li><strong>Sun Needs: </strong>Full Sun</li>
                <li><strong>Soil Needs: </strong>Damp</li>
                <li><strong>Zones: </strong>9 - 11</li>
                <li><strong>Height: </strong>2 - 3 feet</li>
                <li><strong>Blooms in: </strong>Mid‑Summer - Mid‑Fall</li>
                <li><strong>Features: </strong>Tolerates heat</li>
            </ul>
        </div>
    </div>
    <!--  End product image  -->


</div>

</body>
</html>
