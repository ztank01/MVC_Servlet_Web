package vn.iotstar.service;

import java.util.List;

import vn.iotstar.model.CategoryModel;

public interface CategoryService {
	List<CategoryModel> getALLCategory();
	CategoryModel getCategoryByID(String id);
	List<CategoryModel> getListCategoryByID(String cid);
	CategoryModel insert(CategoryModel category);
	void delete(int id);
	CategoryModel edit(CategoryModel category);
	CategoryModel get(int cate_id);
}
