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
<c:set var = "pageTitle" scope = "session" value = "${'Enquiry'}"/>
</head>
<body>
	<%@include file="templates/header.jsp"%>
	<%@include file="templates/navigation.jsp"%>
	<!-- Content - Start  -->
	<div id="content-wrapper">
		<div class="container-fluid">
			<div class="dt-container">
				<table class="table" id="enquiryTable">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Message</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>ID</td>
							<td>Name</td>
							<td>Phone</td>
							<td>Email</td>
							<td>Message</td>
							<td>Status</td>
							<th>Action</th>
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
			
			//var enq = ${enquiries};
			
			var $table = $('#enquiryTable').DataTable( {
	            "ajax":{
	            	url: '/enquiry',
	            	dataSrc:"",
			        type: "GET",
	                headers: { 'Accept': "application/json" },
	            },
			    "columns": [
			        { data: 'enquiryId' },
			        { data: 'name' },
			        
			        { data: 'phoneNo' },
			        { data: 'email' },
			        
			        { data: 'message' },
			        { data: 'status',
			        	render: function(data, type) {
		                    if (type === 'display') {
		                        let css_class = '';
		 
		                        switch (data) {
		                            case 'NEW':
		                            	css_class = 'warning';
		                                break;
		                            case 'INPROGRESS':
		                            	css_class = 'info';
		                                break;
		                            case 'COMPLETED':
		                            	css_class = 'success';
		                                break;
		                        }
		                        fClass = "text-black p-1 mb-2 bg-" + css_class
		 
		                        return '<div class="text-center ' + fClass + '">' + data+ '</div>';
		                    }
		 
		                    return data;
		                }
			        },
			        {
			            data: 'Action',
			            render: function ( data, type, row ) {
			            	var $select = $('<select class="form-select form-select-sm updateStatus" aria-label="Default select example">'
					                + '<option value="NEW" disabled>New</option>'
					                + '<option value="INPROGRESS">In Progress</option>'
					                + '<option value="COMPLETED">Completed</option>'
					                + '</select>');
			            	$select.find('option[value="'+row.status+'"]').attr('selected', 'selected');
			            	return $select[0].outerHTML;
			            },
			        }
			    ]
					    
			});

			$('#enquiryTable tbody').on('change', 'td select', function (){
			    //todo
		        var data_row = $table.row($(this).closest('tr')).data();
		        //console.log(data_row);
		        $.ajax({
		        	'url':'/enquiry/'+ data_row.enquiryId + '?status=' + $(this).val(),
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
		// document ready completed	
		});
	</script>
</body>
</html>
