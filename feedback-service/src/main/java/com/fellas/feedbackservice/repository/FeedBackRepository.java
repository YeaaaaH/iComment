package com.fellas.feedbackservice.repository;

import com.fellas.feedbackservice.model.FeedBack;
import org.springframework.data.repository.CrudRepository;

public interface FeedBackRepository extends CrudRepository<FeedBack, Long> {

}
