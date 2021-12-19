package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.OrderItemModel;

public interface OrderItemDao {

	List<OrderItemModel>getALLOrderItem();
	void delete(int itemId);
}
