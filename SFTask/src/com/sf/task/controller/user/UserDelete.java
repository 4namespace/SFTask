package com.sf.task.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.task.dao.DaoException;
import com.sf.task.dao.DaoFactory;


@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String user= (String)(request.getParameter("trumpubpub"));
		
			deleteUser(user);
		
		request.getRequestDispatcher("/UserList").forward(request, response);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	private void deleteUser(String user) throws DaoException {
		DaoFactory.getUserDao().deleteById(user);
		
	}

}
	
