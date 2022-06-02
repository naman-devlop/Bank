/**
 * 
 */

$("#customerBtn1").click(function() {
	var url = "/bank/customerPage";
	$.ajax({
		url: url,
		type: "Get",
		success: function() {
			window.location = url;
		}
	});
});

$("#homePagebtn").click(function() {
	var url = "/bank/home";
	$.ajax({
		url: url,
		type: "Get",
		success: function() {
			window.location = url;
		}
	});
});

$("#txnBtn").click(function() {
	var url = "/bank/transactionPage";
	$.ajax({
		url: url,
		type: "Get",
		success: function() {
			window.location = url;
		}
	});
});


$("#saveCustomerBtn").click(function() {
	$.ajax({
		type: "POST",
		url: "/bank/addCustomerFromJsp",

		data: $("#customerAddForm").serialize(),
		success: function(msg) {
			location.reload();
		}

	});
})

$(".deleteCustomerBtn").click(function() {
	var row = $(this).closest("tr");
	var account = row.find("td:eq(2)").html();

	$.ajax({
		type: "DELETE",
		url: "/bank/deleteCustomerFromJsp/" + account,
		success: function(msg) {
			location.reload();

		}
	});
});

$(".updateCustomerBtn").click(function() {
	var row = $(this).closest("tr");
	var account = row.find("td:eq(2)").html();
	var name = row.find("td:eq(1)").html();
	var ifsc = row.find("td:eq(3)").html();
	$("#account").val(account);
	$("#name").val(name);
	$("#ifsc").val(ifsc);
	$("#account").prop("readonly", true);
});

$("#searchCustomerBtn").click(function() {
	var account = $("#searchCustomerField").val();
	var url = "/bank/searchCustomer/" + account;
	$.ajax({
		type: "GET",
		url: url,
		success: function(msg) {
			window.location = url;

		}
	});
})


$("#txBtn").click(function() {
	var data = $("#txForm").serialize();
	$.ajax({
		type: "POST",
		url: "/bank/saveCustomerTx",
		data: data,
		success: function(response) {
			alert(response);
			location.reload();
		}
	});

})

$(".addressBtn").click(function() {
	var row = $(this).closest("tr");
	var account = row.find("td:eq(2)").html();
	var url = "/bank/updateCustomerAddressFromJsp/"+account;
	$.ajax({
		type: "GET",
		url: url,
		data: account,
		success: function(response) {
		location.href= url;
		}
	});
})

$("#addressSaveBtn").click(function(){
	var data = $("#addressForm").serialize();
	var account = $("#customerAccount").val();
	var url = "/bank/saveCustomerAddressJsp/"+ account;
	
	$.ajax({
		type: "POST",
		data: data,
		url: url,
		success: function(response) {
			alert(response);
			location.reload();
		}
	});
})
