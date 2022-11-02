<%@ page import="java.util.ArrayList" %>
<%@ page import="tk.newsoulmate.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: jinunghwi
  Date: 2022/11/02
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Member> lis=(ArrayList<Member>) request.getAttribute("list");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>응가</h1>
    <%
        for (Member m:
             lis) {%>

            <%=m.getUserName()%>


        <%}%>
</body>
</html>
