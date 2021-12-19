<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<h1 class="text-center">ĐỔI MẬT KHẨU</h1>
<h5 class="text-danger text-center">Sau khi đổi pass bạn phải Đăng Xuất để update lại</h5>
<form  action="edit-pass" method="post" enctype="multipart/form-data">
<input name="uid" value="${taikhoan.uid}" hidden="">
<div class="form-group">
<label>ID người dùng:</label>
 <input type="text" class="form-control" value="${taikhoan.uid}" name="uid" />
 <label>Password cũ:</label> 
<input type="password" class="form-control" value="" name="pass" />
<label>Password mới:</label> 
<input type="password" class="form-control" value="" name="newpass" />
<label>Repeat Password mới:</label> 
<input type="password" class="form-control" value="" name="renewpass" />
</div>
<button type="submit" class="btn btn-default">Edit</button>
</form>