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

<div align="center">
    <div>
        <div>
            <h2>회원가입</h2>
        </div>

        <div class="agree">
            <label><input type="checkbox" name="agreeCheckBox" class="allcheck">이용약관의
                내용에 모두 동의합니다.</label>
        </div>

        <div class="agree">
            <label><input type="checkbox" name="agreeCheckBox1" required>이용약관에 동의합니다. (필수)</label>
        </div>

        <div>
            <div>
                <textarea readonly class="textarea-form">

                    이용약관

                </textarea>
            </div>

            <div class="agree">
                <label><input type="checkbox" name="agreeCheckBox1" required>개인정보 수집약관의 내용에 동의합니다.(필수)</label>
            </div>

            <div>
                <textarea readonly class="textarea-form">

                    개인정보 수집약관

                </textarea>
            </div>


            <div>
                <button class="btn2 agreeBtn cancelBtn"><a href="MainPage.jsp">취소</a></button>
                <button class="btn2 agreeBtn nextBtn"><a href="memberSignupForm.jsp">가입하기</a></button>
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


</script>

</body>
</html>
