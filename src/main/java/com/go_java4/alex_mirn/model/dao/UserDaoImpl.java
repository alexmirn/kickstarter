package com.go_java4.alex_mirn.model.dao;

import com.go_java4.alex_mirn.model.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }

}
