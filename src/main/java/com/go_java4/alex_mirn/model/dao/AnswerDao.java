package com.go_java4.alex_mirn.model.dao;

import com.go_java4.alex_mirn.model.entity.Answer;
import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.entity.Question;

import java.util.List;

public interface AnswerDao extends Dao<Answer> {
    List<Answer> getAnswersOfQuestion(Question question);
}