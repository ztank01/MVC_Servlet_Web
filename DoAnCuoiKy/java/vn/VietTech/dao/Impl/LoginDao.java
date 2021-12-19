package vn.VietTech.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.VietTech.Connection.DBConnect;
import vn.VietTech.model.AccountModel;



public class LoginDao {

	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs= null;
	public AccountModel loginUser(String user, String pass) {
		String sql= "select * from Users where Username=? and Password=? and isSeller=0 and isAdmin=0;";
		try {
			//mowe kết nối
			conn=new DBConnect().getConnection();
			//ném câu query qua sql
			ps=conn.prepareStatement(sql);
			//lấy kết quả result
			ps.setString(1, user);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			while (rs.next()) {
				return new AccountModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5));
			}
		}catch(Exception e){
			
		}
		return null;
	}
	
	public AccountModel loginSeller(String user, String pass) {
		String sql= "select * from Users where Username=? and Password=? and isSeller=1";
		try {
			//mowe kết nối
			conn=new DBConnect().getConnection();
			//ném câu query qua sql
			ps=conn.prepareStatement(sql);
			//lấy kết quả result
			ps.setString(1, user);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			while (rs.next()) {
				return new AccountModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5));
			}
		}catch(Exception e){
			
		}
		return null;
	}
	
	public AccountModel loginAdmin(String user, String pass) {
		String sql= "select * from Users where Username=? and Password=? and isAdmin=1";
		try {
			//mowe kết nối
			conn=new DBConnect().getConnection();
			//ném câu query qua sql
			ps=conn.prepareStatement(sql);
			//lấy kết quả result
			ps.setString(1, user);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			while (rs.next()) {
				return new AccountModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5));
			}
		}catch(Exception e){
			
		}
		return null;
	}
}
