package com.fellas.iComment.service;

import com.fellas.iComment.model.Category;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {

    private final RestTemplate restTemplate;

    public CategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Category getCategoryById(long id) {
        try{
            return restTemplate.getForObject("http://localhost:8081/category/" + id, Category.class);
        } catch (HttpClientErrorException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response from category-service: " + exception.getStatusCode());
        }
    }

    public List<Category> getAllCategories() {
        return restTemplate.getForObject("http://localhost:8081/category/all", List.class);
    }

    public Category getCategoryByName(String categoryName) throws ResponseStatusException {
        try {
            return restTemplate.getForObject("http://localhost:8081/category/name/" + categoryName, Category.class);
        } catch (HttpClientErrorException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response from category-service: " + exception.getStatusCode());
        }
    }

    public ResponseEntity<Category> createCategory(Category category) {
        HttpEntity<Category> request = new HttpEntity<>(category);
        return restTemplate.postForEntity("http://localhost:8081/category/create", request, Category.class);
    }

    public ResponseEntity<Category> updateCategory(Category category) {
        HttpEntity<Category> request = new HttpEntity<>(category);
        return restTemplate.exchange("http://localhost:8081/category/update", HttpMethod.PUT, request, Category.class);
    }

    public ResponseEntity<String> deleteCategoryById(long id) {
        try {
            restTemplate.delete("http://localhost:8081/category/" + id);
            return ResponseEntity.status(HttpStatus.OK).body("Category with id " + id + " had been deleted");
        } catch (HttpClientErrorException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Response from category-service: " + exception.getStatusCode().toString());
        }
    }
}
