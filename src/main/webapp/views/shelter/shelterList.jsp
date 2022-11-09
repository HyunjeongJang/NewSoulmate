<%@ page import="java.util.ArrayList" %>
<%@ page import="tk.newsoulmate.domain.vo.Shelter" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="tk.newsoulmate.domain.vo.City" %>
<%@ page import="tk.newsoulmate.domain.vo.Village" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022-11-08
  Time: 오후 6:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Shelter> sList = (ArrayList<Shelter>) request.getAttribute("sList");
    ArrayList<City> cList = (ArrayList<City>)request.getAttribute("cList");
    ArrayList<Village> vList = (ArrayList<Village>)request.getAttribute("vList");

%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>보호소리스트</title>
    <style>
        .list-area{
            border: 1px solid black;
            text-align:center;
        }
    </style>
</head>
<body>
<%@include file="/views/templet/menubar.jsp"%>

    <form>
        <table>
            <tr>
            <td>시도</td>
                <td>
                    <select id="mainCategory" onchange="choice();">
                        <% for(City c: cList){ %>
                            <option value="<%=c.getCityNo()%>"><%=c.getCityName()%></option>
                        <% } %>
                    </select>
                </td>

                <td>시군구</td>
                <td>
                    <select id="subCategory" onchange="choice2();">
                       <option>--전체--</option>
                    </select>
                </td>

                <td>보호소명</td>
                <td>
                    <select id="subCategory2">
                        <option>--전체--</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox">봉사가능한 보호소만 조회
                </td>
                <td>
                    <input type="submit" value="조회">
                </td>
            </tr>
        </table>
    </form>
    <script>
        function choice(){
            // 메인페이지 선택시 서브쿼리 삭제
            $("#subCategory").html("");
            // 삭제후 선택 option 넣기
            //$("#subCategory").children().remove();
            $("#subCategory").html("<option value=''>전체</option>");

            $.ajax({
                url : "jqAjaxCity",
                data :  {city :$("#mainCategory").val()},
                success : function (result) {
                    console.log(result,"어라?") ;
                    let str = '';
                for (let i = 0; i < result.length; i++) {
                    str += "<option value="+result[i].villageNo+">" + result[i].villageName+"</option>"
                }
                $("#subCategory").html(str);

            }
            })
        }

        function choice2(){
            // 서브카테고리 선택시 카테고리 2 비우기
            $("#subCategory2").html("");
            // 삭제 후 옵션 넣기
            $("#subCategory2").html("<option value=''>전체</option");

            $.ajax({
                url : "jqAjaxVillage",
                data : {village : $("#subCategory").val()},
                success : function (result){
                    let str ='';
                    console.log(result,'어랏')
                    for(let i = 0; i<result.length;i++){
                        str += "<option>"+result[i].shelterName + "</option>"
                    }
                    $("#subCategory2").html(str);
                }
            })
        }

    </script>
    <table class="list-area">
        <thead>
            <tr>
                <th>보호소명</th>
                <th>보호소 주소</th>
                <th>보호소 전화번호</th>
            </tr>
        </thead>
        <tbody>
            <%for(Shelter s : sList){ %>
                <tr>
                    <td><%= s.getShelterName() %></td>
                    <td><%= s.getShelterAddress() %></td>
                    <td><%= s.getShelterLandline() %></td>
                    </tr>
            <% } %>
        </tbody>
    </table>


</body>
</html>