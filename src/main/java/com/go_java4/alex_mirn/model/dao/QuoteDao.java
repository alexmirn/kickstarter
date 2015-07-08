package com.go_java4.alex_mirn.model.dao;

import com.go_java4.alex_mirn.model.entity.Quote;
import org.springframework.transaction.annotation.Transactional;

public interface QuoteDao {

	@Transactional
	Quote getRandom();
}
