package com.management.stock.service;

import com.management.stock.controller.request.UpdateProductDTO;
import com.management.stock.dto.MessageDTO;
import com.management.stock.dto.OrderDTO;
import com.management.stock.dto.ProductDTO;
import com.management.stock.exception.QuantityException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final String PROCESSED_ORDER = "Order precessed successfully";
    private final String QUANTITY_ERROR = "The quantity of product ?1 exceeds the quantity in stock";

    public void processOrder(OrderDTO orderDTO){

        try {
            for (ProductDTO productDTO : orderDTO.getProductList()) {
                var productFound = productService.findProduct(productDTO.getId());

                var finalQuantity = productFound.getQuantity() - productDTO.getQuantity();

                if (finalQuantity < 0)
                    throw new QuantityException(QUANTITY_ERROR.replace("?1", productDTO.getDescription()));

                productFound.setQuantity(finalQuantity);
                productService.updateProduct(UpdateProductDTO.builder()
                        .id(productFound.getId())
                        .description(productFound.getDescription())
                        .quantity(productFound.getQuantity())
                        .build());

            }

            rabbitTemplate.convertAndSend("message.communication", MessageDTO.builder()
                    .email(orderDTO.getEmail())
                    .name(orderDTO.getName())
                    .orderID(orderDTO.getOrderID())
                    .status(PROCESSED_ORDER)
                    .build());


        } catch (QuantityException e) {
            rabbitTemplate.convertAndSend("message.communication", MessageDTO.builder()
                    .email(orderDTO.getEmail())
                    .name(orderDTO.getName())
                    .orderID(orderDTO.getOrderID())
                    .status(e.getMessage())
                    .build());
        }

    }
}
