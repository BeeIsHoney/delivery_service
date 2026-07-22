package com.example.demo.category;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    // Create
    @PostMapping
    public CatEntity saveCategory(@RequestBody CatEntity category) {
        return catService.saveCategory(category);
    }

    // Read all
    @GetMapping
    public List<CatEntity> getAllCategories() {
        return catService.getAllCategories();
    }

    // Read by ID
    @GetMapping("/{id}")
    public CatEntity getCategoryById(@PathVariable Long id) {
        return catService.getCategoryById(id);
    }

    // Update
    @PutMapping("/{id}")
    public CatEntity updateCategory(@PathVariable Long id,
                                    @RequestBody CatEntity category) {
        return catService.updateCategory(id, category);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        catService.deleteCategory(id);
        return "Category deleted successfully.";
    }
}