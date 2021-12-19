package trinhtruong2k1.io.seller.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import trinhtruong2k1.io.seller.model.OrderItemModel;

public class OrderItemMapper implements RowMapper<OrderItemModel>{

	@Override
	public OrderItemModel mapRow(ResultSet rs) {
		try {
			OrderItemModel orderItem = new OrderItemModel();
			orderItem.setId(rs.getInt("ItemId"));
			orderItem.setQuantity(rs.getInt("Quantity"));
			orderItem.setUnitPrice(rs.getInt("UnitPrice"));
			orderItem.setProductId(rs.getInt("ProductId"));
			orderItem.setOrderId(rs.getInt("OrderID"));
			orderItem.setStatus(rs.getInt("Status"));
			return orderItem;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}

}
