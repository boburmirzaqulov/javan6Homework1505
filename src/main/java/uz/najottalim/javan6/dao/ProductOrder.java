package uz.najottalim.javan6.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductOrder {
    private int id;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status;
    private int customerId;
}
