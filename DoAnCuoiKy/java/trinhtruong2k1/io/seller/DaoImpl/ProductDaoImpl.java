package trinhtruong2k1.io.seller.DaoImpl;

import java.util.List;

import trinhtruong2k1.io.seller.Dao.ProductDao;
import trinhtruong2k1.io.seller.mapper.ProductMapper;
import trinhtruong2k1.io.seller.model.ProductModel;
import trinhtruong2k1.io.seller.service.ProductService;
import trinhtruong2k1.io.seller.serviceImpl.ProductServiceImpl;

public class ProductDaoImpl extends AbstractDao<ProductModel> implements ProductDao {

	@Override
	public int countAll() {
		String sql = "SELECT COUNT(ProductId) FROM Product";
		return count(sql);
	}
	
	@Override
	public int maxId() {
		String sql = "SELECT MAX(ProductId) FROM Product";
		return count(sql);
	}

	@Override
	public void insert(ProductModel product) {
		String sql = "INSERT INTO Product(ProductId, ProductName, Description, Price, ImageLink, CategoryId, SellerID, Amount, InStock) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		Long id = insert(sql,
				product.getId(),
				product.getName(), 
				product.getDescription(), 
				product.getPrice(), 
				product.getImage(), 
				product.getCategoryID(), 
				product.getSellerID(), 
				product.getAmount(), 
				product.getStock()); 
		id = id + 1 - 1;//To do something in the future
	}

	@Override
	public void edit(ProductModel product) {
		String sql = "UPDATE Product SET ProductName = ?, Description = ?, Price = ?, ImageLink = ?, CategoryId = ?, SellerID = ?, Amount = ?, InStock = ?"
				+ " WHERE ProductId = ?";
		update(sql, 
				product.getName(), 
				product.getDescription(), 
				product.getPrice(), 
				product.getImage(), 
				product.getCategoryID(), 
				product.getSellerID(), 
				product.getAmount(), 
				product.getStock(),
				product.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Product WHERE ProductId = ?";
		query(sql, new ProductMapper(), id);
		
	}

	@Override
	public List<ProductModel> findAll() {
		 String sql = "SELECT * FROM Product";
		 return query(sql, new ProductMapper());
	}

	@Override
	public ProductModel findByID(String id) {
		String sql = "SELECT * FROM Product WHERE ProductId = ?";
		List<ProductModel> product = query(sql, new ProductMapper(), id);
		return product.isEmpty() ? null : product.get(0);
	}
	
	@Override
	public List<ProductModel> findBySellerId(String id) {
		String sql = "SELECT * FROM Product WHERE SellerID = ?";
		return query(sql, new ProductMapper(), id);
		
	}
	public static void main(String[] args) {
		try {
			ProductService productService = new ProductServiceImpl();
			List<ProductModel> products = productService.findBySellerId("2");
			System.out.println(products);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductModel> findTop7ProductBySellerId(String id) {
		String sql = "SELECT TOP 7 * FROM Product WHERE SellerID = ? ORDER BY Amount DESC";
		return query(sql, new ProductMapper(), id);
	}

	
}
