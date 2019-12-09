<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<a class="nav-link"
			href="${pageContext.request.contextPath}/logout.html">Logout</a> </span>
	</div>
	</nav>
	<center>
		<h4>Purchase Entry Created</h4>
		<br>
		<h6>TRANSACTION
			ID:${purchaseEntryBeanWithTransactionId.transactionId}</h6>
		<br>
		<table>
			<tr>
				<td>Purchase Id</td>
				<td>${purchaseEntryBeanWithTransactionId.purchaseId}</td>
			</tr>

			<tr>
				<td>Vendor Name</td>
				<td>${purchaseEntryBeanWithTransactionId.vendorName}</td>
			</tr>
			<td>Material Category</td>
			<td>${ purchaseEntryBeanWithTransactionId.materialCategoryId}</td>
			<tr>
				<td>Material Type</td>
				<td>${purchaseEntryBeanWithTransactionId.materialTypeId}</td>
			</tr>

			<tr>
				<td>Unit</td>
				<td>${ purchaseEntryBeanWithTransactionId.unitId}</td>
			</tr>

			<tr>
				<td>Quantity</td>
				<td>${purchaseEntryBeanWithTransactionId.quantity}</td>
			</tr>


			<tr>
				<td>Purchase Amount</td>
				<td><fmt:formatNumber
						value="${purchaseEntryBeanWithTransactionId.purchaseAmount}"
						type="currency" currencySymbol="INR. "></fmt:formatNumber>
			</tr>

			<tr>
				<td>Purchase Date</td>
				<td><fmt:formatDate
						value="${purchaseEntryBeanWithTransactionId.purchaseDate}"
						type="Date" pattern="dd-MMM-yyyy" />
			</tr>

			<tr>
				<td>Status</td>
				<td>${purchaseEntryBeanWithTransactionId.status}</td>
			</tr>
		</table>
	</center>

</body>
</html>