package com.fellas.iComment.service;

import com.fellas.iComment.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CategoryService {

    private final RestTemplate restTemplate;

    public CategoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Category getCategoryById(long id){
        return restTemplate.getForObject("http://localhost:8081/category/" + id, Category.class);
    }

}
