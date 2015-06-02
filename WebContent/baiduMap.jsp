<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>Insert title here</title>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=d6XC0uXpT4HGafTWNblFChyc"></script>
<!-- <script src="http://api.map.baidu.com/api?v=1.4"    type="text/javascript"></script>    -->
<style type="text/css">
body, html,#allmap {width: 80%;height: 80%;overflow: hidden;margin:0;}
</style>


</head>
<body>
<div id="allmap"></div>
</body>

<script type="text/javascript">

// 百度地图API功能
var map = new BMap.Map("allmap");            // 创建Map实例
var point = new BMap.Point(120.299, 31.568);    // 创建点坐标 无锡
map.centerAndZoom(point,15);                     // 初始化地图,设置中心点坐标和地图级别。
map.enableScrollWheelZoom();                            //启用滚轮放大缩小

//map.addControl(new BMap.NavigationControl());  //添加控件：左上角的导航控件

//map.addControl(new BMap.ScaleControl());    
map.addControl(new BMap.OverviewMapControl());    
map.addControl(new BMap.MapTypeControl()); 

var opts = {offset: new BMap.Size(150, 5)}    
map.addControl(new BMap.ScaleControl(opts));

/** 
BMAP_NAVIGATION_CONTROL_LARGE 表示显示完整的平移缩放控件。
BMAP_NAVIGATION_CONTROL_SMALL 表示显示小型的平移缩放控件。
BMAP_NAVIGATION_CONTROL_PAN 表示只显示控件的平移部分功能。
BMAP_NAVIGATION_CONTROL_ZOOM 表示只显示控件的缩放部分功能。
*/
var opts = {type: BMAP_NAVIGATION_CONTROL_PAN}    
map.addControl(new BMap.NavigationControl(opts));


</script>

</html>

