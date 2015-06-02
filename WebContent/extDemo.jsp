<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="http://cdn.sencha.com/ext/trial/5.0.0/build/packages/ext-theme-neptune/build/resources/ext-theme-neptune-all.css">
<script type="text/javascript" src="http://cdn.sencha.com/ext/trial/5.0.0/build/ext-all.js"></script> 
<script type="text/javascript" src="http://cdn.sencha.com/ext/trial/5.0.0/build/packages/ext-theme-neptune/build/ext-theme-neptune.js"></script>

<script type="text/javascript">

Ext.application({
    name   : 'MyApp',

    launch : function() {

       Ext.create('Ext.Panel', {
            renderTo     : Ext.getBody(),
            width        : 200,
            height       : 150,
            bodyPadding  : 5,
            title        : 'Hello World',
            html         : 'Hello <b>World</b>...'
        });

    }
});

</script>
</head>
<body>

</body>
</html>