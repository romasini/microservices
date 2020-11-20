package product.server.services;

import dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import product.server.entities.Product;
import product.server.repositories.ProductRepository;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDto> getProductsInId(List<Long> id){
        List<Product> listP = productRepository.findAllByIdIn(id);
        return listP.stream().map(p->{
            ProductDto pDto = new ProductDto();
            pDto.setId(p.getId());
            pDto.setPrice(p.getPrice());
            pDto.setTitle(p.getTitle());
            return pDto;
        }).collect(Collectors.toList());
    }
}
