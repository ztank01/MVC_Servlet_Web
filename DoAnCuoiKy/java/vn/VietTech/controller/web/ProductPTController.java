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
import vn.VietTech.model.CategoryModel;
import vn.VietTech.model.ProductModel;
import vn.VietTech.model.SoSanPham;
import vn.VietTech.service.ProductService;
import vn.VietTech.service.Impl.ProductServiceImpl;


@WebServlet(urlPatterns= {"/productPT"})
public class ProductPTController extends HttpServlet{

	private static final long serialVersionUID = 3642107104883319838L;
	ProductService productService= new ProductServiceImpl();
	CategoryDaoImpl cateDao= new CategoryDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		//lấy tham số từ jsp
		String cid= req.getParameter("cid");
		// bước 1: Khởi tạo Dao
		
		// bước 2:sử dụng đối tượng list để chứa danh sách từ ProductDAO_LUAT
		List<ProductModel> list= productService.getTop4Product();
		List<ProductModel> listTop1= productService.getTopProduct();
		List<ProductModel> list4Best= productService.getTop4BestProduct();
		List<CategoryModel> listC= cateDao.getAllCategory();
		List<ProductModel> listAll= productService.getAllProduct();
		List<ProductModel> listCid= productService.getAllProductByCateID(cid);
		String indexPage= req.getParameter("index");
		
		
		//khởi tao trạng đầu.
		
		if(indexPage==null) {
			indexPage="1";
		}
		
		int index=Integer.parseInt(indexPage);
		int cid1=Integer.parseInt(cid);
		int count= productService.countAll();
		int countCid=productService.countCID(cid1);
		//chia trang cho count
		int endPage;
		
		
		
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

		if("0".equals(cid)) {
			endPage= count/3;
			if(count % 3 !=0) {
				endPage++;
			}
			List<ProductModel> listCidPage= productService.pagingProduct(index);
			req.setAttribute("endP", endPage);
		req.setAttribute("listAllProduct", listCidPage);
		} else {
			endPage= countCid/3;
			if(countCid % 3 !=0) {
				endPage++;
			}
			List<ProductModel> listPC= productService.pagingProductByCate(index, cid1);
			req.setAttribute("endP", endPage);
		req.setAttribute("listAllProduct", listPC);
		}
		//bước 3: Thiêt lập dữ liệu lên JSP
		req.setAttribute("list4product", list);
		req.setAttribute("list1TopProduct", listTop1);
		req.setAttribute("list4BestProduct", list4Best);
		req.setAttribute("listcate", listC);
		req.setAttribute("listSoCate", listdem);
		req.setAttribute("tagactive", cid);
		req.setAttribute("tag", index);
		
		
		
		// bước 4 : trả về trang jsb nào
		RequestDispatcher rq= req.getRequestDispatcher("/views/Khach/Product.jsp");
		rq.forward(req, resp);
	}
}
