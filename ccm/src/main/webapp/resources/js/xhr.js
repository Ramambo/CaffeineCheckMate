/**
 * 
 */
function createXHR(){
	console.log("createXHR 진입");
	if(window.XMLHttpRequest)
		return new XMLHttpRequest();
	else
		return new ActiveXObject("Microsoft.XMLHTTP");
}

var xhr = null;

function sendRequest(method, url, params, callback){
	console.log("sendRequest 진입");
	var httpMethod=method.toUpperCase();
	var httpUrl = url;
	var httpParams=(params==null || params=="")? null:params;
	if(httpMethod=="GET" &&httpParams!=null){
	console.log("httpMethod:"+httpMethod);
		httpUrl += "?" + httpParams;
	}
	arr.push(httpMethod+ "," + httpUrl + "," + httpParams);
	
	xhr = createXHR();
	xhr.open(httpMethod, httpUrl, true);
	
	//POST일때
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(httpMethod=="POST" ? httpParams:null);
	xhr.onreadystatechange=callback;
	
}
