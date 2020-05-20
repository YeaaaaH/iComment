package com.fellas.categoryservice.controller;

import com.fellas.categoryservice.model.Company;
import com.fellas.categoryservice.service.CompanyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Company getById(@PathVariable("id") long id) {
        return service.findCompanyById(id);
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return service.getAll();
    }

    @PostMapping
    public Company create(@RequestBody Company company) {
        return service.saveCompany(company);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id) {
        return service.deleteCompanyById(id);
    }
}
