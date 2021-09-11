/**


 **/
 
    function setCookie(cookieName, value, exdays){
    	var exdate = new Date();
    	exdate.setDate(exdate.getDate() + exdays);
    	var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    	document.cookie = cookieName + "=" + cookieValue;
    }

    function deleteCookie(cookieName){
    	var expireDate = new Date();
    	expireDate.setDate(expireDate.getDate() - 1);
    	document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
    }

    function getCookie(cookieName) {
    	cookieName = cookieName + '=';
    	var cookieData = document.cookie;
    	var start = cookieData.indexOf(cookieName);
    	var cookieValue = '';
    	if(start != -1){
    		start += cookieName.length;
    		var end = cookieData.indexOf(';', start);
    		if(end == -1)end = cookieData.length;
    		cookieValue = cookieData.substring(start, end);
    	}
    	return unescape(cookieValue);
    }
    
    function frm_submit(){
     	//스크롤 위치 저장
     	var scrollPoint = (document.documentElement && document.documentElement.scrollTop) 
    		|| document.body.scrollTop;

    	setCookie("category", "mainScrollPoint"); // 쿠키에서 사용할 category에 사용자 정의 카테고리명 세팅
    	setCookie("scrollPoint", scrollPoint); // 쿠키에 스크롤 위치 세팅

    	$("#frm").submit();
    }
    
    var category = getCookie("category"); //setCookie("category")로 세팅한 category 변수 명
    var scrollPoint = getCookie("scrollPoint"); //setCookie("scrollPoint")로 세팅한 스크롤 위치
    var currentCategory = "mainScrollPoint"; //이벤트 발생 후 새로 로드된 현재 페이지의 카테고리 지정
    
    if (category != "" && category != 'undefined' 
   	&& category == currentCategory && scrollPoint != "" && scrollPoint != 'undefined') {
       
    	window.scroll(0, scrollPoint); 
    	//body.scrollTop(scrollPoint);
    }

   // 쿠키 삭제
   deleteCookie("category"); //또는 setCookie("category", "");
   deleteCookie("scrollPoint"); //또는 setCookie("scrollPoint", "");
	
	



	
	
	/* $("#loginCard").submit(function() {
		 	var offset = $("#loginCard").offset();
	        $('html, body').animate({scrollTop : offset.top}, 400);
			}); */
			
			$("#loginCard").submit(function() {
			alert("test");
			});

	

	function check() {		
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/; /* 이메일 유효성 검사 */
		3
		 var passcheck = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;   /* 비밀번호 유효성 검사 */
		
			if(exptext.test(email)==false){
				alert("메일형식이 올바르지 않습니다.");
				document.addjoin.email.focus();
				return false;					
			}
			
			if (passcheck.test(password)==false) {			        
			    alert("비밀번호 형식을 지켜주세요.\n비밀번호는 숫자, 소문자, 대문자를 1개이상, 6~20자리 이내로 입력해주세요.");
			    document.addjoin.password.focus();
			    return false;
			}
	}	
