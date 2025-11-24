package org.example.web.item;

import org.springframework.data.jpa.repository.JpaRepository;
/*
    @author   dimag
    @project   Web
    @class  ItemRepository
    @version  1.0.0
    @since 24.11.2025 - 05.47
*/
public interface ItemRepository extends JpaRepository<Item, Long> {
}
