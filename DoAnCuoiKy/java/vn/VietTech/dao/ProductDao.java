package vn.VietTech.dao;

import java.util.List;

import vn.VietTech.model.ProductModel;

public interface ProductDao {

	int countAll();
	int countCID(int cid);
	ProductModel edit(int id, String quantity);
	List<ProductModel> getTop4Product();
	List<ProductModel> getTopProduct();
	List<ProductModel> getAllProduct();
	List<ProductModel> getAllProductByCateID(String cid);
	ProductModel getAllProductByID(String id);
	List<ProductModel> getTop4BestProduct();
	List<ProductModel> searchByProductName(String txtSearch);
	List<ProductModel> pagingProduct(int index);
	List<ProductModel> pagingProductByCate(int index, int cid);
	List<ProductModel> getNext3Product(int iamount);
	List<ProductModel> getTop3Product();
}
