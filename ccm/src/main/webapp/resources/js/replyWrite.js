/**
 * 
 */
/*var arr = new Array();
var root = null;

function writeRequest(requestRoot) {
	console.log("writeRequest 진입 ");
	root = requestRoot;
	var writeReply = document.getElementById("writeReply").value;
	arr.push(root + "," + writeReply);

	var url = root + "/replyWrite.do";
	var params = "writeReply=" + writeReply;
	sendRequest("GET", url, params, writeResponse);
}

function writeResponse() {
		console.log("writeResponse 진입");
	if (xhr.readyState == 4 && xhr.status == 200) {
		arr.push("result" + xhr.responseText);

		var result = xhr.responseText.split(",");
		var cus_re_no = result[0];//.trim();
		var reply = result[1];//.trim();

		document.getElementById("writeReply").value = "";

		var listDiv = document.getElementById("listAllDiv");
		var div = document.createElement("div");
		div.className = "replyDiv";
		div.id = cus_re_no;

		var spanCus_re_no = document.createElement("span");
		spanCus_re_no.innerText = cus_re_no;

		var spanReply = document.createElement("span");
		spanReply.innerText = reply;

		var spanUpdel = document.createElement("span");

		var aDelete = document.createElement("a");

		aDelete.href = "#";
		aDelete.onclick = function() {
			deleteRequest(cus_re_no, root);
		}
		aDelete.innerHTML = "삭제";

		var aUpdate = document.createElement("a");
		aUpdate.href = '#';
		aUpdate.onclick = function() {
			selectRequest(cus_re_no, root);
		}
		aUpdate.innerHTML = "수정";

		spanUpdel.appendChild(aDelete);
		spanUpdel.appendChild(aUpdate);

		div.appendChild(spanCus_re_no);
		div.appendChild(spanReply);
		div.appendChild(spanUpdel);
		listDiv.appendChild(div);
		listDiv.insertBefore(div, listDiv.firstChild);

	} else {

	}
}*/

var arr = new Array();
var root = null;

function writeRequest(requestRoot) {
    console.log("writeRequest 진입 ");
    root = requestRoot;
    console.log("root:", root);
    var writeReply = document.getElementById("writeReply").value;
    console.log("writeReply:", writeReply);
    arr.push(root + "," + writeReply);
    console.log("arr:", arr);

    var url = root + "/replyWrite.do";
    console.log("url:", url);
    var params = "writeReply=" + writeReply;
    console.log("params:", params);
    sendRequest("GET", url, params, writeResponse);
}

function writeResponse() {
    console.log("writeResponse 진입");
    if (xhr.readyState == 4 && xhr.status == 200) {
        arr.push("result" + xhr.responseText);                  //xhr.responseText 여기부터 문제 값이 없다
        console.log("arr:", arr);
        console.log("xhr.responseText:", xhr.responseText);

        var result = xhr.responseText.split(",");
        console.log("result:", result);
        var cus_re_no = result[0];//.trim();
        console.log("cus_re_no:", cus_re_no);
        var reply = result[1];//.trim();
        console.log("reply:", reply);

        document.getElementById("writeReply").value = "";

        var listDiv = document.getElementById("listAllDiv");
        console.log("listDiv:", listDiv);
        var div = document.createElement("div");
        div.className = "replyDiv";
        div.id = cus_re_no;

        var spanCus_re_no = document.createElement("span");
        spanCus_re_no.innerText = cus_re_no;
        console.log("spanCus_re_no:", spanCus_re_no);

        var spanReply = document.createElement("span");
        spanReply.innerText = reply;
        console.log("spanReply:", spanReply);

        var spanUpdel = document.createElement("span");
        console.log("spanUpdel:", spanUpdel);

        var aDelete = document.createElement("a");
        console.log("aDelete:", aDelete);

        aDelete.href = "#";
        aDelete.onclick = function() {
            deleteRequest(cus_re_no, root);
        }
        aDelete.innerHTML = "삭제";
        console.log("aDelete:", aDelete);

        var aUpdate = document.createElement("a");
        console.log("aUpdate:", aUpdate);
        aUpdate.href = '#';
        aUpdate.onclick = function() {
            selectRequest(cus_re_no, root);
        }
        aUpdate.innerHTML = "수정";
        console.log("aUpdate:", aUpdate);

        spanUpdel.appendChild(aDelete);
        spanUpdel.appendChild(aUpdate);

        div.appendChild(spanCus_re_no);
        div.appendChild(spanReply);
        div.appendChild(spanUpdel);
        listDiv.appendChild(div);
        console.log("listDiv:", listDiv);
        listDiv.insertBefore(div, listDiv.firstChild);

    } else {
        console.log("XHR 통신 상태 및 상태 코드 확인 필요");
    }
}
