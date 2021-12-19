package vn.VietTech.controller.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.VietTech.dao.Impl.CartDaoImpl;
import vn.VietTech.dao.Impl.UserDaoImpl;
import vn.VietTech.model.AccountModel;
import vn.VietTech.model.CartItemModel;
import vn.VietTech.model.CartModel;
import vn.VietTech.model.CategoryModel;
import vn.VietTech.model.ProductModel;
import vn.VietTech.service.CartItemService;
import vn.VietTech.service.CategoryService;
import vn.VietTech.service.Impl.CartItemServiceImpl;
import vn.VietTech.service.Impl.CategoryServiceImpl;
import vn.VietTech.service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/cart-list" })
public class CartController extends HttpServlet {

	private static final long serialVersionUID = -4742766791538964186L;
	CategoryService cateService = new CategoryServiceImpl();
	CartItemService cartitemservice = new CartItemServiceImpl();
	CartDaoImpl cartDao = new CartDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		List<CategoryModel> list = cateService.getAllCategory();
		req.setAttribute("listcate", list);
		String username = req.getParameter("username");
		String password = req.getParameter("pass");
		UserDaoImpl userD = new UserDaoImpl();
		AccountModel taikhoan = userD.getAll(username, password);
		req.setAttribute("taikhoan", taikhoan);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/Khach/cart-list.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		DiskFileItemFactory diskFileItemFactory = new
		DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new
		ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		String uid="" ;
		String quanti="" ;
		try {
		List<FileItem> items = servletFileUpload.parseRequest(req);
		for (FileItem item : items) {
			if (item.getFieldName().equals("uid")) {
				uid=item.getString();}
			if (item.getFieldName().equals("quantity")) {
				quanti=item.getString();}
				} 
		}catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {e.printStackTrace();}
		
		UserDaoImpl userD = new UserDaoImpl();
		AccountModel taikhoan= userD.getAllID(uid);
		CartModel cart= new CartModel();
		cart.setBuyer(taikhoan);
		java.util.Date date=new java.util.Date();
		cart.setBuyDate(date);
		cart.setStatus(1);
		cartDao.insert(cart);
		CartModel Order= new CartModel();
		Order= cartDao.getall(cart);
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");// Doc tu Session ra
		@SuppressWarnings("unchecked")
		Map<Integer, CartItemModel> map = (Map<Integer, CartItemModel>) obj; // ep ve kieu cua no
		for (Map.Entry<Integer, CartItemModel> entry : map.entrySet()) {
			int pId =entry.getValue().getItemid();
			int quantity = entry.getValue().getQuantity();
			ProductModel product = entry.getValue().getProduct();
			CartItemModel cartItem = new CartItemModel();
			cartItem.setItemid(pId);
			cartItem.setQuantity(Integer.parseInt(quanti));
			cartItem.setUnitPrice((int)product.getPrice());
			cartItem.setCart(Order);
			cartItem.setProduct(product);
			cartItem.setStatus(0);
			// Cap nhat lai Session
			cartitemservice.insert(cartItem);
			ProductServiceImpl productservice= new ProductServiceImpl();
			productservice.edit(pId, quanti);
		}
		
		
		resp.sendRedirect("home");
		

	}

	@SuppressWarnings("unchecked")
	private Map<Integer, CartItemModel> extracted(Object obj) {
		return (Map<Integer, CartItemModel>) obj;
	}
}
