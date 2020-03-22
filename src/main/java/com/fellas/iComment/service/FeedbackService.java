package com.fellas.iComment.service;

import com.fellas.iComment.model.FeedBack;
import com.fellas.iComment.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public FeedBack findFeedbackById(long id) {
        return feedbackRepository.findById(id).get();
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
