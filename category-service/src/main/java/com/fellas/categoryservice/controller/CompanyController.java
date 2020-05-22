package com.fellas.categoryservice.controller;

import com.fellas.categoryservice.model.Company;
import com.fellas.categoryservice.service.CompanyService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("all")
    public List<Company> getAllCompanies() {
        return service.getAll();
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
    public String delete(@PathVariable("id") long id) {
        return service.deleteCompanyById(id);
    }
}
