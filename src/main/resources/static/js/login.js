/**


 **/
 
 
   
		$(document).ready(function(){ 
		$("#submit").click(function(){
		if($("#id").val().length==0){ alert("아이디를 입력하세요."); $("#id").focus(); return false; }
		if($("#password").val().length==0){ alert("비밀번호를 입력하세요."); $("#password").focus(); return false; }
		});
		});
	