package com.go_java4.alex_mirn.model.dao.template;

import javax.sql.DataSource;

public interface Template<T> {
    void setDataSource(DataSource ds);
    void create(T entity);
    T getById(Integer id);
    void update(T entity);
    void delete(T entity);
}
