package uz.najottalim.javan6.service.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.najottalim.javan6.dao.Product;
import uz.najottalim.javan6.mapper.ProductRowMapper;
import uz.najottalim.javan6.service.ProductService;

import java.util.Date;
import java.util.List;

@Data
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Product> getProductsByCategory(String categoryName){
        String query = "select * from product where category=?";
        List<Product> result = jdbcTemplate.query(query, new ProductRowMapper(), categoryName);
        return result;
    }

    public List<Product> getAllProductsOrderByPriceAcs(){
        String query = "select * from product order by price";
        List<Product> result = jdbcTemplate.query(query, new ProductRowMapper());
        return result;
    }

    public List<Product> getProductsByOrderDate( Date orderDate ){
        String query = "" +
                "select p.id,p.category,p.name,p.price from order_product_relationship  rel join\n" +
                "(select id,order_date from product_order where order_date = ?) as orderId\n" +
                "    on rel.order_id = orderId.id\n" +
                "join product p on rel.product_id = p.id;";
        List<Product> result = jdbcTemplate.query(query, new ProductRowMapper(),orderDate);
        return result;
    }

    public Double getSumOfALlOrderPrice(){
        String query ="select sum(p.price) " +
                "from " +
                "product p " +
                "join " +
                "order_product_relationship opr " +
                "on p.id = opr.product_id";
        Double result = jdbcTemplate.queryForObject(query, Double.class);
        return result;
    }

    public Double getAvgPriceByOrderDate(Date orderDate){
        String query = "select avg(p.price)\n" +
                "from order_product_relationship  rel\n" +
                "    join\n" +
                "    (select id,order_date from product_order where order_date = ?) as orderId\n" +
                "        on rel.order_id = orderId.id\n" +
                "    join product p on rel.product_id = p.id;";
        Double result = jdbcTemplate.queryForObject(query, Double.class, orderDate);
        return result;
    }

}