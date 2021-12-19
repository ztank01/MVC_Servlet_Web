package trinhtruong2k1.io.seller.DaoImpl;

import trinhtruong2k1.io.seller.Dao.UserDao;
import trinhtruong2k1.io.seller.mapper.UserMapper;
import trinhtruong2k1.io.seller.model.UserModel;
import java.util.List;

public class UserDaoImpl extends AbstractDao<UserModel> implements UserDao{

	@Override
	public UserModel findById(String id) {
		String sql = "SELECT * FROM Users WHERE UserId = ?";
		List<UserModel> user = query(sql, new UserMapper(), id);
		return user.isEmpty() ? null : user.get(0);
		
	}

}
