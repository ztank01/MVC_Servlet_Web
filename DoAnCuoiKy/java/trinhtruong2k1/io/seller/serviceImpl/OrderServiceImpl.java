package trinhtruong2k1.io.seller.serviceImpl;

import java.util.List;

import trinhtruong2k1.io.seller.Dao.OrderDao;
import trinhtruong2k1.io.seller.DaoImpl.OrderDaoImpl;
import trinhtruong2k1.io.seller.model.OrderModel;
import trinhtruong2k1.io.seller.service.OrderService;

public class OrderServiceImpl implements OrderService{
	OrderDao orderDao = new OrderDaoImpl();
	@Override
	public int countAll() {
		return orderDao.countAll();
	}

	@Override
	public void insert(OrderModel order) {
		orderDao.insert(order);
	}

	@Override
	public void edit(OrderModel order) {
		orderDao.edit(order);
	}

	@Override
	public void delete(int id) {
		orderDao.delete(id);
	}

	@Override
	public List<OrderModel> findAll() {
		return orderDao.findAll();
	}

	@Override
	public OrderModel findByID(String id) {
		return orderDao.findByID(id);
	}

}
