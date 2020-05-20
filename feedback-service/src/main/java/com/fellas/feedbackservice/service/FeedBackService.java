package com.fellas.feedbackservice.service;

import com.fellas.feedbackservice.model.FeedBack;
import com.fellas.feedbackservice.repository.FeedBackRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FeedBackService {

    private final FeedBackRepository feedbackRepository;

    public FeedBackService(FeedBackRepository feedbackRepository) {
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
