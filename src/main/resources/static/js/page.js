
getURLParams = function(path) {
	const result = {};
	let params = path.split("?")[1];
	params = params.split("&");
	for (const param of params) {
		const keyValSplited = param.split("=");
		let key, val;

		if (keyValSplited.length != 2) {
			continue
		}
		key = keyValSplited[0];
		val = keyValSplited[1];

		result[key] = val;
	}

	return result;
}

function getParamStr(params) {
	let paramStr = ""
	for (const paramKey in params) {
		paramStr += "&" + paramKey + "=" + params[paramKey];
	}
	return paramStr.substr(1, paramStr.length)
}

let path = window.location.href;
const params = getURLParams(path);
const baseURL = window.location.pathname;

window.onload = function() {
	const pageBtns = document.getElementsByClassName("pageBtn");
	const prevBtn = document.getElementById("prevBtn");
	const nextBtn = document.getElementById("nextBtn");
	let maxPage = -1;
	let minPage = 99999;

	for (const btn of pageBtns) {
		let pageNo = btn.innerText;
		let btnURL = baseURL;

		params["pageNo"] = pageNo;
		paramStr = getParamStr(params);
		btn.href = btnURL + "?" + paramStr;

		pageNo = parseInt(pageNo);
		if (pageNo > maxPage) {
			maxPage = pageNo;
		}
		if (pageNo < minPage) {
			minPage = pageNo;
		}
	}

	if (prevBtn) {
		params["pageNo"] = minPage - 1;
		paramStr = getParamStr(params);
		prevBtn.href = baseURL + "?" + paramStr;
	}

	if (nextBtn) {
		params["pageNo"] = maxPage + 1;
		paramStr = getParamStr(params);
		nextBtn.href = baseURL + "?" + paramStr;
	}
}
