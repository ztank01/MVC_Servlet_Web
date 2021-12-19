package trinhtruong2k1.io.seller.serviceImpl;

import java.io.File;
import java.util.List;


import trinhtruong2k1.io.seller.Dao.CategoryDao;
import trinhtruong2k1.io.seller.DaoImpl.CategoryDaoImpl;
import trinhtruong2k1.io.seller.model.CategoryModel;
import trinhtruong2k1.io.seller.service.CategoryService;
import trinhtruong2k1.io.seller.utils.Constant;

public class CategoryServiceImpl implements CategoryService{
	CategoryDao categoryDao = new CategoryDaoImpl();
	
	@Override
	public List<CategoryModel> getAllCategory() {
		return categoryDao.getAllCategory();
	}

	@Override
	public CategoryModel getCategoryByID(String cid) {
		return categoryDao.getCategoryByID(cid);
	}

	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);
		
	}

	@Override
	public void edit(CategoryModel newCategory) {
		CategoryModel oldCategory = categoryDao.get(newCategory.getCate_id());
		oldCategory.setCname(newCategory.getCname());
		if (newCategory.getIcons() != null)
		{
			String fileName = oldCategory.getIcons();
			final String dir = Constant.CATEGORY_DIR;
			File file = new File(dir + fileName);
			if (file.exists()) {
				file.delete();
			}
			oldCategory.setIcons(newCategory.getIcons());	
		}
		categoryDao.edit(oldCategory);
		
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public CategoryModel get(int id) {
		return categoryDao.get(id);
	}
	
}
