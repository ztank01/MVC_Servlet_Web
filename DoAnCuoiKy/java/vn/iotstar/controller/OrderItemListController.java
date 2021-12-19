package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.OrderItemModel;
import vn.iotstar.service.OrderItemService;
import vn.iotstar.service.impl.OrderItemServiceImpl;

@WebServlet(urlPatterns = {"/admin/orderItem/list"})
public class OrderItemListController extends HttpServlet{

	OrderItemService orderItemService = new OrderItemServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<OrderItemModel> orderItemList = orderItemService.getALLOrderItem();
		req.setAttribute("orderItemList", orderItemList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/listOrderItem.jsp");
		dispatcher.forward(req, resp);
	}
}
