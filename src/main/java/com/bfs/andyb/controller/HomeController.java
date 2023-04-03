package com.bfs.andyb.controller;

import com.bfs.andyb.domain.*;
import com.bfs.andyb.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final UserService userService;
    private final QuizService quizService;
    private final QuestionService questionService;
    private final int size = 5;


    public HomeController(UserService userService, QuizService quizService, QuestionService questionService) {
        this.userService = userService;
        this.quizService = quizService;
        this.questionService = questionService;
    }

    @GetMapping("/home")
    public String getHome(HttpServletRequest request, Model model) {
//        HttpSession session = request.getSession(false);
//
////         redirect to /quiz if user is already logged in
//        if (session != null && session.getAttribute("user") != null) {
//            return "redirect:/home";
//        }
//
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);


        User cur_user = (User) request.getSession().getAttribute("user");
        if (cur_user.getIs_admin() == true) {
            return "redirect:/admin";
        }

        String cur_username = cur_user.getUsername();
        List<Quiz> takenQuizzes = quizService.getQuizzesByUsername(cur_username);
        List<String> uniqueCategories = questionService.getDistinctCategories();
        for (String s: uniqueCategories) {
            System.out.println(s);
        }
        model.addAttribute("takenQuizzes", takenQuizzes);
        model.addAttribute("uniqueCategories", uniqueCategories);

        return "home";
    }

}
