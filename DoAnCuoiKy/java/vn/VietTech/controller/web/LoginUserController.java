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

import vn.VietTech.dao.Impl.LoginDao;
import vn.VietTech.dao.Impl.UserDaoImpl;
import vn.VietTech.model.AccountModel;


@WebServlet(urlPatterns= {"/login"})
public class LoginUserController extends HttpServlet {

	private static final long serialVersionUID = -7830181983722177644L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int GiaTri=0;
		String username= req.getParameter("user");
		String password= req.getParameter("pass");
		String vaitro= req.getParameter("vaitro");
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
		LoginDao loginDao= new LoginDao();
		HttpSession httpSession= req.getSession();
		AccountModel account;
		if(vaitro.equals("User")) {
			account= loginDao.loginUser(username, hashpass);
		} else if(vaitro.equals("Seller")) {
			account= loginDao.loginSeller(username, hashpass);
		} else {
			account= loginDao.loginAdmin(username, hashpass);
		}
		
		if(account==null) {
			req.setAttribute("mess", "Sai tên tài khoản hoặc mật khẩu");
			httpSession.setAttribute("GiaTri", GiaTri);
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
		} else {
			HttpSession session=req.getSession();
			session.setAttribute("acc", account);
			UserDaoImpl userD= new UserDaoImpl();
			AccountModel taikhoan= userD.getAll(username, hashpass);
			//session.setMaxInactiveInterval(1000);
			httpSession.setAttribute("username", username);
			httpSession.setAttribute("password", hashpass);
			httpSession.setAttribute("uid", taikhoan.getUid());
			GiaTri=1;
			httpSession.setAttribute("GiaTri", GiaTri);
			if(vaitro.equals("User")) {
				resp.sendRedirect("home");
			} else if(vaitro.equals("Seller")) {
				resp.sendRedirect("seller_home");
			} else {
				resp.sendRedirect("admin/home");
			}
			
			
		}
		
	}
}
