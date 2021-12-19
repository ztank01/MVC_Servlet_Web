package trinhtruong2k1.io.seller.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import trinhtruong2k1.io.seller.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		try {
			CategoryModel category = new CategoryModel();
			category.setCate_id(rs.getInt("CategoryID"));
			category.setCname(rs.getString("CategoryName"));
			category.setIcons(rs.getString("icon"));
			return category;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return null;
		}
	}

}
