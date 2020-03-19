package com.fellas.iComment.service;

import com.fellas.iComment.model.FeedBack;
import com.fellas.iComment.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Optional<FeedBack> findFeedbackById(long id) {
        return feedbackRepository.findById(id);
    }

    public FeedBack saveFeedback(FeedBack feedBack) {
        return feedbackRepository.save(feedBack);
    }

    public String deleteFeedbackById(long id) {
        feedbackRepository.deleteById(id);
        return "Feedback with id: " + id + "was deleted";
    }

    public List<FeedBack> getAll() {
        List<FeedBack> list = new ArrayList<>();
        feedbackRepository.findAll().forEach(list::add);
        return list;
    }
}
