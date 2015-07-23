package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.dao.QuestionDao;
import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("questionService")
@Transactional
public class QuestionService{

    @Autowired
    private QuestionDao questionDao;

    public List<Question> getQuestionsOfProject(Project project) {
        return questionDao.getQuestionsOfProject(project);
    }

}