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
<c:set var="pageTitle" scope="session" value="${'Carousel'}" />
</head>
<body>
	<%@include file="templates/header.jsp"%>
	<%@include file="templates/navigation.jsp"%>
	<!-- Content - Start  -->
	<div id="content-wrapper">
		<div class="container-fluid">
			<div class="dt-container">
				<table class="table" id="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Text</th>
							<th>Filename</th>
							<th>Type</th>
							<th>Image</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>ID</td>
							<td>Text</td>
							<td>Filename</td>
							<td>Type</td>
							<td>Image</td>
							<td>Status</td>
							<td>Action</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="fn-form">
				<h3>Add New Carousel Image</h3>
				<form action="<c:url value='/carousel'/>" method="post"
					enctype="multipart/form-data">
					<div class="form-group col-md-3">
						<label for="text">Text (Description)</label> <input type="text"
							class="form-control" name="text" placeholder="Image text" />
					</div>
					<div class="form-group col-md-3">
						<label for="file">Image</label> <input type="file"
							class="form-control-file" id="carouselFile" name="file">
					</div>
					<button type="submit" class="btn btn-primary col-md-3">Add</button>
				</form>
			</div>

		</div>
	</div>
	<%@include file="templates/nav-toggle-script.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
		// document ready started
			
			var $table = $('#table').DataTable( {
	            "ajax":{
	            	url: '/carousel',
	            	dataSrc:"",
			        type: "GET",
	                headers: { 'Accept': "application/json" },
	            },
			    "columns": [
			        { data: 'id' },
			        { data: 'text' },
			        
			        { data: 'fileName' },
			        { data: 'type' },
			        
			        { 
				        data: 'image',
			            render: function ( data, type, row ) {
			            	return '<img src="data:' + type + ';base64,'+ data +'" width="50" height="50" />';
			            }
				    },
			        { 
				        data: 'status',
			        	render: function(data, type) {
		                    if (type === 'display') {
		                        let css_class = '';
		 
		                        switch (data) {
		                            case 'Inactive':
		                            	css_class = 'info';
		                                break;
		                            case 'Active':
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

			            	var $select = $('<select class="form-select form-select-sm updateStatus">'
					                + '<option value="Inactive">Inactive</option>'
					                + '<option value="Active">Active</option>'
					                + '</select>');
			            	$select.find('option[value="'+row.status+'"]').attr('selected', 'selected');

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
		        	'url':'/carousel/'+ data_row.id + '?status=' + $(this).val(),
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
		        	'url':'/carousel/'+ data_row.id,
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
			
		// document ready completed	
		});
	</script>
</body>
</html>
