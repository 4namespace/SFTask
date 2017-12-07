package com.sf.task.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.task.beans.User;
import com.sf.task.dao.DaoException;
import com.sf.task.dao.DaoFactory;



@WebServlet("/UserSave")
public class UserSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		User user = new User();
		user.setUser(request.getParameter("user"));
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));
		
		String oldUser= request.getParameter("oldUser");
	
		
		if (oldUser.equals("")  ) {
			addNewUser(user) ;
		} else {
			
				updateUser(user,oldUser);
			
		}
	
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/jsp/userForm.jsp").forward(request, response);
		} catch (DaoException e) {
			
			e.printStackTrace();
		}
		
				
	}

	private void updateUser(User user, String oldUser) throws DaoException {
		
		DaoFactory.getUserDao().update(user, oldUser);
		
	}

	private void addNewUser(User user) throws DaoException {
		
		DaoFactory.getUserDao().create(user);
	}

}

