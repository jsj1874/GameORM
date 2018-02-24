package com.gameorm.db.dao;

interface OrmGameDao<T> {
	
	T save(T pojo) ;
	
	T delete(T pojo);
	
	T update(T pojo);
	
    T select(T pojo);

	T select(T pojo, Integer id);
	
}
