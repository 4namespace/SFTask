package com.sf.task.dao;

import java.util.List;

import com.sf.task.beans.User;




public interface UserDao {
	void create(User user) throws DaoException;

	List<User> getAll() throws DaoException;
	
	boolean update(User user, String oldUser ) throws DaoException;
	
	boolean deleteById(String id) throws DaoException;
	
	User getById(String id) throws DaoException;
	

	
}
