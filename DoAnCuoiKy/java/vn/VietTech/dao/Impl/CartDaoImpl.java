package vn.VietTech.dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.VietTech.Connection.DBConnect;
import vn.VietTech.dao.CartDao;
import vn.VietTech.model.AccountModel;
import vn.VietTech.model.CartModel;
import vn.VietTech.service.UserService;
import vn.VietTech.service.Impl.UserServiceImpl;



public class CartDaoImpl extends DBConnect implements CartDao {

	UserService userS = new UserServiceImpl();
	
	@Override
	public void insert(CartModel cart) {
		String sql = "INSERT INTO Orders(OrderId, UserId, OrderDate, Status) VALUES (?,?,?,?)";
		try {
			CartDaoImpl cartD= new CartDaoImpl();
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartD.CountAll()+1);
			ps.setInt(2, cart.getBuyer().getUid());
			ps.setDate(3, new Date(cart.getBuyDate().getTime()));
			ps.setInt(4, cart.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CartModel cart) {
		String sql = "UPDATE cart SET id_user = ?, buyDate = ? WHERE id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getBuyer().getUid());
			ps.setDate(2, new Date(cart.getBuyDate().getTime()));
			ps.setInt(3, cart.getOrderid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM cart WHERE id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CartModel get(int id) {
		String sql = "SELECT TOP 1 * from Orders where OrderId=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userS.getID(rs.getInt(2));
				CartModel cart = new CartModel();
				cart.setOrderid(rs.getInt(1));
				cart.setBuyDate(rs.getDate(3));
				cart.setBuyer(user);
				return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CartModel> getAll() {
		List<CartModel> cartList = new ArrayList<CartModel>();
		String sql = "SELECT id, buyDate from Cart";
	
		try {
			Connection con = super.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cartList.add(new CartModel(
						rs.getInt(1),
						null, rs.getDate(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}

	public List<CartModel> search(String name) {
		List<CartModel> cartList = new ArrayList<CartModel>();
		String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
				+ "FROM cart INNER JOIN user " + "ON cart.id_user = user.id LIKE User.email = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userS.getID(rs.getInt("user_id"));
				CartModel cart = new CartModel();
				cart.setOrderid(rs.getInt("id"));
				cart.setBuyDate(rs.getDate("buyDate"));
				cart.setBuyer(user);
				cartList.add(cart);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public CartModel get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public CartModel getall(CartModel a) {
		String sql = "SELECT * from Orders where UserId=? and OrderDate=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a.getBuyer().getUid());
			ps.setDate(2, new Date(a.getBuyDate().getTime()));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userS.getID(rs.getInt(2));
				CartModel cart = new CartModel();
				cart.setOrderid(rs.getInt(1));
				cart.setBuyDate(rs.getDate(3));
				cart.setBuyer(user);
				return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int CountAll() {
		String sql="select MAX(OrderId) from Orders";
		try {
			Connection conn= super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps= conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {
			
		}
		return 0;
	}
}
