package vn.iotstar.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.iotstar.model.AccountModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;
import vn.iotstar.util.Constant;

@WebServlet(urlPatterns= {"/admin/user/edit"})
public class UserEditController extends HttpServlet{

	UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		AccountModel user = userService.get(Integer.parseInt(id));
		req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/editUser.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountModel user = new AccountModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("id")) {
					user.setUid(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("user")) {
					user.setUser(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("pass")) {
					user.setPass(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("isSeller")) {
					user.setIsSell(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("isAdmin")) {
					user.setIsAdmin(Integer.parseInt(item.getString()));
				} 
			}
			userService.edit(user);
			resp.sendRedirect(req.getContextPath() + "/admin/user/list");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
