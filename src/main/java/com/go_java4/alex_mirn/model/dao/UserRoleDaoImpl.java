package com.go_java4.alex_mirn.model.dao;

import com.go_java4.alex_mirn.model.entity.User;
import com.go_java4.alex_mirn.model.entity.UserRole;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends AbstractDao<UserRole> implements UserRoleDao {

    public UserRoleDaoImpl() {
        super(UserRole.class);
    }

    @Override
    public UserRole getByName(String role_name) {
            Session currentSession = sessionFactory.getCurrentSession();
            Query query = currentSession.createQuery("from UserRole where name = :name");
            query.setParameter("name", role_name);
            return (UserRole) query.uniqueResult();
    }
}
