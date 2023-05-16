package uz.najottalim.javan6.mapper;

import org.springframework.jdbc.core.RowMapper;
import uz.najottalim.javan6.dao.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setTier(rs.getInt("tier"));
        return customer;
    }
}
