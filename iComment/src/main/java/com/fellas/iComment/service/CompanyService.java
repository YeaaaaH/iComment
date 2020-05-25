package com.fellas.iComment.service;

import com.fellas.iComment.model.Company;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CompanyService {

    private final RestTemplate restTemplate;

    public CompanyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Company getCompanyById(long id) {
        return restTemplate.getForObject("http://localhost:8081/company/" + id, Company.class);
    }

    public List<Company> getAllCompanies() {
        return restTemplate.getForObject("http://localhost:8081/company/all", List.class);
    }

    public ResponseEntity<Company> createCompany(Company company) {
        HttpEntity<Company> request = new HttpEntity<>(company);
        return restTemplate.postForEntity("http://localhost:8081/company/create", request, Company.class);
    }

    public ResponseEntity<Company> updateCompany(Company company) {
        HttpEntity<Company> request = new HttpEntity<>(company);
        return restTemplate.exchange("http://localhost:8081/company/update", HttpMethod.PUT, request, Company.class);
    }

    public ResponseEntity<String> deleteCompanyById(long id) {
        try {
            restTemplate.delete("http://localhost:8081/company/" + id);
            return ResponseEntity.status(HttpStatus.OK).body("Company with id " + id + " had been deleted");
        } catch (HttpClientErrorException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Response from server: " + exception.getStatusCode().toString());
        }
    }
}
