package uz.najottalim.javan6.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.najottalim.javan6.dao.ProductOrder;
import uz.najottalim.javan6.mapper.ProductOrderRowMapper;
import uz.najottalim.javan6.service.ProductOrderService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOrderServiceServiceImpl implements ProductOrderService {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductOrder> getProductOrderByStatus(String statusName) {
        LocalDate ad = LocalDate.of(2021,3,30);

        return jdbcTemplate.query(
                "select * from product_order where order_date = ?",
                new ProductOrderRowMapper(),
                ad
        );
    }

    @Override
    public List<ProductOrder> getOrdersLastNDay(Integer n) {
        Date maxDate = jdbcTemplate.queryForObject(
                "select max(order_date) from product_order",
                Date.class
        );
        return jdbcTemplate.query(
                "select * from product_order " +
                        "where order_date between ? - ? " +
                        "and ? " +
                        "order by order_date desc",
                new ProductOrderRowMapper(),
                maxDate, n, maxDate
        );
    }
}
