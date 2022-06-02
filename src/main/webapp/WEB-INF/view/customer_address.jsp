<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp" />
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id = "addressForm" name ="addressForm"class="col-12 d-flex m-0 p-0 flex-wrap">
	<div class="form-group col-5">
		<label>Current Address</label>
		<input type = "text" class="form-control" name = "customerCurrentAddress" id = "customerCurrentAddress" value= ${customerAddress.currentLocation}>
	</div>
	<div class="form-group col-5">
		<label>Permanent Address</label>
		<input type = "text" class="form-control" name = "customerPermanentAddress" id = "customerPermanentAddress" value= ${customerAddress.permanentLocation}>
	</div>
	<div class="form-group col-3">
		<label>Account</label>
		<input type = "text" class="form-control" name = "customerAccount" id = "customerAccount" readonly = "true" value =${account}>
	</div>
	<div class="form-group col-3">
		<label>Mobile</label>
		<input type = "text" class="form-control" name = "customerMobile" id = "customerMobile" value= ${customerAddress.mobileNumber}>
	</div>
		<div class="form-group col-3">
		<label>Email</label>
		<input type = "email" class="form-control" name = "customerEmail" id = "customerEmail" value= ${customerAddress.email}>
	</div>
		<div class="form-group col-3 pt-4">
		<button class = "btn btn-primary" id ="addressSaveBtn">save</button>
	</div>
	
</form>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<jsp:include page="footer.jsp"></jsp:include>