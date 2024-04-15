/**
 * 
 */
 function deleteRequest(cus_re_no, root) {
	console.log("deleteRequest 진입 ");

	var url = root + "/replyDelete.do";
	var params = "cus_re_no=" + cus_re_no;

	sendRequest("GET", url, params, deleteResponse);
	arr.push(cus_re_no + "," + root);
}

function deleteResponse() {
	console.log("deleteResponse 진입 ");

	if (xhr.readyState == 4 && xhr.status == 200) {
		var cus_re_no = xhr.responseText;
		var div = document.getElementById(cus_re_no);

		var listDiv = document.getElementById("listAllDiv");
		listDiv.removeChild(div);

	}
}