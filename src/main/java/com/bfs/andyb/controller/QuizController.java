package com.bfs.andyb.controller;

import com.bfs.andyb.domain.*;
import com.bfs.andyb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.swing.BakedArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.*;

@Controller
public class QuizController {

    private QuestionService questionService;
    private QuizService quizService;
    private ChoiceService choiceService;
    private QuizQuestionService quizQuestionService;
    private List<Question> tempQuestionList;
    private List<List<Choice>> tempChoiceList;
    private static final int quiz_timer_in_sec = 15;
    private Quiz tempQuiz;

    public QuizController(QuestionService questionService, QuizService quizService, ChoiceService choiceService, QuizQuestionService quizQuestionService) {
        this.questionService = questionService;
        this.quizService = quizService;
        this.choiceService = choiceService;
        this.quizQuestionService = quizQuestionService;
    }



    @PostMapping("/home")
    public String postHome(Model model,
                          HttpServletRequest request) {

        String quizCategory = request.getParameter("quizCategory").toString().toLowerCase();

        System.out.println("-------------QuizController: postHome-------------");
        User cur_user = (User) request.getSession().getAttribute("user");
        String cur_username = cur_user.getUsername();

        tempQuiz = quizService.createTempQuiz(cur_username, quizCategory);
        tempQuestionList = quizQuestionService.getNRandomQuestions(quizCategory, 5);
        System.out.println("--------------------------------------------------");
        System.out.println(tempQuiz.toString());
        System.out.println("--------------------------------------------------");

        tempChoiceList = new ArrayList<>();

        for (Question q: tempQuestionList) {
            System.out.print(q.toString());
            System.out.println("--------------------------------------------------");
            List<Choice> cur = choiceService.getChoicesByQuestionId(q.getId());
            tempChoiceList.add(cur);
            cur.stream().forEach(c -> System.out.println(c.toString()));
        }
        System.out.println("--------------------------------------------------");
        System.out.println("done");

        model.addAttribute("questionList", tempQuestionList);
        model.addAttribute("choiceList", tempChoiceList);

        return "quiz";
    }

    @GetMapping("/quiz")
    public String getQuiz(Model model, HttpServletRequest request) {
        return "quiz";
    }


    @PostMapping("/quiz")
    public String submitQuiz(
            @RequestParam(name = "selectedChoiceId_0", required=false) Integer selectedChoiceId_0,
            @RequestParam(name = "selectedChoiceId_1", required=false) Integer selectedChoiceId_1,
            @RequestParam(name = "selectedChoiceId_2", required=false) Integer selectedChoiceId_2,
            @RequestParam(name = "selectedChoiceId_3", required=false) Integer selectedChoiceId_3,
            @RequestParam(name = "selectedChoiceId_4", required=false) Integer selectedChoiceId_4,
            Model model,
            HttpSession session,
            HttpServletRequest request
    ) {

        System.out.println("-------------QuizController: submitQuiz-------------");
        System.out.println(tempQuiz.toString());

        // create Quiz and QuizQuestion only if the user finished the quiz
        Timestamp time_end = new Timestamp(System.currentTimeMillis());
        int quiz_id = quizService.saveQuiz(tempQuiz.getQuizname(), tempQuiz.getCategory(), tempQuiz.getUsername(), tempQuiz.getTime_start(), time_end, null);


        List<Integer> choiceIds = new ArrayList<>();
        choiceIds.add(selectedChoiceId_0 == null ? -1: selectedChoiceId_0);
        choiceIds.add(selectedChoiceId_1 == null ? -1: selectedChoiceId_1);
        choiceIds.add(selectedChoiceId_2 == null ? -1: selectedChoiceId_2);
        choiceIds.add(selectedChoiceId_3 == null ? -1: selectedChoiceId_3);
        choiceIds.add(selectedChoiceId_4 == null ? -1: selectedChoiceId_4);
        int score = 0;

        for (int i = 0; i < 5; i++) {
            session.setAttribute("selectedChoiceId_"+i, choiceIds.get(i));
            quizQuestionService.createQuizQuestion(quiz_id, tempQuestionList.get(i).getId(), choiceIds.get(i));
            if (choiceIds.get(i) >= 1 && choiceService.checkAnswer(choiceService.getChoiceById(choiceIds.get(i)))) score++;

        }
        quizService.setScoreById(score, quiz_id);
        return "redirect:/home";
    }
}
