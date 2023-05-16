package uz.najottalim.javan6.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private Integer id;
    private String category;
    private Double price;
    private String name;
}
