package vn.VietTech.controller.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.VietTech.model.CartItemModel;
import vn.VietTech.service.CartItemService;
import vn.VietTech.service.Impl.CartItemServiceImpl;

@WebServlet(urlPatterns = { "/delete-item" })
public class DeleteCartItemController extends HttpServlet{

	private static final long serialVersionUID = 5985578969094075343L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		CartItemService cartitemservice = new CartItemServiceImpl();
		cartitemservice.deleteSP(id);
		resp.sendRedirect("home");
	}
}
