package com.go_java4.alex_mirn.model.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name="user_login")
    private String login;

    @Column(name="user_password")
    private String password;

    @Column(name="user_email")
    private String email;

    @Column(name="user_name")
    private String name;

    public User() {
    }

    public User(int i, String login, String password, String s, String name) {

    }

    public User(String login, String password, String s, String name) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "user")
    private Collection<Project> project;

//    public Collection<Project> getProject() {
//        return project;
//    }
//
//    public void setProject(Collection<Project> project) {
//        this.project = project;
//    }
}