package vn.VietTech.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.VietTech.dao.UserDao;
import vn.VietTech.dao.Impl.CategoryDaoImpl;
import vn.VietTech.dao.Impl.ProductDaoImpl;
import vn.VietTech.dao.Impl.UserDaoImpl;
import vn.VietTech.model.AccountModel;
import vn.VietTech.model.CategoryModel;
import vn.VietTech.model.ProductModel;


@WebServlet(urlPatterns= {"/productdetail"})
public class ProductDetailController extends HttpServlet {

	private static final long serialVersionUID = -5558690480619183602L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//lấy tham số từ jsp
		String pid= req.getParameter("pid");
		String cid= req.getParameter("cid");

		// bước 1: Khởi tạo Dao
		ProductDaoImpl productDao= new ProductDaoImpl();
		UserDaoImpl userD= new UserDaoImpl();
		CategoryDaoImpl cateDao= new CategoryDaoImpl();
		// bước 2:sử dụng đối tượng list để chứa danh sách từ ProductDAO_LUAT
		List<CategoryModel> listC= cateDao.getAllCategory();
		ProductModel Detail= productDao.getAllProductByID(pid);
		AccountModel sell= userD.getAllID(String.valueOf(Detail.getSellerID()));
		//bước 3: Thiêt lập dữ liệu lên JSP
		req.setAttribute("DetProduct", Detail);
		req.setAttribute("NameSeller", sell.getUser());
		req.setAttribute("listcate", listC);
	//	req.setAttribute("tagactive", pid);

		// bước 4 : trả v�? trang jsb nào
		RequestDispatcher rq= req.getRequestDispatcher("/views/Khach/ProductDetail.jsp");
		rq.forward(req, resp);
		
	}
}
