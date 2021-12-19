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
							<span class="title">Dashboard</span>
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
					<li><a href="javascript:;"> <i
							class="fa fa-shopping-cart"></i> <span class="title">Quản lý sản phẩm</span>
					</a>
						<ul class="sub-menu">
							<li><a href="<c:url value='/admin/product/list'/>"> <i
									class="fa fa-list-ul"></i> Danh sách sản phẩm
							</a></li>
							<li><a href="<c:url value='/admin/product/add'/>"> <i
									class="fa fa-cart-plus"></i> Thêm sản phẩm mới
							</a></li>
						</ul></li>
					<li class="active open"><a href="javascript:;"> <i 
						class="material-icons">account_box</i> <span class="title">Quản lý tài khoản</span><span
							class="selected"></span> <span class="arrow open"></span>
					</a>
						<ul class="sub-menu">
							<li class="active"><a href="<c:url value='/admin/user/list'/>"> <i
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
					<li><a href="<c:url value='/admin/chart'/>"> <i
							class="fa fa-bar-chart"></i> <span class="title">Thống kê báo cáo</span>
					</a></li>
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
					Danh mục sản phẩm <small></small>
				</h3>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-edit"></i>Editable Table
								</div>
							</div>
							<div class="portlet-body">
							<div class="container-sm">
								<table class="table table-striped table-hover table-bordered" style="width:100%"
									id="dataTable">
									<thead>
										<tr>
											<th>STT</th>
											<th>Username</th>
											<th>Password</th>
											<th>IsSeller</th>
											<th>IsAdmin</th>
											<th>Hành động</th>
										</tr>
									</thead>
									<tbody id="myTable">
										<c:forEach items="${userList}" var="user" varStatus="STT">
											<tr class="odd gradeX">
												<td>${STT.index+1 }</td>
												<td>${user.user }</td>
												<td>${user.pass }</td>
												<td>${user.isSell }</td>
												<td>${user.isAdmin }</td>
												<td><a
													href="<c:url value='/admin/user/edit?id=${user.uid }'/>"
													class="center">Sửa</a> | <a
													href="<c:url value='/admin/user/delete?id=${user.uid }'/>"
													class="center">Xóa</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								
								<div id="chartContainer" style="height: 300px; width: 100%;"></div>
								</div>
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


    <!-- jQuery js-->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <!-- Bootstrap js -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <!-- jQuery Datatable js -->
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <!-- Bootstrap Datatable js -->    
    <script src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
    <script>
    var myData = [
        {
            pie_chart: '<span class="sparklines top10" sparkType="pie" sparkHeight="50" sparkWidth="auto" values="4,6,7,7,4"> </span>'
        },



            $('#dataTable').dataTable({
            data: myData,
            columns: [
                {data: 'pie_chart'},
            ],
            responsive: true,
            searching: false,
            paging: false,
            info: false
        });
        $('.top10').sparkline([1, 2, 3, 4], {
            type: 'pie',
            height: '50',
            width: '50'
        });
</script>



<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script type="text/javascript">

window.onload = function () {
	var chart = new CanvasJS.Chart("chartContainer", {
		title:{
			text: "My First Chart in CanvasJS"              
		},
		data: [              
		{
			// Change type to "doughnut", "line", "splineArea", etc.
			type: "column",
			dataPoints: [
				{ label: "apple",  y: 10  },
				{ label: "orange", y: 15  },
				{ label: "banana", y: 25  },
				{ label: "mango",  y: 30  },
				{ label: "grape",  y: 28  }
			]
		}
		]
	});
	chart.render();
}
</script>