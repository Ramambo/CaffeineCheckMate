<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="global.dto.Main" %>
<%@ page import="customRecipe.dto.CustomBoardListDto" %>
<%@ page import="favorite.dto.Favorite" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

    <%
	boolean isAuth = request.getSession().getAttribute("AUTH_USER_ID") != null ? true:false;
	pageContext.setAttribute("isAuth", isAuth);
	%>

    <link rel="stylesheet" href="/resources/css/sample.css">
    <link rel="stylesheet" href="/resources/css/custom.css">

<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div{
	float : right;
}
</style>
</head>
<body>


<div id="imgboard">
<c:forEach var="item" items="${main.customBoardListDao}">
 <li>
       <a href="CustomBoardViewHandler.do?CUS_NUM=${item.cus_num}">
       <div>
           <img src="upload/${item.cus_img_realname}" alt="Image" id="img">
           <div class="boardTextBox">
  <%--          <span class="boardTextLeft"><b>${item.m_id} </b></span> 
           <span class="boardTextRight">${item.cus_regdate} </span><br/>
           <span class="boardTextLeft"><b>${item.cus_title}</b></span><br/>
           <span class="boardTextLeft">${item.cus_content}</span> --%>
           </div>
       </div>
       </a>
      </li>
</c:forEach>
</div>

    <!--임시 커피 목록-->
    <h2>임시 커피목록</h2>
	<div class="coffee-box">
		<div class="coffeelist-item" value="C_NO=2"><h4 style="display: inline;">카페라떼</h4><button style="display: inline-block;" class="addFav-btn">+</button></div>
		<div class="coffeelist-item" value="C_NO=1"><h4 style="display: inline;">아메리카노</h4><button style="display: inline-block;" class="addFav-btn">+</button></div>
		<div class="coffeelist-item" value="C_NO=3"><h4 style="display: inline;">그린티</h4><button style="display: inline-block;" class="addFav-btn">+</button></div>
		<div class="coffeelist-item" value="C_NO=4"><h4 style="display: inline;">밀크티</h4><button style="display: inline-block;" class="addFav-btn">+</button></div>
		<div class="coffeelist-item" value="C_NO=5"><h4 style="display: inline;">아이스아메리카노</h4><button style="display: inline-block;" class="addFav-btn">+</button></div>
	</div>

	<div class="calc-area">
		<!--계산기 include 부분 -->
		<jsp:include page="/views/components/calculator.jsp"></jsp:include>
	</div>

	<div class="fav-area">
		<!--즐겨찾기 include 부분-->
		<jsp:include page="/views/components/favorites.jsp"></jsp:include>
	</div>

</body>

<script>
	let calcResult = "${main.calculationResult}";
	const isAuth = "${isAuth}"==="true"? true : false;
	console.log("html : ",isAuth);
</script>

<script src="https://unpkg.com/react@17.0.2/umd/react.production.min.js"></script>
<script src="https://unpkg.com/react-dom@17.0.2/umd/react-dom.production.min.js"></script> 
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script> 

<script src="https://kit.fontawesome.com/9e2cfcdf3a.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/progressbar.js@1.1.1/dist/progressbar.min.js" integrity="sha256-CjGwkk3nsu5BkdGgSjediSja+n8zB6HARhF/eZxtO0g=" crossorigin="anonymous"></script>

<script src="/resources/js/favoritelist.js" type="text/babel"></script>
<script src="/resources/js/calculator.js"></script>

</html>