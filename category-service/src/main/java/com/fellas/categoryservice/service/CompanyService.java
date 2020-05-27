package com.fellas.categoryservice.service;

import com.fellas.categoryservice.exception.CompanyNotFoundException;
import com.fellas.categoryservice.model.Category;
import com.fellas.categoryservice.model.Company;
import com.fellas.categoryservice.repository.CategoryRepository;
import com.fellas.categoryservice.repository.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CategoryRepository categoryRepository;

    public CompanyService(CompanyRepository companyRepository, CategoryRepository categoryRepository) {
        this.companyRepository = companyRepository;
        this.categoryRepository = categoryRepository;
    }

    /** GET queries*/

    public Company findCompanyById(long id) throws CompanyNotFoundException {
        return companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException("Company with id " + id + " not found"));
    }

    public List<Company> getAll() {
        List<Company> list = new ArrayList<>();
        companyRepository.findAll().forEach(list::add);
        return list;
    }

    public List<Company> findCompaniesByCategoryName(String categoryName) throws CompanyNotFoundException {
        Category category = categoryRepository.findCategoryByName(categoryName)
                .orElseThrow(() -> new CompanyNotFoundException("Category with name " + categoryName + " not found"));
        return companyRepository.findCompaniesByCategory(category);
    }

    /** POST, PUT queries*/

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    /** DELETE queries*/

    public ResponseEntity<String> deleteCompanyById(long id) throws CompanyNotFoundException {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException("Company with id " + id + " not found"));
        companyRepository.delete(company);
        return ResponseEntity.status(HttpStatus.OK).body("Company with id " + id +" had been deleted");
    }
}
