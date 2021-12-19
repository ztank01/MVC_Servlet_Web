package vn.VietTech.dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import vn.VietTech.dao.ProductDao;
import vn.VietTech.dao.UserDao;
import vn.VietTech.model.AccountModel;
import vn.VietTech.model.ProductModel;
import vn.VietTech.Connection.DBConnect;

public class ProductDaoImpl implements ProductDao{
	Connection conn =null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public List<ProductModel> getTop4Product(){
		//Khai báo danh sách tạo
		List<ProductModel> list=new ArrayList<ProductModel>();
		String sql="select TOP 4 * from Product \r\n"
				+"order by ProductID DESC";
		try {
			//mở kết nối database
			conn= new DBConnect().getConnection();
			//câu truy vấn qua sql
			ps=conn.prepareStatement(sql);
			//chạy query và nhận kết quả
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
			
		} catch (Exception e) {
			//ToDo: handle exception
		}
		return list;
	}
	
	public List<ProductModel> getTopProduct(){
		//Khai báo danh sách tạo
		List<ProductModel> list=new ArrayList<ProductModel>();
		String sql="select TOP 1 * from Product Order by Amount DESC";
		try {
			//mở kết nối database
			conn= new DBConnect().getConnection();
			//câu truy vấn qua sql
			ps=conn.prepareStatement(sql);
			//chạy query và nhận kết quả
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
			
		} catch (Exception e) {
			//ToDo: handle exception
		}
		return list;
	}
	
	
	
	public List<ProductModel> getTop3Product(){
		//Khai báo danh sách tạo
		List<ProductModel> list=new ArrayList<ProductModel>();
		String sql="select TOP 3 * from Product ";
		try {
			//mở kết nối database
			conn= new DBConnect().getConnection();
			//câu truy vấn qua sql
			ps=conn.prepareStatement(sql);
			//chạy query và nhận kết quả
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
			
		} catch (Exception e) {
			//ToDo: handle exception
		}
		return list;
	}
	
	
	public List<ProductModel> getAllProduct(){
		//Khai báo danh sách tạo
		List<ProductModel> list=new ArrayList<ProductModel>();
		String sql="select * from Product Order by Amount DESC";
		try {
			//mở kết nối database
			conn= new DBConnect().getConnection();
			//câu truy vấn qua sql
			ps=conn.prepareStatement(sql);
			//chạy query và nhận kết quả
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
			
		} catch (Exception e) {
			//ToDo: handle exception
		}
		return list;
	}
	
	//hiển thị tất cả sản phẩm theo category
	public List<ProductModel> getAllProductByCateID(String cid){
		//Khai báo danh sách tạo
		List<ProductModel> list=new ArrayList<ProductModel>();
		String sql="select * from Product where CategoryID=? ";
		try {
			//mở kết nối database
			conn= new DBConnect().getConnection();
			//câu truy vấn qua sql
			ps=conn.prepareStatement(sql);
			//gán giá trị cho từng dấu ?
			ps.setString(1, cid);
			//chạy query và nhận kết quả
			
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
			
		} catch (Exception e) {
			//ToDo: handle exception
		}
		return list;
	}
	
