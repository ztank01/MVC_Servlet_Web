<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<h1 class="text-center">ĐỔI TÊN TÀI KHOẢN</h1>
<h5 class="text-danger text-center">Sau khi đổi tên tài khoản bạn phải Đăng Xuất để update lại</h5>
<form  action="edit-taikhoan" method="post" enctype="multipart/form-data">
<input name="uid" value="${taikhoan.uid}" hidden="">
<div class="form-group">
<label>ID người dùng:</label>
 <input type="text" class="form-control" value="${taikhoan.uid}" name="uid" />
<label>Tên Tài Khoản:</label> 
<input type="text" class="form-control" value="${taikhoan.user}" name="newname" />
</div>
<button type="submit" class="btn btn-default">Edit</button>
</form>