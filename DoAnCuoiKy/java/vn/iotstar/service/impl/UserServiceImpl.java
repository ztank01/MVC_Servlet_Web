package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.model.AccountModel;
import vn.iotstar.service.UserService;

public class UserServiceImpl implements UserService{

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public List<AccountModel> getALLSeller() {
		return userDao.getALLSeller();
	}

	@Override
	public List<AccountModel> getALLUser() {
		// TODO Auto-generated method stub
		return userDao.getALLUser();
	}

	@Override
	public void insert(AccountModel user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	@Override
	public AccountModel get(int userId) {
		// TODO Auto-generated method stub
		return userDao.get(userId);
	}

	@Override
	public void edit(AccountModel user) {
		// TODO Auto-generated method stub
		userDao.edit(user);
	}
	
	@Override
	public AccountModel login(String username, String password) {
		AccountModel user = this.get(username);
		if (user != null && password.equals(user.getPass())) {
		return user;
		}
		return null;
	}

	@Override
	public AccountModel get(String username) {
		return userDao.get(username);
	}

}
