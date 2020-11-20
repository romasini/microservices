package order.server.services;

import lombok.AllArgsConstructor;
import order.server.entities.Order;
import order.server.entities.OrderItem;
import order.server.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public List<Order> findAll(Integer numPage, int sizePage){

        return orderRepository.findAll();
    }

    public Order save(Order order){
        for (OrderItem oi: order.getItems()){
            oi.setOrder(order);
        }

        return orderRepository.save(order);

    }

}
