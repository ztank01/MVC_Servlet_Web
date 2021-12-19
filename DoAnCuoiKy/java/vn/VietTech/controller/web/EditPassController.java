package vn.VietTech.controller.web;

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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.VietTech.dao.Impl.UserDaoImpl;
import vn.VietTech.model.AccountModel;
import vn.VietTech.service.Impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/edit-pass" })
public class EditPassController extends HttpServlet {

	private static final long serialVersionUID = 5684405232413062567L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = req.getParameter("uid");
		UserDaoImpl userD = new UserDaoImpl();
		AccountModel taikhoan = userD.getAllID(uid);
		req.setAttribute("taikhoan", taikhoan);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/Khach/EditPass.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			String newpass = "";
			String renewpass = "";
			String pass="";
			String uid = "";
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("uid")) {
					uid = item.getString();
				}
				if (item.getFieldName().equals("pass")) {
					pass = item.getString("UTF-8");
				}
				if (item.getFieldName().equals("newpass")) {
					newpass = item.getString("UTF-8");
				}
				if (item.getFieldName().equals("renewpass")) {
					renewpass = item.getString("UTF-8");
				}
			}
		String hashpass;
		try { 
	            // Static getInstance method is called with hashing MD5 
	            MessageDigest pas= MessageDigest.getInstance("MD5"); 
	          
	            // digest() method is called to calculate message digest 
	            //  of an input digest() return array of byte 
	            byte[] messageDigest = pas.digest(newpass.getBytes()); 
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
		
		
		String hashpass1;
		try { 
	            // Static getInstance method is called with hashing MD5 
	            MessageDigest pas= MessageDigest.getInstance("MD5"); 
	          
	            // digest() method is called to calculate message digest 
	            //  of an input digest() return array of byte 
	            byte[] messageDigest = pas.digest(pass.getBytes()); 
	            // Convert byte array into signum representation 
	            BigInteger no1 = new BigInteger(1, messageDigest); 
	  
	            // Convert message digest into hex value 
	            hashpass1 = no1.toString(16); 
	            while (hashpass1.length() < 32) { 
	                hashpass1 = "0" + hashpass1; 
	            } 
	            
	        }  
			 // For specifying wrong message digest algorithms 
	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        } 
			UserDaoImpl userD = new UserDaoImpl();
			AccountModel taikhoan = userD.getAllID(uid);
			String oldpass = taikhoan.getPass().toString();
			int x = oldpass.compareTo(hashpass1);
			int y= newpass.compareTo(renewpass);
			if (x != 0 || y!=0 ) {
				req.setAttribute("mess", "Nhap sai password hoac repeat password");
				resp.sendRedirect(req.getContextPath() + "/edit-pass?uid="+ uid);
			} else {
				UserServiceImpl userDao = new UserServiceImpl();
				userDao.editPass(hashpass, uid);
				resp.sendRedirect(req.getContextPath() + "/logout");
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
