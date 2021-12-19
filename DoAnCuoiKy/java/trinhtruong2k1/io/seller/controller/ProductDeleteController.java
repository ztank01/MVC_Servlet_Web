package trinhtruong2k1.io.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trinhtruong2k1.io.seller.service.ProductService;
import trinhtruong2k1.io.seller.serviceImpl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/seller_products_delete" })
public class ProductDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ProductService productServive = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// Lấy tham số từ JSP
		String pid = req.getParameter("pid");
		
		productServive.delete(Integer.valueOf(pid));
		
		resp.sendRedirect(req.getContextPath() + "/seller_products");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
