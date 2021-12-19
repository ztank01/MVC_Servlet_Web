package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.UserDao;
import vn.iotstar.model.AccountModel;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;

public class UserDaoImpl implements UserDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int maxId() {
		String query = "SELECT MAX(UserId) FROM Users";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return 0;
	}
	
	@Override
	public List<AccountModel> getALLSeller() {
		List<AccountModel> list = new ArrayList<AccountModel>();
		String sql = "select * from Users where isSeller = 1";
		try {
			// mo ket noi
			conn = new DBConnect().getConnection();
			// nem cau query qua sql
			ps = conn.prepareStatement(sql);
			// lay ket qua result
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new AccountModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	@Override
	public List<AccountModel> getALLUser() {
		// TODO Auto-generated method stub
		List<AccountModel> list = new ArrayList<AccountModel>();
		String sql = "select * from Users";
		try {
			// mo ket noi
			conn = new DBConnect().getConnection();
			// nem cau query qua sql
			ps = conn.prepareStatement(sql);
			// lay ket qua result
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new AccountModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	@Override
	public void insert(AccountModel user) {
		int id = maxId() + 1;
		String sql = "INSERT INTO Users(UserId, UserName, Password, IsSeller, IsAdmin) VALUES (?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, user.getUser());
			ps.setString(3, user.getPass());
			ps.setInt(4, user.getIsSell());
			ps.setInt(5, user.getIsAdmin());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Users WHERE UserId = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public AccountModel get(int userId) {
		// TODO Auto-generated method stub
		String sql = "select * from Users where  UserId = ? ";
		try {
		conn = new DBConnect().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, userId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		AccountModel user = new AccountModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
		return user;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}

	@Override
	public void edit(AccountModel user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Users SET UserName = ?, Password = ?, isSeller = ?, isAdmin = ?  WHERE UserId = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser());
			ps.setString(2, user.getPass());
			ps.setInt(3, user.getIsSell());
			ps.setInt(4, user.getIsAdmin());
			ps.setInt(5, user.getUid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public AccountModel get(String username) {
		String sql = "SELECT * FROM users WHERE Username = ? ";
		try {
		conn = new DBConnect().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while (rs.next()) {
		AccountModel user = new AccountModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
		return user;}
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}

}
