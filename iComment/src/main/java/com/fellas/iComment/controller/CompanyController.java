package com.fellas.iComment.controller;

import com.fellas.iComment.model.Company;
import com.fellas.iComment.service.CompanyService;
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
@RequestMapping("api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("{id}")
    public Company getCompanyById(@PathVariable("id") long id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping("all")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping("create")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @PutMapping("update")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        return companyService.updateCompany(company);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable long id) {
        return companyService.deleteCompanyById(id);
    }
}
