package com.sf.task.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.sf.task.beans.User;
import com.sf.task.dao.DaoException;
import com.sf.task.dao.UserDao;


public class UserDaoImpl extends ConnectionMySQL implements UserDao {
	
	private static final String GET_ALL_SQL = "SELECT USER, PASSWORD, ROLE FROM USERS";
	private static final String GET_BY_ID_SQL = "SELECT USER, PASSWORD, ROLE FROM USERS WHERE USER = ?";
	private static final String DELETE_BY_ID_SQL = "DELETE FROM USERS WHERE USER = ?";
	private static final String CREATE_BY_ID_SQL = "INSERT INTO USERS (USER, PASSWORD, ROLE) VALUES(?, ?, ?)";
	private static final String UPDATE_BY_ID_SQL = "UPDATE USERS SET USER = ?, PASSWORD = ?, ROLE = ? WHERE USER = ?";
	

	@Override
	public void create(User user) throws DaoException {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(CREATE_BY_ID_SQL);
			ps.setString(1, user.getUser());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole());
			ps.executeUpdate();
		
					
		} catch (SQLException e){
			throw new DaoException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ignore) {	}
			}
		}
	}

	@Override
	public List<User> getAll() throws DaoException {
		Connection connection = getConnection();
		try{
		PreparedStatement ps = connection.prepareStatement(GET_ALL_SQL);
		ResultSet set =ps.executeQuery();
		 
		List<User> list = new ArrayList<User>();
		
		while(set.next()) {
			User user = new User();
			user.setUser(set.getString("USER"));
			user.setPassword(set.getString("PASSWORD"));
			user.setRole(set.getString("ROLE"));
			
			list.add(user);
			
		}
		
			return list;
		} catch (SQLException e) {
		throw new DaoException(e);
		}
		
	}

	@Override
	public boolean update(User user, String oldUser) throws DaoException {
		Connection connection = getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement(UPDATE_BY_ID_SQL);
			ps.setString(1, user.getUser());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole());
			ps.setString(4, oldUser);
			int count = ps.executeUpdate();
			
			return count == 1;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public boolean deleteById(String id) throws DaoException {
		Connection connection = getConnection();
		try{
			PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID_SQL);
			ps.setString(1,id);
			int count = ps.executeUpdate();
			
			return count == 1;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public User getById(String id) throws DaoException {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(GET_BY_ID_SQL);
			ps.setString(1, id);
			ResultSet set = ps.executeQuery(); 
			
			while (set.next()) {
				User user = new User();
				user.setUser(set.getString("USER"));
				user.setPassword(set.getString("PASSWORD"));
				user.setRole(set.getString("ROLE"));
				return user;
			}
			return null;
		} catch (SQLException e){
			throw new DaoException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ignore) {	}
			}
		}
	}

	


}

