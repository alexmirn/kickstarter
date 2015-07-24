package com.go_java4.alex_mirn.service;

import com.go_java4.alex_mirn.model.dao.UserDao;
import com.go_java4.alex_mirn.model.dao.UserRoleDao;
import com.go_java4.alex_mirn.model.entity.User;
import com.go_java4.alex_mirn.model.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.LinkedList;

@Service("userDetailsService")
//@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    public User getUserByLogin(String login) {
        return userDao.getByLogin(login);
    }

    public User getById(Integer userId) {
        return userDao.getById(userId);
    }

    public void create(User user) {
        user.setUserRole(userRoleDao.getById(2)); //ROLE_USER
//        user.setActive(true);
        userDao.create(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }


    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Assembler assembler = new Assembler();
        User user = userDao.getByLogin(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return assembler.buildUserFromUserEntity(user);
    }

    private class Assembler {
        org.springframework.security.core.userdetails.User buildUserFromUserEntity(com.go_java4.alex_mirn.model.entity.User userEntity) {
            String username = userEntity.getLogin();
            String password = userEntity.getPassword();
//            boolean enabled = userEntity.isActive();
//            boolean accountNonExpired = userEntity.isActive();
//            boolean credentialsNonExpired = userEntity.isActive();
//            boolean accountNonLocked = userEntity.isActive();
            Collection<SimpleGrantedAuthority> authorities = new LinkedList<>();
            authorities.add(new SimpleGrantedAuthority(userEntity.getUserRole().getName()));
//            org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
            org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(username, password, authorities);
            return user;
        }
    }
}