package com.fellas.iComment.repository;

import com.fellas.iComment.model.FeedBack;
import org.springframework.data.repository.CrudRepository;


public interface FeedbackRepository extends CrudRepository<FeedBack, Long> {

}
