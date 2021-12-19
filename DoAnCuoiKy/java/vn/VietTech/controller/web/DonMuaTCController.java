package vn.VietTech.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.VietTech.dao.Impl.CartDaoImpl;
import vn.VietTech.model.CartItemModel;
import vn.VietTech.service.CartItemService;
import vn.VietTech.service.CategoryService;
import vn.VietTech.service.Impl.CartItemServiceImpl;
import vn.VietTech.service.Impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/MuaTC" })
public class DonMuaTCController extends HttpServlet {

	private static final long serialVersionUID = 8549647164131006732L;
	// bước 1: Kh�?i tạo Service
	CategoryService cateService = new CategoryServiceImpl();
	CartDaoImpl cartDao = new CartDaoImpl();
	CartItemService cartitemservice = new CartItemServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String uid = req.getParameter("uid");
		String status = "1";
		List<CartItemModel> list = cartitemservice.getAll(uid, status);
		req.setAttribute("listcate", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/Khach/muaTC.jsp");
		dispatcher.forward(req, resp);
	}

}
