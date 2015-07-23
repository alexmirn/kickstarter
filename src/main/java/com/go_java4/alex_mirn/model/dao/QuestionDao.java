package com.go_java4.alex_mirn.model.dao;

import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.entity.Question;
import com.go_java4.alex_mirn.model.entity.Quote;
import com.go_java4.alex_mirn.model.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuestionDao extends Dao<Question> {
    List<Question> getQuestionsOfProject(Project project);
}
