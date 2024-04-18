<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디중복체크</title>
<style>
/* 전체 body 스타일 */
body {
    font-family: 'Noto Sans KR', sans-serif; /* 폰트 설정 */
    background-color: #f5f6f7; /* 배경색 설정 */
    display: flex; /* Flexbox 레이아웃 사용 */
    justify-content: center; /* 가로 중앙 정렬 */
    align-items: center; /* 세로 중앙 정렬 */
    height: 100vh; /* 뷰포트 높이에 맞게 설정 */
}

/* 로그인 컨테이너 스타일 */
.container {
    width: 400px; /* 너비 설정 */
    background-color: #fff; /* 배경색 설정 */
    padding: 20px; /* 안쪽 여백 설정 */
    border-radius: 10px; /* 테두리 반경 설정 */
    box-shadow: 0 5px 20px rgba(0, 0, 0, 0.1); /* 그림자 효과 설정 */
}

/* 제목 스타일 */
h1 {
    color: #03c75a; /* 글자색 설정 */
    margin-bottom: 20px; /* 하단 여백 설정 */
    text-align: center; /* 가운데 정렬 */
}

/* 입력 필드 스타일 */
input[type="text"], input[type="password"] {
    width: 50%; /* 너비 100% 설정 */
    padding: 10px; /* 안쪽 여백 설정 */
    margin: 10px 0; /* 바깥 여백 설정 */
    border: 1px solid #ddd; /* 테두리 설정 */
    border-radius: 5px; /* 테두리 반경 설정 */
    box-sizing: border-box; /* 상자 크기 설정 */
}

/* 버튼 스타일 */
input[type="submit"], input[type="button"] {
    width: 30%; /* 너비 100% 설정 */
    padding: 10px; /* 안쪽 여백 설정 */
    margin: 10px 0; /* 바깥 여백 설정 */
    border: none; /* 테두리 없애기 */
    border-radius: 5px; /* 테두리 반경 설정 */
    background-color:  #03c75a; /* 배경색 설정 */
    color: white;/*  글자색 설정 */
    cursor: pointer; /* 커서 설정 */
}

/* 버튼 호버 효과 */
input[type="submit"]:hover, input[type="button"]:hover {
    background-color: #029e47; /* 호버 시 배경색 변경 */
}
.container{
text-align: center;
}
</style>
</head>
<body>

<div class="container">
</br></br></br>
<h3>아이디 중복확인</h3>
	<form action="/CheckHandler.do" method="get" name="joinForm">
		아이디 : <input type="text" name="joinId" value='${joinPut}'>
			<input type="submit" value="중복 체크">
	</form>
<c:if test="${result == 1}">
		<script>
			//opener란 이창을 열어준 창을 말한다. 즉 여기서는 회원가입폼
			opener.document.joinForm.joinId.value = "";	//입력한 값을 없애줌
		</script>
			${joinPut}는 이미 사용중인 아이디입니다.
</c:if>
	
	<c:if test="${result == 0}">
		</br>${joinPut}는 사용가능한 아이디입니다.</br></br>
			<input type="button" value="사용" onclick="return idok('${joinPut}')">
	</c:if>
<script>
	function idok(joinPut){
		//opener.setIdValue(joinPut);
		opener.setIdValue(joinPut, true);
		//전달하면서 창을 닫겠다.
		self.close();
		}
</script>
</div>

</body>
</html>