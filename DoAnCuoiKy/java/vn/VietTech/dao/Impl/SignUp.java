package vn.VietTech.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.VietTech.Connection.DBConnect;
import vn.VietTech.model.AccountModel;


public class SignUp {

	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs= null;
	UserDaoImpl userD= new UserDaoImpl();
	public AccountModel SignUp(String username, String password) {
		String sql= "insert into Users(UserId, Username, Password, isSeller, isAdmin) values (?,?,?,?,?)";
		try {
			conn= new DBConnect().getConnection();
			ps=conn.prepareStatement(sql);
			System.out.println(userD.CountAll());
			ps.setInt(1, userD.CountAll()+1);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setInt(4, 0);
			ps.setInt(5, 0);
			ps.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	public AccountModel SignUpSeller(String username, String password) {
		String sql= "insert into Users(UserId, Username, Password, isSeller, isAdmin) values (?,?,?,?,0)";
		try {
			conn= new DBConnect().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userD.CountAll()+1);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setInt(4, 1);
			ps.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	public AccountModel SignUpAdmin(String username, String password) {
		String sql= "insert into Users(UserId, Username, Password,isSeller, isAdmin) values (?,?,?,0,?)";
		try {
			conn= new DBConnect().getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userD.CountAll()+1);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setInt(4, 1);
			ps.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
