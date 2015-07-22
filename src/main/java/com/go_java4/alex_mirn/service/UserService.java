package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.dao.UserDao;
import com.go_java4.alex_mirn.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getById(int userId) {
        return  userDao.getById(userId);
    }

}
