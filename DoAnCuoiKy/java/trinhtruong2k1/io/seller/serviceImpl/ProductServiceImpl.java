package trinhtruong2k1.io.seller.serviceImpl;

import java.io.File;
import java.util.List;

import trinhtruong2k1.io.seller.Dao.ProductDao;
import trinhtruong2k1.io.seller.DaoImpl.ProductDaoImpl;
import trinhtruong2k1.io.seller.model.ProductModel;
import trinhtruong2k1.io.seller.service.ProductService;
import trinhtruong2k1.io.seller.utils.Constant;

public class ProductServiceImpl implements ProductService{
	ProductDao productDao = new ProductDaoImpl();
	@Override
	public int countAll() {
		return productDao.countAll();
	}

	@Override
	public void insert(ProductModel product) {
		if (product.getImage() == null)
			product.setImage("NULL");
		productDao.insert(product);
	}

	@Override
	public void edit(ProductModel newProduct) {
		ProductModel oldProduct = productDao.findByID(Integer.toString(newProduct.getId()));
		if (newProduct.getImage() != null)
		{
			String fileName = oldProduct.getImage();
			final String dir = Constant.PRODUCT_DIR;
			File file = new File(dir + fileName);
			if (file.exists()) {
				file.delete();
			}
		}
		else
		{
			newProduct.setImage(oldProduct.getImage());
		}
		oldProduct = newProduct;
		productDao.edit(oldProduct);
	}

	@Override
	public void delete(int id) {
		productDao.delete(id);
	}

	@Override
	public List<ProductModel> findAll() {
		return productDao.findAll();
	}

	@Override
	public ProductModel findByID(String id) {
		return productDao.findByID(id);
	}

	@Override
	public List<ProductModel> findBySellerId(String id) {
		return productDao.findBySellerId(id);
	}

	@Override
	public List<ProductModel> findTop7ProductBySellerId(String id) {
		return productDao.findTop7ProductBySellerId(id);
	}

	@Override
	public int maxId() {
		return productDao.maxId();
	}

	
	
}
