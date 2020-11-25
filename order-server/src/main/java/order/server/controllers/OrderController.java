package order.server.controllers;

import com.netflix.discovery.EurekaClient;
import dto.OrderDto;
import dto.ProductDto;
import lombok.RequiredArgsConstructor;
import order.server.entities.Order;
import order.server.repositories.OrderRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final RestTemplate restTemplate;
    private final OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<OrderDto> getOrders(){
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = orders.stream().map(o->{
            OrderDto oDto = new OrderDto();
            oDto.setCustomer_address(o.getCustomer_address());
            oDto.setCustomer_name(o.getCustomer_name());
            oDto.setCustomer_phone(o.getCustomer_phone());
            List<Long> id = o.getItems().stream().map(oi->oi.getProductId()).collect(Collectors.toList());
            List<ProductDto> productDtos = restTemplate.getForObject("http://product/list_products",List.class, id);
            return oDto;

        }).collect(Collectors.toList());

        return orderDtos;
    }

    @GetMapping("/product")
    public List<ProductDto> getProduct(){


        //"http://product/list_products",
        Long[] listId = {1l,2l};
        Map<String, String> params = new HashMap<>();
        params.put("listId", "1,2");
        List<ProductDto> productDtos = restTemplate.getForObject("http://product/list_products", List.class, params);
        return productDtos;

    }

    @GetMapping("/say_hello")
    public String sayHello(){
        return restTemplate.getForObject("http://product/say_hello",String.class);
    }
}
