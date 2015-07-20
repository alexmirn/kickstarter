package com.go_java4.alex_mirn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go_java4.alex_mirn.model.entity.Quote;
import com.go_java4.alex_mirn.service.QuoteService;

@RestController
@RequestMapping("/v1/quote")
public class QuoteRest {
	@Autowired
	private QuoteService quoteService;

	@RequestMapping("/random")
	public Quote getRandomQuote() {

		return quoteService.getRandom();

	}

}
