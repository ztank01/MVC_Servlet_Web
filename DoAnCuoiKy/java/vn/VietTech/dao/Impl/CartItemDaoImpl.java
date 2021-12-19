package vn.VietTech.dao.Impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.VietTech.Connection.DBConnect;
import vn.VietTech.dao.CartItemDao;
import vn.VietTech.dao.UserDao;
import vn.VietTech.model.AccountModel;
import vn.VietTech.model.CartItemModel;
import vn.VietTech.model.CartModel;
import vn.VietTech.model.ProductModel;
import vn.VietTech.service.CartService;
import vn.VietTech.service.ProductService;
import vn.VietTech.service.Impl.CartServiceImpl;
import vn.VietTech.service.Impl.ProductServiceImpl;




public class CartItemDaoImpl extends DBConnect implements CartItemDao {

	CartService cartService = new CartServiceImpl();
	ProductService productService = new ProductServiceImpl();
	UserDao userDao = new UserDaoImpl();

	@Override
	public void insert(CartItemModel cartItem) {
		String sql = "INSERT INTO OrderItem(ItemId, Quantity, UnitPrice, ProductId, OrderID,Status) VALUES (?,?,?,?,?,?)";
		try {
			CartItemDaoImpl cartitem= new CartItemDaoImpl();
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartitem.CountAll()+1);
			ps.setInt(2, cartItem.getQuantity());
			ps.setInt(3, cartItem.getUnitPrice());
			ps.setInt(4, cartItem.getProduct().getId());
			int cat= cartItem.getCart().getOrderid();
			ps.setInt(5,cat);
			ps.setInt(6, cartItem.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CartItemModel cartItem) {
		String sql = "UPDATE CartItem SET cat_id = ?, pro_id = ?, quantity = ?, unitPrice=? WHERE id = ?";
		try {
			Connection con = super.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartItem.getCart().getOrderid());
			ps.setInt(2, cartItem.getProduct().getId());
			ps.setInt(3, cartItem.getQuantity());
			ps.setDouble(4, cartItem.getUnitPrice());
			ps.setInt(5, cartItem.getItemid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteSP(String id) {
		String sql = "UPDATE OrderItem set Status =2 where ItemId=?";
		try {
			Connection con = super.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public CartItemModel get(int id) {
		String sql = "SELECT " + "CartItem.id, " + "CartItem.quantity, " + "CartItem.unitPrice, " + "cart.u_id, "
				+ "cart.buyDate, " + "product.name, " + "product.price " + "FROM CartItem " + "INNER JOIN Cart "
				+ "ON CartItem.cart_id = cart.id " + "INNER JOIN Product " + "ON CartItem.pro_id = Product.id "
				+ "WHERE CartItem.id = ?";
		try {
			Connection con = super.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userDao.getID(rs.getInt("u_id"));
				CartModel cart = new CartModel();
				cart.setBuyer(user);
				cart.setBuyDate(rs.getDate("buyDate"));
				ProductModel product = new ProductModel();
				product.setName(rs.getString("name"));
				product.setPrice(rs.getLong("price"));
				CartItemModel cartItem = new CartItemModel();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice((int)rs.getLong("unitPrice"));
				return cartItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CartItemModel> getAll(String uid, String status) {
		List<CartItemModel> cartItemList = new ArrayList<CartItemModel>();
		String sql = "select * from OrderItem, Orders, Product where Product.ProductId=OrderItem.ProductId and OrderItem.OrderID=Orders.OrderId and OrderItem.Status=? and Orders.UserId=?";

		try {
			Connection con = super.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, status);
			ps.setString(2, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userDao.getID(rs.getInt("UserId"));
				CartModel cart = new CartModel();
				cart.setBuyer(user);
				cart.setOrderid(rs.getInt("OrderId"));
				cart.setBuyDate(rs.getDate("OrderDate"));
				ProductModel product = new ProductModel();
				product.setName(rs.getString("ProductName"));
				product.setImage(rs.getString("imageLink"));
				product.setPrice(rs.getInt("Price"));
				CartItemModel cartItem = new CartItemModel();
				cartItem.setItemid(rs.getInt("ItemId"));
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(rs.getInt("Quantity"));
				cartItem.setUnitPrice(rs.getInt("UnitPrice"));
				cartItemList.add(cartItem);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItemList;
	}

	public List<CartItemModel> search(String name) {
		return null;
	}

	@Override
	public CartItemModel get(String name) {
		return null;
	}

	@Override
	public int CountAll() {
		String sql="select MAX(ItemId) from OrderItem";
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