	public ProductModel getAllProductByID(String id){
		//Khai báo danh sách tạo
		String sql="select * from Product where ProductID=? ";
		try{
			//mở kết nối database
			conn= new DBConnect().getConnection();
			//câu truy vấn qua sql
			ps=conn.prepareStatement(sql);
			//gán giá trị cho từng dấu ?
			ps.setString(1, id);
			//chạy query và nhận kết quả
			
			rs=ps.executeQuery();
			while (rs.next()) {
				return new ProductModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8));
			}
			
		}catch (Exception e) {
			//ToDo: handle exception
		}
		return null;
	}
	
	
	public List<ProductModel> getTop4BestProduct(){
		//Khai báo danh sách tạo
		List<ProductModel> list=new ArrayList<ProductModel>();
		String sql="select TOP 4 * from Product Order by Amount DESC";
		try {
			//mở kết nối database
			conn= new DBConnect().getConnection();
			//câu truy vấn qua sql
			ps=conn.prepareStatement(sql);
			//chạy query và nhận kết quả
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
			
		} catch (Exception e) {
			//ToDo: handle exception
		}
		return list;
	}

	public List<ProductModel> searchByProductName(String txtSearch){
		//Khai báo danh sách tạo
		List<ProductModel> list=new ArrayList<ProductModel>();
		String sql="select * from Product where Productname like ?";
		try {
			//mở kết nối database
			conn= new DBConnect().getConnection();
			//câu truy vấn qua sql
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+txtSearch+"%");
			//chạy query và nhận kết quả
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
			
		} catch (Exception e) {
			//ToDo: handle exception
		}
		return list;

	}

	@Override
	public int countAll() {
		String sql="select count(*) from Product";
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
	public int countCID(int cid) {
		String sql="select count(*) from Product where CategoryID= ?";
		try {
			conn= new DBConnect().getConnection();
			ps= conn.prepareStatement(sql);
			ps.setInt(1, cid);
			rs= ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {
			
		}
		return 0;
	}

	@Override
	public List<ProductModel> pagingProduct(int index) {
		List<ProductModel> list= new ArrayList<ProductModel>();
		String sql="select * from Product order by ProductID OFFSET ? ROW fetch next 3 rows only";
		try{
			//mở kết nối database
			conn= new DBConnect().getConnection();
			//câu truy vấn qua sql
			ps=conn.prepareStatement(sql);
			//truy�?n (index-1)*3 cho từng dấu ? vì 1-offset từ 0, 2-offset từ 3, 3-offset từ 6
			ps.setInt(1, (index-1)*3);
			//chạy query và nhận kết quả
			
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
			
		}catch (Exception e) {
			//ToDo: handle exception
		}
		return list;
	}
	
	
	@Override
	public List<ProductModel> getNext3Product(int iamount) {
		List<ProductModel> list= new ArrayList<ProductModel>();
		String sql="select * from Product order by ProductID OFFSET ? ROW fetch next 3 rows only";
		try{
			//mở kết nối database
			conn= new DBConnect().getConnection();
			//câu truy vấn qua sql
			ps=conn.prepareStatement(sql);
			//truy�?n (index-1)*3 cho từng dấu ? vì 1-offset từ 0, 2-offset từ 3, 3-offset từ 6
			ps.setInt(1, iamount);
			//chạy query và nhận kết quả
			
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
			
		}catch (Exception e) {
			//ToDo: handle exception
		}
		return list;
	}
	
	@Override
	public List<ProductModel> pagingProductByCate(int index, int cid) {
		List<ProductModel> list= new ArrayList<ProductModel>();
		String sql="select * from Product where CategoryID= ? order by ProductID OFFSET ? ROW fetch next 3 rows only";
		try{
			//mở kết nối database
			conn= new DBConnect().getConnection();
			//câu truy vấn qua sql
			ps=conn.prepareStatement(sql);
			//truy�?n (index-1)*3 cho từng dấu ? vì 1-offset từ 0, 2-offset từ 3, 3-offset từ 6
			ps.setInt(1, cid);
			ps.setInt(2, (index-1)*3);
			//chạy query và nhận kết quả
			
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new ProductModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
			
		}catch (Exception e) {
			//ToDo: handle exception
		}
		return list;
	}

	@Override
	public ProductModel edit(int id, String quantity) {
		String sql = "UPDATE Product SET Amount=Amount + ? WHERE ProductId = ?";
		try {
			conn= new DBConnect().getConnection();
			//câu truy vấn qua sql
			ps=conn.prepareStatement(sql);
			
			//truy�?n (index-1)*3 cho từng dấu ? vì 1-offset từ 0, 2-offset từ 3, 3-offset từ 6
			ps.setString(1, quantity);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
