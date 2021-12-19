package vn.iotstar.service.impl;

import java.io.File;
import java.util.List;

import vn.iotstar.dao.CategoryDao;
import vn.iotstar.dao.impl.CategoryDAOImpl;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	CategoryDao categoryDao = new CategoryDAOImpl();
	@Override
	public CategoryModel insert(CategoryModel category) {
		// TODO Auto-generated method stub
		categoryDao.insert(category);
		return category;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryDao.delete(id);
	}

	@Override
	public CategoryModel edit(CategoryModel category) {
		// TODO Auto-generated method stub
		CategoryModel oldCategory = categoryDao.get(category.getCate_id());
		oldCategory.setCate_name(category.getCate_name());
		if (category.getCate_icon() != null) {
		// XOA ANH CU DI
		String fileName = oldCategory.getCate_icon();
		final String dir = "E:\\upload";
		File file = new File(dir + "/category" + fileName);
		if (file.exists()) {
		file.delete();
		}
		oldCategory.setCate_icon(category.getCate_icon());
		}
		categoryDao.edit(oldCategory);
		return oldCategory;
	}

	@Override
	public CategoryModel get(int cate_id) {
		return categoryDao.get(cate_id);
	}

	@Override
	public List<CategoryModel> getALLCategory() {
		// TODO Auto-generated method stub
		return categoryDao.getALLCategory();
	}

	@Override
	public CategoryModel getCategoryByID(String id) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryByID(id);
	}

	@Override
	public List<CategoryModel> getListCategoryByID(String cid) {
		// TODO Auto-generated method stub
		return categoryDao.getListCategoryByID(cid);
	}

}
