package com.go_java4.alex_mirn.model.dao;

import java.util.List;

import com.go_java4.alex_mirn.model.entity.Project;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("projectsDao")
@Transactional
public class ProjectsDaoImpl extends AbstractDao<Project> implements ProjectsDao{

	public ProjectsDaoImpl() {
		super(Project.class);
	}

	@Override
	public List<Project> getProjectsInCategory(int index) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria cr = currentSession.createCriteria(Project.class);
		cr.add(Restrictions.eq("category.id", index));
		cr.addOrder(Order.asc("projectId"));
		return cr.list();
	}
}
