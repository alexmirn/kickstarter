package com.go_java4.alex_mirn.model.dao;

import com.go_java4.alex_mirn.model.entity.User;
import com.go_java4.alex_mirn.model.entity.UserRole;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends AbstractDao<UserRole> implements UserRoleDao {

    public UserRoleDaoImpl() {
        super(UserRole.class);
    }
}
