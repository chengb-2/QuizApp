package com.bfs.andyb.service;

import com.bfs.andyb.dao.QuestionDao;
import com.bfs.andyb.dao.ChoiceDao;
import com.bfs.andyb.domain.Choice;
import com.bfs.andyb.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChoiceService {
    private final QuestionDao questionDao;
    private final ChoiceDao choiceDao;

    @Autowired
    public ChoiceService(QuestionDao questionDao, ChoiceDao choiceDao) {
        this.questionDao = questionDao;
        this.choiceDao = choiceDao;
    }
    public Choice getChoiceById(Integer id) {
        return choiceDao.getChoiceById(id);
    }

    public boolean checkAnswer(Choice choice) {
        return choice.is_correct();
    }


    public List<Choice> getChoicesByQuestionId(Integer id) {
        return choiceDao.getChoicesByQuestionId(id);
    }

    public int updateChoice(Integer id, String statement) {
        return choiceDao.updateChoice(id, statement);
    }

    public int setCorrectById(Integer id) {
        return choiceDao.setCorrectById(id);
    }

    public int createChoice(Integer question_id, String statement, Boolean is_correct){
        return choiceDao.createChoice(question_id, statement, is_correct);
    }

    public Choice getChoiceByQuizQuestionId(Integer id) {
        return choiceDao.getChoiceByQuizQuestionId(id);
    }


}
