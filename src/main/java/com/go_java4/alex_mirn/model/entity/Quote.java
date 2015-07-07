package com.go_java4.alex_mirn.model.entity;

public class Quote {

	private int id;

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