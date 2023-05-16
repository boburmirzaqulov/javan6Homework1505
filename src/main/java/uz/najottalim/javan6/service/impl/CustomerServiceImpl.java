package uz.najottalim.javan6.service.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.najottalim.javan6.dao.Customer;
import uz.najottalim.javan6.mapper.CustomerRowMapper;
import uz.najottalim.javan6.service.CustomerService;

import java.util.*;

@Service
@Data
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getAllCustomers(){
        String query = "select * from customer";
        List<Customer> result = jdbcTemplate.query(query, new CustomerRowMapper());
        return result;
    }
}
