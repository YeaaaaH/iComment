package com.fellas.iComment.service;

import com.fellas.iComment.model.Company;
import com.fellas.iComment.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> findCompanyById(long id) {
        return companyRepository.findById(id);
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public String deleteCompanyById(long id) {
        companyRepository.deleteById(id);
        return "Company with id: " + id + "was deleted";
    }

    public List<Company> getAll() {
        List<Company> list = new ArrayList<>();
        companyRepository.findAll().forEach(list::add);
        return list;
    }

}
