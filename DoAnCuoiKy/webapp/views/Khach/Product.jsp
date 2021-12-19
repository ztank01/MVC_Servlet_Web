<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%-- <c:url value="/templates/css/assets" var="url"></c:url> --%>

<!-- Body BEGIN -->
<body class="ecommerce">
	<!-- BEGIN STYLE CUSTOMIZER -->
	<div class="color-panel hidden-sm">
		<div class="color-mode-icons icon-color"></div>
		<div class="color-mode-icons icon-color-close"></div>
		<div class="color-mode">
			<p>THEME COLOR</p>
			<ul class="inline">
				<li class="color-red current color-default" data-style="red"></li>
				<li class="color-blue" data-style="blue"></li>
				<li class="color-green" data-style="green"></li>
				<li class="color-orange" data-style="orange"></li>
				<li class="color-gray" data-style="gray"></li>
				<li class="color-turquoise" data-style="turquoise"></li>
			</ul>
		</div>
	</div>
	<!-- END BEGIN STYLE CUSTOMIZER -->

	

	<div class="title-wrapper">
		<div class="container">
			<div class="container-inner">
				<h1>
					<span>THẾ GIỚI ĐIỆN MÁY</span> VIỆT NHẬT <span>CHẤT LƯỢNG
						THAY LỜI NÓI </span>
				</h1>

				<em>MANG ĐẾN TIỆN ÍCH CHO NGÔI NHÀ BẠN</em>

			</div>
		</div>
	</div>

	<div class="main">
		<div class="container">
			
			<!-- BEGIN SIDEBAR & CONTENT -->
			<div class="row margin-bottom-40">
				<!-- BEGIN SIDEBAR -->
				<div class="sidebar col-md-3 col-sm-5">
					<div class="card bg-light mb-3">
						<div class="card-header bg-primary text-white text-uppercase">
							<i class="fa fa-list"></i> Categories
						</div>
						<ul class="list-group category_block">
							<c:forEach items="${listcate}" var="o">
								<c:forEach items="${listSoCate}" var="p">
									<c:if test="${o.cate_id==p.cate_id}">
										<li class="list-group-item ${tagactive == o.cate_id ? "active":" "} "><a
											href="productPT?cid=${o.cate_id}"> ${o.cname} ___(${p.sp})</a></li>
									</c:if>
								</c:forEach>
							</c:forEach>
						</ul>
					</div>
				</div>
				<!-- END SIDEBAR -->
				<!-- BEGIN CONTENT -->
				<div class="col-md-9 col-sm-7">
					<!-- BEGIN PRODUCT LIST -->
					<div class="row product-list">
						<div class="container">
							<div class="row">

								<div class="col-sm-9">
									<!-- PRODUCT ITEM START -->
									<div id="content" class="row">
										<c:forEach items="${listAllProduct}" var="o">
											<div class="product col-md-4 col-sm-4 col-xs-10">
												<div class="product-item">
													<div class="pi-img-wrapper">
														<c:url value="/image?fname=${o.image}" var="imgUrl"></c:url>
														<td><img src="${imgUrl}" class="img-responsive"
															alt="Berry Lace Dress" /></td>
														<div>
															<div class="card-body">
																<a href="" data-toggle="modal"
																	data-target="#productModal"> <img class="img-fluid"
																	src="${imgUrl}" />
																	<p class="btn btn-default fancybox-button">Zoom</p>
																</a>
															</div>
															<a href="productdetail?pid=${o.id}"
																class="btn btn-default fancybox-fast-view">XEM CHI
																TIẾT</a>
														</div>
													</div>
													<h3>
														<a href="shop-item.html">${o.name}</a>
													</h3>
													<div class="pi-price"> ${o.price} VNĐ</div>
													<a href="<c:url value="/cart-add?pId=${o.id}&quantity=1&username=${username}&pass=${password}"></c:url>" class="btn btn-default add2cart">THÊM VÀO
														GIỎ HÀNG</a>
												</div>

											</div>
										</c:forEach>
									</div>
									<button onclick="loadMore()" class="btn btn-primary">Xem
										tiếp</button>
								</div>
							</div>
						</div>
					</div>
					<script
						src="https://ajax.googleapos.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
					<script>
						function loadMore() {
							/*  tạo viên amount để Gọi và đếm classname là product */
							var amount = document
									.getElementsByClassName("product").length;
							$.ajax({
								url : "/DoAnCuoiKy/load",
								type : "get", //send it through get method
								data : {
									exits : amount
									
								},
								success : function(data) {
									var row = document
											.getElementById("content");
									row.innerHTML += data;
								},
								error : function(xhr) {
									//Do Something to handle error
								}
							});
						}
					</script>
					<!-- END PRODUCT LIST -->
					<!-- BEGIN PAGINATOR -->
					<!-- END PAGINATOR -->
				</div>
				<!-- END CONTENT -->
			</div>
			<!-- END SIDEBAR & CONTENT -->
		</div>
	</div>

</body>
<!-- END BODY -->
