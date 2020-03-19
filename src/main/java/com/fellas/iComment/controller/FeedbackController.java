package com.fellas.iComment.controller;

import java.util.List;

import com.fellas.iComment.model.FeedBack;
import com.fellas.iComment.service.FeedbackService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public FeedBack getById(@PathVariable("id") long id) {
        return service.findFeedbackById(id).get();
    }

    @GetMapping
    public List<FeedBack> getAllFeedbacks() {
        return service.getAll();
    }

    @PostMapping
    public FeedBack create(@RequestBody FeedBack feedBack) {
        return service.saveFeedback(feedBack);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id) {
        return service.deleteFeedbackById(id);
    }
}
