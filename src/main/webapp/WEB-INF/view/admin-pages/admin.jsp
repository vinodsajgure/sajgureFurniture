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
<title>SF - Admin </title>

<%@include file="templates/imports_top.jsp"%>
<c:set var = "pageTitle" scope = "session" value = "${'Dashboard'}"/>
</head>
<body>
	<%@include file="templates/header.jsp"%>
	<%@include file="templates/navigation.jsp"%>
	<!-- Content - Start  -->
	<div id="content-wrapper">
		<div class="container-fluid">
			<div class="chart-row three">
				<div class="chart-container-wrapper">
					<div class="chart-container">
						<div class="chart-info-wrapper">
							<h2>Carousels</h2>
							<span>${carouselCounts.total}</span>
						</div>
						<div class="chart-svg">
							<svg viewBox="0 0 36 36" class="circular-chart green">
      							<path class="circle-bg"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <path class="circle" stroke-dasharray="${ carouselCounts.activePerc }, 100"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <text x="18" y="20.35" class="percentage">${carouselCounts.active}</text>
							      <text x="18" y="26.35" class="text-status">Active</text>
							    </svg>
						</div>
						
						<div class="chart-svg">
							<svg viewBox="0 0 36 36" class="circular-chart orange">
      							<path class="circle-bg"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <path class="circle" stroke-dasharray="${ carouselCounts.inactivePerc }, 100"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <text x="18" y="20.35" class="percentage">${carouselCounts.inactive}</text>
							      <text x="18" y="26.35" class="text-status">Inactive</text>
							    </svg>
						</div>
					</div>
				</div>
				<div class="chart-container-wrapper">
					<div class="chart-container">
						<div class="chart-info-wrapper">
							<h2>Enquiries</h2>
							<span>${enquiryCounts.total}</span>
						</div>
						<div class="chart-svg">
							<svg viewBox="0 0 36 36" class="circular-chart green">
      							<path class="circle-bg"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <path class="circle" stroke-dasharray="${ enquiryCounts.completedPerc }, 100"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <text x="18" y="20.35" class="percentage">${enquiryCounts.completed}</text>
							      <text x="18" y="26.35" class="text-status">Completed</text>
							    </svg>
						</div>
						
						<div class="chart-svg">
							<svg viewBox="0 0 36 36" class="circular-chart orange">
      							<path class="circle-bg"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <path class="circle" stroke-dasharray="${ enquiryCounts.inprogressPerc }, 100"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <text x="18" y="20.35" class="percentage">${enquiryCounts.inProgress}</text>
							      <text x="18" y="26.35" class="text-status">In Progress</text>
							    </svg>
						</div>
						
						<div class="chart-svg">
							<svg viewBox="0 0 36 36" class="circular-chart teal">
      							<path class="circle-bg"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <path class="circle" stroke-dasharray="${ enquiryCounts.newPerc }, 100"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <text x="18" y="20.35" class="percentage">${enquiryCounts.inNew}</text>
							      <text x="18" y="26.35" class="text-status">New</text>
							    </svg>
						</div>
						
					</div>
				</div>
				<div class="chart-container-wrapper">
					<div class="chart-container">
						<div class="chart-info-wrapper">
							<h2>Users</h2>
							<span>${userCounts.total}</span>
						</div>
						<div class="chart-svg">
							<svg viewBox="0 0 36 36" class="circular-chart green">
      							<path class="circle-bg"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <path class="circle" stroke-dasharray="${ userCounts.enabledPerc}, 100"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <text x="18" y="20.35" class="percentage">${userCounts.enabled}</text>
							      <text x="18" y="26.35" class="text-status">Enabled</text>
							    </svg>
						</div>
						<div class="chart-svg">
							<svg viewBox="0 0 36 36" class="circular-chart orange">
      							<path class="circle-bg"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <path class="circle" stroke-dasharray="${ userCounts.disabledPerc == 0.00 ? 0 :  userCounts.disabledPerc}, 100"
									d="M18 2.0845
							          a 15.9155 15.9155 0 0 1 0 31.831
							          a 15.9155 15.9155 0 0 1 0 -31.831"></path>
							      <text x="18" y="20.35" class="percentage">${userCounts.disabled}</text>
							      <text x="18" y="26.35" class="text-status">Disabled</text>
							    </svg>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="templates/nav-toggle-script.jsp"%>
</body>
</html>
