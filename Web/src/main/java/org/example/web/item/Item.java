package org.example.web.item;

import jakarta.persistence.*;
import lombok.*;

/*
    @author   dimag
    @project   Web
    @class  Item
    @version  1.0.0
    @since 24.11.2025 - 05.47
*/
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
}
