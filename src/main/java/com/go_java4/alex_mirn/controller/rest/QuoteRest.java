package com.go_java4.alex_mirn.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.go_java4.alex_mirn.model.entity.Quote;
import com.go_java4.alex_mirn.service.QuoteService;

@RestController
@RequestMapping(value="/v1/quote", headers = "Accept=application/json")
public class QuoteRest {
	@Autowired
	private QuoteService quoteService;

	@RequestMapping(value="/random", method = RequestMethod.GET)
	public Quote getRandomQuote() {

		return quoteService.getRandom();

	}

}
