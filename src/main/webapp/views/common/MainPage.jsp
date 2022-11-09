<%--
  Created by IntelliJ IDEA.
  User: jinunghwi
  Date: 2022/11/08
  Time: 3:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta >
    <title>메인화면-환승주인</title>

</head>
<body>

</body>
</html>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>Slick</title>
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
    <style>
        img {
            max-height: 150px;
            max-width: 80px;
            height: auto;
            margin-top: 30px;
        }
        .slider {
            height: 200px;
            width: 600px;
            margin: 0px auto;
            background-color: rgba(255, 99, 71, 0.708);
            border-radius: 25px;
        }
        .slick-prev:before, .slick-next:before {
            color: darkcyan;
        }
    </style>
</head>
<body>
<%@include file="/views/templet/menubar.jsp"%>
<script>
    $( document ).ready( function() {
        $( '.slider' ).slick( {
            autoplay: true,
            autoplaySpeed: 2000,
            slidesToShow : 5,
            infinite : true,
            dots : true,
        } );
    } );
</script>
<main>
    <div class="slider">
        <div><img src="" alt="">사진1</div>
        <div><img src="" alt="">사진2</div>
        <div><img src="image/flower3.jpg" alt="">꽃사진3</div>
        <div><img src="image/flower4.jpg" alt="">꽃사진4</div>
        <div><img src="image/flower5.jpg" alt="">꽃사진5</div>
        <div><img src="image/bono.jpg" alt="">보노보노</div>
    </div>
</main>
<%@include file="/views/templet/menubar.jsp"%>
</body>

</html>