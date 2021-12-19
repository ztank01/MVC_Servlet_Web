<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
    

<div class="title-wrapper">
		<div class="container">
			<div class="container-inner">
				<h1>
					<span>Chào Mừng</span> ${taikhoan.user}<span> Đây là tài khoản của bạn</span>
				</h1>
			</div>
		</div>
	</div>
 
 <div class="main">
      <div class="container">
 <!-- BEGIN CONTENT -->
     <div class="col-md-6 col-sm-4">
            
            <div class="content-page">
              <h2>Tài Khoản: ${taikhoan.user}</h2>
              <ul>
                <li><a href="${pageContext.request.contextPath }/edit-taikhoan?uid=${taikhoan.uid}&pass=${taikhoan.pass}">Đổi tên</a></li>
                <li><a href="${pageContext.request.contextPath }/edit-pass?uid=${taikhoan.uid}">Đổi password</a></li>
              </ul>
              <hr>

              <h2>Đơn Mua</h2>
              <ul>
                <li><a href="${pageContext.request.contextPath }/DonMua?uid=${taikhoan.uid}"><span>xem đơn mua của bạn</span></a></li>
                
              </ul>
            </div>
          </div>
          </div>
          </div>