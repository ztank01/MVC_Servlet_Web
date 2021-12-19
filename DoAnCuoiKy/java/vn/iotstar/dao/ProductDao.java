package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.ProductModel;

public interface ProductDao {
	List<ProductModel> getAllProduct();
	void edit(ProductModel product);
	void insert(ProductModel product);
	void delete(int id);
	ProductModel get(int productId);
}
