/**


 **/
 
   $(document).ready(function(){ 
		$("#submit").click(function(){
		if($("#id").val().length==0){ alert("아이디를 입력하세요."); $("#id").focus(); return false; }
		if($("#email").val().length==0){ alert("이메일을 입력하세요."); $("#email").focus(); return false; }
		});
		});