/**
 * 
 */
 var root = null;
function selectRequest(cus_re_no, requestRoot) {
	console.log("selectRequest 진입 ");
	root = requestRoot;

	var url = root + "/replySelect.do";
	var params = "cus_re_no=" + cus_re_no;
	arr.push(url + "," + params);

	sendRequest("GET", url, params, SelectResponse);

}

function SelectResponse() {
	console.log("SelectResponse 진입 ");
	if (xhr.readyState == 4 && xhr.status == 200) {
		var result = xhr.responseText.split(',');
		var cus_re_no = result[0];//.trim();
		var reply = result[1];//.trim();

		arr.push(cus_re_no + "," + reply);

		var div = document.createElement("div");
		div.id = "up" + cus_re_no;

		var inputText = document.createElement("input");
		inputText.type = "text";
		inputText.value = reply;

		var inputBtn = document.createElement("input");
		inputBtn.type = "button";
		inputBtn.value = "수정";
		inputBtn.onclick = function() {
			updateToServer(cus_re_no, inputText.value);
		}

		div.appendChild(inputText);
		div.appendChild(inputBtn);

		var cus_re_noDiv = document.getElementById(cus_re_no);
		cus_re_noDiv.appendChild(div);

	}
}

function updateRequest(cus_re_no, value) {
	console.log("updateRequest 진입 ");
	var url = root + "/reply/replyUpdate.do";
	var params = "cus_re_no=" + cus_re_no + "&value=" + value;

	sendRequest("POST", url, params, updateRequestResponse);
}

function updateRequestResponse() {
	console.log("updateRequestResponse 진입 ");
	if (xhr.readyState == 4 && xhr.status == 200) {
		var result = xhr.responseText.split(",");
		var cus_re_no = result[0];//.trim();
		var reply = result[1];//.trim();

		var cus_re_noDiv = document.getElementById(cus_re_no);
		var span = cus_re_noDiv.getElementsByTagName("span");
		span[1].innerText = reply;

		var upDiv = document.getElementById("up" + cus_re_no);
		cus_re_noDiv.removeChild(upDiv);
	}
}