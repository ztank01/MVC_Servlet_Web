<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<body class="page-header-fixed page-quick-sidebar-over-content ">
	<!-- BEGIN HEADER -->
	<div class="page-header navbar navbar-fixed-top">
		<!-- BEGIN HEADER INNER -->
		<div class="page-header-inner">
			<!-- BEGIN LOGO -->
			<div class="page-logo">
				<a href="index.html"> <img
					src="templates/assets/admin/layout/img/logo.png" alt="logo"
					class="logo-default" />
				</a>
				<div class="menu-toggler sidebar-toggler hide">
					<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
				</div>
			</div>
			<!-- END LOGO -->
			<!-- BEGIN RESPONSIVE MENU TOGGLER -->
			<a href="javascript:;" class="menu-toggler responsive-toggler"
				data-toggle="collapse" data-target=".navbar-collapse"> </a>
			<!-- END RESPONSIVE MENU TOGGLER -->
			<!-- BEGIN TOP NAVIGATION MENU -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
					<!-- BEGIN INBOX DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<!-- END INBOX DROPDOWN -->
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-user"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						data-hover="dropdown" data-close-others="true"> <img alt=""
							class="img-circle"
							src="templates/assets/admin/layout/img/avatar3_small.jpg" /> <span
							class="username username-hide-on-mobile"> ${sessionScope.acc.user} </span> <i
							class="fa fa-angle-down"></i>
					</a>
						<ul class="dropdown-menu dropdown-menu-default">
							<li>
								<a href="<c:url value='/home'/>">
								<i class="glyphicon glyphicon-shopping-cart"></i> Become Buyer </a>
							</li>
							<li>
								<a href="<c:url value='/logout'/>">
								<i class="fa fa-sign-out"></i> Log Out </a>
							</li>
						</ul></li>
					<!-- END USER LOGIN DROPDOWN -->
					<!-- BEGIN QUICK SIDEBAR TOGGLER -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte --> 	
					<!-- END QUICK SIDEBAR TOGGLER -->
				</ul>
			</div>
			<!-- END TOP NAVIGATION MENU -->
		</div>
		<!-- END HEADER INNER -->
	</div>
	<!-- END HEADER -->
	<div class="clearfix"></div>