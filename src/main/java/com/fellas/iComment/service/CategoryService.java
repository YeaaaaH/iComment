package com.fellas.iComment.service;

import com.fellas.iComment.model.Category;
import com.fellas.iComment.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<Category> findCategoryById(long id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public String deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
        return "Category with id: " + id + "was deleted";
    }

    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        categoryRepository.findAll().forEach(list::add);
        return list;
    }
}
