package trinhtruong2k1.io.seller.DaoImpl;

import java.util.List;

import trinhtruong2k1.io.seller.Dao.CategoryDao;
import trinhtruong2k1.io.seller.mapper.CategoryMapper;
import trinhtruong2k1.io.seller.model.CategoryModel;

public class CategoryDaoImpl extends AbstractDao<CategoryModel> implements CategoryDao{

	//Lấy tất cả các Category
	public List<CategoryModel> getAllCategory() {
		 String sql = "SELECT * FROM Category";
		 return query(sql, new CategoryMapper());
	}
	public CategoryModel getCategoryByID(String cid) {
		 String sql = "SELECT * FROM Category WHERE CategoryId = ?";
		 List<CategoryModel> category = query(sql, new CategoryMapper(), cid);
		 return category.isEmpty() ? null : category.get(0);
	}
	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO Category(CategoryName, icon) VALUES (?,?)";
		Long cid = insert(sql, category.getCname(), category.getIcons());
		cid = cid + 1 - 1;//To do something in the future
	}
	@Override
	public void edit(CategoryModel category) {
		String sql = "UPDATE Category SET CategoryName = ?, icon = ? WHERE "
				+ "CategoryID = ?";
		update(sql, category.getCname(), category.getIcons(), category.getCate_id());
	}
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Category WHERE CategoryID = ?";
		query(sql, new CategoryMapper(), id);
	}
	@Override
	public CategoryModel get(int id) {
		 String sql = "SELECT * FROM category WHERE CategoryID = ?";
		 List<CategoryModel> category = query(sql, new CategoryMapper(), id);
		 return category.isEmpty() ? null : category.get(0);
		}
	@Override
	public List<CategoryModel> findAll() {
		 String sql = "SELECT * FROM Category";
		 return query(sql, new CategoryMapper());
	}
	@Override
	public CategoryModel findOne(long id) {
		 String sql = "SELECT * FROM category WHERE CategoryID = ?";
		 List<CategoryModel> category = query(sql, new CategoryMapper(), id);
		 return category.isEmpty() ? null : category.get(0);
	}
	public static void main(String[] args) {
		try {
			CategoryDao productDao = new CategoryDaoImpl();
			//CategoryModel product = new CategoryModel(10,"1","1");
			//productDao.insert(product);
			System.out.println(productDao.getCategoryByID("2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
