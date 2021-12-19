package trinhtruong2k1.io.seller.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trinhtruong2k1.io.seller.model.OrderItemModel;
import trinhtruong2k1.io.seller.model.ProductModel;
import trinhtruong2k1.io.seller.service.OrderItemService;
import trinhtruong2k1.io.seller.service.ProductService;
import trinhtruong2k1.io.seller.serviceImpl.OrderItemServiceImpl;
import trinhtruong2k1.io.seller.serviceImpl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/seller_orders_confirm" })
public class SellerConfirmOrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	OrderItemService orderItemService = new OrderItemServiceImpl();
	ProductService productServive = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// Lấy tham số từ JSP
		String Itemid = req.getParameter("ItemId");
		
		OrderItemModel item = orderItemService.findByItemID(Itemid);
		item.setStatus(1);
		orderItemService.edit(item);
		ProductModel product = productServive.findByID(Integer.toString(item.getProductId()));
		product.setAmount(product.getAmount() + 1);
		product.setStock(product.getStock() - 1);
		productServive.edit(product);
		resp.sendRedirect(req.getContextPath() + "/seller_orders");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
