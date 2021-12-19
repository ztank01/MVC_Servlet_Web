package vn.VietTech.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.VietTech.Connection.DBConnect;
import vn.VietTech.dao.UserDao;
import vn.VietTech.model.AccountModel;

public class UserDaoImpl implements UserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public void insert(AccountModel user) {
		String sql = "Insert into [Users](UserID, Username, Password, isSeller, isAdmin) VALUES (?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps.setInt(1, user.getUid());
			ps.setString(2, user.getUser());
			ps.setString(3, user.getPass());
			ps.setInt(4, user.getIsSell());
			;
			ps.setInt(5, user.getIsAdmin());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public AccountModel getID(int int1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountModel getAll(String username, String pass) {
		String sql = "select * from Users where Username=? and Password=? ";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// câu truy vấn qua sql
			ps = conn.prepareStatement(sql);
			// gán giá trị cho từng dấu ?
			ps.setString(1, username);
			ps.setString(2, pass);
			// chạy query và nhận kết quả

			rs = ps.executeQuery();
			while (rs.next()) {
				return new AccountModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}

		} catch (Exception e) {
			// ToDo: handle exception
		}
		return null;
	}

	@Override
	public AccountModel editName(String username, String u_id) {
		String sql = "UPDATE Users set Username=? where UserId=?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, u_id);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountModel getAllID(String id) {
		String sql = "select * from Users where UserId=? ";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// câu truy vấn qua sql
			ps = conn.prepareStatement(sql);
			// gán giá trị cho từng dấu ?
			ps.setString(1, id);
			
			// chạy query và nhận kết quả

			rs = ps.executeQuery();
			while (rs.next()) {
				return new AccountModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}

		} catch (Exception e) {
			// ToDo: handle exception
		}
		return null;
	}

	@Override
	public AccountModel editPass(String password, String u_id) {
		String sql = "UPDATE Users set Password=? where UserId=?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, u_id);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int CountAll() {
		String sql="select max(UserId) from Users";
		try {
			conn= new DBConnect().getConnection();
			ps= conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {
			
		}
		return 0;
	}

	@Override
	public AccountModel getAllId(String id, String pass) {
		String sql = "select * from Users where UserId=? and Password=?";
		try {
			// mở kết nối database
			conn = new DBConnect().getConnection();
			// câu truy vấn qua sql
			ps = conn.prepareStatement(sql);
			// gán giá trị cho từng dấu ?
			ps.setString(1, id);
			ps.setString(2, pass);
			// chạy query và nhận kết quả

			rs = ps.executeQuery();
			while (rs.next()) {
				return new AccountModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}

		} catch (Exception e) {
			// ToDo: handle exception
		}
		return null;
	}


}
