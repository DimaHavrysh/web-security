package org.example.webapplication.item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/*
    @author   dimag
    @project   web-application
    @class  DataLoader
    @version  1.0.0
    @since 01.10.2025 - 00.58
*/
@Component
public class DataLoader implements CommandLineRunner {

    private final ItemRepository itemRepository;

    public DataLoader(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Очищаємо колекцію (опційно)
        itemRepository.deleteAll();

        // Додаємо стартові дані
        itemRepository.save(new Item("Війна і мир", "Лев Толстой"));
        itemRepository.save(new Item("Майстер і Маргарита", "Михайло Булгаков"));
        itemRepository.save(new Item("1984", "Джордж Орвелл"));

        System.out.println("Стартові дані завантажено!");
    }
}