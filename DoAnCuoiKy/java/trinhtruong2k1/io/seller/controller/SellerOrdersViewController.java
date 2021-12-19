package trinhtruong2k1.io.seller.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trinhtruong2k1.io.seller.model.CategoryModel;
import trinhtruong2k1.io.seller.model.OrderItemModel;
import trinhtruong2k1.io.seller.model.OrderModel;
import trinhtruong2k1.io.seller.model.ProductModel;
import trinhtruong2k1.io.seller.model.UserModel;
import trinhtruong2k1.io.seller.service.CategoryService;
import trinhtruong2k1.io.seller.service.OrderItemService;
import trinhtruong2k1.io.seller.service.OrderService;
import trinhtruong2k1.io.seller.service.ProductService;
import trinhtruong2k1.io.seller.service.UserService;
import trinhtruong2k1.io.seller.serviceImpl.CategoryServiceImpl;
import trinhtruong2k1.io.seller.serviceImpl.OrderItemServiceImpl;
import trinhtruong2k1.io.seller.serviceImpl.OrderServiceImpl;
import trinhtruong2k1.io.seller.serviceImpl.ProductServiceImpl;
import trinhtruong2k1.io.seller.serviceImpl.UserServiceImpl;

@WebServlet(urlPatterns = { "/seller_orders_view" })
public class SellerOrdersViewController extends HttpServlet {

	private static final long serialVersionUID = 7405424350583920147L;
	ProductService productServive = new ProductServiceImpl();
	OrderItemService orderItemService = new OrderItemServiceImpl();
	UserService userService = new UserServiceImpl();
	OrderService orderSevice = new OrderServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// Lấy tham số từ JSP
		String Itemid = req.getParameter("ItemId");
		
		OrderItemModel item = orderItemService.findByItemID(Itemid);
		OrderModel order = orderSevice.findByID(Integer.toString(item.getOrderId()));
		UserModel customer = userService.findById(Integer.toString(order.getUserId()));
		ProductModel product = productServive.findByID(Integer.toString(item.getProductId()));
		CategoryModel category = categoryService.getCategoryByID(Integer.toString(product.getCategoryID()));
		UserModel seller = userService.findById(Integer.toString(product.getSellerID()));
		
		req.setAttribute("item", item);
		req.setAttribute("order", order);
		req.setAttribute("customer", customer);
		req.setAttribute("seller", seller);
		req.setAttribute("product", product);
		req.setAttribute("category", category);
		RequestDispatcher rq = req.getRequestDispatcher("/views/seller/seller_orders_view.jsp");
		rq.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
