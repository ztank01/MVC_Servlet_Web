package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.model.AccountModel;
import vn.iotstar.service.UserService;
import vn.iotstar.service.impl.UserServiceImpl;


@WebServlet(urlPatterns= {"/admin/chart"})
public class Chart extends HttpServlet{
	
	UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<AccountModel> userList = userService.getALLUser();
		req.setAttribute("userList", userList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/chart.jsp");
		dispatcher.forward(req, resp);
	}

}
