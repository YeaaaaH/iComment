package com.fellas.categoryservice.service;

import com.fellas.categoryservice.exception.CompanyNotFoundException;
import com.fellas.categoryservice.model.Company;
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

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company findCompanyById(long id) throws CompanyNotFoundException {
        return companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Company with id " + id + " not found"));
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public ResponseEntity<String> deleteCompanyById(long id) throws CompanyNotFoundException {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException("Company with id " + id + " not found"));
        companyRepository.delete(company);
        return ResponseEntity.status(HttpStatus.OK).body("Company with id " + id +" had been deleted");
    }

    public List<Company> getAll() {
        List<Company> list = new ArrayList<>();
        companyRepository.findAll().forEach(list::add);
        return list;
    }

}
