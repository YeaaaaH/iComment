package com.fellas.iComment.service;

import com.fellas.iComment.ApiGateAwayApplication;
import com.fellas.iComment.model.Category;
import com.fellas.iComment.model.Company;
import com.fellas.iComment.model.FeedBack;
import com.fellas.iComment.model.Role;
import com.fellas.iComment.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.of;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiGateAwayApplication.class)
@Transactional
public class FeedbackServiceTest {

    @Autowired
    private FeedbackService feedbackService;

    @Test
    public void getAllFeedbacksTest() {
        assertThat(feedbackService.getAllFeedBacks(), notNullValue());
        assertThat(feedbackService.getAllFeedBacks().size(), is(1));
        assertThat(feedbackService.getAllFeedBacks().get(0), isA(FeedBack.class));
    }

    @Test
    public void findFeedBackByIdTest() {
        assertThat(feedbackService.getFeedBackById(0L), notNullValue());
        assertThat(feedbackService.getFeedBackById(0L), isA(FeedBack.class));
        assertThat(feedbackService.getFeedBackById(0L).getRate(), is(4));
        assertThat(feedbackService.getFeedBackById(0L).getNegative(), is("NEGATIVE"));
        assertThat(feedbackService.getFeedBackById(0L).getPositive(), is("POSITIVE"));
    }

    private void init() {
        Category category = new Category();
        category.setName("FMCG");
        category.setDescription("fast moving consumer goods");

        Company company = new Company();
        company.setAverageRate(4.4);
        company.setName("Davo");
        company.setCategory(category);
        company.setDescription("top rated in FMCG category");

        Role role = new Role();
        role.setName("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        User user = new User();
        user.setEmail("email@gmail.com");
        user.setLogin("test");
        user.setPassword("test");
        user.setName("someName");
        user.setSurName("someSurname");
        user.setRoles(roles);

        FeedBack feedBack = new FeedBack();
        feedBack.setCompany_id(0);
        feedBack.setDate(of(2020, 3, 22));
        feedBack.setNegative("NEGATIVE");
        feedBack.setPositive("POSITIVE");
        feedBack.setRate(4);
        feedBack.setUser_id(0);
    }
}
