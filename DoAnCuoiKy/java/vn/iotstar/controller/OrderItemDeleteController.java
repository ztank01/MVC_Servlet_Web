package vn.iotstar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.service.OrderItemService;
import vn.iotstar.service.impl.OrderItemServiceImpl;

@WebServlet(urlPatterns = {"/admin/orderItem/delete"})
public class OrderItemDeleteController extends HttpServlet{

	OrderItemService orderItemService = new OrderItemServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		orderItemService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin/orderItem/list");
	}
}
