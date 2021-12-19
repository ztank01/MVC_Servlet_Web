package vn.VietTech.service;

import java.util.List;


import vn.VietTech.model.CartModel;


public interface CartService {

	int CountAll();
	void insert(CartModel cart);
	 void edit(CartModel newCart);
	 void delete(int id);
	 CartModel get(int id);
	 CartModel getall(CartModel a);
	 List<CartModel> getAll();
	 List<CartModel> search(String keyword);
}
