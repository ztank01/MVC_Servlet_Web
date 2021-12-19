package trinhtruong2k1.io.seller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trinhtruong2k1.io.seller.model.CategoryModel;
import trinhtruong2k1.io.seller.model.ProductModel;
import trinhtruong2k1.io.seller.service.CategoryService;
import trinhtruong2k1.io.seller.service.ProductService;
import trinhtruong2k1.io.seller.serviceImpl.CategoryServiceImpl;
import trinhtruong2k1.io.seller.serviceImpl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/seller_products_add" })
public class SellerProductsAddController extends HttpServlet {
	private static final long serialVersionUID = 7405424350583920147L;
	ProductService productServive = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// Lấy tham số từ JSP
		String pid = req.getParameter("pid");
		int edit = 0;
		ProductModel product = new ProductModel();
		if (pid.equals("0"))
		{
			product.setId(productServive.maxId() + 1);
		}
		else
		{
			product = productServive.findByID(pid);
			edit = 1;
		}
		List<CategoryModel> categories = categoryService.getAllCategory();
		
		req.setAttribute("categories", categories);
		req.setAttribute("product", product);
		req.setAttribute("edit", edit);
		RequestDispatcher rq = req.getRequestDispatcher("/views/seller/seller_products_add.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
