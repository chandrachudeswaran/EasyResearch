<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Easy Research - <c:out value="${usertype}"></c:out> Login</title>
<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/static/js/loginValidation.js"></script>
</head>
<body>
	
	
	<div id="main-wraper">
		<div id="top-wraper">
			<div id="banner">Easy Research</div>
			<div id="nav">
				<ul>
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/aboutus">Aboutus</a></li>
					<li><a href="${pageContext.request.contextPath}/contactus">Contact</a></li>
					<li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
				</ul>
			</div>
		</div>
		<table style="width: 100%; display: inline-block;">
			<tbody>
				<tr>
					<td>
						<h2>Easy Research Login</h2>
					</td>
				</tr>
				<tr>
				
					<td><c:choose>
					<c:when test="${userstatus!=null}">
							<span class="invalidText"  style="color: red;">Invalid
								UserName/ Password Combination</span>
						</c:when> 
						
						</c:choose>
						<form name="form1" action="${pageContext.request.contextPath}/j_spring_security_check" method="post"
							onsubmit="return chklogin();">
							<table class="logintable">
							
								<tbody>
									<tr>
										<td class="textright">Username :</td>
										<td class="tableinputtext"><input class="tableinput"
											type="text" name="j_username" /><input type="hidden" name="typeofuser" value="${usertype}" /></td>
									</tr>
									<tr>
										<td class="textright">Password :</td>
										<td class="tableinputtext"><input class="tableinput"
											type="password" name="j_password" /></td>
									</tr>
									<tr>
										<td colspan="2" style="text-align: center;"><input
											type="submit" value="Login" name="submit" class="loginbutton">
			</td>
									</tr>
									<tr>
										<td colspan="2" style="font-size: small; text-align: right"><a
											style="text-decoration: none;"
											href="ResetPassword.jsp?user=author">Forgot your password</a></td>
									</tr>
								</tbody>
							</table>
						</form></td>
						
					
				</tr>
			</tbody>
		</table>
		<div class="footer">
			<p id="copyright">Copyright &copy; 2014. Developed by
				Chandrachudeswaran Sankar, Sashank Santhanam, Rohit Bansod, Samatha
				Kolagatla</p>
		</div>
	</div>
</body>
</html>