package uz.najottalim.javan6.service;

import uz.najottalim.javan6.dao.Product;

import java.util.Date;
import java.util.List;

public interface ProductService {
    List<Product> getProductsByCategory(String categoryName);
    List<Product> getAllProductsOrderByPriceAcs();
    List<Product> getProductsByOrderDate( Date orderDate);
    Double getSumOfALlOrderPrice();
    Double getAvgPriceByOrderDate(Date orderDate);
}
