package com.go_java4.alex_mirn.model.daoOld;

import com.go_java4.alex_mirn.model.entity.Quote;

public interface QuoteDao extends Dao<Quote> {

	Quote getRandom();
}
