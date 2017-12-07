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


@WebServlet("/UserForm")
public class UserForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String idStr = request.getParameter("id");
		User user;
		if(idStr == null) {
			user = new User();
			user.setUser("");
		} else {
			
				user = getUser(idStr);	
				}
		
		request.setAttribute("user",user);
		request.getRequestDispatcher("/WEB-INF/jsp/userForm.jsp").forward(request, response);
		} catch (DaoException e) {
			
			e.printStackTrace();
		}
	}

	private User getUser(String id) throws DaoException {
		
		return DaoFactory.getUserDao().getById(id);
		
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
