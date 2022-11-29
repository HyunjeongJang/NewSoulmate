<%@ page import="java.util.ArrayList" %>
<%@ page import="tk.newsoulmate.domain.vo.Shelter" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-11-11
  Time: 오후 3:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Shelter s= (Shelter)request.getAttribute("s");

%>
<html>
<head>
    <title>보호소 상세 페이지</title>
    <%@ include file="/views/template/styleTemplate.jsp"%>
    <link href="<%=request.getContextPath()%>/css/shelter/shelterDetailView.css" rel="stylesheet">
</head>
<body>
<%@include file="/views/template/menubar.jsp"%>

<div id="content">
    <div id="name">
        <%=s.getShelterName()%>
    </div>
    <table id="list-area">
        <tr>
            <th>보호소명</th>
            <td>
                <%=s.getShelterName()%>
            </td>
            <th>전화번호</th>
            <td>
                <%=s.getShelterLandline()%>
            </td>
        </tr>
        <tr>
            <th>주소</th>
            <td colspan="3">
                <%=s.getShelterAddress()%>
            </td>
        </tr>
    </table>
    <div id="map"></div>
    <div id="listBtn">
        <button onclick="location.href='<%=request.getContextPath()%>/shelterList;'">목록으로 돌아가기</button>
    </div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=25a11b9a945a1d444011113fe431e818&libraries=services"></script>
<script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    // 지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);

    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new kakao.maps.services.Geocoder();

    // 주소로 좌표를 검색합니다
    geocoder.addressSearch("<%=s.getShelterAddress()%>", function(result, status) {

        // 정상적으로 검색이 완료됐으면
        if (status === kakao.maps.services.Status.OK) {

            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new kakao.maps.Marker({
                map: map,
                position: coords
            });

            // 인포윈도우로 장소에 대한 설명을 표시합니다
            var infowindow = new kakao.maps.InfoWindow({
                content: '<div style="width:150px;text-align:center;padding:6px 0;"><%=s.getShelterName()%></div>'
            });
            infowindow.open(map, marker);

            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        }
    });
</script>




</body>
</html>
