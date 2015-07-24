package com.go_java4.alex_mirn.model.dao;

import com.go_java4.alex_mirn.model.entity.User;

public interface UserDao extends Dao<User> {
    User getByLogin(String login);
}
