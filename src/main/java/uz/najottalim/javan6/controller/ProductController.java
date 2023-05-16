package uz.najottalim.javan6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.javan6.dao.Product;
import uz.najottalim.javan6.service.impl.ProductServiceImpl;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/category/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName){
        return productServiceImpl.getProductsByCategory(categoryName);
    }

    @GetMapping("/all")
    public List<Product> getAllProductsOrderByPriceAsc(){
        return productServiceImpl.getAllProductsOrderByPriceAcs();
    }

    @GetMapping("/order-date/{orderDate}")
    public List<Product> getProductsBuOrderDate(@PathVariable("orderDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return productServiceImpl.getProductsByOrderDate(date);
    }
    @GetMapping("/orders/all-sum")
    public double getSumOfAllOrderPrice(){
        return productServiceImpl.getSumOfALlOrderPrice();
    }

    @GetMapping("/order/avg/{date}")
    public double getSumOfAllOrderPrice(@PathVariable("date")@DateTimeFormat(pattern = "yyyy-MM-dd")Date date){
        return productServiceImpl.getAvgPriceByOrderDate(date);
    }
}
