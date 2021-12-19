package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.CategoryModel;

public interface CategoryDao {
	List<CategoryModel> getALLCategory();
	CategoryModel getCategoryByID(String id);
	List<CategoryModel> getListCategoryByID(String cid);
	void insert(CategoryModel category);
	void delete(int id);
	void edit(CategoryModel category);
	CategoryModel get(int cate_id);
}
