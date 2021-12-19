package vn.VietTech.service.Impl;

import java.io.File;
import java.util.List;

import vn.VietTech.dao.CategoryDao;
import vn.VietTech.dao.Impl.CategoryDaoImpl;
import vn.VietTech.model.CategoryModel;
import vn.VietTech.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao categoryDao= new CategoryDaoImpl();
	@Override
	public List<CategoryModel> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategory();
	}

	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);
	}

	@Override
	public void edit(CategoryModel category) {
		CategoryModel oldCategory = categoryDao.get(category.getCate_id());
		oldCategory.setCname(category.getCname());
		if (category.getIcons() != null) {
		// XOA ANH CU DI
		String fileName = oldCategory.getIcons();
		final String dir = "C:\\Users\\DELL\\Pictures\\NHAP";
		File file = new File(dir + "/category" + fileName);
		if (file.exists()) {
		file.delete();
		}
		oldCategory.setIcons(category.getIcons());
		}
		categoryDao.edit(oldCategory);
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public CategoryModel get(int id) {
		// TODO Auto-generated method stub
		return categoryDao.get(id);
	}

	@Override
	public CategoryModel get(String name) {
		// TODO Auto-generated method stub
		return categoryDao.get(name);
	}

}
