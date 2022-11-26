<%@ page import="tk.newsoulmate.web.manger.site.service.ManageService" %>
<%@ page import="tk.newsoulmate.domain.vo.Subscription" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 상엽
  Date: 2022-11-24
  Time: 오후 3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Subscription s = new Subscription();

%>

<html>
<head>
    <title>입양신청서확인</title>
    <link href="<%=request.getContextPath()%>/css/manager/managerAdoptApplyDetail.css" rel="stylesheet">
    <%@ include file="/views/template/styleTemplate.jsp"%>
</head>
<body>
<header><%@include file="/views/manager/managerHeader.jsp"%></header>

<div class="headcontainer">
    <div id="right_view">
        <div id="adoptApplyDetail">
            <br>
            <br>
            <table class="check-area" style="text-align: center">

                <tr width="150">
                    <th>공고 번호</th>
                    <td>${n.desertionNo}</td>
                </tr>

                <tr width="150">
                    <th>신청인</th>
                    <td>${s.name}</td>
                </tr>

                <tr width="150">
                    <th>보호소 이름</th>
                    <td>${n.careNm}</td>
                </tr>
                <tr width="150">
                    <th>보호소 연락처</th>
                    <td>${n.officetel}</td>
                </tr>
                <tr width="150">
                    <th>입양 희망일</th>
                    <td>${s.wishDate}</td>
                </tr>
                <tr width="150">
                    <th>신청인 전화번호</th>
                    <td>${s.telNum}</td>
                </tr>
                <tr width="150">
                    <th>신청일자</th>
                    <td>${s.subDate}</td>
                </tr>
                <tr width="150">
                    <th>성별</th>
                    <td>
                        <c:if test="${s.gender eq 'M'}">남자</c:if>
                        <c:if test="${s.gender eq 'F'}">여자</c:if>
                    </td>
                </tr>
            </table>
            <br><br>
            <h4>입양을 결정하게 된 이유</h4>
            <p>${s.adoptReason}</p>
            <h4>가족 구성원의 반대가 없었는지?</h4>
            <p>${s.familyAgreement}</p>
            <h4>입양해 간 아이가 많이 아프다면?</h4>
            <p>${s.whenSick}</p>
            <h4>평생 사랑으로 책임질 수있는지?</h4>
            <p>${s.bigDuty}</p>


            <form action="${context}/adoptApplySubRead" type="post">
                <input type="hidden" name="sno" value="${s.subNo}">
                <input type="hidden" name="subRead" value="${s.subRead}">
                <input type="submit" id="confirm" value="확인" class="btn btn-danger btn-sm">
            </form>
        </div>
    </div>
</div>


</body>
</html>
