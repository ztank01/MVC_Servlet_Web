<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%-- <c:url value="/templates/css/assets" var="url"></c:url> --%>


<h1 class="text-warning text-center">Giỏ Hàng Của Bạn</h1>
<c:set var="total" />
<form role="form" action="${pageContext.request.contextPath }/cart-list"
	method="post" enctype="multipart/form-data">
	<div class="form-group">
<label>ID người dùng:</label>
 <input type="text" class="form-control" value="${taikhoan.uid}" name="uid" />
</div>
	<div class="container mb-4">
		<div class="row">
			<div class="col-12">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Ảnh</th>
								<th scope="col">Tên sản phẩm</th>
								<th scope="col">Đã bán</th>
								<th scope="col" class="text-center">Số lượng</th>
								<th scope="col" class="text-right">Giá</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sessionScope.cart}" var="map">
								<tr>
									<c:url value="/image?fname=${map.value.product.image}"
										var="imgUrl"></c:url>
									<td><a href="" data-toggle="modal"
										data-target="#productModal"> <img class="img-fluid"
											width="100px" height="60px" src="${imgUrl}" />

									</a></td>
									<td>${map.value.product.name }</td>
									<td>${map.value.product.amount }</td>
									<td>
										<div class="input-group mb-3">
											<div class="input-group-prepend">
												<button type="button"
													class="quantity-left-minus btn btn-danger btn-number"
													data-type="minus" data-field="">
													<i class="fa fa-minus"></i>
												</button>
											</div>

											<input type="text" class="form-control" id="quantity"
												name="quantity" min="1" max="100"
												value="${map.value.quantity }">
											<div class="input-group-append">
												<button type="button"
													class="quantity-right-plus btn btn-success btn-number"
													data-type="plus" data-field="">
													<i class="fa fa-plus"></i>
												</button>
											</div>
										</div>
									</td>
									<td class="text-right shop-red">
										${map.value.product.price * map.value.quantity } VNĐ</</td>
									<td class="text-right"><a
										href="${pageContext.request.contextPath}/cart-remove?pId=${map.value.product.id}"
										class="btn btn-sm btn-danger"><i class="fa fa-trash"></i>
									</a></td>
								</tr>
							</c:forEach>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>Sub-Total</td>
								<td class="text-right"><h4>Subtotal:</h4> <c:set
										var="total" value="${0}" /> <c:forEach
										items="${sessionScope.cart}" var="map">
										<c:set var="total"
											value="${total + map.value.quantity * map.value.product.price}" />
									</c:forEach>
									<div class="total-result-in">
										<span>$ ${total }</span>
									</div></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>Shipping</td>
								<td class="text-right">---</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><strong>Total</strong></td>
								<td class="text-right"><strong>$ ${total }</strong></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col mb-2">
				<div class="row">
					<button type="submit" class="btn btn-default">THANH TOÁN</button>
				</div>
			</div>
		</div>
	</div>
</form>

<br>
</br>

<a href="home" class="btn btn-default btn-success text-uppercase">Continue
	Shopping</a>

<br>
</br>
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
	type="text/javascript"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	type="text/javascript"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	//Plus & Minus for Quantity product
	$(document).ready(function() {
		var quantity = 1;

		$('.quantity-right-plus').click(function(e) {
			e.preventDefault();
			var quantity = parseInt($('#quantity').val());
			$('#quantity').val(quantity + 1);
		});

		$('.quantity-left-minus').click(function(e) {
			e.preventDefault();
			var quantity = parseInt($('#quantity').val());
			if (quantity > 1) {
				$('#quantity').val(quantity - 1);
			}
		});

	});
</script>
