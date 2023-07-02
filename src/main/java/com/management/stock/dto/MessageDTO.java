package com.management.stock.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MessageDTO implements Serializable {

    private String email;
    private String name;
    private String orderID;
    private String status;

}
