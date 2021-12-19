package vn.VietTech.controller.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.VietTech.dao.Impl.SignUp;
import vn.VietTech.model.AccountModel;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


@WebServlet(urlPatterns= {"/signup"})
public class SignUpUserController extends HttpServlet {

	private static final long serialVersionUID = -2979002434446659573L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/decorators/DangKyTaiKhoan.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username= req.getParameter("user");
		String password= req.getParameter("pass");
		String repass= req.getParameter("repass");
		String vaitro= req.getParameter("vaitro");
		SignUp signup= new SignUp();
		String hashpass;
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
		
		int x= password.compareTo(repass);
		
		if(x!=0) {
			req.setAttribute("mess", "Nhập  sai repeat password");
			req.getRequestDispatcher("/decorators/DangKyTaiKhoan.jsp").forward(req, resp);
		}
		else {
			AccountModel account;
			if(vaitro.equals("User")) {
				account= signup.SignUp(username, hashpass);
			} else if(vaitro.equals("Seller")) {
				account= signup.SignUpSeller(username, hashpass);
			} else {
				account= signup.SignUpAdmin(username, hashpass);
			}
			HttpSession session=req.getSession();
			session.setAttribute("acc", account);
			//session.setMaxInactiveInterval(1000);
			resp.sendRedirect("login");
		}
		
	}
}
