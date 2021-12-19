package vn.VietTech.service.Impl;

import java.util.List;

import vn.VietTech.dao.CartItemDao;
import vn.VietTech.dao.Impl.CartItemDaoImpl;
import vn.VietTech.model.CartItemModel;
import vn.VietTech.service.CartItemService;


public class CartItemServiceImpl  implements CartItemService {

	CartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public void edit(CartItemModel newCartItem) {
		CartItemModel oldCartItem = cartItemDao.get(newCartItem.getItemid());
		oldCartItem.setCart(newCartItem.getCart());
		oldCartItem.setProduct(newCartItem.getProduct());
		oldCartItem.setQuantity(newCartItem.getQuantity());
		oldCartItem.setUnitPrice(newCartItem.getUnitPrice());
		
		cartItemDao.edit(oldCartItem);
	}

	@Override
	public void deleteSP(String id) {
		cartItemDao.deleteSP(id);
	}

	@Override
	public CartItemModel get(int id) {
		return cartItemDao.get(id);
	}

	@Override
	public List<CartItemModel> getAll(String uid, String status) {
		return cartItemDao.getAll(uid, status);
	}

	@Override
	public List<CartItemModel> search(String keyword) {
		return cartItemDao.search(keyword);
	}

	@Override
	public void insert(CartItemModel cartItem) {
		cartItemDao.insert(cartItem);
	}

	@Override
	public int CountAll() {
		// TODO Auto-generated method stub
		return cartItemDao.CountAll();
	}
}
