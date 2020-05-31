package com.fellas.iComment.service;

import com.fellas.iComment.model.FeedBack;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FeedbackService {

    private final RestTemplate restTemplate;

    public FeedbackService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FeedBack getFeedBackById(long id) {
        try {
            return restTemplate.getForObject("http://localhost:8083/feedback/" + id, FeedBack.class);
        } catch (HttpClientErrorException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Response from user-service: " + exception.getStatusCode());
        }
    }

    public List<FeedBack> getAllFeedBacks() {
        return restTemplate.getForObject("http://localhost:8083/feedback/all", List.class);
    }

    public List<FeedBack> getAllFeedbacksByCompanyId(long id) {
        return restTemplate.getForObject("http://localhost:8083/feedback/company/" + id, List.class);
    }

    public ResponseEntity<FeedBack> createFeedback(FeedBack feedBack) {
        HttpEntity<FeedBack> request = new HttpEntity<>(feedBack);
        return restTemplate.postForEntity("http://localhost:8083/feedback/create", request, FeedBack.class);
    }

    public ResponseEntity<FeedBack> updateFeedback(FeedBack feedBack) {
        HttpEntity<FeedBack> request = new HttpEntity<>(feedBack);
        return restTemplate.exchange("http://localhost:8083/feedback/update", HttpMethod.PUT, request, FeedBack.class);
    }

    public ResponseEntity<String> deleteFeedBackById(long id) {
        try {
            restTemplate.delete("http://localhost:8083/feedback/" + id);
            return ResponseEntity.status(HttpStatus.OK).body("Feedback with id " + id + " had been deleted");
        } catch (HttpClientErrorException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Response from server: " + exception.getStatusCode().toString());
        }
    }
}