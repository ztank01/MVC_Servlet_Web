package trinhtruong2k1.io.seller.Dao;

import java.util.List;

import trinhtruong2k1.io.seller.model.CategoryModel;

public interface CategoryDao {
	void insert (CategoryModel category);
	void edit (CategoryModel category);
	void delete (int id);
	CategoryModel get(int id);
	List<CategoryModel> getAllCategory();
	CategoryModel getCategoryByID(String cid);
	public List<CategoryModel> findAll();
	public CategoryModel findOne(long id);
}
