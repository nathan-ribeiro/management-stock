package com.management.stock.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderDTO implements Serializable {

    private String id;
    private String email;
    private String name;
    private List<ProductDTO> products;

}
