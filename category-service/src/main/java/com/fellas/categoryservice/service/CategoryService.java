package com.fellas.categoryservice.service;

import com.fellas.categoryservice.exception.CategoryNotFoundException;
import com.fellas.categoryservice.model.Category;
import com.fellas.categoryservice.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /** GET queries*/

    public Category findCategoryById(long id) throws CategoryNotFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with id " + id + " had not been found"));
    }

    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        categoryRepository.findAll().forEach(list::add);
        return list;
    }

    public Category findCategoryByName(String categoryName) throws CategoryNotFoundException {
        return categoryRepository.findCategoryByName(categoryName)
                .orElseThrow(() -> new CategoryNotFoundException("Category with name " + categoryName + " not found"));
    }

    /** POST, PUT queries*/

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    /** DELETE queries*/

    public ResponseEntity<String> deleteCategoryById(long id) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + id + " had not been found"));
        categoryRepository.delete(category);
        return ResponseEntity.status(HttpStatus.OK).body("Category with id " + id + " had been deleted");
    }
}
