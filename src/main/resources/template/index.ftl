<html>
 <head>
   <meta charset="utf-8"/>
 </head>
 <script type="text/javascript">
 function test(){
	 var url="http://localhost:8080/user/test";
	 $.ajax({
		 url:url,
		 type:"get",
		 data:{aplIdd:"123456789"},
		 success:function(data){
			 alert("23:"+data);
		 },error:function(data){
			 alert("error:"+data);
		 }

	 });
 }
 
 </script>
 <script src="../static/js/jquery.min.js"></script>
 <body>
   <#list list as user>
第${user_index+1}个用户
 用户名:${user.cityName}
 密  码：${user.description}
 年  龄: ${user.id}
</#list>


<input type="button" value="测试" onclick="test()">
 </body>
</html>