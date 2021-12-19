package vn.VietTech.controller.web;

import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.VietTech.dao.Impl.CategoryDaoImpl;
import vn.VietTech.dao.Impl.ProductDaoImpl;
import vn.VietTech.model.CategoryModel;
import vn.VietTech.model.ProductModel;
import vn.VietTech.model.SoSanPham;


@WebServlet(urlPatterns= {"/home"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 6900814006656678783L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// bước 1: Khởi tạo Dao
		ProductDaoImpl productDao= new ProductDaoImpl();
		CategoryDaoImpl cateDao= new CategoryDaoImpl();
		// bước 2:sử dụng đối tượng list để chứa danh sách từ ProductDAO_LUAT
		List<ProductModel> list= productDao.getTop4Product();
		List<ProductModel> listTop1= productDao.getTopProduct();
		List<ProductModel> list4Best= productDao.getTop4BestProduct();
		List<CategoryModel> listC= cateDao.getAllCategory();
		List<ProductModel> listAll= productDao.getAllProduct();
		List<SoSanPham> listdem= new ArrayList<>();
		for(CategoryModel cate : listC)
		{
			int dem =0;
			for(ProductModel pro : listAll)
			{
				if(cate.getCate_id()==pro.getCategoryID())
					dem=dem+1;
			}
			listdem.add(new SoSanPham(cate.getCate_id(),dem));
		}
		//bước 3: Thiêt lập dữ liệu lên JSP
		req.setAttribute("list4product", list);
		req.setAttribute("list1TopProduct", listTop1);
		req.setAttribute("list4BestProduct", list4Best);
		req.setAttribute("listcate", listC);
		req.setAttribute("listProduct", listAll);
		req.setAttribute("listSoCate", listdem);
		// bước 4 : trả v�? trang jsb nào
		RequestDispatcher rq= req.getRequestDispatcher("/views/Khach/home.jsp");
		rq.forward(req, resp);
	}
}