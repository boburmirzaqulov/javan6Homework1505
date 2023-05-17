package uz.najottalim.javan6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.javan6.dao.ProductOrder;
import uz.najottalim.javan6.service.ProductOrderService;

import java.util.List;

@RestController
@RequestMapping("/product-order")
public class ProductOrderController {
    @Autowired
    ProductOrderService productOrderService;

    @GetMapping("/status/{statusName}")
    public List<ProductOrder> getProductOrderByStatus(@PathVariable String statusName){
        return productOrderService.getProductOrderByStatus(statusName);
    }

    @GetMapping("/orders/day/{n}")
    public List<ProductOrder> getOrdersLastNDay(@PathVariable Integer n){
        return productOrderService.getOrdersLastNDay(n);
    }
}
