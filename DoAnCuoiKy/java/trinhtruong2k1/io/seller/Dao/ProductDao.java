package trinhtruong2k1.io.seller.Dao;

import java.util.List;

import trinhtruong2k1.io.seller.model.ProductModel;

public interface ProductDao {
	int countAll();
	int maxId();
	void insert (ProductModel product);
	void edit (ProductModel product);
	void delete (int id);
	List<ProductModel> findAll();
	ProductModel findByID(String id);
	List<ProductModel> findBySellerId(String id);
	List<ProductModel> findTop7ProductBySellerId(String id);
}

