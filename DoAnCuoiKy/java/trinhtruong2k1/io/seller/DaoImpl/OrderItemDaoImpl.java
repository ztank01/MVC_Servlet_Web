package trinhtruong2k1.io.seller.DaoImpl;

import java.util.List;

import trinhtruong2k1.io.seller.Dao.OrderItemDao;
import trinhtruong2k1.io.seller.mapper.OrderItemMapper;
import trinhtruong2k1.io.seller.model.OrderItemModel;
import trinhtruong2k1.io.seller.service.OrderItemService;
import trinhtruong2k1.io.seller.serviceImpl.OrderItemServiceImpl;



public class OrderItemDaoImpl extends AbstractDao<OrderItemModel> implements OrderItemDao{

	@Override
	public int countAll(String id) {
		String sql = "SELECT COUNT(ItemId) FROM OrderItem,Product WHERE OrderItem.ProductId=Product.ProductId AND Product.SellerID = ? AND Status != 2";
		return count(sql, id);
	}

	@Override
	public void insert(OrderItemModel orderItem) {
		String sql = "INSERT INTO OrderItem(ItemId, Quantity, UnitPrice, ProductId, OrderID, Status) VALUES(?, ?, ?, ?, ?, ?)";
		Long id = insert(sql, 
					orderItem.getId(),
					orderItem.getQuantity(),
					orderItem.getUnitPrice(),
					orderItem.getProductId(),
					orderItem.getOrderId(),
					orderItem.getStatus()
					);
		id = id + 1 - 1;//To do something in the future
		
	}

	@Override
	public void edit(OrderItemModel orderItem) {
		String sql = "UPDATE OrderItem SET Quantity = ?, UnitPrice = ?, ProductId = ?, OrderID = ?, Status = ? WHERE ItemId = ?";
		update(sql, 
				orderItem.getQuantity(),
				orderItem.getUnitPrice(),
				orderItem.getProductId(),
				orderItem.getOrderId(),
				orderItem.getStatus(),
				orderItem.getId()
			);
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM OrderItem WHERE ItemId = ?";
		query(sql, new OrderItemMapper(), id);
		
	}

	@Override
	public List<OrderItemModel> findAll() {
		String sql = "SELECT * FROM OrderItem";
		return query(sql, new OrderItemMapper());
	}

	@Override
	public List<OrderItemModel> findBySellerID(String id) {
		String sql = "SELECT ItemId, Quantity, UnitPrice, OrderItem.ProductId, OrderID, Status FROM OrderItem,Product WHERE OrderItem.ProductId=Product.ProductId AND Product.SellerID = ? ORDER BY Status ASC";
		return query(sql, new OrderItemMapper(), id);
		
	}
	public static void main(String[] args) {
		try {
			OrderItemService orderItemService = new OrderItemServiceImpl();
			OrderItemModel item = orderItemService.findByItemID("1");
			item.setStatus(1);
			System.out.println(item);
			orderItemService.edit(item);
			System.out.println(orderItemService.findByItemID("1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int countTotalSale(String id) {
		String sql = "SELECT SUM(UnitPrice*Quantity) FROM OrderItem,Product WHERE OrderItem.ProductId=Product.ProductId AND Product.SellerID = ? AND Status != 2";
		return count(sql, id) * 1000;
	}

	@Override
	public double countAvgSale(String id) {
		int numberOrderItem = countAll(id);
		int totalSale = countTotalSale(id);
		if (numberOrderItem == 0)
			return 0;
		return totalSale/numberOrderItem;
	}

	@Override
	public OrderItemModel findByItemID(String id) {
		String sql = "SELECT * FROM OrderItem WHERE ItemId = ?";
		List<OrderItemModel> orderItems= query(sql, new OrderItemMapper(), id);
		return orderItems.isEmpty() ? null : orderItems.get(0);
	}

}
