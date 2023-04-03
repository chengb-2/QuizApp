package com.bfs.andyb.controller;

import com.bfs.andyb.domain.Choice;
import com.bfs.andyb.domain.Question;
import com.bfs.andyb.domain.QuizQuestion;
import com.bfs.andyb.domain.User;
import com.bfs.andyb.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class QuizResultController {

    private QuestionService questionService;
    private UserService userService;
    private QuizService quizService;
    private ChoiceService choiceService;
    private QuizQuestionService quizQuestionService;

    public QuizResultController(QuestionService questionService, UserService userService, QuizService quizService, ChoiceService choiceService, QuizQuestionService quizQuestionService) {
        this.questionService = questionService;
        this.userService = userService;
        this.quizService = quizService;
        this.choiceService = choiceService;
        this.quizQuestionService = quizQuestionService;
    }

    @GetMapping("/quiz-result")
    public String getQuizResult(Model model, HttpSession session, HttpServletRequest request) {
        // get question list and choice list by quiz id
        // get user choice ids

//        Map<String, String[]> parameters = request.getParameterMap();
//        System.out.println(parameters.size());
//        for(String parameter : parameters.keySet()) {
//            System.out.println(parameter);
//            System.out.println(request.getParameter(parameter));
//        }

        Integer quiz_id = Integer.valueOf(request.getParameter("quizRecord"));
        List<QuizQuestion> quizQuestionList = quizQuestionService.getQuizQuestionsByQuizId(quiz_id);
//        System.out.println("QuizResultController - quizQuestionList.toString()");
//        System.out.println(quizQuestionList.toString());
//        System.out.println(quizQuestionList.size());

        List<Question> questionList = new ArrayList<>();
        List<List<Choice>> choiceList = new ArrayList<>();
        List<String> selectedChoiceStatements = new ArrayList<>();
        List<Boolean> results = new ArrayList<>();

        for (QuizQuestion qq: quizQuestionList) {
            Question question = questionService.getQuestionById(qq.getQuestion_id());
            questionList.add(question);

            List<Choice> cur = choiceService.getChoicesByQuestionId(qq.getQuestion_id());
            choiceList.add(cur);

            Integer userSelectedChoiceId = qq.getUser_choice_id();
            if (userSelectedChoiceId == -1) {
                selectedChoiceStatements.add("Empty choice");
                results.add(false);
            } else {
                Choice userSelectedChoice = choiceService.getChoiceById(userSelectedChoiceId);
                selectedChoiceStatements.add(userSelectedChoice.getStatement());
                Boolean result = choiceService.checkAnswer(userSelectedChoice);
                results.add(result);

//                System.out.println("selectedChoiceDescription: " + selectedChoiceStatements.get(selectedChoiceStatements.size()-1));
//                System.out.println("correct: " + results.get(results.size()-1));
            }
        }

        Optional<User> p_user = userService.getUserByUsername(quizService.getQuizById(quiz_id).getUsername());
        if (p_user.isPresent()) {
            model.addAttribute("user", p_user.get());
        } else {
            System.out.println("QuizResultController - getQuizResult");
            System.out.println("Error: user not found!");
        }


        model.addAttribute("questionList", questionList);
        model.addAttribute("choiceList", choiceList);
        model.addAttribute("selectedChoiceStatements", selectedChoiceStatements);
        model.addAttribute("results", results);
        model.addAttribute("score", quizService.getScoreById(quiz_id));
        model.addAttribute("quiz", quizService.getQuizById(quiz_id));

        return "quiz-result";
    }
}
