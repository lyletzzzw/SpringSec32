<%@page import="java.util.Enumeration"%>
<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<h2>version:Spring Sec3 2.0</h2>
	这是首页，欢迎您！！！

<%
	Enumeration men = session.getAttributeNames();
	while (men.hasMoreElements()){
		Object obj = men.nextElement();
		out.print("</br>"+obj+"->"+session.getAttribute(obj.toString()));
    } 
%>
</body>
</html>