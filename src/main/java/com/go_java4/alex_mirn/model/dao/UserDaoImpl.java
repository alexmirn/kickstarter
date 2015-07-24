package com.go_java4.alex_mirn.model.dao;

import com.go_java4.alex_mirn.model.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getByLogin(String login) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from User where login = :user_login");
//        Query query = currentSession.createQuery("from User where login = :login");
        query.setParameter("user_login", login);
        User user = (User) query.uniqueResult();
        return user;
    }
//
//    @Override
//    public void activateUser(Integer id) {
//        changeUserStatus(id, true);
//    }
//
//    @Override
//    public void deactivateUser(Integer id) {
//        changeUserStatus(id, false);
//    }
//
//    private void changeUserStatus(Integer id, boolean status) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        Query query = currentSession.createQuery("update User set active = :active where id = :id");
//        query.setBoolean("active", status);
//        query.setInteger("id", id);
//        query.executeUpdate();
//    }

}
