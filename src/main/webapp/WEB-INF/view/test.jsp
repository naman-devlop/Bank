
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-12 d-flex">
	<div class="col-3 d-flex">
		<div class="col-5 font-weight-bold">Name:</div><div class="col-5">${customer.name}</div>
	</div>
	<div class="col-3 d-flex">
		<div class="col-5 font-weight-bold">Account:</div><div class="col-5">${customer.account}</div>
	</div>
	<div class="col-3 d-flex">
		<div class="col-5 font-weight-bold">IFSC:</div><div class="col-5">${customer.ifcCode}</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

<jsp:include page="footer.jsp"></jsp:include>
