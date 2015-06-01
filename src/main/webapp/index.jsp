<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="st" uri="/star-taglib" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type="text/javascript">

var webSocket = new WebSocket('ws://localhost:8081/SpringWeb/websocket');

  webSocket.onerror = function(event) {
    onError(event)
  };

  webSocket.onopen = function(event) {
    onOpen(event)
  };

  webSocket.onmessage = function(event) {
    onMessage(event)
  };

  function onMessage(event) {
    document.getElementById('messages').innerHTML
      += '<br />' + event.data;
  }

  function onOpen(event) {
    document.getElementById('messages').innerHTML
      = 'Connection established';
  }

  function onError(event) {
    alert(event.data);
  }

  function start() {
    webSocket.send('hello');
    return false;
  }

</script>

</head>
<body>

<a href="index_home.html?as=ss">sda</a>
<br>
<a href="user_list.html">用户列表</a>
<br>
<st:number value="1.566" type="roundDown" scale="4"/>
<br>
<a href="map.html">百度地图</a>
<br>
<a href="demo_extDemo.html">extDemo</a>
<br>
<a href="demo_chartDemo.html?sss=20">chartDemo</a>
<br>

<div id="messages"></div>
<input type="submit" value="Start" onclick="start()" />
</body>
</html>