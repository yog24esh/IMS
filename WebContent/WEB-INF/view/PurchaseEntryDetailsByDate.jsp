<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});

	$(function() {
		$("#datepicker2").datepicker();
	});
</script>
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
			<li class="nav-item active"><a class="nav-link" href="/IMS">HOME<span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item">
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}//loadPurchaseEntryPage.html">PURCHASE
					ENTRY</a></li>

			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/getDateRangeBean.html">GET
					DETAILS BY DATE</a></li>
		</ul>
		<span class="navbar-text"> <a class="nav-link"
			href="${pageContext.request.contextPath}/logout.html">LOGOUT</a>
		</span>
	</div>
	</nav>
	<center>
		<form:form modelAttribute="dateRangeBean"
			action="submitDateRangeBean.html">

			<h4>Enter the Dates</h4>
			<table>
				<tr>
					<td>From Date:</td>
					<td><form:input id="datepicker" path="fromDate" /></td>
				</tr>

				<tr>
					<td>To Date:</td>
					<td><form:input id="datepicker2" path="toDate" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="submit" /></td>
				</tr>
			</table>
		</form:form>
	</center>

	<c:if test="${not empty purchaseEntryBeanList}">
		<h2>PURCHASE ENTRY DETAILS BETWEEN ENTERED DATE</h2>
		<table border="1">
			<tr>
				<th>Transaction Id</th>
				<th>Purchase Id</th>
				<th>Vendor Name</th>
				<th>Material Category</th>
				<th>Material Type</th>
				<th>Unit</th>
				<th>Quantity</th>
				<th>Purchase Amount</th>
				<th>Purchase Date</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${purchaseEntryBeanList}"
				var="purchaseEntryBeanWithTransactionId">
				<tr>
					<td>${purchaseEntryBeanWithTransactionId.transactionId}</td>
					<td>${purchaseEntryBeanWithTransactionId.purchaseId}</td>
					<td>${purchaseEntryBeanWithTransactionId.vendorName}</td>
					<td>${purchaseEntryBeanWithTransactionId.materialCategoryId}</td>
					<td>${purchaseEntryBeanWithTransactionId.materialTypeId}</td>
					<td>${purchaseEntryBeanWithTransactionId.unitId}</td>
					<td>${purchaseEntryBeanWithTransactionId.quantity}</td>
					<td><fmt:formatNumber
							value="${purchaseEntryBeanWithTransactionId.purchaseAmount}"
							type="currency" currencySymbol="INR. "></fmt:formatNumber></td>
					<td><fmt:formatDate
							value="${purchaseEntryBeanWithTransactionId.purchaseDate}"
							type="Date" pattern="dd-MMM-yyyy" /></td>
					<td>${purchaseEntryBeanWithTransactionId.status}</td>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>