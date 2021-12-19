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
import vn.VietTech.model.CategoryModel;
import vn.VietTech.model.ProductModel;
import vn.VietTech.model.SoSanPham;
import vn.VietTech.service.CategoryService;
import vn.VietTech.service.ProductService;
import vn.VietTech.service.Impl.CategoryServiceImpl;
import vn.VietTech.service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/product" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 4053864528493519377L;
	// bước 1: Khởi tạo service
	ProductService productSerive = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập tiếng viết
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// lấy tham số từ JSP
		String cid = req.getParameter("cid");
		String indexPage = req.getParameter("index");
		// khởi tạo trang đầu
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		// Bước 2: Sử dụng đối tượng list để chứa danh sách từ ProductDAO
		// List<ProductModel> list = productSerive.getAllProduct();
		List<ProductModel> listP = productSerive.getTop3Product();
		List<ProductModel> list1 = productSerive.getTopProduct();
		List<ProductModel> list2 = productSerive.getTop4BestProduct();
		List<CategoryModel> listC = categoryService.getAllCategory();
		// List<CategoryModel> cateByID = categoryService.getALLCategoryByID(cid);
		// bước 3: Thiết lập dữ liệu lên JSP
		List<ProductModel> list = productSerive.getAllProduct();
		req.setAttribute("listAllProduct", listP);
		// if("0".equals(cid)) {
		req.setAttribute("listcate", listC);
		// }else {
		// req.setAttribute("listcate", cateByID);
		// }
		List<SoSanPham> listdem = new ArrayList<>();
		for (CategoryModel cate : listC) {
			int dem = 0;
			for (ProductModel pro : list) {
				if (cate.getCate_id() == pro.getCategoryID())
					dem = dem + 1;
			}
			listdem.add(new SoSanPham(cate.getCate_id(), dem));
		}
		req.setAttribute("listSoCate", listdem);
		req.setAttribute("list1TopProduct", list1);
		req.setAttribute("list4BestProduct", list2);
		req.setAttribute("listcate", listC);
		req.setAttribute("tagactive", cid);
		req.setAttribute("tag", index);
		// bước 4: Trả v�? trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/Khach/Product.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}