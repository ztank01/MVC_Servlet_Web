package vn.VietTech.service;

import java.util.List;

import vn.VietTech.model.CartItemModel;


public interface CartItemService {

	int CountAll();
	void insert(CartItemModel cartItem);
	 void edit(CartItemModel cartItem);
	 void deleteSP(String id);
	 CartItemModel get(int id);
	 List<CartItemModel> getAll(String uid, String status);
	 List<CartItemModel> search(String keyword);
}
