package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.OrderItemDao;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.OrderItemModel;

public class OrderItemDaoImpl implements OrderItemDao{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public List<OrderItemModel> getALLOrderItem() {
		// TODO Auto-generated method stub
		List<OrderItemModel> list = new ArrayList<OrderItemModel>();
		String sql = "select OrderItem.ItemId, OrderItem.Quantity, OrderItem.UnitPrice, OrderItem.ProductId, OrderItem.OrderID, OrderItem.Status, Product.ProductName, Users.UserName from OrderItem, Orders, Users, Product where OrderItem.ProductId = Product.ProductId and OrderItem.OrderID=Orders.OrderId and Orders.UserId=Users.UserId";
		try {
			// mo ket noi
			conn = new DBConnect().getConnection();
			// nem cau query qua sql	
			ps = conn.prepareStatement(sql);
			// lay ket qua result
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new OrderItemModel(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8)));
			}
		} catch (Exception e) {

		}
		return list;
	}
	@Override
	public void delete(int itemId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM OrderItem WHERE ItemId = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
