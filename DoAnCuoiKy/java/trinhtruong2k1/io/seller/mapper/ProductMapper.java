package trinhtruong2k1.io.seller.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import trinhtruong2k1.io.seller.model.ProductModel;

public class ProductMapper implements RowMapper<ProductModel> {

	@Override
	public ProductModel mapRow(ResultSet rs) {
		try {
			ProductModel product = new ProductModel();
			product.setId(rs.getInt("ProductId"));
			product.setName(rs.getString("ProductName"));
			product.setDescription(rs.getString("Description"));
			product.setPrice(rs.getInt("Price"));
			product.setImage(rs.getString("ImageLink"));
			product.setCategoryID(rs.getInt("CategoryId"));
			product.setSellerID(rs.getInt("SellerID"));
			product.setAmount(rs.getInt("Amount"));
			product.setStock(rs.getInt("InStock"));
			return product;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
