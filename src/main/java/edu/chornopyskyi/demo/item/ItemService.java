package edu.chornopyskyi.demo.item;/*
    @author andri
    @project IntelliJ IDEA
    @class ItemService
    @version 1.0.0
    @since 13.05.2025 - 15.03
*/

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository repository;

    private List<Item> items;

    @PostConstruct
    void init() {
        items = List.of(
                new Item("1", "name1", "description"),
                new Item("2", "name2", "description2"),
                new Item("3", "name3", "description3")
        );
        repository.saveAll(items);
    }

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Item getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Item create(Item item) {
        return repository.save(item);
    }

    public Item update(Item item) {
        return repository.save(item);
    }
    // Часткове оновлення опису
    public Item updateDescription(String id, String description) {
        return repository.findById(id)
                .map(item -> {
                    item.setDescription(description);
                    return repository.save(item);
                })
                .orElse(null);
    }

    // Підрахунок кількості елементів
    public long count() {
        return repository.count();
    }

    // Видалити всі
    public void deleteAll() {
        repository.deleteAll();
    }

    // Чи існує за ID
    public boolean existsById(String id) {
        return repository.existsById(id);
    }
}
