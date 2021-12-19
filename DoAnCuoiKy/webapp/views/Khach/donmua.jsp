<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<h1 class="text-warning text-center">Đơn mua của bạn</h1>
<h3 class="text-danger text-center">Sản phẩm đang chờ Seller xác nhận đơn hàng</h3>
<c:set var="total"/>
<div class="container mb-4">
	<div class="row">
		<div class="col-12">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Ảnh</th>
							<th scope="col">Tên sản phẩm</th>
							<th scope="col" class="text-center">Số lượng</th>
							<th scope="col" class="text-right">Giá</th>
							<th scope="col" >Ngày Đặt</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listcate}" var="p">
							<tr>
								<c:url value="/image?fname=${p.product.image}"
										var="imgUrl"></c:url>
									<td><a href="" data-toggle="modal"
										data-target="#productModal"> <img class="img-fluid"
											width="100px" height="60px" src="${imgUrl}" />

									</a></td>
								<td>${p.product.name }</td>
								<td>${p.quantity}</td>
								
								<td class="text-right shop-red"> ${p.product.price * p.quantity } VNĐ</</td> 
								
								
								<td>${p.cart.buyDate}</td>
								<td class="text-right"><a
										href="${pageContext.request.contextPath}/delete-item?id=${p.itemid}"
										class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> Hủy đơn
									</a></td>
								
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
		<div class="col mb-2">
			<div class="row">
				<div  class="col-sm-12  col-md-6">
					
				</div>
			</div>
		</div>
	</div>
</div>
<a href="home" class="btn btn-default btn-success text-uppercase">Continue
	Shopping</a>