<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
	<h2>version:Spring Sec3 2.0</h2>
	<form name='f' action='/SpringSec32/j_spring_security_check' method='POST'>
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type='text' name='userName' value=''>
				</td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type='password' name='password' />
				</td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>