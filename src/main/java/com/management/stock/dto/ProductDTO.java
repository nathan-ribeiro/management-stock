package com.management.stock.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO implements Serializable {

    private Long id;
    private String description;
    private Integer quantity;

}
