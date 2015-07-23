package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.dao.AnswerDao;
import com.go_java4.alex_mirn.model.entity.Answer;
import com.go_java4.alex_mirn.model.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("answerService")
public class AnswerService {

    @Autowired
    private AnswerDao answerDao;

    public List<Answer> getAnswersOfQuestion(Question question) {
        return answerDao.getAnswersOfQuestion(question);
    }
}
