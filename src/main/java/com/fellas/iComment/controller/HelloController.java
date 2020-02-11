package com.fellas.iComment.controller;

import com.fellas.iComment.model.FeedBack;
import com.fellas.iComment.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("feedback")
public class HelloController {

    private final FeedbackRepository repository;

    @Autowired
    public HelloController(FeedbackRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{id}")
    public FeedBack getById(@PathVariable("id") FeedBack feedBack) {
        return feedBack;
    }

    @PostMapping
    public FeedBack create(@RequestBody FeedBack feedBack) {
        return repository.save(feedBack);
    }
}
