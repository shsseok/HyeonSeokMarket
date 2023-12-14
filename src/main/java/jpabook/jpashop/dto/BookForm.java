package jpabook.jpashop.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BookForm {
    private Long id;
    @NotEmpty(message = "책 이름을 입력하세요")
    private String name;
    @NotNull(message = "가격을 입력하세요.")
    @Min(value = 1000, message = "가격은 1000 이상이어야 합니다.")
    @Max(value = 1000000, message = "가격은 1000000 이하여야 합니다.")
    private Integer price;
    @NotNull(message = "재고가 몇 개 인지 입력하세요")
    private Integer stockQuantity;
    private String author;
    private String isbn;
}
