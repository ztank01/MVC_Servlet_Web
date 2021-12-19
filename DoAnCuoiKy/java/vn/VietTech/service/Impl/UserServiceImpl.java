package vn.VietTech.service.Impl;

import vn.VietTech.dao.UserDao;
import vn.VietTech.dao.Impl.UserDaoImpl;
import vn.VietTech.model.AccountModel;
import vn.VietTech.service.UserService;

public class UserServiceImpl implements UserService {


	UserDao userDao= new UserDaoImpl();
	@Override
	public void insert(AccountModel user) {
		userDao.insert(user);
	}
	
	@Override
	public AccountModel getID(int int1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public AccountModel getAll(String username, String pass) {
		// TODO Auto-generated method stub
		return userDao.getAll(username, pass);
	}

	@Override
	public AccountModel editName(String username, String u_id) {
		return userDao.editName(username, u_id);
	}

	

	@Override
	public AccountModel editPass(String password, String u_id) {
		// TODO Auto-generated method stub
		return userDao.editPass(password, u_id);
	}

	@Override
	public int CountAll() {
		// TODO Auto-generated method stub
		return userDao.CountAll();
	}

	@Override
	public AccountModel getAllID(String id) {
		// TODO Auto-generated method stub
		return userDao.getAllID(id);
	}

	@Override
	public AccountModel getAllId(String id, String pass) {
		// TODO Auto-generated method stub
		return userDao.getAllId(id, pass);
	}

	

	

}
