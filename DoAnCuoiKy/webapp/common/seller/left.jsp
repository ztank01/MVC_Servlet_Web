<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- BEGIN SIDEBAR -->
<div class="page-sidebar-wrapper">
	<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
	<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
	<div class="page-sidebar navbar-collapse collapse">
		<!-- BEGIN SIDEBAR MENU -->
		<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
		<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
		<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
		<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
		<ul class="page-sidebar-menu" data-keep-expanded="false"
			data-auto-scroll="true" data-slide-speed="200">
			<!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
			<li class="sidebar-toggler-wrapper">
				<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				<div class="sidebar-toggler"></div> <!-- END SIDEBAR TOGGLER BUTTON -->
			</li>
			<!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->
			<li class="sidebar-search-wrapper">
				<!-- BEGIN RESPONSIVE QUICK SEARCH FORM --> <!-- DOC: Apply "sidebar-search-bordered" class the below search form to have bordered search box -->
				<!-- DOC: Apply "sidebar-search-bordered sidebar-search-solid" class the below search form to have bordered & solid search box -->
			</li>
			<li class="active open"><a href="${pageContext.request.contextPath}/seller_home"> <i
					class="icon-home"></i> <span class="title"> Home</span>
			</a></li>
			<li class="active open"><a href="javascript:;"> <i
					class="icon-basket"></i> <span class="title"> Orders</span> <span
					class="selected"></span> <span class="arrow open"></span>
			</a>
				<ul class="sub-menu">
					<li><a href="${pageContext.request.contextPath}/seller_orders"> <i
							class="icon-basket"></i> All Orders
					</a></li>
				</ul></li>
			<li class="active open"><a href="javascript:;"> <i
					class="icon-handbag"></i> <span class="title"> Product</span> <span
					class="selected"></span> <span class="arrow open"></span>
			</a>
				<ul class="sub-menu">
					<li><a href="${pageContext.request.contextPath}/seller_products"> <i
							class="icon-handbag"></i> All Products
					</a></li>
					<li><a href="${pageContext.request.contextPath}/seller_products_add?pid=0"> <i
							class="icon-pencil"></i> Add New Product
					</a></li>
				</ul></li>
		</ul>
		<!-- END SIDEBAR MENU -->
	</div>
</div>
<!-- END SIDEBAR -->