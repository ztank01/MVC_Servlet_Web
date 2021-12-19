package vn.VietTech.dao;

import java.util.List;

import vn.VietTech.model.CartItemModel;


public interface CartItemDao {

	int CountAll();
	void insert(CartItemModel cartItem);
	 void edit(CartItemModel cartItem);
	 void deleteSP(String id);
	 CartItemModel get(String name);
	 CartItemModel get(int id);
	 List<CartItemModel> getAll(String uid, String status);
	 List<CartItemModel> search(String name);
}
