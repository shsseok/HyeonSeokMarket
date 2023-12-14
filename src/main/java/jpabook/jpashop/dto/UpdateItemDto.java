package jpabook.jpashop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateItemDto {
    private Long itemId;
    private String name;
    private int price;
    private int stockQuantity;
}
