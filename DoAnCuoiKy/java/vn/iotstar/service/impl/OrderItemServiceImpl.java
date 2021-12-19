package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.OrderItemDao;
import vn.iotstar.dao.impl.OrderItemDaoImpl;
import vn.iotstar.model.OrderItemModel;
import vn.iotstar.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService{

	OrderItemDao orderItem = new OrderItemDaoImpl();
	@Override
	public List<OrderItemModel> getALLOrderItem() {
		// TODO Auto-generated method stub
		return orderItem.getALLOrderItem();
	}
	@Override
	public void delete(int itemId) {
		// TODO Auto-generated method stub
		orderItem.delete(itemId);
	}

}
