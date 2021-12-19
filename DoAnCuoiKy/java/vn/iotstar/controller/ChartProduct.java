package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.ProductModel;
import vn.iotstar.service.ProductService;
import vn.iotstar.service.impl.ProductServiceImpl;


@WebServlet(urlPatterns= {"/admin/chart/product"})
public class ChartProduct extends HttpServlet{
	
ProductService productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> productList = productService.getAllProduct();
		req.setAttribute("productList", productList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/chartProduct.jsp");
		dispatcher.forward(req, resp);
	}

}
