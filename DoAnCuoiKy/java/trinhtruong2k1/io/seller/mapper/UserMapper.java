package trinhtruong2k1.io.seller.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import trinhtruong2k1.io.seller.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel user = new UserModel();
			user.setId(rs.getInt("UserId"));
			user.setUname(rs.getString("UserName"));
			user.setPassword(rs.getString("Password"));
			user.setSeller(rs.getInt("IsSeller"));
			user.setAdmin(rs.getInt("IsAdmin"));
			return user;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}

	}
}
