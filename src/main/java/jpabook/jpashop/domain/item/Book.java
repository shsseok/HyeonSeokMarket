package jpabook.jpashop.domain.item;

import jpabook.jpashop.dto.BookForm;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends Item {
    public static Book createBook(BookForm form)
    {
        Book book=new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setIsbn(form.getIsbn());
        book.setAuthor(form.getAuthor());
        return book;
    }
    public static Book updateBook(BookForm form)
    {
        Book book=new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setIsbn(form.getIsbn());
        book.setAuthor(form.getAuthor());
        return book;
    }





    private String author;
    private String isbn;
}
