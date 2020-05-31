package com.fellas.feedbackservice.service;

import com.fellas.feedbackservice.exception.FeedbackNotFoundException;
import com.fellas.feedbackservice.model.FeedBack;
import com.fellas.feedbackservice.repository.FeedBackRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * GET queries
     */

    public FeedBack findFeedbackById(long id) throws FeedbackNotFoundException {
        return feedbackRepository.findById(id).orElseThrow(() -> new FeedbackNotFoundException("Feedback with id " + id + " had not been found"));
    }

    public List<FeedBack> getAll() {
        List<FeedBack> list = new ArrayList<>();
        feedbackRepository.findAll().forEach(list::add);
        return list;
    }

    public List<FeedBack> getAllByCompanyId(long id) {
        List<FeedBack> list = feedbackRepository.findAllByCompanyId(id);
        return list;
    }

    /**
     * POST, PUT queries
     */

    public FeedBack saveFeedback(FeedBack feedBack) {
        return feedbackRepository.save(feedBack);
    }

    /**
     * DELETE queries
     */

    public ResponseEntity<String> deleteFeedBackById(long id) throws FeedbackNotFoundException {
        FeedBack company = feedbackRepository.findById(id)
                .orElseThrow(() -> new FeedbackNotFoundException("Feedback with id " + id + " had not been found"));
        feedbackRepository.delete(company);
        return ResponseEntity.status(HttpStatus.OK).body("Feedback with id " + id + " had been deleted");
    }
}
