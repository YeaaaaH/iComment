package com.fellas.iComment.controller;

import com.fellas.iComment.model.Category;
import com.fellas.iComment.service.CategoryService;
import org.springframework.http.ResponseEntity;
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

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{id}")
    public Category getCategoryById(@PathVariable("id") long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("all")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }
}
