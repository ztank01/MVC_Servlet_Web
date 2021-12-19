package trinhtruong2k1.io.seller.DaoImpl;



import java.util.List;

import trinhtruong2k1.io.seller.Dao.OrderDao;
import trinhtruong2k1.io.seller.mapper.OrderMapper;
import trinhtruong2k1.io.seller.model.OrderModel;


public class OrderDaoImpl extends AbstractDao<OrderModel> implements OrderDao{

	@Override
	public int countAll() {
		String sql = "SELECT COUNT(OrderId) FROM Orders";
		return count(sql);
	}

	@Override
	public void insert(OrderModel order) {
		String sql = "INSERT INTO Orders(OrderId, UserId, OrderDate, Status) VALUES (?,?,?,?)";
		Long id = insert(sql,
				order.getOrderId(),
				order.getUserId(),
				order.getOrderDate(),
				order.getStatus()
				);
		id = id -1 + 1;//To do something in the future
		
	}

	@Override
	public void edit(OrderModel order) {
		String sql = "UPDATE Orders SET UserId = ?, OrderDate = ?, Status = ? WHERE OrderId = ?";
		update(sql, 
				order.getUserId(),
				order.getOrderDate(),
				order.getStatus(),
				order.getOrderId()
				);
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Orders WHERE OrderId = ?";
		query(sql, new OrderMapper(), id);
	}

	@Override
	public List<OrderModel> findAll() {
		String sql = "SELECT * FROM Orders";
		return query(sql, new OrderMapper());
	}

	@Override
	public OrderModel findByID(String id) {
		String sql = "SELECT * FROM Orders WHERE OrderId = ?";
		List<OrderModel> orders = query(sql, new OrderMapper(), id);
		return orders.isEmpty() ? null : orders.get(0);
	}
	public static void main(String[] args) {
		try {
			OrderDao orderDao = new OrderDaoImpl();
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			OrderModel order = new OrderModel(20, 3, sqlDate, 12);
			orderDao.edit(order);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
