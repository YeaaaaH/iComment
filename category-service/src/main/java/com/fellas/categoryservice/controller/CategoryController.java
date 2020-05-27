package com.fellas.categoryservice.controller;

import com.fellas.categoryservice.exception.CategoryNotFoundException;
import com.fellas.categoryservice.model.Category;
import com.fellas.categoryservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable("id") long id) throws CategoryNotFoundException {
        return service.findCategoryById(id);
    }

    @GetMapping("all")
    public List<Category> getAllCategories() {
        return service.getAll();
    }

    @GetMapping("name/{categoryName}")
    public Category getCompaniesByCategoryName(@PathVariable("categoryName") String categoryName) throws CategoryNotFoundException {
        return service.findCategoryByName(categoryName);
    }

    @PostMapping("create")
    public Category create(@RequestBody Category category) {
        return service.saveCategory(category);
    }

    @PutMapping("update")
    public Category update(@RequestBody Category category) {
        return service.saveCategory(category);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) throws CategoryNotFoundException {
        return service.deleteCategoryById(id);
    }
}
