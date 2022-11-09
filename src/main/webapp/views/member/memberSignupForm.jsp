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

<%--<script src="/js.common/memberSignupForm.js"></script>--%>

<script>

    let checkId = 0;
    let checkPwd = 0;
    let checkPwdRe = 0;
    let checkPhone = 0;
    let checkMail = 0;


    // 아이디 중복 검사

    const memberId = document.querySelector("#memberId");

    $("[name=memberId]").on("change", function() {
        const memberId = $(this).val();
        const idReg = /^[a-zA-Z0-9]{6,}/;

        const idChkMsg = document.querySelector("#idChkMsg");
        if (idReg.test(memberId)) {
            $.ajax({
                url: "/ajaxCheckId.do",
                type: "get",
                data: { memberId: memberId },
                success: function(data) {

                    if (data == "1") {
                        idChkMsg.innerText = "이미 사용중인 아이디 입니다."
                        checkId = 0;
                    } else if (data == "0") {
                        idChkMsg.innerText = "사용가능한 아이디 입니다."
                        checkId = 1;
                    }
                }
            });

        } else {
            idChkMsg.innerText = "아이디를 6자이상 입력해 주세요."
            checkId = 0;
        }
    });


    //비밀번호 유효성 검사

    const memberPw = document.querySelector("#memberPw");
    const memberPwRe = document.querySelector("#memberPwRe");

    memberPw.addEventListener("change", function() {

        const inputPw = memberPw.value;
        const pwReg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
        const pwChkMsg = document.querySelector("#pwChkMsg");

        const inputPwRe = memberPwRe.value;
        const pwReChkMsg = document.querySelector("#pwReChkMsg");
        if (pwReg.test(inputPw)) {
            pwChkMsg.innerText = "조건이 일치합니다."
            checkPwd = 1;
        } else {
            pwChkMsg.innerText = "조건이 일치하지 않습니다."
            checkPwd = 0;
        }
        if(inputPwRe != ""){
            if(inputPw == inputPwRe){
                pwReChkMsg.innerText = "비밀번호가 일치합니다."
                checkPwdRe = 1;
            }else{
                pwReChkMsg.innerText = "비밀번호가 일치하지않습니다."
                checkPwdRe = 0;
            }
        }else{

        }
    });

    memberPwRe.addEventListener("change", function() {
        const inputPw = memberPw.value;
        const inputPwRe = memberPwRe.value;
        const pwReChkMsg = document.querySelector("#pwReChkMsg");
        if (inputPw == inputPwRe) {

            pwReChkMsg.innerText = "비밀번호가 일치합니다."
            checkPwdRe = 1;
        } else {
            pwReChkMsg.innerText = "비밀번호가 일치하지않습니다."
            checkPwdRe = 0;
        }
    });



    //인증 메일

    let mailCode;
    function sendMail() {
        const memberMail = $("#memberMail").val();
        $.ajax({
            url: "/sendMail.do",
            data: { memberMail: memberMail },
            type: "post",
            success: function(data) {
                if (data != null) {
                    mailCode = data;
                    $("#auth").css("display","flex");

                    authTime();
                }
            }
        });
    }

    let intervalId;
    function authTime() {

        $("#timeZone").html("<span id='min'>3</span> : <span id='sec'>00</span>");
        intervalId = window.setInterval(function() {
            timeCount();
        }, 1000);
    }

    function timeCount() {

        const min = Number($("#min").text());

        const sec = $("#sec").text();
        if (sec == "00") {
            if (min == 0) {
                mailCode = null;
                clearInterval(intervalId);
            } else {
                $("#min").text(min - 1);
                $("#sec").text(59);

            }
        } else {

            const newSec = Number(sec) - 1;
            if (newSec < 10) {

                $("#sec").text("0" + newSec);
            } else {
                $("#sec").text(newSec);
            }
        }
    }

    $("#authBtn").on("click", function() {
        const inputValue = $("#authCode").val();
        if (mailCode != null) {
            if (inputValue == mailCode) {
                $("#authMsg").text("인증에 성공하셨습니다.");

                clearInterval(intervalId);
                $("#timeZone").hide();
                checkMail = 1;
            } else {
                $("#authMsg").text("인증번호가 일치하지 않습니다.");
                checkMail = 0;
            }
        } else {
            $("#authMsg").text("인증시간이 만료되었습니다.");

            checkMail = 0;
        }

    });

</script>

</body>
</html>
