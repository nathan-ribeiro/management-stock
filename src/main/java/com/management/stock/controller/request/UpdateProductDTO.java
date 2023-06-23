package com.management.stock.controller.request;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateProductDTO implements Serializable {

    private Long id;
    private String description;
    private Integer quantity;

}
