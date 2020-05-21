package com.fellas.iComment.service;

import com.fellas.iComment.model.Category;
import com.fellas.iComment.model.Company;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompanyService {

    private final RestTemplate restTemplate;

    public CompanyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Company getCompanyById(long id){
        return restTemplate.getForObject("http://localhost:8081/company/" + id, Company.class);
    }

}
