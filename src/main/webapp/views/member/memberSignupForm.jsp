<%--
  Created by IntelliJ IDEA.
  User: gram
  Date: 2022-11-09
  Time: 오후 4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>

<%@include file="/views/templet/menubar.jsp"%>

<div class="signup-content">
    <div class="center-move">

        <div>
            <form action="/signup.do" method="post">

                <div>
                    <div>
                        <label for="memberId">아이디 <span id="ajaxCheckId"></span></label>
                        <input type="text" name="memberId" id="memberId" placeholder="*아이디">
                        <button type="button" onclick="idChkMsg();">중복확인</button>
                    </div>
                </div>

                <div>
                    <div>
                        <label for="memberPw">비밀번호</label>
                        <input type="password" name="memberPw" id="memberPw" placeholder="*비밀번호">
                        <span id="pwChkMsg"></span>
                    </div>
                </div>

                <div>
                    <div>
                        <label for="memberPw">비밀번호 확인</label>
                        <input type="password" name="memberPwRe" id="memberPwRe" placeholder="*비밀번호 재입력">
                        <span id="pwReChkMsg"></span>
                    </div>
                </div>

                <div>
                    <div>
                        <label for="memberName">이름</label>
                        <input type="text" name="memberName" id="memberName" placeholder="*이름">
                    </div>
                </div>

                <div>
                    <div>
                        <label for="nickname">닉네임</label>
                        <input type="text" name="nickname" id="nickname" placeholder="*닉네임">
                        <button type="button" onclick="nicknameCheck();">중복확인</button>
                    </div>
                </div>

                <div>
                    <div>
                        <label for="memberPhone">전화번호</label>
                        <select name="phoneNum" id="phoneNum">
                            <option value="010">010</option>
                            <option value="011">011</option>
                            <option value="016">016</option>
                            <option value="019">019</option>
                        </select>
                        <input type="text" name="memberPhone" id="memberPhone" placeholder="-빼고 입력">
                        <span id="phoneChkMsg"></span>
                    </div>
                </div>

                <div>
                    <div>
                        <label for="memberMail">이메일</label>
                        <input type="text" name="memberMail" id="memberMail" placeholder="*이메일">
                        <button onclick="sendMail();" class="btn3 notsubmit">인증번호 발송</button>

                        <div id="auth">
                            <div>
                                <input type="text" id="authCode" placeholder="인증번호">
                                <button class="btn3 notsubmit" id="authBtn">인증하기</button>
                            </div>
                        </div>
                    </div>
                </div>

                <span id="timeZone"></span>
                <span id="authMsg"></span>

                <div class="center-move">
                    <button type="button" class="btn2 cancelBtn">취소</button>
                    <button type="submit" class="btn2 signUpBtn">회원가입</button>
                </div>
            </form>

        </div>
    </div>
</div>

<%@include file="/views/templet/footer.jsp"%>


</body>
</html>
