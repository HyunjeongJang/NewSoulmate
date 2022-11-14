<%--
 Created by IntelliJ IDEA.
 User: 상엽
 Date: 2022-11-11
 Time: 오전 2:27
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="tk.newsoulmate.domain.vo.Category" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<Category> list = (ArrayList<Category>) request.getAttribute("list");
%>

<%
    String alertMsg = (String)session.getAttribute("alertMsg");
    // 서비스 요청 전 : null
    // 서비스 요청성공 후 : alert로 띄어줄 메시지 문구.
%>

<html>
<head>
    <title>1:1 문의 등록페이지</title>
    <%@ include file="/views/template/styleTemplate.jsp"%>
</head>
<body>
    <%@include file="/views/template/menubar.jsp"%>
    <div class="outer">
        <br>
        <h2 style="text-align:center;">1:1 문의</h2>
        <br>
        <hr>
        <br>

        <form action="<%=request.getContextPath() %>/inquireInsert.bo" method="post" enctype="multipart/form-data">
            <!-- 카테고리, 제목, 내용, 첨부파일을 입력받고, 작성자의 회원번호는 hidden으로 넘기기. -->
<%--            <input type="hidden" name="userNo" value="<%=loginUser.getUserNo() %>">--%>
            <table align="center">
                <tr>
                    <th width="100">카테고리*</th>
                    <td width="500">
                        <select name="category">

                            <% for(Category c : list) { %>
                            <option value="<%= c.getCategoryNo() %>"><%= c.getCategoryName() %></option>

                            <%} %>

                        </select>
                    </td>
                </tr>

                <tr>
                    <th>제목*</th>
                    <td><input type="text" name="title" required></td>

                </tr>

                <tr>
                    <th>문의내용*</th>
                    <td>
                        <textarea name="content" id="" cols="30" rows="10" required></textarea>
                    </td>
                </tr>

                <tr>
                    <th>첨부파일</th>
                    <td><input type="file" name="upfile"></td>
                </tr>
            </table>

            <br>

            <div align="right" style="margin-right: 200px;">
<%--                <button type="reset" class="btn btn-secondary btn-sm">취소하기</button>--%>
                <a href="<%=request.getContextPath()%>/inquire" class="btn btn-secondary btn-sm">취소하기</a>
                <button type="submit" class="btn btn-secondary btn-sm">작성하기</button>

            </div>
        </form>

    </div>
    <script>
        let msg = "<%= alertMsg %>"; // let msg = 성공적으로 로그인이 되었습니다.

        if(msg != "null") {
            alert(msg);
            // 알림창을 띄워준 후 session에 담긴 해당메세지는 지워줘야함.
            // 안그러면 menubar.jsp가 로딩될때마다 매번 alert가 계속 뜰 것.

            <% session.removeAttribute("alertMsg");%>
        }

    </script>
    <%@include file="/views/template/footer.jsp"%>
</body>
</html>
