package product.server.controllers;

import dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import product.server.services.ProductService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list_products")
    public List<ProductDto> getList(@RequestParam Long... listId){
        return productService.getProductsInId(Arrays.asList(listId));
    }

    @GetMapping("/say_hello")
    public String sayHello(){
        return "hello!";
    }

}
