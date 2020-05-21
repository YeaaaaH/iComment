package com.fellas.iComment.service;

import com.fellas.iComment.model.FeedBack;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FeedbackService {
    private final RestTemplate restTemplate;

    public FeedbackService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FeedBack getFeedBackById(long id) {
        return restTemplate.getForObject("http://localhost:8083/feedback/" + id, FeedBack.class);
    }

    public List<FeedBack> getAllFeedBacks() {
        return restTemplate.getForObject("http://localhost:8083/feedback/all", List.class);
    }
}