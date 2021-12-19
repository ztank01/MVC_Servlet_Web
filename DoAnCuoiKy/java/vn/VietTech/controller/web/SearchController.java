package vn.VietTech.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.VietTech.dao.Impl.CategoryDaoImpl;
import vn.VietTech.dao.Impl.ProductDaoImpl;
import vn.VietTech.model.CategoryModel;
import vn.VietTech.model.ProductModel;


@WebServlet(urlPatterns= {"/search"})
public class SearchController extends HttpServlet {


	private static final long serialVersionUID = -557658672364147998L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
	
		String txt1= req.getParameter("txt");
		ProductDaoImpl dao= new ProductDaoImpl();
		CategoryDaoImpl cateDao=new CategoryDaoImpl();
		// bước 2:sử dụng đối tượng list để chứa danh sách từ ProductDAO_LUAT
		List<ProductModel> list= dao.getTop4Product();
		List<ProductModel> listTop1= dao.getTopProduct();
		List<ProductModel> list4Best=dao.getTop4BestProduct();
		List<CategoryModel> listC= cateDao.getAllCategory();
		List<ProductModel> listAll= dao.getAllProduct();
		List<ProductModel> listtxt= dao.searchByProductName(txt1);
		//bước 3: Thiêt lập dữ liệu lên JSP
		req.setAttribute("list4product", list);
		req.setAttribute("list1TopProduct", listTop1);
		req.setAttribute("list4BestProduct", list4Best);
		req.setAttribute("listcate", listC);
		req.setAttribute("listAllProduct",listtxt );
		req.setAttribute("txtS", txt1);
		req.getRequestDispatcher("views/Khach/Product.jsp").forward(req, resp);
	}
}
