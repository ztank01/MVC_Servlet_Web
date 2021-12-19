package trinhtruong2k1.io.seller.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

import trinhtruong2k1.io.seller.model.ProductModel;
import trinhtruong2k1.io.seller.service.ProductService;
import trinhtruong2k1.io.seller.serviceImpl.ProductServiceImpl;
import trinhtruong2k1.io.seller.utils.Constant;

@WebServlet(urlPatterns = { "/api/add_edit_product" })
public class APIAddOrEditProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ProductService productServive = new ProductServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession= req.getSession();
		int uid = (int) httpSession.getAttribute("uid");
		String id = Integer.toString(uid);
		//String id = "2";
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
				if (item.getFieldName().equals("pid")) {
					product.setId(Integer.valueOf(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("name")) {
					product.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("description")) {
					product.setDescription(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("price")) {
					product.setPrice(Integer.valueOf(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("category")) {
					product.setCategoryID(Integer.valueOf(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("stock")) {
					product.setStock(Integer.valueOf(item.getString("UTF-8")));
				} else  if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						if (!ext.equals(""))
						{
							String fileName = System.currentTimeMillis() + "." + ext;
							File file = new File(Constant.PRODUCT_DIR + fileName);
							item.write(file);
							product.setImage(fileName);
						}
					} else {
						product.setImage(null);
					}
				}
			}
			// Kiểm tra là sửa hay thêm mới
			int newId = productServive.maxId() + 1;
			product.setSellerID(Integer.valueOf(id));
			product.setAmount(0);
			if (product.getId() == newId)
			{
				productServive.insert(product);
			}
			else
			{
				productServive.edit(product);
			}
			resp.sendRedirect(req.getContextPath() + "/seller_products");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath() + "/seller_products");
	}
}
