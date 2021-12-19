package vn.VietTech.service;

import java.util.List;

import vn.VietTech.model.CategoryModel;

public interface CategoryService {

	List<CategoryModel> getAllCategory();
	void insert(CategoryModel category);
	void edit(CategoryModel category);
	void delete(int id);
	CategoryModel get(int id);
	CategoryModel get(String name);
}
