package trinhtruong2k1.io.seller.serviceImpl;

import trinhtruong2k1.io.seller.Dao.UserDao;
import trinhtruong2k1.io.seller.DaoImpl.UserDaoImpl;
import trinhtruong2k1.io.seller.model.UserModel;
import trinhtruong2k1.io.seller.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public UserModel findById(String id) {
		return userDao.findById(id);
	}

}
