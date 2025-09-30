package org.example.webapplication.item;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/*
    @author   dimag
    @project   web-application
    @class  ItemRestController
    @version  1.0.0
    @since 01.10.2025 - 00.34
*/
@RestController
@RequestMapping("/api/items")

public class ItemRestController {
    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable String id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
    }
}
