package com.go_java4.alex_mirn.model.entity;

import javax.persistence.*;

@Entity
@Table(name="userrole")
public class UserRole {
    @Id
    @Column(name="userrole_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="userrole_name")
    private String name;

    public UserRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}