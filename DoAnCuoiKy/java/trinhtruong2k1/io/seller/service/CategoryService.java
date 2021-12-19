package trinhtruong2k1.io.seller.service;

import java.util.List;

import trinhtruong2k1.io.seller.model.CategoryModel;

public interface CategoryService {
	void insert (CategoryModel category);
	void edit (CategoryModel category);
	void delete (int id);
	CategoryModel get(int id);
	List<CategoryModel> getAllCategory();
	CategoryModel getCategoryByID(String cid);
	
}
