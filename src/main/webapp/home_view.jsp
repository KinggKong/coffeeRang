<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/14/2024
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <link rel="stylesheet" href="static/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <style>
        .item {
            font-size: 26px;
            cursor: pointer;
            color: #8B8B8B;

        }

        ._categories {
            margin-top: 13px;
            margin-bottom: 4px;
            margin-right: 55px;
        }

        .active {
            color: black;
            border-bottom: 3px solid black;
        }
    </style>
</head>
<body>
<!-- start header -->
<div class="_header"
     style="display: flex; width: 100%; justify-content: space-between;background-color: #F9FBE7;  cursor: pointer;">
    <div class="_logo" style="margin-top: 21px; margin-bottom: 14px; margin-left: 101px;">
        <!-- image -->
        <img src="static/image/logo.png" width="128" height="95" alt="">
    </div>
    <div class="_categories" style="display: flex ; gap: 90px;">
        <h4 class="item active" onclick="get_category(event,0)">Introduction</h4>
        <h4 class="item" onclick="get_category(event,1)">Products</h4>
        <h4 class="item" onclick="get_category(event,2)">User Analytics</h4>
        <h4 class="item" onclick="get_category(event,3)">Our Web</h4>
        <h4 class="item" onclick="get_category(event,4)">Planning</h4>
    </div>

</div>
<!-- end header -->
<div id="main_container">
    <div class="_content" id="_content" style="display: flex;">
        <div class="_content_1" style="margin-top: 98px; margin-left: 100px;">
            <div>
                <h3 style="color: #553C1C; font-weight: bold; font-size: 55px;">Lợi ích của cà phê</h3>
            </div>
            <div class="_dicription" style="font-size: 24px; line-height: 48px;">
                <p>Trong cafe có rất nhiều caffeine là một chất có rất nhiều tác dụng tốt với cơ thể, đồng thời các loại
                    khoáng chất và hợp chất có lợi cũng đem lại cho người uống cafe thường xuyên nhiều lợi ích.<br>
                    Nói về tác động có lợi của cafe, người ta có thể kể ra hàng loạt hạng mục như: chống buồn ngủ, giúp
                    tinh thần sảng khoái, thoải mái hơn, ngăn ngừa ung thư, lão hóa, kéo dài tuổi thọ, làm đẹp, giảm
                    cân,… Và rất nhiều lợi ích khác.</p>
            </div>
        </div>
        <div class="_content_2" style="margin-top: 110px; margin-left: 143px; margin-bottom: 107px;">
            <img src="static/image/image1.png" width="817" height="733" alt="">
        </div>


    </div>
</div>
<script src="static/js/index.js"></script>
</body>
</html>
