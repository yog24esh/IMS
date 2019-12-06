<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<style>
.heightOfHeader {
	height: 40px;
}

.navbar-link {
	color: white;
}

.error {
	color: red;
	margin-left: 68%;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 30%;
	padding: 12px 20px;
	margin: -18px 35%;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
	border-radius: 25px;
}

button {
	background-color: #ffc107;
	color: white;
	padding: 14px 20px;
	margin: 3% 25%;
	border: none;
	border-radius: 25px;
	cursor: pointer;
	width: 15%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body>
	<h2>Inventory Management System &nbsp;&nbsp;&nbsp;&nbsp;</h2>
	<nav
		class="heightOfHeader navbar navbar-expand-lg navbar-light bg-warning"
		text-color="white"> <!--   <a class="navbar-brand" href="#">IMS</a> -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarText" aria-controls="navbarText"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="/IMS">Home<span
					class="sr-only">(current)</span></a></li>
			<!-- <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li> -->
		</ul>
		<span class="navbar-text"> <a class="nav-link" href="#">Login</a>
		</span>
	</div>
	</nav>

	<form:form modelAttribute="login" method="POST"
		action="${pageContext.request.contextPath}/validatelogin.html">

		<br>
		<div class="container">
			<center>
				<label for="uname"><b>Username</b></label>
			</center>
			<br>
			<p>
				<form:input path="userName" />
				<form:errors path="userName" cssClass="error" />

			</p>
			<br>
			<center>
				<br> <label for="psw"><b>Password</b></label>
			</center>
			<br>
			<form:input path="password" />
			<form:errors path="password" cssClass="error"></form:errors>
		</div>

		<center>
			<button type="submit" value="logIn">Login</button>
		</center>
		<!-- <input type="submit" value="logIn" /> -->
	</form:form>

</body>
</html>