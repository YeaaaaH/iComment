package com.fellas.iComment.controller;

import com.fellas.iComment.model.FeedBack;
import com.fellas.iComment.service.FeedbackService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("{id}")
    public FeedBack getCompanyById(@PathVariable("id") long id) {
        return feedbackService.getFeedBackById(id);
    }

    @GetMapping("all")
    public List<FeedBack> getCompanyById() {
        return feedbackService.getAllFeedBacks();
    }
}
