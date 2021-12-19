<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Men category | Metronic Shop UI</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<meta content="Metronic Shop UI description" name="description">
<meta content="Metronic Shop UI keywords" name="keywords">
<meta content="keenthemes" name="author">

<meta property="og:site_name" content="-CUSTOMER VALUE-">
<meta property="og:title" content="-CUSTOMER VALUE-">
<meta property="og:description" content="-CUSTOMER VALUE-">
<meta property="og:type" content="website">
<meta property="og:image" content="-CUSTOMER VALUE-">
<!-- link to image for socio -->
<meta property="og:url" content="-CUSTOMER VALUE-">

<link rel="shortcut icon" href="favicon.ico">

<!-- Fonts START -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
	rel="stylesheet" type="text/css">
<!-- Fonts END -->

<!-- Global styles START -->
<link
	href="templates/css/assets/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="templates/css/assets/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Global styles END -->
<link href="<c:url value="templates/css/style.css" />" rel="stylesheet" type="text/css">
<!-- Page level plugin styles START -->
<link
	href="templates/css/assets/global/plugins/fancybox/source/jquery.fancybox.css"
	rel="stylesheet">
<link
	href="templates/css/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css"
	rel="stylesheet">
<link
	href="templates/css/assets/global/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css">
<link
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"
	rel="stylesheet" type="text/css">
<!-- for slider-range -->
<link href="templates/css/assets/global/plugins/rateit/src/rateit.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin styles END -->

<!-- Theme styles START -->
<link href="templates/css/assets/global/css/components.css"
	rel="stylesheet">
<link href="templates/css/assets/frontend/layout/css/style.css"
	rel="stylesheet">
<link href="templates/css/assets/frontend/pages/css/style-shop.css"
	rel="stylesheet" type="text/css">
<link
	href="templates/css/assets/frontend/layout/css/style-responsive.css"
	rel="stylesheet">
<link href="templates/css/assets/frontend/layout/css/themes/red.css"
	rel="stylesheet" id="style-color">
<link href="templates/css/assets/frontend/layout/css/custom.css"
	rel="stylesheet">

<!-- Theme styles END -->
</head>
<!-- Head END -->

<body>
	<!-- header -->
	<%@include file="/common/web/header.jsp"%>
	<!--end header  -->
	<!-- content -->
	<dec:body />
	<!-- end content -->
	<!-- footer -->
	<%@include file="/common/web/footer.jsp"%>
	<!-- end footer -->

	<!-- JS -->

	<!-- Load javascripts at bottom, this will reduce page load time -->
	<!-- BEGIN CORE PLUGINS(REQUIRED FOR ALL PAGES) -->
	<!--[if lt IE 9]>
    <script src="../../assets/global/plugins/respond.min.js"></script>  
    <![endif]-->
	<script src="templates/css/assets/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="templates/css/assets/global/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<script
		src="templates/css/assets/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="templates/css/assets/frontend/layout/scripts/back-to-top.js"
		type="text/javascript"></script>
	<script
		src="templates/css/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
	<script
		src="templates/css/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js"
		type="text/javascript"></script>
	<!-- pop up -->
	<script
		src="templates/css/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<!-- slider for products -->
	<script
		src='templates/css/assets/global/plugins/zoom/jquery.zoom.min.js'
		type="text/javascript"></script>
	<!-- product zoom -->
	<script
		src="templates/css/assets/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js"
		type="text/javascript"></script>
	<!-- Quantity -->
	<script
		src="templates/css/assets/global/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>
	<script
		src="templates/css/assets/global/plugins/rateit/src/jquery.rateit.js"
		type="text/javascript"></script>
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"
		type="text/javascript"></script>
	<!-- for slider-range -->
	<script src="//code.jquery.com/jquery-3.6.0.min.js" type="text/javascript"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="templates/css/assets/frontend/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			Layout.init();
			Layout.initOWL();
			Layout.initTwitter();
			Layout.initImageZoom();
			Layout.initTouchspin();
			Layout.initUniform();
			Layout.initSliderRange();
		});
	</script>
	<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
</html>