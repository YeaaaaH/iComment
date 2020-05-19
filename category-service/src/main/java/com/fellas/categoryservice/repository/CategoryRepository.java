package com.fellas.categoryservice.repository;

import com.fellas.categoryservice.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
