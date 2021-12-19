package vn.VietTech.controller.web;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.VietTech.dao.Impl.CategoryDaoImpl;
import vn.VietTech.dao.Impl.ProductDaoImpl;
import vn.VietTech.dao.Impl.UserDaoImpl;
import vn.VietTech.model.AccountModel;
import vn.VietTech.model.CategoryModel;
import vn.VietTech.model.ProductModel;

@WebServlet(urlPatterns= {"/taikhoan"})
public class TaiKhoanController extends HttpServlet{

	private static final long serialVersionUID = -7331046505716064850L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username= req.getParameter("username");
		String password= req.getParameter("pass");
		UserDaoImpl userD= new UserDaoImpl();
		AccountModel taikhoan= userD.getAll(username, password);
		req.setAttribute("taikhoan", taikhoan);
		RequestDispatcher rq= req.getRequestDispatcher("/views/Khach/TaiKhoan.jsp");
		rq.forward(req, resp);
	}
}
