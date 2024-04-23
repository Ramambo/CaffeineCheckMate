<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="global.dto.Main" %>
<%@ page import="favorite.dto.Favorite" %>
<%@ page import="mypage.dto.MypagesDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<!-- <%
	boolean isAuth = request.getSession().getAttribute("AUTH_USER_ID") != null ? true:false;
	pageContext.setAttribute("isAuth", isAuth);
	%>
	<% 
	if(request.getAttribute("mypages")!=null) {		
	MypagesDTO main = (MypagesDTO)request.getAttribute("mypages");
	pageContext.setAttribute("main", main);
	}
	%>
	<link href="https://fonts.googleapis.com/css?family=Raleway:400,300,600,800,900" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/progressbar.js@1.1.1/local-dev/main.min.css"> -->
	<meta charset="UTF-8">
	<meta http-equiv="Compatible" content="no-cache"/>
</head>
<body>
	
	<c:choose>
		<c:when test="${isAuth}">
			<h2>즐겨찾기목록</h2>
		</c:when>
		<c:when test="${!isAuth}">
			<h2>즐겨찾기 많은 커피 5개</h2>
		</c:when>
	</c:choose>
	<div class="fav-pop-box">
		<c:choose>
			<c:when test="${isAuth}">
				<div class="fav-box">
					<c:forEach var="favorite" items="${main.favorites}">
						<div class="fp-item" id="fi_${favorite.key}" value="C_NO=${favorite.key}">
							<div class="fp-item__box clickable">
								<div class="fp-item__img clickable">이미지 이름 : ${favorite.value.c_IMAGE}</div>
								<div class="fp-item__info clickable">커피 이름 : ${favorite.value.c_NAME}</div>
							</div>
							<button class="fp-item__delete-btn clickable"><i class="fa-solid fa-x"></i></button>
						</div>
					</c:forEach>
				</div>
			</c:when>
			<c:when test="${!isAuth}">
				<div class="popular-box">
					<c:forEach var="popular" items="${main.favorites}">
						<div class="fp-item" id="fi_${popular.key}" value="${popular.value.c_CAFFEINE}">
							<div class="fp-item__box clickable">
								<div class="fp-item__img clickable">이미지 이름 : ${popular.value.c_IMAGE}</div>
								<div class="fp-item__info clickable">커피 이름 : ${popular.value.c_NAME}</div>
							</div>
						</div>
					</c:forEach>	
				</div>
			</c:when>
		</c:choose>
    </div>
    
</body>
<!--즐겨찾기js가 계산기js보다 위에 있어야함, 즐겨찾기js는 type="text/babel"-->

</html>