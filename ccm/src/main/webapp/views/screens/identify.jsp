<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보확인</title>
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
    width: 100%; /* 너비 100% 설정 */
    padding: 10px; /* 안쪽 여백 설정 */
    margin: 10px 0; /* 바깥 여백 설정 */
    border: 1px solid #ddd; /* 테두리 설정 */
    border-radius: 5px; /* 테두리 반경 설정 */
    box-sizing: border-box; /* 상자 크기 설정 */
}

/* 버튼 스타일 */
input[type="submit"], input[type="button"] {
    width: 100%; /* 너비 100% 설정 */
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

/* 체크박스 스타일 */
input[type="checkbox"] {
    margin-right: 5px; /* 오른쪽 여백 설정 */
}

.container{
text-align: center;
}
</style>
</head>

<body>
<div class="container">
<% 
	String value = request.getParameter("Value");
	
	if(value.equals("delete")){
%>	
	<form action="<%=request.getContextPath() %>/DeleteMemberHandler.do" method = "post" name="DeleteLogin" id="DeleteLogin">
				<h1>로그인정보확인</h1>
			아이디<br/><input type="text" name="identgyId" id="deleteId" placeholder="아이디" required="required"/><br/>
			비밀번호<br/><input type="password" name="identgyPw" id="deletePw" placeholder="비밀번호" required="required"/><br/>
			<input type="hidden" value="delete" name="Value"/>
			<br/><input type="submit" value="탈퇴"/>
			<input type="button"  onclick="location.href='/views/screens/testView.jsp'" value="취소"/>
	</form>
	<%}if(value.equals("edit")){%>
	<form action="<%=request.getContextPath() %>/UpdateMemberHandler.do" method = "post" name="UpdateLogin" id="UpdateLogin">
				<h1>로그인정보확인</h1>
			아이디<br/><input type="text" name="identgyId" id="updateId" placeholder="아이디" required="required"/><br/>
			비밀번호<br/><input type="password" name="identgyPw" id="updatePw" placeholder="비밀번호" required="required"/><br/>
			<br/><input type="submit" value="정보확인"/>
			<input type="button"  onclick="location.href='/views/screens/testView.jsp'" value="취소"/>
	</form>
	<%}if(value.equals("deleteCancel")){%>	
	<form action="<%=request.getContextPath() %>/DeleteMemberHandler.do" method = "post" name="DeleteCancelLogin" id="DeleteCancelLogin">
				<h1>로그인정보확인</h1>
			아이디<br/><input type="text" name="identgyId" id="deleteCancelId" placeholder="아이디" required="required"/><br/>
			비밀번호<br/><input type="password" name="identgyPw" id="deleteCancelPw" placeholder="비밀번호" required="required"/>
			<input type="hidden" value="deleteCancel" name="Value"/><br/>
			<br/><input type="submit" value="정보확인"/>
			<input type="button"  onclick="location.href='/views/screens/testView.jsp'" value="취소"/>
	</form>
	<%}%>
			<%// 로그인 실패시 에러메세지 관련 부분
			String model = (String) session.getAttribute("errMSG");
			if(model != null){
				out.println("<br/>" + model);
				//session.invalidate();
			}%>
</div>

</body>
</html>