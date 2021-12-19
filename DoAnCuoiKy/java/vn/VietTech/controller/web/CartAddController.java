package vn.VietTech.controller.web;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.VietTech.model.CartItemModel;
import vn.VietTech.model.ProductModel;
import vn.VietTech.service.CartItemService;
import vn.VietTech.service.ProductService;
import vn.VietTech.service.Impl.CartItemServiceImpl;
import vn.VietTech.service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/cart-add" })
public class CartAddController extends HttpServlet {

	private static final long serialVersionUID = -135120731772441934L;
	ProductService productService = new ProductServiceImpl();
    CartItemService cartitemservice= new CartItemServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String pId = req.getParameter("pId");
		String quantity = req.getParameter("quantity");
		String username= req.getParameter("username");
		String password= req.getParameter("pass");
		ProductModel product = productService.getAllProductByID(pId);
		CartItemModel cartItem = new CartItemModel();
		cartItem.setQuantity(Integer.parseInt(quantity));
		cartItem.setUnitPrice((int)product.getPrice());
		cartItem.setProduct(product);
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		if (obj == null) {
			Map<Integer, CartItemModel> map = new HashMap<Integer, CartItemModel>();
			map.put(cartItem.getProduct().getId(), cartItem);
			httpSession.setAttribute("cart", map);
			
		} else {
			Map<Integer, CartItemModel> map = extracted(obj);
			CartItemModel existedCartItem = map.get(Integer.valueOf(pId));
			if (existedCartItem == null) {
				map.put(product.getId(), cartItem);
			} else {
				existedCartItem.setQuantity(existedCartItem.getQuantity() + Integer.parseInt(quantity));
			}
			httpSession.setAttribute("cart", map);
			
		}
		resp.sendRedirect(req.getContextPath() + "/cart-list?username="+username+"&pass="+password);
	}

	@SuppressWarnings("unchecked")
	private Map<Integer, CartItemModel> extracted(Object obj) {
		return (Map<Integer, CartItemModel>) obj;
	}
}
