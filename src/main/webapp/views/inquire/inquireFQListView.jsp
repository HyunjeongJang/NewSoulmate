<%--
  Created by IntelliJ IDEA.
  User: 상엽
  Date: 2022-11-08
  Time: 오후 5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>고객센터 FAQ,Q&A</title>
    <script src="../../css/inquire/inquireFQ.css"></script>
</head>
<body>
    <%@include file="../templet/menubar.jsp"%>
    <div id="FQ_bt">
        <button id="faq_bt" class="btn btn-secondary">FAQ</button> <button id="qna_bt" class="btn btn-secondary">Q&A</button><br>
    </div>
    <div id="Fcontent">

        <h3>자주 묻는 질문</h3>

        <div> 유기동물을 발견했어요</div>
        <p> 유기동물을 발견하셨다면 120번 또는 해당 구청 담당부서로 연락주세요!</p>

        <div> 자원봉사는 어떻게 신청하나요?</div>
        <p> 상단바에 봉사페이지를 이용해주세요</p>

        <div> 후원금은 어떻게 사용되나요?</div>
        <p> 잘 이용됩니다.</p>

        <div> 어떤 동물들이 있는지 궁금합니다.</div>
        <p> 개, 고양이등 기타 동물들이 있습니다.</p>
    </div>
    <div id="Qcontent" style="display: none;">
        <h3> 1:1 문의</h3>
        <br>
        <div id="box1" style="float: left;"><input type="checkbox" id="" >나의 문의내역 보기</div>
<%--        <div id="box2" style="float: right;"><button id="write_bt" style="background-color: gray; color:white;" class="btn btn-secondary" >글쓰기</button></div>--%>
        <br><br>
        <%if(loginUser != null) { %>
        <div align="right" style="width: 850px;">
            <a href="<%=contextPath%>/enrollForm.bo" class="btn btn-secondary">글작성</a>
            <br>
            <br>
        </div>
        <% } %>
        <table align="center" class="list-area">
            <thead>
            <tr>
                <th width="70">글번호</th>
                <th width="75">카테고리</th>
                <th width="300">제목</th>
                <th width="100">작성자</th>
                <th width="50">조회수</th>
                <th width="100">작성일</th>
            </tr>
            </thead>
            <tbody>
            <% if(list.isEmpty()){ %>
            <tr>
                <td colspan="6">조회된 리스트가 없습니다</td>
            </tr>
            <% } else { %>
            <% for(Board b : list) { %>
            <tr>
                <td><%= b.getResultStatus() %></td>
                <td><%= b.getBoardNo() %></td>
                <td><%= b.getBoardTitle() %></td>
                <td><%= b.getCreateDate() %></td>
                <td><%= b.getMemberName() %></td>
            </tr>
            <% } %>
            <% } %>
            </tbody>

        </table>

    </div>
    <script>
        $(function(){
            $(document).on("click", "#Fcontent div" ,function(){
                let $p = $(this).next();

                if($p.css("display") == "none"){
                    $p.siblings("p").slideUp();
                    $p.slideDown(100);

                }else{
                    $p.slideUp(100);
                }

            });
        });

        $(function(){
            $("#faq_bt").on("click", function(){
                $(this).css("color", "#f8f5f2")
                $(this).css("background-color", "#f45d48")
                $("#qna_bt").css("color", "black")
                $("#qna_bt").css("background-color", "lightgray")
                $("#Fcontent").css("display", "block")
                $("#Qcontent").css("display", "none")
            });
        });

        $(function(){
            $("#qna_bt").on("click", function(){
                $(this).css("color", "#f8f5f2")
                $(this).css("background-color", "#f45d48")
                $("#faq_bt").css("color", "black")
                $("#faq_bt").css("background-color", "lightgray")
                $("#Fcontent").css("display", "none")
                $("#Qcontent").css("display", "block")
            });
        });



    </script>




</body>
</html>
