package com.go_java4.alex_mirn.model.dao;


import com.go_java4.alex_mirn.model.entity.Quote;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("quoteDao")
@Transactional
public class QuoteDaoImpl extends AbstractDao<Quote> implements QuoteDao {

	public QuoteDaoImpl() {
		super(Quote.class);
	}

	@Override

	public Quote getRandom() {
		Session currentSession = sessionFactory.getCurrentSession();
		return (Quote) currentSession.createSQLQuery("SELECT * FROM quote ORDER BY RANDOM() LIMIT 1").addEntity(Quote.class).uniqueResult();
	}
}