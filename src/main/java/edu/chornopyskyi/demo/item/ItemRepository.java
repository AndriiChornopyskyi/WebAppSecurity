package edu.chornopyskyi.demo.item;/*
    @author andri
    @project IntelliJ IDEA
    @class ItemRepository
    @version 1.0.0
    @since 13.05.2025 - 15.02
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
