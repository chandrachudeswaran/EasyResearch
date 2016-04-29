
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<!-- Comments: This page lets Author to update his profile details in the system -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath}/static/js/functions.js"></script>
		<title>Easy Research - Edit Profile</title>
	</head>

	<body>
	
	
	
		<div id="main-wraper">
			<div id="top-wraper">
				<div id="banner">Easy Research</div>
				<div id="nav">
					<ul>
					  <li><a href="${pageContext.request.contextPath}/userhome">Home</a></li>
					  <li><a href="">List of Conferences</a></li>
				  	  <li><a href="">Check Status</a></li>
					</ul>
				</div>
				<div class="logout">
					<form name="logout" action="Logout" method="post">
						<input type="submit" value="Logout" align ="right"> 
					</form>
				</div>
			</div>
			
		
			<form name="form3" action="EditProfile" method="post" >
				<table id="signUpForm" style="width: 100%; border-color: #000000; display: inline-block;">
					<tbody>
						<tr>
				            <td width="75%">
								<h2 style="display: inline-block;">Edit Your Profile</h2>	
											
							</td>
				        </tr>
				        <tr>
				            <td class="style2">First Name</td>
				            <td><input type="text" class="tableinput" name="fname" value= "<c:out value="${user.name}" />"></td>
				        </tr>
				        <tr>
				        	<td class="style2">Last Name</td>
				        	<td><input type="text" class="tableinput" name="lname" value ="<c:out value="${user.lastname}" />"></td>
				        </tr>
				        
				        
				        <tr>
				            <td class="style2">Company/Organization</td>
				            <td><input type="text" class="tableinput" name="company" value="<c:out value="${user.company}" />"></td>
				        </tr>
				      
				        <tr>
				            <td class="style2">Address Line 1</td>
				            <td><input type="text" class="tableinput" name="address" value="<c:out value="${user.address.street}" />"></td>
				        </tr>
				        <tr>
				            <td class="style2">City</td>
				            <td><input type="text" class="tableinput" name="city" value="<c:out value="${user.address.city}" />"></td>
				        </tr>
				        <tr>
				            <td class="style2">State</td>
				            <td><input type="text" class="tableinput" name="state" value="<c:out value="${user.address.state}" />"></td>
				        </tr>
				        <tr>
				            <td class="style2">Country</td>
				            <td><input type="text" class="tableinput" name="country" value="<c:out value="${user.address.country}" />"></td>
				        </tr>
				      
				        <tr>
				            <br/><td class="style1" colspan="2" align="center"><input style="min-width:80pt;" class="loginbutton" type="Submit" name="submit" value="Update"></td>
				        </tr>
			        </tbody>
			    </table>
			</form>
		</div>
	</body>
</html>