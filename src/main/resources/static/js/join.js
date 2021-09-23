

	function check() {		
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/; /* 이메일 유효성 검사 */
		
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
