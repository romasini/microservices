package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemDto {

    private Long id;
    private Long productId;
    private String title;
    private Integer quantity;
    private Integer price;

}
