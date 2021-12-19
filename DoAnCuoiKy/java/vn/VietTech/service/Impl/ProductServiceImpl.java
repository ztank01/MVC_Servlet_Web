package vn.VietTech.service.Impl;

import java.util.List;

import vn.VietTech.dao.ProductDao;
import vn.VietTech.dao.Impl.ProductDaoImpl;
import vn.VietTech.model.ProductModel;
import vn.VietTech.service.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao= new ProductDaoImpl();
	@Override
	public int countAll() {
		
		return productDao.countAll();
	}
	@Override
	public List<ProductModel> getTop4Product() {
		// TODO Auto-generated method stub
		return productDao.getTop4Product();
	}
	@Override
	public List<ProductModel> getTopProduct() {
		// TODO Auto-generated method stub
		return productDao.getTopProduct();
	}
	@Override
	public List<ProductModel> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}
	@Override
	public List<ProductModel> getAllProductByCateID(String cid) {
		// TODO Auto-generated method stub
		return productDao.getAllProductByCateID(cid);
	}
	@Override
	public ProductModel getAllProductByID(String id) {
		// TODO Auto-generated method stub
		return productDao.getAllProductByID(id);
	}
	@Override
	public List<ProductModel> getTop4BestProduct() {
		// TODO Auto-generated method stub
		return productDao.getTop4BestProduct();
	}
	@Override
	public List<ProductModel> searchByProductName(String txtSearch) {
		// TODO Auto-generated method stub
		return productDao.searchByProductName(txtSearch);
	}
	@Override
	public List<ProductModel> pagingProduct(int index) {
		
		return productDao.pagingProduct(index);
	}
	@Override
	public List<ProductModel> pagingProductByCate(int index, int cid) {
		// TODO Auto-generated method stub
		return productDao.pagingProductByCate(index, cid);
	}
	@Override
	public List<ProductModel> getNext3Product(int iamount) {
		// TODO Auto-generated method stub
		return productDao.getNext3Product(iamount);
	}
	@Override
	public List<ProductModel> getTop3Product() {
		// TODO Auto-generated method stub
		return productDao.getTop3Product();
	}
	@Override
	public int countCID(int cid) {
		// TODO Auto-generated method stub
		return productDao.countCID(cid);
	}
	@Override
	public ProductModel edit(int id, String quantity) {
		// TODO Auto-generated method stub
		return productDao.edit(id, quantity);
	}
	

}

