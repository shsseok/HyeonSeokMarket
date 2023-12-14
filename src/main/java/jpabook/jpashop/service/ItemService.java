package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.dto.UpdateItemDto;
import jpabook.jpashop.exception.NoItemException;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
     * 변경감지 이용
     * @param updateItemDto
     */
    @Transactional
    public void updateItem(UpdateItemDto updateItemDto)
    {
        Item findItem = itemRepository.findById(updateItemDto.getItemId())
                .orElseThrow(() -> new NoItemException("해당 하는 상품이 없습니다."));
        findItem.changeItem(updateItemDto);
    }



    public List<Item> findItems()
    {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId)
    {
        return itemRepository.findById(itemId).orElseThrow(() -> new NoItemException("해당 하는 상품이 없습니다."));
    }


}
