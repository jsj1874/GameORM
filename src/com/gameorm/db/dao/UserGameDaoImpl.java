package com.gameorm.db.dao;

import java.util.Properties;

import com.bean.User;

public class UserGameDaoImpl extends BaseGameDaoImpl<User> {

	public UserGameDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserGameDaoImpl(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	public UserGameDaoImpl(String propertiesPath) {
		super(propertiesPath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public User save(User pojo) {
		// TODO Auto-generated method stub
		return super.save(pojo);
	}

	@Override
	public User update(User pojo) {
		// TODO Auto-generated method stub
		return super.update(pojo);
	}

	@Override
	public User select(User pojo, Integer id) {
		// TODO Auto-generated method stub
		return super.select(pojo, id);
	}

	@Override
	public User select(User pojo) {
		// TODO Auto-generated method stub
		return super.select(pojo);
	}

	
}
