package com.fellas.categoryservice.controller;

import com.fellas.categoryservice.exception.CompanyNotFoundException;
import com.fellas.categoryservice.model.Company;
import com.fellas.categoryservice.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {
    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public Company getById(@PathVariable("id") long id) throws CompanyNotFoundException {
        return service.findCompanyById(id);
    }

    @GetMapping("all")
    public List<Company> getAllCompanies() {
        return service.getAll();
    }

    @GetMapping("category/{categoryName}")
    public List<Company> getCompaniesByCategoryName(@PathVariable("categoryName") String categoryName) throws CompanyNotFoundException {
        return service.findCompaniesByCategoryName(categoryName);
    }

    @PostMapping("create")
    public Company create(@RequestBody Company company) {
        return service.saveCompany(company);
    }

    @PutMapping("update")
    public Company update(@RequestBody Company company) {
        return service.saveCompany(company);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) throws CompanyNotFoundException {
        return service.deleteCompanyById(id);
    }
}
