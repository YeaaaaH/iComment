package com.fellas.categoryservice.controller;

import com.fellas.categoryservice.model.Category;
import com.fellas.categoryservice.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable("id") long id) {
        return service.findCategoryById(id);
    }

    @GetMapping
    public List<Category> getAllFeedbacks() {
        return service.getAll();
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.saveCategory(category);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id) {
        return service.deleteCategoryById(id);
    }
}
