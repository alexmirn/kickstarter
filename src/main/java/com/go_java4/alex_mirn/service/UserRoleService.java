package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.dao.UserDao;
import com.go_java4.alex_mirn.model.dao.UserRoleDao;
import com.go_java4.alex_mirn.model.entity.User;
import com.go_java4.alex_mirn.model.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userRoleService")
public class UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    public void create(UserRole userRole) {
        userRoleDao.create(userRole);
    }

    public UserRole getById(Integer id) {
        return userRoleDao.getById(id);
    }

    public void delete(UserRole userRole) {
        userRoleDao.delete(userRole);
    }
}