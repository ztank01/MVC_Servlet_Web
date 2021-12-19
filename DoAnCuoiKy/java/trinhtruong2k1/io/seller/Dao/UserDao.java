package trinhtruong2k1.io.seller.Dao;

import trinhtruong2k1.io.seller.model.UserModel;

public interface UserDao {
	UserModel findById(String id);
}
