package com.go_java4.alex_mirn.model.dao;


import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.entity.Question;
import com.go_java4.alex_mirn.model.entity.Quote;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("questionDao")
public class QuestionDaoImpl extends AbstractDao<Question> implements QuestionDao {

	public QuestionDaoImpl() {
		super(Question.class);
	}

	@Override
	public List<Question> getQuestionsOfProject(Project project) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Question.class)
				.add(Restrictions.eq("project.projectId", project.getProjectId()))
				.list();
	}
}