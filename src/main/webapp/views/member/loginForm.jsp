<%--
  Created by IntelliJ IDEA.
  User: jinunghwi
  Date: 2022/11/07
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>

<%@include file="/views/templet/menubar.jsp"%>

<div class="content-wrap">
    <div class="title-wrap">
        <h2>로그인</h2>
    </div>
    <div class="content-box">
        <form action="/login.do" method="post">
            <table class="tbl">
                <tr>
                    <th><label for="loginId">아이디</label></th>
                    <td><input class="input-form" type="text" name="loginId" id="loginId" placeholder="아이디"></td>
                </tr>
                <tr>
                    <th><label for="loginPw">비밀번호</label></th>
                    <td> <input class="input-form" type="password" name="loginPw" id="loginPw"placeholder="비밀번호"></td>
                </tr>
                <tr>
                    <th colspan="2"><a href="searchMember.do">아이디/비밀번호 찾기</a></th>
                </tr>
                <tr>
                    <th colspan="2">
                    </th>
                </tr>
                <tr>
                    <th colspan="2"><button type="submit" class="btn3">로그인</button></th>
                </tr>
            </table>
        </form>
    </div>
</div>

<%@include file="/views/templet/footer.jsp"%>



</body>
</html>







