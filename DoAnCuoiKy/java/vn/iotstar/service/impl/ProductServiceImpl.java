package vn.iotstar.service.impl;

import java.util.List;

import vn.iotstar.dao.ProductDao;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.model.ProductModel;
import vn.iotstar.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	ProductDao productDao = new ProductDaoImpl();
	
	@Override
	public List<ProductModel> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}

	@Override
	public ProductModel get(int productId) {
		// TODO Auto-generated method stub
		return productDao.get(productId);
	}

	@Override
	public void edit(ProductModel product) {
		// TODO Auto-generated method stub
		productDao.edit(product);
	}

	@Override
	public void insert(ProductModel product) {
		// TODO Auto-generated method stub
		productDao.insert(product);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productDao.delete(id);
	}
}
