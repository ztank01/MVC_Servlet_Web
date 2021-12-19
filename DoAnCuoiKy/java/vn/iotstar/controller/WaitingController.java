package vn.iotstar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.model.AccountModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/waiting")
public class WaitingController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("acc") != null) {
			AccountModel u=(AccountModel) session.getAttribute("acc");
			req.setAttribute("user", u.getUser());
			if(u.getIsAdmin()==1) {
			resp.sendRedirect(req.getContextPath()+"/admin/home");
			}else if(u.getIsSell()==1) {
			resp.sendRedirect(req.getContextPath()+"/manager/home");
			}else {
			resp.sendRedirect(req.getContextPath()+"/home");
			}
			}else {
			resp.sendRedirect(req.getContextPath()+"/login");
			}
	}
}
