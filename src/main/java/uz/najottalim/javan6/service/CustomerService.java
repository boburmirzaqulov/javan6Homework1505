package uz.najottalim.javan6.service;

import uz.najottalim.javan6.dao.Customer;
import uz.najottalim.javan6.dao.ProductOrder;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    List<ProductOrder> getAllProductOrderById(Integer id);
}
