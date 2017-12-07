package com.sf.task.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.task.dao.DaoException;
import com.sf.task.dao.DaoFactory;
import com.sf.task.beans.User;


@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			List<User> users = getUsersList();
			request.setAttribute("alluser", users);
			request.getRequestDispatcher("/WEB-INF/jsp/alluser.jsp").forward(request, response);
		}catch (DaoException e) {
			throw new ServletException(e);
		}

	} 
	
	
		private List<User> getUsersList() throws DaoException {
			
			return  DaoFactory.getUserDao().getAll();
		
			
		}
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
