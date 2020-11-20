package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String customer_name;
    private String customer_phone;
    private String customer_address;
    private Integer price;
    private List<OrderItemDto> items;
}
