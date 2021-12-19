package vn.VietTech.controller.web;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import vn.VietTech.Connection.DBConnect;
import vn.VietTech.dao.Impl.SignUp;
import vn.VietTech.dao.Impl.UserDaoImpl;
import vn.VietTech.model.AccountModel;
import vn.VietTech.service.Impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/edit-taikhoan" })
public class EditUserController extends HttpServlet {

	private static final long serialVersionUID = 6222967220261224176L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = req.getParameter("uid");
		String pass= req.getParameter("pass");
		UserDaoImpl userD = new UserDaoImpl();
		AccountModel taikhoan = userD.getAllId(uid, pass);
		req.setAttribute("taikhoan", taikhoan);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/Khach/EditName.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DiskFileItemFactory diskFileItemFactory = new
		DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new
		ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String newname="" ;
		String uid="" ;
		List<FileItem> items = servletFileUpload.parseRequest(req);
		for (FileItem item : items) {
			if (item.getFieldName().equals("uid")) {
				uid=item.getString();}
			if (item.getFieldName().equals("newname")) {
				newname=item.getString("UTF-8");
				} 
		}
			UserServiceImpl userDao = new UserServiceImpl();
			userDao.editName(newname, uid);
			resp.sendRedirect(req.getContextPath() + "/logout");
		
		}
		catch (FileUploadException e) {
			e.printStackTrace();
			} catch (Exception e) {e.printStackTrace();}

		
	}
}
