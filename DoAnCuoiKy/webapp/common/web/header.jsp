<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- BEGIN HEADER -->
<div class="header">
	<div class="container">
		<a class="site-logo" href="http://localhost:8080/OnlineShop/home"><img
			src="templates/css/assets/frontend/layout/img/logos/logos1.png"
			width="200px" height="100px" alt="Metronic Shop UI">Sản Phẩm
			Phân phối độc quyền từ Công Ty LDT</a> <a href="javascript:void(0);"
			class="mobi-toggler"><i class="fa fa-bars"></i></a>
		<c:if test="${GiaTri == 1}">
			<a class="btn btn-success btn-sm ml-3"
				href="${pageContext.request.contextPath }/cart-list?username=${username}&pass=${password}">
				<c:set var="count" value="${0}" /> <c:forEach
					items="${sessionScope.cart}" var="map">
					<c:set var="count" value="${count + map.value.quantity}" />
				</c:forEach> <i class="fa fa-shopping-cart"></i> Giỏ hàng <span
				class="badge badge-light">${count }</span>
			</a>
			<li class="btn btn-info btn-sm ml-3"><a class="nav-link"
						href="${pageContext.request.contextPath }/MuaTC?uid=${uid}"><i
							class="fa fa-shopping-cart"></i>Đơn Mua Thành Công</a></li>
			<li class="btn btn-warning btn-sm ml-3"><a class="nav-link"
				href="${pageContext.request.contextPath }/DonMua?uid=${uid}"><i
					class="fa fa-shopping-cart"></i>Đơn Mua</a></li>

		</c:if>
		<!-- BEGIN NAVIGATION -->
		<div class="header-navigation">
			<ul>
				<li class="dropdown">
					<!-- END DROPDOWN MENU -->
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/home">Home</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" aria-haspopup="true" href="#"
					id="navbarScrollingDropdown" role="button" data-toggle="dropdown"
					aria-expanded="false"> Categories </a>
					<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
						<c:forEach items="${listcate}" var="o">
							<c:forEach items="${listSoCate}" var="p">
								<c:if test="${o.cate_id==p.cate_id}">
									<li><a class="dropdown-item ${tagactive == o.cate_id ? "
										active":" "}" href="productPT?cid=${o.cate_id}"> ${o.cname}
											___(${p.sp})</a></li>
								</c:if>
							</c:forEach>
						</c:forEach>
					</ul></li>

				<li class="nav-item"><a class="nav-link" href="product?cid=0">Sản
						phẩm</a></li>
				<c:if test="${GiaTri == 1}">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath }/taikhoan?username=${username}&pass=${password}">${username}</a></li>
				</c:if>
				<c:if test="${GiaTri == 1}">
					<li class="nav-item"><a class="nav-link" href="logout">Đăng
							xuất</a></li>
				</c:if>
				<c:if test="${GiaTri == 0 or GiaTri == null}">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath }/login">Đăng nhập</a></li>

					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath }/signup">Đăng Ký Tài
							Khoản</a></li>
				</c:if>
				<!-- BEGIN TOP SEARCH -->
				<li class="menu-search"><span class="sep"></span> <i
					class="fa fa-search search-btn"></i>
					<div class="search-box">
						<form action="search">
							<div class="input-group">
								<input type="text" name="txt" value="${txtS }"
									placeholder="Tìm Kiếm" class="form-control"> <span
									class="input-group-btn">
									<button class="btn btn-primary" type="submit">Tìm Kiếm</button>
								</span>
							</div>
						</form>
					</div></li>
				<!-- END TOP SEARCH -->
			</ul>
		</div>
		<!-- END NAVIGATION -->
	</div>

</div>
<!-- Header END -->



