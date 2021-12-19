package vn.iotstar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.impl.LoginDAO;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.model.AccountModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;
import vn.iotstar.util.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/admin/login" })
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4304463338799699183L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		//session.setMaxInactiveInterval(10);
		if (session != null && session.getAttribute("acc") != null) {
		resp.sendRedirect(req.getContextPath()+ "/waiting");
		return;
		}
		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
		for (Cookie cookie : cookies) {
		if (cookie.getName().equals("user")) {
		session = req.getSession(true);
		session.setAttribute("user", cookie.getValue());
		resp.sendRedirect(req.getContextPath()+ "/waiting");
		return;
		}
		}
		}
		req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		boolean isRememberMe = false;
		String remember = req.getParameter("remember");
		if("on".equals(remember)){
		isRememberMe = true;
		}
		UserService service = new UserServiceImpl();
		AccountModel account = service.login(username, password);
		 if (account == null) {
		 req.setAttribute("mess", "Sai tài khoản và mật khẩu");
		 req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
		 } else {
		 HttpSession session = req.getSession(true);
		 session.setAttribute("acc", account);
		 if(isRememberMe){
			 saveRemeberMe(resp, username);
			 }
			resp.sendRedirect(req.getContextPath()+"/waiting");
		 //session.setMaxInactiveInterval(1000);
		 //resp.sendRedirect("home");
		 }
	}
	private void saveRemeberMe(HttpServletResponse response, String
			username){
			Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER,
			username);
			cookie.setMaxAge(30*60);
			response.addCookie(cookie);
			}

		
}
