package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.OrderEntity;
import com.ecomm.api.backend.exceptions.ResourceNotFoundException;
import com.ecomm.api.backend.repository.OrderRepository;
import com.ecommerce.api.model.NewOrder;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public Iterable<OrderEntity> getOrdersByCustomerID(String customerID) {
        return orderRepository.findByCustomerId(UUID.fromString(customerID));
    }

    @Override
    public Optional<OrderEntity> addOrder( @Valid  NewOrder newOrder) {
        if (Strings.isEmpty(newOrder.getCustomerId())) {
            throw new ResourceNotFoundException("Customer ID not found");
        }
        // check  for  valid address
        if(Objects.isNull(newOrder.getAddress()) || Strings.isEmpty(newOrder.getAddress().getId())){
            throw new ResourceNotFoundException("Address ID not found");
        }

        //check for valid  cardDetails
        if(Objects.isNull(newOrder.getCard()) || Strings.isEmpty(newOrder.getCard().getId())){
            throw new ResourceNotFoundException("Invalid card Id ");
        }

        return orderRepository.insert(newOrder) ; // create triggers to verify the  order  and update the inventory


    }

    @Override
    public Optional<OrderEntity> getOrderById(String orderID) {
        return orderRepository.findById(UUID.fromString(orderID));
    }


}
