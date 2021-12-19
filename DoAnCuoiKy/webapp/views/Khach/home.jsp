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
			<div class=" row text-info margin-bottom-40">
				<!-- BEGIN SIDEBAR -->
				<div class="sidebar col-md-3 col-sm-5">
					<div class="row product">
						<!-- PRODUCT ITEM START -->
						<div class="row">
							<c:forEach items="${list1TopProduct}" var="o">
								<div class=" col-sm-8 col-xs-12">

									<div class="product-item">
										<div class="pi-img-wrapper">
											<c:url value="/image?fname=${o.image}" var="imgUrl"></c:url>
											<td><img src="${imgUrl}" class="img-responsive"
												alt="Berry Lace Dress" /></td>
											<div>
												<div class="card-body">
													<a href="" data-toggle="modal" data-target="#productModal">
														<img class="img-fluid" src="${imgUrl}" />
														<p class="btn btn-default fancybox-button">Zoom</p>
													</a>
												</div>
												<a href="productdetail?pid=${o.id}"
													class="btn btn-default fancybox-fast-view">XEM CHI TIẾT</a>
											</div>
										</div>
										<h3>
											<a href="shop-item.html">${o.name}</a>
										</h3>
										<div class="pi-price"> ${o.price} VNĐ</div>
										<a href="<c:url value="/cart-add?pId=${o.id}&quantity=1&username=${username}&pass=${password}"></c:url>" class="btn btn-default ">THÊM VÀO GIỎ HÀNG</a>
									</div>

								</div>
							</c:forEach>
						</div>
					</div>
					
				</div>
				<!-- END SIDEBAR -->
				<!-- BEGIN CONTENT -->
				<div class="col-md-9 col-sm-7">
				
					<!-- BEGIN PRODUCT LIST -->
					<div class="card row product-list">
						<!-- PRODUCT ITEM START -->
						<div class="card-header bg-yellow text-danger text-info">
							<i class="fa fa-trophy"></i> Best products
						</div>
						<c:forEach items="${list4BestProduct}" var="o">
							<div class="col-md-5 col-sm-4 col-xs-10">
								<div class="product product-item">
									<div class="pi-img-wrapper">
										<c:url value="/image?fname=${o.image}" var="imgUrl"></c:url>
										<td><img src="${imgUrl}" class="img-responsive"
											alt="Berry Lace Dress" /></td>
										<div>
											<div class="card-body">
												<a href="" data-toggle="modal" data-target="#productModal">
													<img class="img-fluid" src="${imgUrl}" />
													<p class="btn btn-default fancybox-button">Zoom</p>
												</a>
											</div>
											<a href="productdetail?pid=${o.id}"
												class="btn btn-default fancybox-fast-view">XEM CHI TIẾT</a>
										</div>
									</div>
									<h3>
										<a href="shop-item.html">${o.name}</a>
									</h3>
									<div class="pi-price"> ${o.price} VNĐ</div>
									<a href="<c:url value="/cart-add?pId=${o.id}&quantity=1&username=${username}&pass=${password}"></c:url>" class="btn btn-default add2cart">THÊM VÀO GIỎ
										HÀNG</a>
								</div>

							</div>
						</c:forEach>
					</div>
					<div class="card ">
						<div class="card-header bg-yellow text-danger text-uppercase">
							<i class="fa fa-star"></i> Last products
						</div>
						<c:forEach items="${list4product}" var="o">
							<div class="col-md-5 col-sm-4 col-xs-10">
								<div class="product product-item">
									<div class="pi-img-wrapper">
										<c:url value="/image?fname=${o.image}" var="imgUrl"></c:url>
										<td><img src="${imgUrl}" class="img-responsive"
											alt="Berry Lace Dress" /></td>
										<div>
											<div class="card-body">
												<a href="" data-toggle="modal" data-target="#productModal">
													<img class="img-fluid" src="${imgUrl}" />
													<p class="btn btn-default fancybox-button">Zoom</p>
												</a>
											</div>
											<a href="productdetail?pid=${o.id}"
												class="btn btn-default fancybox-fast-view">XEM CHI TIẾT</a>
										</div>
									</div>
									<h3>
										<a href="shop-item.html">${o.name}</a>
									</h3>
									<div class="pi-price">${o.price} VNĐ</div>
									<a href="<c:url value="/cart-add?pId=${o.id}&quantity=1&username=${username}&pass=${password}"></c:url>" class="btn btn-default add2cart">THÊM VÀO GIỎ
										HÀNG</a>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- PRODUCT ITEM END -->
				</div>
				<!-- END PRODUCT LIST -->
				<!-- BEGIN PAGINATOR -->
				
				<!-- END PAGINATOR -->
			</div>
			<!-- END CONTENT -->
		</div>
		<!-- END SIDEBAR & CONTENT -->
	</div>
	</div>

	<!-- BEGIN BRANDS -->
	<div class="brands">
		<div class="container">
			<div class="owl-carousel owl-carousel6-brands">
				<a href="shop-product-list.html"><img
					src="templates/css/assets/frontend/pages/img/brands/canon.jpg"
					alt="canon" title="canon"></a> <a href="shop-product-list.html"><img
					src="templates/css/assets/frontend/pages/img/brands/esprit.jpg"
					alt="esprit" title="esprit"></a> <a href="shop-product-list.html"><img
					src="templates/css/assets/frontend/pages/img/brands/gap.jpg"
					alt="gap" title="gap"></a> <a href="shop-product-list.html"><img
					src="templates/css/assets/frontend/pages/img/brands/next.jpg"
					alt="next" title="next"></a> <a href="shop-product-list.html"><img
					src="templates/css/assets/frontend/pages/img/brands/puma.jpg"
					alt="puma" title="puma"></a> <a href="shop-product-list.html"><img
					src="templates/css/assets/frontend/pages/img/brands/zara.jpg"
					alt="zara" title="zara"></a> <a href="shop-product-list.html"><img
					src="templates/css/assets/frontend/pages/img/brands/canon.jpg"
					alt="canon" title="canon"></a> <a href="shop-product-list.html"><img
					src="templates/css/assets/frontend/pages/img/brands/esprit.jpg"
					alt="esprit" title="esprit"></a> <a href="shop-product-list.html"><img
					src="templates/css/assets/frontend/pages/img/brands/gap.jpg"
					alt="gap" title="gap"></a> <a href="shop-product-list.html"><img
					src="templates/css/assets/frontend/pages/img/brands/next.jpg"
					alt="next" title="next"></a> <a href="shop-product-list.html"><img
					src="templates/css/assets/frontend/pages/img/brands/puma.jpg"
					alt="puma" title="puma"></a> <a href="shop-product-list.html"><img
					src="templates/css/assets/frontend/pages/img/brands/zara.jpg"
					alt="zara" title="zara"></a>
			</div>
		</div>
	</div>
	<!-- END BRANDS -->

	<!-- BEGIN STEPS -->
	<div class="steps-block steps-block-red">
		<div class="container">
			<div class="row">
				<div class="col-md-4 steps-block-col">
					<i class="fa fa-truck"></i>
					<div>
						<h2>Free ship TOÀN QUỐC</h2>
						<em>GIAO NHANH TRONG 24H</em>
					</div>
					<span>&nbsp;</span>
				</div>
				<div class="col-md-4 steps-block-col">
					<i class="fa fa-gift"></i>
					<div>
						<h2>QUÀ TẶNG NGẪU NHIÊN</h2>
						<em>3 PHẦN QUÀ BÍ MẬT GIAO THEO ĐƠN CỦA BẠN</em>
					</div>
					<span>&nbsp;</span>
				</div>
				<div class="col-md-4 steps-block-col">
					<i class="fa fa-phone"></i>
					<div>
						<h2>477 505 8877</h2>
						<em>24/7 customer care available</em>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END STEPS -->

	<!-- BEGIN PRE-FOOTER -->
	<div class="pre-footer">
		<div class="container">
			<div class="row">
				<!-- BEGIN BOTTOM ABOUT BLOCK -->
				<div class="col-md-3 col-sm-6 pre-footer-col">
					<h2>About us</h2>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
						sed diam sit nonummy nibh euismod tincidunt ut laoreet dolore
						magna aliquarm erat sit volutpat. Nostrud exerci tation
						ullamcorper suscipit lobortis nisl aliquip commodo consequat.</p>
					<p>Duis autem vel eum iriure dolor vulputate velit esse
						molestie at dolore.</p>
				</div>
				<!-- END BOTTOM ABOUT BLOCK -->
				<!-- BEGIN BOTTOM INFO BLOCK -->
				<div class="col-md-3 col-sm-6 pre-footer-col">
					<h2>Information</h2>
					<ul class="list-unstyled">
						<li><i class="fa fa-angle-right"></i> <a href="#">Delivery
								Information</a></li>
						<li><i class="fa fa-angle-right"></i> <a href="#">Customer
								Service</a></li>
						<li><i class="fa fa-angle-right"></i> <a href="#">Order
								Tracking</a></li>
						<li><i class="fa fa-angle-right"></i> <a href="#">Shipping
								& Returns</a></li>
						<li><i class="fa fa-angle-right"></i> <a href="contacts.html">Contact
								Us</a></li>
						<li><i class="fa fa-angle-right"></i> <a href="#">Careers</a></li>
						<li><i class="fa fa-angle-right"></i> <a href="#">Payment
								Methods</a></li>
					</ul>
				</div>
				<!-- END INFO BLOCK -->

				<!-- BEGIN TWITTER BLOCK -->
				<div class="col-md-3 col-sm-6 pre-footer-col">
					<h2 class="margin-bottom-0">Latest Tweets</h2>
					<a class="twitter-timeline" href="https://twitter.com/twitterapi"
						data-tweet-limit="2" data-theme="dark" data-link-color="#57C8EB"
						data-widget-id="455411516829736961"
						data-chrome="noheader nofooter noscrollbar noborders transparent">Loading
						tweets by @keenthemes...</a>
				</div>
				<!-- END TWITTER BLOCK -->

				<!-- BEGIN BOTTOM CONTACTS -->
				<div class="col-md-3 col-sm-6 pre-footer-col">
					<h2>Our Contacts</h2>
					<address class="margin-bottom-40">
						35, Lorem Lis Street, Park Ave<br> California, US<br>
						Phone: 300 323 3456<br> Fax: 300 323 1456<br> Email: <a
							href="mailto:info@metronic.com">info@metronic.com</a><br>
						Skype: <a href="skype:metronic">metronic</a>
					</address>
				</div>
				<!-- END BOTTOM CONTACTS -->
			</div>
			<hr>
			<div class="row">
				<!-- BEGIN SOCIAL ICONS -->
				<div class="col-md-6 col-sm-6">
					<ul class="social-icons">
						<li><a class="rss" data-original-title="rss" href="#"></a></li>
						<li><a class="facebook" data-original-title="facebook"
							href="#"></a></li>
						<li><a class="twitter" data-original-title="twitter" href="#"></a></li>
						<li><a class="googleplus" data-original-title="googleplus"
							href="#"></a></li>
						<li><a class="linkedin" data-original-title="linkedin"
							href="#"></a></li>
						<li><a class="youtube" data-original-title="youtube" href="#"></a></li>
						<li><a class="vimeo" data-original-title="vimeo" href="#"></a></li>
						<li><a class="skype" data-original-title="skype" href="#"></a></li>
					</ul>
				</div>
				<!-- END SOCIAL ICONS -->
				<!-- BEGIN NEWLETTER -->
				<div class="col-md-6 col-sm-6">
					<div class="pre-footer-subscribe-box pull-right">
						<h2>Newsletter</h2>
						<form action="#">
							<div class="input-group">
								<input type="text" placeholder="youremail@mail.com"
									class="form-control"> <span class="input-group-btn">
									<button class="btn btn-primary" type="submit">Subscribe</button>
								</span>
							</div>
						</form>
					</div>
				</div>
				<!-- END NEWLETTER -->
			</div>
		</div>
	</div>
	<!-- END PRE-FOOTER -->
	<!-- BEGIN fast view of a product -->
	<div id="product-pop-up" style="display: none; width: 700px;">
		<div class="product-page product-pop-up">
			<div class="row">
				<div class="col-md-6 col-sm-6 col-xs-3">
					<div class="product-main-image">
						<img
							src="templates/css/assets/frontend/pages/img/products/model7.jpg"
							alt="Cool green dress with red bell" class="img-responsive">
					</div>
					<div class="product-other-images">
						<a href="#" class="active"><img alt="Berry Lace Dress"
							src="templates/css/assets/frontend/pages/img/products/model3.jpg"></a>
						<a href="#"><img alt="Berry Lace Dress"
							src="templates/css/assets/frontend/pages/img/products/model4.jpg"></a>
						<a href="#"><img alt="Berry Lace Dress"
							src="templates/css/assets/frontend/pages/img/products/model5.jpg"></a>
					</div>
				</div>
				<div class="col-md-6 col-sm-6 col-xs-9">
					<h1>Cool green dress with red bell</h1>
					<div class="price-availability-block clearfix">
						<div class="price">
							<strong><span>$</span>47.00</strong> <em>$<span>62.00</span></em>
						</div>
						<div class="availability">
							Availability: <strong>In Stock</strong>
						</div>
					</div>
					<div class="description">
						<p>Lorem ipsum dolor ut sit ame dolore adipiscing elit, sed
							nonumy nibh sed euismod laoreet dolore magna aliquarm erat
							volutpat Nostrud duis molestie at dolore.</p>
					</div>
					<div class="product-page-options">
						<div class="pull-left">
							<label class="control-label">Size:</label> <select
								class="form-control input-sm">
								<option>L</option>
								<option>M</option>
								<option>XL</option>
							</select>
						</div>
						<div class="pull-left">
							<label class="control-label">Color:</label> <select
								class="form-control input-sm">
								<option>Red</option>
								<option>Blue</option>
								<option>Black</option>
							</select>
						</div>
					</div>
					<div class="product-page-cart">
						<div class="product-quantity">
							<input id="product-quantity" type="text" value="1" readonly
								name="product-quantity" class="form-control input-sm">
						</div>
						<button class="btn btn-primary" type="submit">Add to cart</button>
						<a href="shop-item.html" class="btn btn-default">More details</a>
					</div>
				</div>

				<div class="sticker sticker-sale"></div>
			</div>
		</div>
	</div>
	<!-- END fast view of a product -->



</body>
<!-- END BODY -->
