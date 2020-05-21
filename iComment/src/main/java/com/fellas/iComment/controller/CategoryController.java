package com.fellas.iComment.controller;

import com.fellas.iComment.model.Category;
import com.fellas.iComment.service.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
}
