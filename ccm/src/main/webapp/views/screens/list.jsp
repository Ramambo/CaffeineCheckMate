<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${root}/resources/js/xhr.js"></script>
<script type="text/javascript" src="${root}/resources/js/replyWrite.js"></script>
<script type="text/javascript" src="${root}/resources/js/replyDelete.js"></script>
<script type="text/javascript" src="${root}/resources/js/replyUpdate.js"></script>
</head>
<body>
	<div>댓글</div>
	<br /><br />
	
	
	<div id="listAllDiv">
		<c:forEach var="replyDto" items="${replyList}">
			<div class="replyDiv" id="${replyDto.cus_re_no}">
				<span >${replyDto.cus_re_no}</span>
				<span>${replyDto.cus_re_content}</span>
				<span>
					<a href="javascript:selectRequest('${replyDto.cus_re_no}', '${root}')">수정</a>
					<a href="javascript:deleteRequest('${replyDto.cus_re_no}','${root}')">삭제</a>
				</span>
			</div>
		</c:forEach>
	</div>
	<div>
		<input id="writeReply" type="text" name="write" size="50"/>
		<input type="button" value="댓글" onclick="writeRequest('${root}')"/>
	</div>
</body>
</html>