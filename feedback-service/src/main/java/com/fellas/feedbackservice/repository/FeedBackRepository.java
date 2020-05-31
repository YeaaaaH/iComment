package com.fellas.feedbackservice.repository;

import com.fellas.feedbackservice.model.FeedBack;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedBackRepository extends CrudRepository<FeedBack, Long> {
    @Query(value = "SELECT f from FeedBack f WHERE f.company_id = :id")
    List<FeedBack> findAllByCompanyId(long id);
}
