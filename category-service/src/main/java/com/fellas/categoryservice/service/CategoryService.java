package com.fellas.categoryservice.service;

import com.fellas.categoryservice.model.Category;
import com.fellas.categoryservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findCategoryById(long id) {
        return categoryRepository.findById(id).get();
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
