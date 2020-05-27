package com.fellas.categoryservice.repository;

import com.fellas.categoryservice.model.Category;
import com.fellas.categoryservice.model.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    List<Company> findCompaniesByCategory(Category category);
}
