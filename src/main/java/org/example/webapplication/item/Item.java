package org.example.webapplication.item;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/*
    @author   dimag
    @project   web-application
    @class  item
    @version  1.0.0
    @since 01.10.2025 - 00.33
*/
@Document(collection = "items")
public class Item {
    @Id
    private String id;
    @Setter
    private String title;
    @Setter
    private String author;

    public Item() {}

    public Item(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}
