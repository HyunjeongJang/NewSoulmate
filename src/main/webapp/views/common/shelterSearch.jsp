<%@ page import="tk.newsoulmate.domain.vo.City" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="tk.newsoulmate.domain.vo.Village" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-11-18
  Time: 오후 5:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<City> cList = (ArrayList<City>)request.getAttribute("cList");
    ArrayList<Village> vList = (ArrayList<Village>)request.getAttribute("vList");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="search">
    <form action="<%=request.getContextPath()%>/updateShelter" method="get">
        <table id="searchBox">
            <tr>
                <td>시도</td>
                <th>
                    <select name="cityNo" id="mainCategory" onchange="choice();">
                        <option value="0">--전체--</option>
                        <% for(City c: cList){ %>
                        <option value="<%=c.getCityNo()%>">
                            <%=c.getCityName()%>
                        </option>
                        <% } %>
                    </select>
                </th>

                <td>시군구</td>
                <th>
                    <select name="villageNo" id="subCategory">
                        <option value="0">--전체--</option>
                    </select>
                </th>
                <td>
                    <button type="submit">조회</button>
                </td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>
