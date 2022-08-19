package com.ecomm.api.backend.service;

import com.ecomm.api.backend.entity.BeforeReactiv.ItemEntity;
import com.ecomm.api.backend.entity.BeforeReactiv.OrderEntity;
import com.ecomm.api.backend.repository.*;
import com.ecommerce.api.model.NewOrder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.function.BiFunction;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
   private PaymentRepository paymentRepository;
   private UserRepository userRepository;
   private CardRepository cardRepository;
   private ItemRepository itemRepository;
    private ShipmentRepository shipmentRepository;
    private BiFunction<OrderEntity, List<ItemEntity>, OrderEntity> biOrderItems = (o,fi) -> o.setItems(fi);

    public OrderServiceImpl (OrderRepository orderRepository, PaymentRepository paymentRepository, UserRepository userRepository, CardRepository cardRepository, ItemRepository itemRepository, ShipmentRepository shipmentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
        this.itemRepository = itemRepository;
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Mono<OrderEntity> addOrder(@Valid  Mono<NewOrder> newOrder) {
        return orderRepository.insert(newOrder);
    }

    @Override
    public Mono<OrderEntity> updateMapping(OrderEntity orderEntity) {
        return orderRepository.updateMapping(orderEntity);
    }

    @Override
    public Flux<OrderEntity> getOrdersByCustomerId(String customerId) {
        return orderRepository.findByCustomerId(customerId)
                .flatMap(order ->
                        Mono.just(order)
                                .zipWith(userRepository.findById(order.getc))
                )
    }

    @Override
    public Mono<OrderEntity> getByOrderId(String id) {
        return null;
    }

    /*
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

     */


}
