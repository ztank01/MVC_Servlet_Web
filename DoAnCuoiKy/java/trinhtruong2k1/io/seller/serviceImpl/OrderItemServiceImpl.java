package trinhtruong2k1.io.seller.serviceImpl;

import java.util.List;

import trinhtruong2k1.io.seller.Dao.OrderItemDao;
import trinhtruong2k1.io.seller.DaoImpl.OrderItemDaoImpl;
import trinhtruong2k1.io.seller.model.OrderItemModel;
import trinhtruong2k1.io.seller.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService{
	OrderItemDao orderItemDao = new OrderItemDaoImpl();
	@Override
	public int countAll(String id) {
		return orderItemDao.countAll(id);
	}

	@Override
	public void insert(OrderItemModel orderItem) {
		orderItemDao.insert(orderItem);
	}

	@Override
	public void edit(OrderItemModel orderItem) {
		orderItemDao.edit(orderItem);
	}

	@Override
	public void delete(int id) {
		orderItemDao.delete(id);
	}

	@Override
	public List<OrderItemModel> findAll() {
		return orderItemDao.findAll();
	}

	@Override
	public List<OrderItemModel> findBySellerID(String id) {
		return orderItemDao.findBySellerID(id);
	}

	@Override
	public int countTotalSale(String id) {
		return orderItemDao.countTotalSale(id);
	}

	@Override
	public double countAvgSale(String id) {
		return orderItemDao.countAvgSale(id);
	}

	@Override
	public OrderItemModel findByItemID(String id) {
		return orderItemDao.findByItemID(id);
	}

}
