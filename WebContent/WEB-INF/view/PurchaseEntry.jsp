<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<style>
	.heightOfHeader{
		height:40px;
	}
	.navbar-link{
		color:white;
	}
</style>
</head>
<body>
<h2>Inventory Management System &nbsp;&nbsp;&nbsp;&nbsp;</h2>
<nav class="heightOfHeader navbar navbar-expand-lg navbar-light bg-warning" text-color="white">
<!--   <a class="navbar-brand" href="#">IMS</a> -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/IMS">Home<span class="sr-only">(current)</span></a>
      </li>
      <!-- <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li> -->
    </ul>
    <span class="navbar-text">
    <a class="nav-link" href="#">Login</a>
    </span>
  </div>
</nav>
<center>
	<h1>MaterialsPurchaseEntry</h1>
	<form:form modelAttribute="purchaseEntryBean" method="POST"
			action="${pageContext.request.contextPath}/PurchaseEntry.html">
		<table>
			<tr>
				<td>Vendor Name</td>
				<td>
					<form:select path="vendorName">
						<form:option label="---SELECT---" value=""></form:option>
						<form:options items="${VendorNamesList}"/>
					</form:select>
				</td>
			</tr>
		<%-- 	<tr>
				<form:select path="" >
						<form:option label="---SELECT---" value=""></form:option>
						<form:options items="${MaterialCategoryList}"/>
					</form:select>
			</tr> --%>
			
		</table>
	</form:form>
</center>
</body>
</html>