package vn.VietTech.controller.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/logout"})
public class LogoutUserController extends HttpServlet {

	private static final long serialVersionUID = -305595459630457657L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		int GiaTri=0;
		session.setAttribute("GiaTri", GiaTri);
		session.invalidate();
		resp.sendRedirect("home");
	}
}
