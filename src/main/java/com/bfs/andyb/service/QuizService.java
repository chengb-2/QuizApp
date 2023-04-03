package com.bfs.andyb.service;

import com.bfs.andyb.dao.QuizDao;
import com.bfs.andyb.domain.Choice;
import com.bfs.andyb.domain.Question;
import com.bfs.andyb.domain.Quiz;
import com.bfs.andyb.domain.QuizQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class QuizService {
    private final QuizDao quizDao;
    private final ChoiceService choiceService;
    private final QuestionService questionService;
    private final QuizQuestionService quizQuestionService;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public QuizService(QuizDao quizDao, ChoiceService choiceService, QuestionService questionService, QuizQuestionService quizQuestionService) {
        this.quizDao = quizDao;
        this.choiceService = choiceService;
        this.questionService = questionService;
        this.quizQuestionService = quizQuestionService;
    }

    public List<Quiz> getQuizzesByUsername(String username){
        return quizDao.getQuizzesByUsername(username);
    }

    public Quiz createTempQuiz(String username, String category){
        Timestamp time_start = new Timestamp(System.currentTimeMillis());
        String quizname = username + "-" + category + "-" + sdf.format(time_start);
        Quiz quiz = new Quiz(-1, quizname, category, username, time_start, null, null);


        return quiz;
    }

    public int saveQuiz(String quizname, String category, String username, Timestamp time_start, Timestamp time_end, Integer score){
        quizDao.saveQuiz(quizname, category, username, time_start, time_end, score);
        int quiz_id = quizDao.getQuizIdByQuizname(quizname);
        return quiz_id;
    }

    public Quiz getQuizById(Integer id) {
        return quizDao.getQuizById(id);
    }

    public List<Quiz> getFilteredQuizzes(String category, String username) {
        return quizDao.getFilteredQuizzes(category, username);
    }

    public int setScoreById(Integer score, Integer id) {
        return quizDao.setScoreById(score, id);
    }

    public int getScoreById(Integer id) {
        return quizDao.getScoreById(id);
    }

}
