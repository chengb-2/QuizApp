package com.bfs.andyb.service;

import com.bfs.andyb.dao.FeedbackDao;
import com.bfs.andyb.domain.Feedback;
import com.bfs.andyb.domain.Quiz;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackDao feedbackDao;

    public FeedbackService(FeedbackDao feedbackDao) {
        this.feedbackDao = feedbackDao;
    }
    public List<Feedback> getAllFeedbacks() {
        return feedbackDao.getAllFeedbacks();
    }

    public int createNewFeedback(String message, Integer rating, Timestamp timestamp){
        return feedbackDao.createNewFeedback(message, rating, timestamp);
    }

}
