package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item)
    {
        itemRepository.save(item);
    }

    /**
     * 변경감지 이용ㄴ
     * @param updateItemDto
     */
    @Transactional
    public void updateItem(UpdateItemDto updateItemDto)
    {
        Item findItem = itemRepository.findOne(updateItemDto.getItemId());
        findItem.changeItem(updateItemDto);
    }



    public List<Item> findItems()
    {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId)
    {
        return itemRepository.findOne(itemId);
    }


}
