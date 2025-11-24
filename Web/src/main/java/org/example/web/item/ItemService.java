package org.example.web.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/*
    @author   dimag
    @project   Web
    @class  ItemService
    @version  1.0.0
    @since 24.11.2025 - 05.47
*/
@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> findAll() { return itemRepository.findAll(); }
    public Item findById(Long id) { return itemRepository.findById(id).orElse(null); }
    public Item save(Item item) { return itemRepository.save(item); }
    public void deleteById(Long id) { itemRepository.deleteById(id); }
}
