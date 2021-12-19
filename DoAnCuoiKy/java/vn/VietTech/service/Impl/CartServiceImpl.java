package vn.VietTech.service.Impl;

import java.util.List;

import vn.VietTech.dao.CartDao;
import vn.VietTech.dao.Impl.CartDaoImpl;
import vn.VietTech.model.CartModel;
import vn.VietTech.service.CartService;

public class CartServiceImpl implements CartService {

	CartDao cartDao = new CartDaoImpl();

	@Override
	public List<CartModel> search(String name) {
		return cartDao.search(name);
	}


	@Override
	public List<CartModel> getAll() {
		return cartDao.getAll();
	}

	@Override
	public CartModel get(int id) {
		return cartDao.get(id);
	}

	@Override
	public void edit(CartModel newCart) {
		CartModel oldCart = cartDao.get(newCart.getOrderid());

		oldCart.setBuyDate(newCart.getBuyDate());
		oldCart.setBuyer(newCart.getBuyer());
		
		
		cartDao.edit(oldCart);

	}

	@Override
	public void delete(int id) {
		cartDao.delete(id);
	}


	@Override
	public void insert(CartModel cart) {
		cartDao.insert(cart);
	}


	@Override
	public CartModel getall(CartModel a) {
		// TODO Auto-generated method stub
		return cartDao.getall(a);
	}


	@Override
	public int CountAll() {
		// TODO Auto-generated method stub
		return cartDao.CountAll();
	}
}
