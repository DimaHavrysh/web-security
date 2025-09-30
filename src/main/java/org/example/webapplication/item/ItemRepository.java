package org.example.webapplication.item;
import org.springframework.data.mongodb.repository.MongoRepository;
/*
    @author   dimag
    @project   web-application
    @class  ItemRepository
    @version  1.0.0
    @since 01.10.2025 - 00.33
*/
public interface ItemRepository extends MongoRepository<Item, String> {
}
