package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.ProductDao;
import vn.iotstar.model.ProductModel;

public class ProductDaoImpl implements ProductDao{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<ProductModel> getAllProduct() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select ProductId, ProductName, Product.Description, Product.Price, Product.ImageLink, Product.CategoryId, Product.SellerID, Product.Amount, Product.InStock, Category.CategoryName, Users.UserName from Product, Category, Users where Product.CategoryId = Category.CategoryId and Product.SellerID = Users.UserId order by price asc";
		try {
			// mo ket noi database
			conn = new DBConnect().getConnection();
			// nem cau query qua sql
			ps = conn.prepareStatement(sql);
			// lay resultset do vao list
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11)));
			}
		} catch (Exception e) {
		}
		return list;
	}
	
	@Override
	public ProductModel get(int productId) {
		// TODO Auto-generated method stub
		String sql = "select ProductId, ProductName, Product.Description, Product.Price, Product.ImageLink, Product.CategoryId, Product.SellerID, Product.Amount, Product.InStock, Category.CategoryName, Users.UserName from Product, Category, Users where Product.CategoryId = Category.CategoryId and Product.SellerID = Users.UserId and ProductId = ? ";
		try {
		conn = new DBConnect().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, productId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		ProductModel product = new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
				rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getString(10), rs.getString(11));
		return product;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}

	@Override
	public void edit(ProductModel product) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Product SET ProductName = ?, Description = ?, Price = ?, ImageLink = ?, CategoryId = ?, SellerID = ?, Amount = ?, InStock = ?  WHERE ProductId = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setInt(3, (int)product.getPrice());
			ps.setString(4, product.getImage());
			ps.setInt(5, product.getCategoryID());
			ps.setInt(6, product.getSellerID());
			ps.setInt(7, product.getAmount());
			ps.setInt(8, product.getInStock());
			ps.setInt(9, product.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int maxId() {
		String query = "SELECT MAX(ProductId) FROM Product";
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
	public void insert(ProductModel product) {
		int id = maxId() + 1;
		String sql = "INSERT INTO Product(ProductId,ProductName,Description,Price,ImageLink,CategoryId,SellerID,Amount,InStock) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, product.getName());
			ps.setString(3, product.getDescription());
			ps.setInt(4, (int)product.getPrice());
			ps.setString(5, product.getImage());
			ps.setInt(6, product.getCategoryID());
			ps.setInt(7, product.getSellerID());
			ps.setInt(8, product.getAmount());
			ps.setInt(9, product.getInStock());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Product WHERE ProductId = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
