package com.fellas.iComment.controller;

import com.fellas.iComment.model.FeedBack;
import com.fellas.iComment.service.FeedbackService;
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
@RequestMapping("api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("{id}")
    public FeedBack getFeedbackById(@PathVariable("id") long id) {
        return feedbackService.getFeedBackById(id);
    }

    @GetMapping("all")
    public List<FeedBack> getAllFeedbacks() {
        return feedbackService.getAllFeedBacks();
    }

    @GetMapping("company/{id}")
    public List<FeedBack> getFeedBacksByCompanyId(@PathVariable("id") long id) {
        return feedbackService.getAllFeedbacksByCompanyId(id);
    }

    @PostMapping("create")
    public ResponseEntity<FeedBack> createFeedback(@RequestBody FeedBack feedBack) {
        return feedbackService.createFeedback(feedBack);
    }

    @PutMapping("update")
    public ResponseEntity<FeedBack> updateFeedback(@RequestBody FeedBack feedBack) {
        return feedbackService.updateFeedback(feedBack);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFeedBack(@PathVariable long id) {
        return feedbackService.deleteFeedBackById(id);
    }
}
