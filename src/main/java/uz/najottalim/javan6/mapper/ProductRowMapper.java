package uz.najottalim.javan6.mapper;

import org.springframework.jdbc.core.RowMapper;
import uz.najottalim.javan6.dao.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        product.setCategory(rs.getString("category"));
        return product;
    }
}
