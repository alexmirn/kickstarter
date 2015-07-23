package com.go_java4.alex_mirn.model.entity;

import javax.persistence.*;

@Entity
@Table(name="question")
public class Question {

    @Id
    @Column(name="question_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name="question_name")
    private String question_name;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Question() {
    }
}


