package com.bfs.andyb.service;

import com.bfs.andyb.dao.QuizQuestionDao;
import com.bfs.andyb.domain.Choice;
import com.bfs.andyb.domain.Question;
import com.bfs.andyb.domain.QuizQuestion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizQuestionService {
    private final QuizQuestionDao quizQuestionDao;

    private final QuestionService questionService;
    private final ChoiceService choiceService;

    public QuizQuestionService(QuizQuestionDao quizQuestionDao, QuestionService questionService, ChoiceService choiceService) {
        this.quizQuestionDao = quizQuestionDao;
        this.questionService = questionService;
        this.choiceService = choiceService;
    }

    public List<Question> getNRandomQuestions(String category, int size){
        System.out.println("QuizQuestionService - generateQuizQuestions");
        List<Question> questionList = questionService.getNRandomQuizQuestions(category, size);
        return questionList;
    }

//    public void generateQuizQuestions(int quiz_id, String category){
//        System.out.println("QuizQuestionService - generateQuizQuestions");
//
//        List<Question> questionList = questionService.getQuestionByCategory(category, 5);
//        for (Question q: questionList) {
//            quizQuestionDao.createNewQuizQuestion(quiz_id, q.getId(), -1);
//        }
//    }

    public int createQuizQuestion(Integer quiz_id, Integer question_id, Integer user_choice_id) {
        System.out.println("QuizQuestionService - createQuizQuestion");
        return quizQuestionDao.createQuizQuestion(quiz_id, question_id, user_choice_id);
    }

    public List<QuizQuestion> getQuizQuestionsByQuizId(int quiz_id){
        List<QuizQuestion> questionList = quizQuestionDao.getQuestionsByQuizId(quiz_id);
        return questionList;
    }

    public int setUserChoiceId(int quiz_id, int question_id, int user_choice_id){
        // 1. store user choice id into quiz_question table
        quizQuestionDao.setUserChoiceId(quiz_id, question_id, user_choice_id);
        return quiz_id;
    }

}
