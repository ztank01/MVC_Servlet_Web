package vn.iotstar.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.iotstar.model.AccountModel;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.CategoryService;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.CategoryServiceImpl;
import vn.iotstar.service.impl.ProductServiceImpl;
import vn.iotstar.service.impl.UserServiceImpl;
import trinhtruong2k1.io.seller.utils.Constant;


@WebServlet(urlPatterns = { "/admin/product/edit" })
public class ProductEditController extends HttpServlet{
	
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();
	UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ProductModel product = productService.get(Integer.parseInt(id));
		req.setAttribute("product", product);
		
		List<CategoryModel> cateList = cateService.getALLCategory();
		req.setAttribute("cateList", cateList);
		
		List<AccountModel> sellerList = userService.getALLSeller();
		req.setAttribute("sellerList", sellerList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/editProduct.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductModel product = new ProductModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("id")) {
					product.setId(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("name")) {
					product.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("editor")) {
					product.setDescription(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("price")) {
					product.setPrice(Double.parseDouble(item.getString()));
				} else if (item.getFieldName().equals("cate_id")) {
					product.setCategoryID(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("seller_id")) {
					product.setSellerID(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("amount")) {
					product.setAmount(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("inStock")) {
					product.setInStock(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("icon")) {
					if (item.getSize() > 0) {// neu co file d
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.PRODUCT_DIR + fileName);
						item.write(file);
						product.setImage(fileName);
					} else {
						product.setImage(null);
					}
				}
			}
			productService.edit(product);
			resp.sendRedirect(req.getContextPath() + "/admin/product/list");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
