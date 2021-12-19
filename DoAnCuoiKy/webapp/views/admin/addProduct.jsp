<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="clearfix"></div>
<div class="container">
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
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
				<ul class="page-sidebar-menu page-sidebar-menu-hover-submenu "
					data-keep-expanded="false" data-auto-scroll="true"
					data-slide-speed="200">
					<li class="start"><a href="<c:url value='/admin/home'/>"> <i class="fa fa-home"></i>
							<span class="title">Home</span>
					</a></li>
					<li><a href="javascript:;"> <i
							class="fa fa-archive"></i> <span class="title">Quản lý danh mục</span>
					</a>
						<ul class="sub-menu">
							<li><a href="<c:url value='/admin/category/list'/>"> <i
									class="fa fa-list-ul"></i> Danh mục sản phẩm
							</a></li>
							<li><a href="<c:url value='/admin/category/add'/>">
									<i class="fa fa-plus-square"></i> Thêm danh mục
							</a></li>
						</ul></li>
					<li class="active open"><a href="javascript:;"> <i
							class="fa fa-shopping-cart"></i> <span class="title">Quản lý sản phẩm</span><span
							class="selected"></span> <span class="arrow open"></span>
					</a>
						<ul class="sub-menu">
							<li><a href="<c:url value='/admin/product/list'/>"> <i
									class="fa fa-list-ul"></i> Danh sách sản phẩm
							</a></li>
							<li class="active"><a href="<c:url value='/admin/product/add'/>"> <i
									class="fa fa-cart-plus"></i> Thêm sản phẩm mới
							</a></li>
						</ul></li>
					<li><a href="javascript:;"> <i 
						class="material-icons">account_box</i> <span class="title">Quản lý tài khoản</span>
					</a>
						<ul class="sub-menu">
							<li><a href="<c:url value='/admin/user/list'/>"> <i
									class="fa fa-list-ul"></i> Danh sách người dùng
							</a></li>
							<li><a href="<c:url value='/admin/user/add'/>"> <i
									class="fa fa-user-plus"></i> Thêm tài khoản mới
							</a></li>
						</ul></li>
					<li><a href="javascript:;"> <i
							class="fa fa-truck"></i> <span class="title">Quản lý đơn hàng</span>
					</a>
						<ul class="sub-menu">
							<li><a href="<c:url value='/admin/orderItem/list'/>"> <i
									class="fa fa-list-ul"></i>Danh sách  đơn hàng
							</a></li>
						</ul></li>
					<li><a href="javascript:;"> <i
							class="fa fa-bar-chart"></i> <span class="title">Thống kê báo cáo</span>
					</a>
						<ul class="sub-menu">
							<li><a href="<c:url value='/admin/chart/product'/>"> <i
									class="fa fa-pie-chart"></i> Thống kê sản phẩm
							</a></li>
							
						</ul></li>
				</ul>
				<!-- END SIDEBAR MENU -->
			</div>
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<div class="page-content">
				<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				<div class="modal fade" id="portlet-config" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title">Modal title</h4>
							</div>
							<div class="modal-body">Widget settings form goes here</div>
							<div class="modal-footer">
								<button type="button" class="btn blue">Save changes</button>
								<button type="button" class="btn default" data-dismiss="modal">Close</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				
				<!-- BEGIN PAGE HEADER-->
				<h3 class="page-title">
					Danh sách sản phẩm <small></small>
				</h3>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-edit"></i>Thêm sản phẩm mới
								</div>
							</div>
							<div class="portlet-body">

								<form role="form" action="add" method="post"
									enctype="multipart/form-data">
									<div class="form-group">
										<label>Tên sản phẩm:</label> <input class="form-control"
											placeholder="please enter category Name" name="name" />
									</div>
									<div class="form-group">
										<label>Mô tả:</label>
										<textarea name="editor"></textarea>
										<script>
											CKEDITOR.replace('editor');
										</script>
									</div>
									<div class="form-group">
										<label>Giá sản phẩm:</label> <input type="number"
											class="form-control" placeholder="please enter category Name"
											name="price" />
									</div>
									<div class="form-group">
										<label>Ảnh đại diện:</label> <input type="file" name="icon" />
									</div>
									<div class="form-group">
										<label>Thuộc danh mục sản phẩm:</label> <select name="cate_id">
											<c:forEach items="${cateList}" var="cate">
												<option value="${cate.cate_id}">${cate.cate_name}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label>Người bán:</label> <select name="seller_id">
											<c:forEach items="${sellerList}" var="seller">
												<option value="${seller.uid}">${seller.user}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<label>Số lượng đã bán:</label> <input type="number"
											class="form-control" placeholder="please enter category Name"
											name="amount" />
									</div>
									<div class="form-group">
										<label>Số lượng trong kho:</label> <input type="number"
											class="form-control" placeholder="please enter category Name"
											name="inStock" />
									</div>
									<button type="submit" class="btn btn-default">Thêm</button>
									<button type="reset" class="btn btn-primary">Hủy</button>
								</form>

							</div>
						</div>
						<!-- END EXAMPLE TABLE PORTLET-->
					</div>
				</div>
				<!-- END PAGE CONTENT -->
			</div>
		</div>
		<!-- END CONTENT -->
		<!-- BEGIN QUICK SIDEBAR -->
		<!--Cooming Soon...-->
		<!-- END QUICK SIDEBAR -->
	</div>
</div>