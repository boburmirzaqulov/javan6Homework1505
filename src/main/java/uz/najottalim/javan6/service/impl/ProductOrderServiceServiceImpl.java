package uz.najottalim.javan6.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.najottalim.javan6.dao.ProductOrder;
import uz.najottalim.javan6.mapper.ProductOrderRowMapper;
import uz.najottalim.javan6.service.ProductOrderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOrderServiceServiceImpl implements ProductOrderService {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductOrder> getProductOrderByStatus(String statusName) {
        return jdbcTemplate.query("select * from product_order where status = ?", new ProductOrderRowMapper(), statusName.toUpperCase());
    }
}
