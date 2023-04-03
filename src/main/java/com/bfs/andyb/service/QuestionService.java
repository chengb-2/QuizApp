package com.bfs.andyb.service;

import com.bfs.andyb.dao.QuestionDao;
import com.bfs.andyb.dao.ChoiceDao;
import com.bfs.andyb.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    private final QuestionDao questionDao;

    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<String> getDistinctCategories(){
        List<Question> questions =  questionDao.getAllQuestions();
        List<String> distinctCategories = questions.stream().map(q -> q.getCategory()).distinct().collect(Collectors.toList());
        return distinctCategories;
    }

    public List<Question> getNRandomQuizQuestions(String category, int size) {
        List<Question> questionList = questionDao.getRandQuestions(category, size);
        return questionList;
    }

    public Question getQuestionById(int id) {
        Question question = questionDao.getQuestionById(id);
        return question;
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = questionDao.getAllQuestions();
        return questionList;
    }

    public int setIs_activeById(Integer id, Integer action) {
        return questionDao.setIs_activeById(id, action);
    }

    public int updateQuestion(Integer question_id, String category, String statement) {
        System.out.println("QuestionService - updateQuestion");
        System.out.println("question_id: " + question_id);
        System.out.println("category: " + category);
        System.out.println("statement: " + statement);

        return questionDao.updateQuestion(question_id, category, statement);
    }

    public int createQuestion(String category, String statement){
        return questionDao.createQuestion(category, statement);
    }

//    public int selectLastInsertedId() {
//        return questionDao.selectLastInsertedId();
//    }



//    public String checkAnswer(Choice selectedChoice) {
//        Question question = questionDao.getQuestion();
//        Choice correctChoice = question.getChoices().get(question.getCorrectChoiceId() - 1);
//        return selectedChoice.equals(correctChoice) ? "Correct!" : "Incorrect";
//    }

//    public Optional<Choice> getChoiceById(Integer selectedChoiceId) {
//        return questionDao
//                .getQuestion()
//                .getChoices()
//                .stream()
//                .filter(choice -> choice.getId() == selectedChoiceId)
//                .findFirst();
//    }
}
