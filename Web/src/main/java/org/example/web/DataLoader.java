package org.example.web;
import lombok.RequiredArgsConstructor;
import org.example.web.item.Item;
import org.example.web.item.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/*
    @author   dimag
    @project   Web
    @class  DataLoader
    @version  1.0.0
    @since 24.11.2025 - 05.47
*/
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final ItemRepository itemRepository;

    @Override
    public void run(String... args) {
        itemRepository.deleteAll();

        itemRepository.save(new Item(null, "Війна і мир", "Лев Толстой"));
        itemRepository.save(new Item(null, "Майстер і Маргарита", "Михайло Булгаков"));
        itemRepository.save(new Item(null, "1984", "Джордж Орвелл"));

        System.out.println("Стартові дані завантажено!");
    }
}
