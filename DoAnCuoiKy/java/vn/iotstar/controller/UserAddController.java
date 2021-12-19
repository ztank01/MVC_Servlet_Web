package vn.iotstar.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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


@WebServlet(urlPatterns = { "/admin/user/add" })
public class UserAddController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/addUser.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountModel user = new AccountModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		String password = null;
		String hashpass;
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
					password = item.getString("UTF-8");
				} else if (item.getFieldName().equals("isSeller")) {
					user.setIsSell(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("isAdmin")) {
					user.setIsAdmin(Integer.parseInt(item.getString()));
				}
			}
			try { 
	            // Static getInstance method is called with hashing MD5 
	            MessageDigest pass = MessageDigest.getInstance("MD5"); 
	          
	            // digest() method is called to calculate message digest 
	            //  of an input digest() return array of byte 
	            byte[] messageDigest = pass.digest(password.getBytes()); 
	            // Convert byte array into signum representation 
	            BigInteger no1 = new BigInteger(1, messageDigest); 
	  
	            // Convert message digest into hex value 
	            hashpass = no1.toString(16); 
	            while (hashpass.length() < 32) { 
	                hashpass = "0" + hashpass; 
	            } 
	            
	        }  
	        // For specifying wrong message digest algorithms 
	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        }
			user.setPass(hashpass);
			userService.insert(user);
			resp.sendRedirect(req.getContextPath() + "/admin/user/list");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
