package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.dto.BookForm;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.dto.UpdateItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    @GetMapping("/items/new")
    public String createForm(Model model)
    {
          model.addAttribute("form",new BookForm());
          return "items/createItemForm";
    }
    @PostMapping("/items/new")
    public String create(@Valid BookForm form, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "redirect:/items/new";
        }
        Book book = Book.createBook(form);
        itemService.saveItem(book);
        return "redirect:/";
    }
    @GetMapping(value = "/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping(value = "/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model
            model)
    {
        Book item = (Book) itemService.findOne(itemId);
        BookForm form = new BookForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setAuthor(item.getAuthor());
        form.setIsbn(item.getIsbn());
        model.addAttribute("form", form);
        return "items/updateItemForm";
    }
    @PostMapping(value = "/items/{itemId}/edit")
    public String updateItem(@PathVariable("itemId") Long itemId,@ModelAttribute("form") UpdateItemDto updateItemDto)
    {

        itemService.updateItem(updateItemDto);
        return "redirect:/items";
    }
}
