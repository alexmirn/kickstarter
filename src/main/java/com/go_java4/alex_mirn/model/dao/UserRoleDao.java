package com.go_java4.alex_mirn.model.dao;

import com.go_java4.alex_mirn.model.entity.User;
import com.go_java4.alex_mirn.model.entity.UserRole;

public interface UserRoleDao extends Dao<UserRole> {
    UserRole getByName(String role_name);
}
