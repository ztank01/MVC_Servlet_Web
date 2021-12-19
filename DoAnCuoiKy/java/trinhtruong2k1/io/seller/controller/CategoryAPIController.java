package trinhtruong2k1.io.seller.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import trinhtruong2k1.io.seller.model.CategoryModel;
import trinhtruong2k1.io.seller.service.CategoryService;
import trinhtruong2k1.io.seller.serviceImpl.CategoryServiceImpl;
import trinhtruong2k1.io.seller.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-category" })
public class CategoryAPIController extends HttpServlet {

	private static final long serialVersionUID = 1769295748169703288L;
	CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		List<CategoryModel> cateModel = HttpUtil.of(req.getReader()).listModel(CategoryModel.class);
		cateModel = categoryService.getAllCategory();
		mapper.writeValue(resp.getOutputStream(), cateModel);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel cateModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		categoryService.insert(cateModel);
		mapper.writeValue(resp.getOutputStream(), "{Đã thêm thành công}");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel cateModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		categoryService.edit(cateModel);
		mapper.writeValue(resp.getOutputStream(), "{Đã cập nhật thành công}");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel cateModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		categoryService.delete(cateModel.getCate_id());
		mapper.writeValue(resp.getOutputStream(), "{Đã xóa}");
	}
}
