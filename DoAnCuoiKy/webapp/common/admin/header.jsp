<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.1
Version: 3.6
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<head>
<meta charset="utf-8"/>
<title>Metronic</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>
 
<!-- Bootstrap DataTable CSS -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css">
<link href="<c:url value="/templates/theme/assets/global/plugins/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/templates/theme/assets/global/plugins/simple-line-icons/simple-line-icons.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/templates/theme/assets/global/plugins/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/templates/theme/assets/global/plugins/uniform/css/uniform.default.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/templates/theme/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"/>" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="<c:url value="/templates/theme/assets/global/plugins/select2/select2.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/templates/theme/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>"/>
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="<c:url value="/templates/theme/assets/global/css/components.css"/>" id="style_components" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/theme/assets/global/css/plugins.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/theme/assets/admin/layout2/css/layout.css"/>" rel="stylesheet" type="text/css"/>
<link id="style_color" href="<c:url value="/templates/theme/assets/admin/layout2/css/themes/grey.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/templates/theme/assets/admin/layout2/css/custom.css"/>" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="<c:url value="/templates/templates/admin2/favicon.ico"/>"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-boxed page-header-fixed page-container-bg-solid page-sidebar-closed-hide-logo ">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner container">
		<!-- BEGIN LOGO -->
		<div class="page-logo" style="display:table-cell; vertical-align:middle; text-align:center">
			<a href="<c:url value='/admin/home'/>">
			<img src="<c:url value="/templates/dashboard.png"/>" width="100%" alt="logo" class="logo-default"/>
			</a><h4>ADMIN</h4>
			
		</div>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		
		<!-- BEGIN PAGE TOP -->
		<div class="page-top">
		
			<!-- BEGIN TOP NAVIGATION MENU -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
				
			<c:choose>
				<c:when test="${sessionScope.acc != null}">
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<img alt="" class="img-circle" src="<c:url value="/templates/manager.png"/>"/>
						<span class="username username-hide-on-mobile">
						${sessionScope.acc.user} </span>
						<i class="fa fa-angle-down"></i>
						</a>
						<ul class="dropdown-menu dropdown-menu-default">
							<li>
								<a href="<c:url value='/logout'/>">
								<i class="fa fa-sign-out"></i> Log Out </a>
							</li>
						</ul>
					</li>
					</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
			</div>
			<!-- END TOP NAVIGATION MENU -->
		</div>
		<!-- END PAGE TOP -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->