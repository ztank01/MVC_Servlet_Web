package vn.VietTech.dao;

import java.util.List;

import vn.VietTech.model.CartModel;


public interface CartDao {

	 int CountAll();
	 void insert(CartModel cart);
	 void edit(CartModel cart);
	 void delete(int id);
	 CartModel get(String name);
	 CartModel get(int id);
	 CartModel getall(CartModel a);
	 List<CartModel> getAll();
	 List<CartModel> search(String name);
}
