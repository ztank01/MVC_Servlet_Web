package vn.VietTech.dao.Impl;


import java.lang.reflect.Array;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.VietTech.dao.CategoryDao;
import vn.VietTech.model.CategoryModel;
import vn.VietTech.Connection.DBConnect;

public class CategoryDaoImpl implements CategoryDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<CategoryModel> getAllCategory() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "select * from Category";
		try {
			// mowe kết nối
			conn = new DBConnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// lấy kết quả result
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {

		}
		return list;

	}

	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO Category(CategoryName,icon) VALUES (?,?)";
		try {
			conn = new DBConnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCname());
			ps.setString(2, category.getIcons());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(CategoryModel category) {
		String sql = "UPDATE Category SET CategoryName = ?, icon=? WHERE CategoryID = ?";
				try {
					conn = new DBConnect().getConnection();
					// ném câu query qua sql
					ps = conn.prepareStatement(sql);
				ps.setString(1, category.getCname());
				ps.setString(2, category.getIcons());
				ps.setInt(3, category.getCate_id());
				ps.executeUpdate();
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Category WHERE CategoryID = ?";
		try {
			conn = new DBConnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}

	}

	@Override
	public CategoryModel get(int id) {
		String sql = "SELECT * FROM Category WHERE CategoryID = ? ";
		try {
			conn = new DBConnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		CategoryModel category = new CategoryModel();
		category.setCate_id(rs.getInt("CategoryID"));
		category.setCname(rs.getString("CategoryName"));
		category.setIcons(rs.getString("icon"));
		return category;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}

	@Override
	public CategoryModel get(String name) {
		String sql = "SELECT * FROM Category WHERE CategoryName = ? ";
		try {
			conn = new DBConnect().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		CategoryModel category = new CategoryModel();
		category.setCate_id(rs.getInt("CategoryID"));
		category.setCname(rs.getString("CategoryName"));
		category.setIcons(rs.getString("icon"));
		return category;
		}} catch (Exception e) {
		e.printStackTrace();}
		return null;
	}

}

