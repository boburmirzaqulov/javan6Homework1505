package uz.najottalim.javan6.service;

import uz.najottalim.javan6.dao.ProductOrder;

import java.util.List;

public interface ProductOrderService {

    List<ProductOrder> getProductOrderByStatus(String statusName);
}
