package com.bfs.andyb.controller;

import com.bfs.andyb.domain.*;
import com.bfs.andyb.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class AdminController {
    private final UserService userService;
    private final QuizService quizService;
    private final QuestionService questionService;
    private final FeedbackService feedbackService;
    private final ChoiceService choiceService;
    private String filterCategory;
    private String filterUsername;
    private int updateQuestionId;

    public AdminController(UserService userService, QuizService quizService, QuestionService questionService, FeedbackService feedbackService, ChoiceService choiceService) {
        this.userService = userService;
        this.quizService = quizService;
        this.questionService = questionService;
        this.feedbackService = feedbackService;
        this.choiceService = choiceService;
    }

    @GetMapping("/admin")
    public String getAdminHome(HttpServletRequest request,
                               Model model) {
        HttpSession session = request.getSession(false);

        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        User user = (User) session.getAttribute("user");
        if (user.getIs_admin() == false) {
            return "redirect:/home";
        }


        String categoryPattern = "%";
        String usernamePattern = "%";

        if (filterCategory != "" && filterCategory != null) categoryPattern = filterCategory;
        if (filterUsername != "" && filterUsername != null) usernamePattern = filterUsername;

//        System.out.println("AdminController - getAdminHome");
//        System.out.println(categoryPattern);
//        System.out.println(categoryPattern);

        List<Quiz> filterQuizzes = quizService.getFilteredQuizzes(categoryPattern, usernamePattern);
        model.addAttribute("filteredQuizzes", filterQuizzes);

        return "admin";
    }

    @PostMapping("/admin")
    public String postAdminFilter(Model model, HttpSession session, HttpServletRequest request) {
        filterCategory = request.getParameter("filterCategory");
        filterUsername = request.getParameter("filterUsername");

//        HttpSession oldSession = request.getSession(false);
//        oldSession.setAttribute("filterCategory", filterCategory);
//        oldSession.setAttribute("filterUsername", filterUsername);

        return "redirect:/admin";
    }

    @GetMapping("/user-profile")
    public String getUserProfile(HttpServletRequest request, Model model) {
//        HttpSession session = request.getSession(false);
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);

        return "user-profile";
    }

    @PostMapping("/user-profile")
    public String postUserProfile(Model model, HttpSession session, HttpServletRequest request) {
        String[] split = request.getParameter("activateUser").split(",");
        int action = Integer.valueOf(split[0]);
        int user_id = Integer.valueOf(split[1]);

        System.out.println("AdminController - postUserProfile");
        System.out.println("action: " + (action == 1 ? "active" : "suspend"));
        System.out.println("user_id: " + user_id);

        userService.setIs_activeById(user_id, action);


        return "redirect:/user-profile";
    }

    @GetMapping("/view-feedback")
    public String getViewFeedback(HttpServletRequest request, Model model) {
        List<Feedback> feedbackList = feedbackService.getAllFeedbacks();
        model.addAttribute("feedbackList", feedbackList);

        return "view-feedback";
    }

    @GetMapping("/view-question")
    public String getViewQuestion(HttpServletRequest request, Model model) {
        System.out.println("AdminController - getViewQuestion");
        List<Question> questionList = questionService.getAllQuestions();
        model.addAttribute("questionList", questionList);
        return "view-question";
    }

    @PostMapping("/view-question")
    public String postViewQuestion(Model model, HttpSession session, HttpServletRequest request) {
        System.out.println("AdminController - postViewQuestion");


        if (request.getParameter("question_id") != null) {
            updateQuestionId = Integer.valueOf(request.getParameter("question_id"));
            System.out.println("updateQuestionId" + ", " + updateQuestionId);

            return "redirect:/update-question";
        }

        if (request.getParameter("activateQuestion") != null) {
            String[] split = request.getParameter("activateQuestion").split(",");
            int action = Integer.valueOf(split[0]);
            int question_id = Integer.valueOf(split[1]);

//            System.out.println("action: " + (action == 1 ? "active" : "disable"));
//            System.out.println("question_id: " + question_id);

            questionService.setIs_activeById(question_id, action);
        }


        return "redirect:/view-question";
    }

    @GetMapping("/update-question")
    public String getUpdateQuestion(HttpServletRequest request, Model model) {
        System.out.println("AdminController - getUpdateQuestion");
        System.out.println(updateQuestionId);

        Question question = questionService.getQuestionById(updateQuestionId);
        List<Choice> choiceList = choiceService.getChoicesByQuestionId(updateQuestionId);
        model.addAttribute("question", question);
        model.addAttribute("choiceList", choiceList);



        return "update-question";
    }

    @PostMapping("/update-question")
    public String postUpdateQuestion(Model model, HttpSession session, HttpServletRequest request) {
        System.out.println("AdminController - postUpdateQuestion");

//        Map<String, String[]> parameters = request.getParameterMap();
//        System.out.println(parameters.size());
//        System.out.println("--------------------starting--------------------");
//        for(String parameter : parameters.keySet()) {
//            System.out.println("----------------------------------------");
//            System.out.println(parameter);
//            System.out.println(request.getParameter(parameter));
//            System.out.println("----------------------------------------");
//        }

        questionService.updateQuestion(updateQuestionId, request.getParameter("question_category"), request.getParameter("question_statement"));
        for (int i = 0; i < 4; i++) {
            int choice_id = Integer.valueOf(request.getParameter("choice_id_" + i));
            String choice_statement = request.getParameter("statement_" + i);
            choiceService.updateChoice(choice_id, choice_statement);
        }
        choiceService.setCorrectById(Integer.valueOf(request.getParameter("correct")));
        return "redirect:/view-question";
    }

    @GetMapping("/add-question")
    public String getAddQuestion(HttpServletRequest request, Model model) {
        System.out.println("AdminController - getAddQuestion");
        return "add-question";
    }

    @PostMapping("/add-question")
    public String postAddQuestion(Model model, HttpSession session, HttpServletRequest request) {
        System.out.println("AdminController - postAddQuestion");

        int question_id = questionService.createQuestion(request.getParameter("question_category"), request.getParameter("question_statement"));
//        int question_id = questionService.selectLastInsertedId();
        System.out.println("new_question_id: " + question_id);
        System.out.println("correct_index: " + Integer.valueOf(request.getParameter("correct")));
        for (int i = 0; i < 4; i++) {
            if (i == Integer.valueOf(request.getParameter("correct"))) {
                choiceService.createChoice(question_id, request.getParameter("statement_" + i), true);
            } else {
                choiceService.createChoice(question_id, request.getParameter("statement_" + i), false);
            }
        }

        return "redirect:/view-question";
    }
}
