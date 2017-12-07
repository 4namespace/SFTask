package com.sf.task.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public abstract class ConnectionMySQL {
	Connection getConnection() throws DaoException {
		try {
			MysqlDataSource dataSource = new MysqlDataSource();
		    dataSource.setServerName("localhost");
		    dataSource.setPortNumber(3306);
		    dataSource.setDatabaseName("my_db");
            //input your ac/pass
		    dataSource.setUser("");
		    dataSource.setPassword("");
		    
		return dataSource.getConnection();
		}catch (SQLException e) {
			throw new DaoException();
	  	}

	}
}
