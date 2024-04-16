<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reply</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>
	<!--댓글 입력-->
	<div align="center">
    <table style="width: 500px;">
        <tr>
            <td rowspan="2" style="vertical-align: middle; text-align: center;">
                <!--프로필 사진-->
                <div class="box" style="background: white;">
                    <img class="profile" src="<%=request.getContextPath()%>/resources/imgs/profile.png" style="width: 40px; height: 40px; vertical-align: middle;">
                </div>
            </td>
            <!-- 여기에 </td> 태그 추가 -->
        </tr>
        <tr>
            <td style="width: 80%;">
                <div class="relpyForm">
                    <label for="reply"></label> 
                    <input type="text" class="form-control" id="usr" placeholder="댓글을 입력하세요." style="width: 350px; height: 30px;" name="nikname">
                </div>
            </td>
            <td><button class="btn btn-sm btn-success" onclick="insertReply();" style="width: 80px;  height: 30px;">게시하기</button></td>
        </tr>
    </table>
</div>


	<br>
	<!--댓글 조회-->
	<div id="replList">
		<!--각 댓글 영역 -->
		<div class="replyArea" align="center" id="reply-content-area">
			<table style="width: 500px;">
				<tbody>

				</tbody>
			</table>
		</div>
	</div>

	<script>
	/*자동 함수 호출*/
	$(function(){
		selectReplyList();
		setInterval(selectReplyList,5000);
	})
	
	 /*댓글 작성*/
    function insertReply(){
    	$.ajax({
    		url : "insert.do",
    	    data : {content : $("#reply").val(),
	    	custoRecipeNo : "1",
	   		memberId : "원진"
     		},
    		type : "post",
    		success : function(result){
								if(result>0){
			         			selectReplyList();
			         			$("#reply").val("");
				         		}
				    		}
		     		})
		   	  }
     
     /*댓글 조회 */
     function selectReplyList(){
     	$.ajax({
     	 	url : "list.do",
         	data : {cus_no: "1"},
         	success : function(cus_re_list){
         		var result = "";
         		for(var i in cus_re_list){
         			result += 
            			"<br>"	+	
            			"<td>"+
                        "<div class='box' style='background: #white;''>" + 
                        "<img class='profile' src='" + list[i].profileImg + "'>" + 
                       	"</div>" +
                 		"</td>" + 	
                        "<td>" + "<b>" + list[i].replyWriter + "</b>" + "</td>" +
                        "<td>" + list[i].enrollDate + "</td>" + 
                        "<td style='color: gray;'>" + "<a href='' class='report-user-btn'>" + "신고하기" + "</a>" + "</td>" + 
                        "<br>" +
                        "<tr class='reply-deatil-content'>" + 
                        "<td colspan='3'>" + list[i].replyContent  + "</td>" + 
                        "</tr>" +
                        "<br>"
         		} 
					$("#reply-content-area tbody").html(result);	
         	}
     	})
     }
	</script>

</body>
</html>