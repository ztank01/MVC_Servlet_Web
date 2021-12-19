<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
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
<html lang="vi">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>Metronic | eCommerce - Dashboard</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description" />
<meta content="" name="author" />

<!-- Bootstrap DataTable CSS -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/templates/assets/global/plugins/font-awesome/css/font-awesome.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/templates/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/templates/assets/global/plugins/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/templates/assets/global/plugins/uniform/css/uniform.default.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/templates/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" />"
	rel="stylesheet" type="text/css">
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN THEME STYLES -->
<link
	href="<c:url value="/templates/assets/global/css/components.css" />"
	id="style_components" rel="stylesheet" type="text/css">
<link href="<c:url value="/templates/assets/global/css/plugins.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/templates/assets/admin/layout/css/layout.css" />"
	rel="stylesheet" type="text/css">
<link id="style_color"
	href="<c:url value="/templates/assets/admin/layout/css/themes/darkblue.css" />"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/templates/assets/admin/layout/css/custom.css" />"
	rel="stylesheet" type="text/css">
<!-- END THEME STYLES -->
<link rel="shortcut icon"
	href="<c:url value="/templates/favicon.ico" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "
	page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body
	element to force fixed header or footer in mobiledevices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body>
	<!-- header -->
	<%@ include file="/common/seller/header.jsp"%>
	<!-- end header -->
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- left -->
		<%@ include file="/common/seller/left.jsp"%>
		<!-- end left -->
		<!-- content -->

		<dec:body />

		<!-- end content -->
	</div>
	<!-- footer -->
	<%@ include file="/common/seller/footer.jsp"%>
	<!-- end footer -->
	<!-- END CONTAINER -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<!--[if lt IE 9]>
<script src="templates/assets/global/plugins/respond.min.js"></script>
<script src="templates/assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
	<script src="templates/assets/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="templates/assets/global/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script
		src="templates/assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"
		type="text/javascript"></script>
	<script
		src="templates/assets/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="templates/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
		type="text/javascript"></script>
	<script
		src="templates/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<script src="templates/assets/global/plugins/jquery.blockui.min.js"
		type="text/javascript"></script>
	<script src="templates/assets/global/plugins/jquery.cokie.min.js"
		type="text/javascript"></script>
	<script
		src="templates/assets/global/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>
	<script
		src="templates/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script src="templates/assets/global/plugins/flot/jquery.flot.js"
		type="text/javascript"></script>
	<script
		src="templates/assets/global/plugins/flot/jquery.flot.resize.js"
		type="text/javascript"></script>
	<script
		src="templates/assets/global/plugins/flot/jquery.flot.categories.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="templates/assets/global/scripts/metronic.js"
		type="text/javascript"></script>
	<script src="templates/assets/admin/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script src="templates/assets/admin/layout/scripts/quick-sidebar.js"
		type="text/javascript"></script>
	<script src="templates/assets/admin/layout/scripts/demo.js"
		type="text/javascript"></script>
	<script src="templates/assets/admin/pages/scripts/ecommerce-index.js"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			QuickSidebar.init(); // init quick sidebar
			Demo.init(); // init demo features
			EcommerceIndex.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>