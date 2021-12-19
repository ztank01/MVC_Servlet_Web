package trinhtruong2k1.io.seller.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import trinhtruong2k1.io.seller.model.OrderModel;

public class OrderMapper implements RowMapper<OrderModel>{

	@Override
	public OrderModel mapRow(ResultSet rs) {
		try {
			OrderModel order = new OrderModel();
			order.setOrderId(rs.getInt("OrderId"));
			order.setUserId(rs.getInt("UserId"));
			order.setOrderDate(rs.getDate("OrderDate"));
			order.setStatus(rs.getInt("Status"));
			return order;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}

}
