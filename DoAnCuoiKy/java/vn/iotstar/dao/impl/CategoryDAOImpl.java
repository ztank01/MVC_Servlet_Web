package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnect;
import vn.iotstar.dao.CategoryDao;
import vn.iotstar.model.CategoryModel;

public class CategoryDAOImpl implements CategoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<CategoryModel> getALLCategory() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "select * from Category";
		try {
			// mo ket noi
			conn = new DBConnect().getConnection();
			// nem cau query qua sql
			ps = conn.prepareStatement(sql);
			// lay ket qua result
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	public CategoryModel getCategoryByID(String id) {
		String sql = "select * from Category\r\n" + "where CategoryID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<CategoryModel> getListCategoryByID(String cid) {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "select * from Category where CategoryID = ?";
		try {
			// mo ket noi
			conn = new DBConnect().getConnection();
			// nem cau query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			// lay ket qua result
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {

		}
		return list;
	}
	public int maxId() {
		String query = "SELECT MAX(CategoryID) FROM Category";
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

	public void insert(CategoryModel category) {
		// TODO Auto-generated method stub
		int id = maxId() + 1;
		String sql = "INSERT INTO Category(CategoryID, CategoryName,icon) VALUES (?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, category.getCate_name());
			ps.setString(3, category.getCate_icon());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Category WHERE CategoryID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void edit(CategoryModel category) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Category SET CategoryName = ?, icon=? WHERE CategoryID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCate_name());
			ps.setString(2, category.getCate_icon());
			ps.setInt(3, category.getCate_id());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public CategoryModel get(int cate_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Category WHERE CategoryID = ? ";
		try {
		conn = new DBConnect().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, cate_id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		CategoryModel category = new CategoryModel();
		category.setCate_id(rs.getInt("CategoryID"));
		category.setCate_name(rs.getString("CategoryName"));
		category.setCate_icon(rs.getString("icon"));
		return category;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}
}
