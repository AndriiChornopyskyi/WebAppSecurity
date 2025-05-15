package edu.chornopyskyi.demo.item;/*
    @author andri
    @project IntelliJ IDEA
    @class ItemRestController
    @version 1.0.0
    @since 13.05.2025 - 15.04
*/

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
@AllArgsConstructor
public class ItemRestController {

    private final ItemService service;

    @GetMapping
    public List<Item> getItems() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Item getOneItem(@PathVariable String id) {
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return service.create(item);
    }

    @PutMapping
    public Item update(@RequestBody Item item) {
        return service.update(item);
    }
    
    @GetMapping("/hello/user")
    public String helloUser() {
        return "Hello User!";
    }

    @GetMapping("hello/admin")
    public String helloAdmin() {
        return "Hello Admin!";
    }

    @GetMapping("hello/unknown")
    public String helloUnknown() {
        return "Hello Unknown!";
    }

    // Partially update description by ID
    @PatchMapping("/{id}/description")
    public Item updateDescription(@PathVariable String id, @RequestBody String description) {
        return service.updateDescription(id, description);
    }

    // Count all items
    @GetMapping("/count")
    public long countItems() {
        return service.count();
    }

    // Delete all items
    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }

    // Check if item exists by ID
    @GetMapping("/{id}/exists")
    public boolean exists(@PathVariable String id) {
        return service.existsById(id);
    }
}





}