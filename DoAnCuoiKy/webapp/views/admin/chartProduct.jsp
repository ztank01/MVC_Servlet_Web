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
					<li class="active open"><a href="javascript:;"> <i
							class="fa fa-bar-chart"></i> <span class="title">Thống kê báo cáo</span><span
							class="selected"></span> <span class="arrow open"></span>
					</a>
						<ul class="sub-menu">
							<li class="active"><a href="<c:url value='/admin/chart/product'/>"> <i
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
					Biểu đồ <small></small>
				</h3>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-edit"></i>Biểu đồ
								</div>
							</div>
							<div class="portlet-body">
								<table class="display" style="width:100%"
									id="dataTable">
									<thead>
										<tr>
											<th>STT</th>
											<th>Tên sản phẩm</th>
											<th>Giá</th>
											<th>Ảnh</th>
											<th>Danh mục sản phẩm</th>
											<th>Người bán</th>
											<th>Số lượng</th>
											<th>Số lượng trong kho</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${productList}" var="product" varStatus="STT">
											<tr class="odd gradeX">
												<td>${STT.index+1 }</td>
												<td>${product.name }</td>
												<td>${product.price }</td>
												<c:url value="/image?fname=${product.image}" var="imgUrl"></c:url>
												<td><img height="150" width="200" src="${imgUrl}" /></td>
												<td>${product.cate_name }</td>
												<td>${product.user }</td>
												<td>${product.amount }</td>
												<td>${product.inStock }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
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



<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/searchpanes/1.4.0/js/dataTables.searchPanes.min.js"></script>
<script src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>
<script src="//code.highcharts.com/highcharts.js"></script>


<script>
$(document).ready(function () {
    // Create DataTable
    var table = $('#dataTable').DataTable({
        dom: 'Pfrtip',
    });
 
    // Create the chart with initial data
    var container = $('<div/>').insertBefore(table.table().container());
 
    var chart = Highcharts.chart(container[0], {
        chart: {
            type: 'pie',
        },
        title: {
            text: 'Thống kê các sản phẩm theo số lượng người bán',
        },
        series: [
            {
                data: chartData(table),
            },
        ],
    });
 
    // On each draw, update the data in the chart
    table.on('draw', function () {
        chart.series[0].setData(chartData(table));
    });
});
 
function chartData(table) {
    var counts = {};
 
    // Count the number of entries for each position
    table
        .column(1, { search: 'applied' })
        .data()
        .each(function (val) {
            if (counts[val]) {
                counts[val] += 1;
            } else {
                counts[val] = 1;
            }
        });
 
    // And map it to the format highcharts uses
    return $.map(counts, function (val, key) {
        return {
            name: key,
            y: val,
        };
    });
}
</script>