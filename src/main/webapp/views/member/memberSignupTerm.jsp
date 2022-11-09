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
    <title>회원가입 약관</title>
</head>
<body>

<%@include file="/views/templet/menubar.jsp"%>

<div>
    <div>
        <div>
            <h2>회원가입</h2>
        </div>

        <div class="agree">
            <label><input type="checkbox" name="agreeCheckBox" class="allcheck">이용약관의 내용에 모두 동의합니다.</label>
        </div>

        <div class="agree">
            <label><input type="checkbox" name="agreeCheckBox" required>이용약관에 동의합니다.(필수)</label>
        </div>

        <div>
            <div>
                <textarea readonly class="textarea-form">

                    이용약관

                </textarea>
            </div>

            <div class="agree">
                <label><input type="checkbox" name="agreeCheckBox" required>개인정보 수집약관의 내용에 동의합니다.(필수)</label>
            </div>

            <div>
                <textarea readonly class="textarea-form">

                    개인정보 수집약관

                </textarea>
            </div>


            <div>
                <button id="cancelBtn"><a href="MainPage.jsp">취소</a></button>
                <button id="signupBtn"><a href="memberSignupForm.jsp">가입하기</a></button>
            </div>
        </div>
    </div>
</div>



<%@include file="/views/templet/footer.jsp"%>

<script>

    $(function(){
        $("[type=checkbox][name=agreeCheckBox]").on("change", function(){
            const check = $(this).prop("checked");

            if($(this).hasClass("allcheck")){
                $("[type=checkbox][name=agreeCheckBox]").prop("checked", check);


            }else{
                const all = $("[type=checkbox][name=agreeCheckBox].allcheck");
                const allcheck = all.prop("checked")
                if(check != allcheck){
                    const len = $("[type=checkbox][name=agreeCheckBox]").not(".allcheck").length;
                    const ckLen = $("[type=checkbox][name=agreeCheckBox]:checked").not(".allcheck").length;
                    if(len === ckLen){
                        all.prop("checked", true);
                    }else{
                        all.prop("checked", false);
                    }
                }
            }
        });
    });




/*    // 체크박스 선택이 됐을때만 회원가입 버튼 활성화
    $("#signupBtn").on("click", function() {
        if (idx == 1) {
            if ($("input:checkbox[name = agreeCheckBox]").is(":checked") == true) {
                for (let i = 0; i < idx; i++) {
                    $("#signupBtn").eq(i).disable();
                }
                $("#signupBtn").eq(idx).show();
            } else {

            }

        }
    });*/





</script>



</body>
</html>
