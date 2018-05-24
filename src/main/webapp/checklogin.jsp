<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script language="javascript">
		function 	ajaxSubmit(){
			
			$.ajax({
	            url: "http://192.168.1.198:8080/p2ploan/user/checkIfRegiste",    //要请求的servlet
	            data:{"uPhone":"17610680299"},    //给服务器的参数，本例中使用的是json格式的数据
	            type: "POST",                //发送请求的类型
	            dataType: "json",            //请求数据的格式
	            async: false,        //到低是不是异步请求,如果是异步,那么不会等服务器响应则会让程序向下走,false表示不是异步请求,true表示是异步请求
	            cache: false,        //是否缓存数据
	            success: function (result) {    //如果服务器给出应答,则会调用下面的代码,result代表了服务器返回回来的值
	                //拿到视频播放的地址
	                //alert(result);
	                var obj = eval('(' + result + ')');
	
	                data = obj.hs_300663.data;
	            }, error: function () {
	                //alert("分时图没有获取到数据");
	            }
       		 });

			
		}
		</script>	
		
		<form action="/p2ploan/user/checkIfRegiste" method="post">
			<input type="text" name="uPhone" value="17610680299" >
			<!--
			<input type="text" name="uPhone" value="17610680299" >
			-->
			<!--<input type="button" onclick="ajaxSubmit()" />-->
			<input type="submit" value="提交" />
			
		</form>
		

</body>
</html>