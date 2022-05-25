
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp" />
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container col-12 p-0 m-0">
	<div class="col-12 d-flex flex-wrap m-0 p-0 justify-content-center">
		<div class="col-12 text-center m-0 p-0 font-weight-bold text-primary">Add
			Customer</div>
		<div class="col-12 d-flex  m-0 ">
			<form class="col-12 m-0 p-0 d-flex flex-wrap" id = "customerAddForm">
				<div class="form-group col-5 d-flex flex-wrap">
					<label class="">Customer's Name</label> <input type="text"
						name="name" id="name" class="form-control"
						placeholder="Customer's Name" />
				</div>

				<div class="form-group col-5 d-flex flex-wrap">
					<label class="">Customer's Account</label> <input type="text"
						name="account" id="account" class="form-control"
						placeholder="Customer's Account Number" />
				</div>

				<div class="form-group col-5 d-flex flex-wrap">
					<label class="">Customer's IFSC</label> <input type="text"
						name="ifsc" id="ifsc" class="form-control"
						placeholder="Customer's IFSC" />
				</div>
				<div class="form-group col-5 d-flex flex-wrap m-1 p-1">
					<button class="btn btn-primary m-0 p-0 col-2" id="saveCustomerBtn">Save</button>
				</div>
			</form>
		</div>
	</div>
	<div class="col-12 d-flex m-0 p-0 ">
		<table class="table">
			<thead class="">
				<tr class="">
					<th scope="col">Customer's Id</th>
					<th scope="col">Customer's Name</th>
					<th scope="col">Customer's Account</th>
					<th scope="col">Customer's IFSC</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="customer" items="${customers}">
					<tr>
						<td>${customer.id}</td>
						<td>${customer.name}</td>
						<td>${customer.account}</td>
						<td>${customer.ifcCode}</td>

						<td class="m-0 p-0 d-flex ">
							<button class="btn btn-outline-success m-2 p-1 updateCustomerBtn">
								<i class="fa fa-pencil text-success" aria-hidden="true"></i>
							</button>
							<button class="btn m-2 btn-outline-danger p-1 deleteCustomerBtn">
								<i class="fa fa-trash text-danger" aria-hidden="true"></i>
							</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</div>


<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

<jsp:include page="footer.jsp"></jsp:include>
