
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp" />

<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-12 d-flex justify-content-center">
<c:if test=" ${not empty error}">
	<div class="alert alert-danger col-4" role="alert">${error.message}
	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
	</div>
</c:if>
</div>
<div class="container col-12 p-0 m-0 ">
	<div class="col-12 d-flex flex-wrap">
		<div class="col-12 d-flex  m-2 p-1 ">

			<div class="d-flex col-12">
				<input type="text" class="form-control" id="searchCustomerField"
					placeholder="Enter the customer account ">
				<button class="btn btn-primary " id="searchCustomerBtn">Search</button>
			</div>
		</div>

		<div class="col-12 d-flex">
			<div class="col-4 d-flex flex-wrap m-0 p-0">
				<div class="col-12 d-flex">
					<div class="col-5 font-weight-bold">Name:</div>
					<div class="col-5">${customer.name}</div>
				</div>
				<div class="col-12 d-flex">
					<div class="col-5 font-weight-bold">Account:</div>
					<div class="col-5">${customer.account}</div>
				</div>
				<div class="col-12 d-flex">
					<div class="col-5 font-weight-bold">IFSC:</div>
					<div class="col-5">${customer.ifcCode}</div>
				</div>
				<div class="col-12 d-flex">
					<div class="col-6 font-weight-bold text-primary">Current
						Balance:</div>
					<div class="col-6 p-0 m-0">Rs. ${currentBalance}</div>
				</div>
			</div>
			<div class="col-7 ">
				<form class="col-12 m-0 p-0 d-flex flex-wrap" id= "txForm">
				<div class="col-4 form-group">
						<input type="text" class="form-control" id="customerId" name="customerId"
							placeholder="" value="${customer.id}"
							readonly="true">
					</div>
					<div class="col-4 form-group">
						<input type="text" class="form-control" id="customerAccount" name="customerAccount"
							placeholder="Enter account" value="${customer.account}"
							readonly="true">
					</div>
					<div class="col-4 form-group">
						<input type="text" class="form-control" id="customerIFSC" name="customerIFSC"
							placeholder="Enter IFSC" value="${customer.ifcCode}">
					</div>
					<div class="col-3 form-group">
						<input type="text" class="form-control" id="amount" name="amount"
							placeholder="Enter Amount">
					</div>
					<div class="col-3 form-group">
						<input type="text" class="form-control" id="txType" name="txType"
							placeholder="CR/DB">
					</div>
					<button class="btn btn-primary col-3" id="txBtn">Submit</button>
				</form>
			</div>
		</div>

		<div class="col-12">
			<div
				class="col-12 mt-3 mb-3 text-center font-weight-bold h2 text-warning">Transaction
				History</div>
			<table class="table">
				<thead>
					<tr>
						<th>Account</th>
						<th>CreditAmount</th>
						<th>DebitAmount</th>

						<th>Transaction Type</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tx" items="${transactionInfo}">
						<tr>
							<td>${tx.account}</td>
							<td>${tx.creditAmount}</td>
							<td>${tx.debitAmount}</td>
							<td>${tx.transactionType}</td>
							<td>${tx.transactionDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"
			integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
			crossorigin="anonymous"></script>

		<jsp:include page="footer.jsp"></jsp:include>