<%--
  Created by IntelliJ IDEA.
  User: gram
  Date: 2022-11-09
  Time: 오후 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 약관동의</title>
</head>
<body>

<%@include file="/views/templet/menubar.jsp"%>

<div class="content-wrap">

    <div class="content-box">
        <div class="title-wrap">
            <h2>회원가입</h2>
        </div>


        <div class="agree">
            <label><input type="checkbox" name="agreeCheckBox">이용약관의
                내용에 모두 동의합니다.</label>
        </div>

        <div class="agree">
            <label><input type="checkbox" name="agreeCheckBox1" required>이용약관에 동의합니다. (필수)</label>
        </div>

        <div class="signup-content">
            <div class="center-move">
                <textarea readonly class="textarea-form">

                    이용약관


                </textarea>

            </div>

            <div class="agree">
                <label><input type="checkbox" name="agreeCheckBox1" required>개인정보 수집약관의 내용에 동의합니다.(필수)</label>
            </div>

            <div class="center-move">
                <textarea readonly class="textarea-form">

                    개인정보 수집약관


                </textarea>

            </div>


            <div class="center-move">
                <button class="btn2 agreeBtn cancelBtn">취소</button>
                <button class="btn2 agreeBtn nextBtn">다음</button>
            </div>
        </div>


<%@include file="/views/templet/footer.jsp"%>

</body>
</html>
