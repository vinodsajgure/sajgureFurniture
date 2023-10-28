<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="msapplication-tap-highlight" content="no" />
<meta name="description" content="" />
<title>SF - Admin</title>

<%@include file="templates/imports_top.jsp"%>
<c:set var="pageTitle" scope="session" value="${'Users'}" />
</head>
<body>
	<%@include file="templates/header.jsp"%>
	<%@include file="templates/navigation.jsp"%>
	<!-- Content - Start  -->
	<div id="content-wrapper">
			<div class="container-fluid">
				<div class="dt-container">
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-success" data-bs-toggle="modal"
					data-bs-target="#userModal">Add New User</button>

				<!-- Modal -->
					<div class="modal fade" id="userModal" tabindex="-1"
						aria-labelledby="userModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="userModalLabel">Add New User</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form class="row g-3">
										<div class="col-md-6">
											<label for="fName" class="form-label">First Name</label> <input
												type="text" class="form-control" id="fName">
										</div>
										<div class="col-md-6">
											<label for="lName" class="form-label">Last Name</label> <input
												type="text" class="form-control" id="lName">
										</div>
										<div class="col-md-6">
											<label for="email" class="form-label">Email</label> <input
												type="email" class="form-control" id="email">
										</div>
										<div class="col-md-6">
											<label for="password" class="form-label">Password</label> <input
												type="password" class="form-control" id="password">
										</div>
										<div class="col-6">
											<label for="mobileNo" class="form-label">Mobile
												Number</label> <input type="text" class="form-control" id="mobileNo">
										</div>
										<div class="col-md-6">
											<label for="Role" class="form-label">Enabled Status</label> 
											<select
												class="form-select" id="enabled"><option
													value="false">Disable</option>
												<option value="true">Enable</option></select>
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary" id="saveUser">Save
										User</button>
								</div>
							</div>
						</div>
					</div>
					<p>
				
					<table class="table" id="table">
						<thead>
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Mobile No</th>
								<th>Role</th>
								<th>Enabled Status</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>First Name</td>
								<td>Last Name</td>
								<td>Email</td>
								<td>Mobile No</td>
								<td>Role</td>
								<td>Enabled Status</td>
								<td>Action</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	<%@include file="templates/nav-toggle-script.jsp"%>
	<script type="text/javascript">

		$(document).ready(function() {
		// document ready started
			
			var baseURL = "/users";
			
			var $table = $('#table').DataTable( {
	            "ajax":{
	            	url: baseURL,
	            	dataSrc:"",
			        type: "GET",
	                headers: { 'Accept': "application/json" },
	            },
			    "columns": [
			        { data: 'fName' },
			        { data: 'lName' },
			        { data: 'email' },
			        { data: 'mobileNo' },
			        { data: 'role' },
			        {
				        data: 'enabled',
			        	render: function(data, type) {
		                    if (type === 'display') {
		                        let css_class = '';
		 						var dispData;
		                        switch (data) {
		                            case true:
		                            	dispData = "Enabled";
		                            	css_class = 'success';
		                                break;
		                            case false:
		                            	dispData = "Disabled";
		                            	css_class = 'info';
		                                break;
		                        }
		                        fClass = "text-black p-1 mb-2 bg-" + css_class
		 
		                        return '<div class="text-white text-center ' + fClass + '">' + dispData + '</div>';
		                    }
		                    return data;
		                }
			        },
			        {
			            data: 'Action',
			            render: function ( data, type, row ) {

			            	var $select = $('<select class="form-select form-select-sm updateStatus">'
					                + '<option value="false">Disable</option>'
					                + '<option value="true">Enable</option>'
					                + '</select>');
			            	$select.find('option[value="'+row.enabled+'"]').attr('selected', 'selected');

			            	var $delete = $('<button type="button" class="btn btn-danger btn-sm">Delete</button>');

			            	var $div = $('<div class="row">'
			            		  + '<div class="col-auto">'
			                	  + $select[0].outerHTML
						          + '</div>'
						          + '<div class="col-auto">'
						          + $delete[0].outerHTML
						          + '</div>'
						          + '</div>');

			            	return  $div[0].outerHTML;
			            },
			        }
			    ]
					    
			});

			// Update status of carousel (active/inactive)
			$('#table tbody').on('change', 'td select', function (){
		        var data_row = $table.row($(this).closest('tr')).data();
		        //console.log(data_row);
		        $.ajax({
		        	'url': baseURL + '/'+ data_row.email + '?enabled=' + $(this).val(),
		        	'method':'PATCH',
		        	'contentType': 'application/json',
		        	'data':JSON.stringify({
		        	    "status":$(this).val(),
		        	 }),
		        	 success: function (data,status,xhr) {
		        		 $table.ajax.reload();
		        	 },
		        	 error: function (status) {
		        		 alert("Status updation failed!");
		        	 }
		        });
			});

			// Delete carousel
			$('#table tbody').on('click', 'td button', function (){
		        var data_row = $table.row($(this).closest('tr')).data();
		        //console.log(data_row);
		        $.ajax({
		        	'url':baseURL + '/'+ data_row.email,
		        	'method':'DELETE',
		        	'contentType': 'application/json',
		        	 success: function (data,status,xhr) {
		        		 $table.ajax.reload();
		        	 },
		        	 error: function (status) {
		        		 alert("Status updation failed!");
		        	 }
		        });
			});

			$("#saveUser").click(function(){

				var userData = {
							"fName": $('#fName').val(),
							"lName": $('#lName').val(),
							"email": $('#email').val(),
							"mobileNo": $('#mobileNo').val(),
							"role": "ADMIN",
							"enabled": $('#enabled').val(),
							"password": $('#password').val()
						}
				
				$.ajax({
		        	'url':baseURL,
		        	'method':'POST',
		        	'contentType': 'application/json',
		        	'data': JSON.stringify(userData),
		        	 success: function (data,status,xhr) {
		        		 $table.ajax.reload();
		        	 },
		        	 error: function (status) {
		        		 alert("Status updation failed!");
		        	 }
		        }); 
			});
			
		// document ready completed	
		});
	</script>
</body>
</html>
