package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.domain.CategoryItem;
import jpabook.jpashop.exception.NotEnounghStockException;
import jpabook.jpashop.service.UpdateItemDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItems=new ArrayList<>();
    //비즈니스 로직

    /**
     * 상품 변경 Dto
     * @param updateItemDto
     */
    public void changeItem(UpdateItemDto updateItemDto)
    {
        setName(updateItemDto.getName());
        setPrice(updateItemDto.getPrice());
        setStockQuantity(updateItemDto.getStockQuantity());
    }
    /**
     *
     * stock 증가
     */


    public void addStock(int quantity)
    {
        this.stockQuantity+=quantity;
    }
    /**
     * stock 감소
     */
    public void removeStock(int quantity)
    {
        int restStock = this.stockQuantity - quantity;
        if (restStock <0)
        {
            throw new NotEnounghStockException("need more stock");
        }
        this.stockQuantity=restStock;
    }

}
