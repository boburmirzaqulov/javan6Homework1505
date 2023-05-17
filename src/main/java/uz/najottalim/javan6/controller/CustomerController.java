package uz.najottalim.javan6.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.javan6.dao.Customer;
import uz.najottalim.javan6.dao.ProductOrder;
import uz.najottalim.javan6.service.CustomerService;
import uz.najottalim.javan6.service.impl.CustomerServiceImpl;
import java.util.*;
@Data
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}/product-orders")
    public List<ProductOrder> getAllProductOrderById(@PathVariable Integer id){
        return customerService.getAllProductOrderById(id);
    }
}
