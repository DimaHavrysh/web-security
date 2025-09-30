package org.example.webapplication.item;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    @author   dimag
    @project   web-application
    @class  ItemService
    @version  1.0.0
    @since 01.10.2025 - 00.33
*/
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }
}
