package com.bfs.andyb.controller;

import com.bfs.andyb.domain.User;
import com.bfs.andyb.service.FeedbackService;
import com.bfs.andyb.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
public class FeedbackController {
    private final FeedbackService feedbackService;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/feedback")
    public String getFeedback(HttpServletRequest request, Model model) {
        return "feedback";
    }

    @PostMapping("/feedback")
    public String postFeedback(HttpServletRequest request, Model model) {
        String message = request.getParameter("message");
        Integer rating = Integer.valueOf(request.getParameter("rating"));
        Timestamp submitTime = new Timestamp(System.currentTimeMillis());

        System.out.println("FeedbackController - postFeedback");
        System.out.println("message: " + message);
        System.out.println("rating: " + rating);
        System.out.println("timestamp: " + sdf.format(submitTime));

        feedbackService.createNewFeedback(message, rating, submitTime);

        String[] url = request.getHeader("referer").split("/");
        return url[url.length-1];
    }
}
