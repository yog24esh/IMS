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
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>

<style type="text/css">
	.heightOfHeader{
		height:40px;
	}
	.navbar-link{
		color:white;
	}
	
	.error{
	color:red;
		
	}
	
</style>

<script>
function getmattypeAndUnit(customerId) {
  //task1
  //write code here and chk ctrl getting invoked or not
  if(customerId==""){
	  alert("Material Category cant be empty");
  }else{
	  document.forms["form1"].action="getMaterialTypeAndUnit.html";
	  document.forms["form1"].method="post";
	  document.forms["form1"].submit();
  }

}
</script>


	
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
	<form:form name="form1" modelAttribute="purchaseEntryBean" method="POST">
		<table>
			<tr>
				<td>Vendor Name</td>
				<td width="150px">
					<form:select path="vendorName">
						<form:option label="---SELECT---" value=""></form:option>
						<form:options items="${VendorNamesList}"/>
						<form:errors path="vendorName" cssClass="error"></form:errors>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Material Category</td>
				<td width="150px">
					<form:select id="customerId" onchange="getmattypeAndUnit(customerId.value)" path="materialCategoryId">
						<form:option label="---SELECT---" value="" ></form:option>
						<form:options items="${MaterialCategoryIdAndName}" />
						<form:errors path="materialCategoryId" cssClass="error"></form:errors>
					</form:select>
				</td>
			</tr>
		</table>
	</form:form>
	<c:if test="${purchaseEntryBean.materialCategoryId!=null}">
	<form:form name="form2" modelAttribute="purchaseEntryBean" method="POST" action="addPurchaseEntry.html">
		<table>
			<tr>
				<td>Material Type</td>
				<td width="150px">
					<form:select path="materialTypeId">
						<form:option label="---SELECT---" value="" ></form:option>
						<form:options items="${materialTypeNameAndId}" />
						<form:errors path="materialTypeId" cssClass="error"></form:errors>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Brand Name</td>
				<td width="150px">
					<form:input path="brandName"/>
					<form:errors path="brandName" cssClass="error"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Unit</td>
				<td width="150px">
					<form:select path="unitId">
						<form:option label="---SELECT---" value="" ></form:option>
						<form:options items="${materialUnitNameAndId}" />
						<form:errors path="unitId" cssClass="error"></form:errors>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td width="150px">
					<form:input path="quantity"/>
					<form:errors path="quantity" cssClass="error"></form:errors>
					
				</td>
			</tr>
				<tr>
				<td>Purchase Amount</td>
				<td width="150px">
					<form:input path="purchaseAmount"/>
					<form:errors path="purchaseAmount" cssClass="error"></form:errors>
				</td>
			</tr>
			
				<tr>
				<td>Purchase Date</td>
				<td width="150px">
					<form:input id="datepicker" path="purchaseDate"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit">
				</td>
			</tr>
		</table>
	</form:form>
	</c:if>
</center>
</body>
</html>