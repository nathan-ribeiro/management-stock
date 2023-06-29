package com.management.stock.amqp.listener;

import com.management.stock.dto.OrderDTO;
import com.management.stock.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = "order.process")
    public void getMessage(OrderDTO order){
        System.out.println("MessageListener - getMessage, body: " + order.toString());

        orderService.processOrder(order);
    }

}
