package com.go_java4.alex_mirn.model.entity;

import javax.persistence.*;

@Entity
@Table(name="quote")
public class Quote {

    @Id
    @Column(name="quote_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

    @Column(name="quote_name")
	private String quote;

    public Quote() {
    }

	public Quote(int id, String quote) {
		this.id = id;
		this.quote = quote;
	}

    public Quote(String quote) {
        this.quote = quote;
    }

	@Override
	public String toString() {
        return quote;
	}

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}