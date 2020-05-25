package com.fellas.feedbackservice.controller;

import com.fellas.feedbackservice.exception.FeedbackNotFoundException;
import com.fellas.feedbackservice.model.FeedBack;
import com.fellas.feedbackservice.service.FeedBackService;
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
@RequestMapping("feedback")
public class FeedBackController {
    private final FeedBackService service;

    public FeedBackController(FeedBackService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public FeedBack getById(@PathVariable("id") long id) throws FeedbackNotFoundException {
        return service.findFeedbackById(id);
    }

    @GetMapping("all")
    public List<FeedBack> getAllFeedBacks() {
        return service.getAll();
    }

    @PostMapping("create")
    public FeedBack create(@RequestBody FeedBack feedBack) {
        return service.saveFeedback(feedBack);
    }

    @PutMapping("update")
    public FeedBack update(@RequestBody FeedBack feedBack) {
        return service.saveFeedback(feedBack);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) throws FeedbackNotFoundException {
        return service.deleteFeedBackById(id);
    }
}
