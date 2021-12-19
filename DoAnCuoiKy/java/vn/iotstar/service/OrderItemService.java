package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.OrderItemModel;

public interface OrderItemService {

	List<OrderItemModel> getALLOrderItem();
	void delete(int itemId);
}
