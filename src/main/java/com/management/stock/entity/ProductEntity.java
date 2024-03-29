package com.management.stock.entity;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@Entity(name = "ProductEntity")
@Table(name = "TB_PRODUCT")
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "QUANTITY")
    private Integer quantity;

}
