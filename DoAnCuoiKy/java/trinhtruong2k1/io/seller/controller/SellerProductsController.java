package trinhtruong2k1.io.seller.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trinhtruong2k1.io.seller.model.ProductModel;
import trinhtruong2k1.io.seller.service.ProductService;
import trinhtruong2k1.io.seller.serviceImpl.ProductServiceImpl;


@WebServlet(urlPatterns= {"/seller_products"})
public class SellerProductsController extends HttpServlet{
	private static final long serialVersionUID = 7405424350583920147L;
	
	ProductService productServive = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession httpSession= req.getSession();
		int uid = (int) httpSession.getAttribute("uid");
		String id = Integer.toString(uid);
		//String id = "2";
		List<ProductModel> products = productServive.findBySellerId(id);
		req.setAttribute("productList", products);
		RequestDispatcher rq = req.getRequestDispatcher("/views/seller/seller_products.jsp");
		rq.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	} 
}
