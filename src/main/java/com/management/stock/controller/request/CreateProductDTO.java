package com.management.stock.controller.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductDTO implements Serializable {

    private String description;
    private Integer quantity;

}
