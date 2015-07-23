package com.go_java4.alex_mirn.model.dao;

import com.go_java4.alex_mirn.model.entity.Answer;
import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.entity.Question;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("answerDao")
public class AnswerDaoImpl extends AbstractDao<Answer> implements AnswerDao {

	public AnswerDaoImpl() {
		super(Answer.class);
	}

	@Override
	public List<Answer> getAnswersOfQuestion(Question question) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Answer.class)
				.add(Restrictions.eq("question.id", question.getId()))
				.list();
	}
}