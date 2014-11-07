<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/SpringWeb/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/SpringWeb/js/Highcharts-4.0.3/js/highcharts.js"></script>
<script type="text/javascript" src="/SpringWeb/js/chart.js"></script>

<script type="text/javascript">
$(function(){
	$.ajax({
		url : "demo_todayChart.html",
		data : {type : 'today'},
		type : "post",
		dataType : "json",
		error : function(data){
		},
		success:function(data){
			chartToday("xx数据", "sdsd", "sddffffv", data.listChart);
		}
	})
});

</script>
</head>
<body>

	<div id="container" style="width: 1000px; height: 400px">
		<img alt="" src="/SpringWeb/imgs/loading_big1.gif">
	</div>

</body>
</html>