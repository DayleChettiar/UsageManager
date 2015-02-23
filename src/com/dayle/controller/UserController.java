package com.dayle.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dayle.dao.UserDAO;
import com.dayle.dao.UserDAOImpl;
import com.dayle.model.User;
import com.dayle.validate.Validator;

public class UserController extends HttpServlet{
	
	 private static final long serialVersionUID = 1L;
	 private static String INSERT_OR_EDIT = "/users.jsp";
	 private static String LIST_USERS = "/listUsers.jsp";
	 private static String SEARCH_USERS = "/searchUsers.jsp";
	 
	 String forward;
	 
	 UserDAO userDAO;
	 
	 public UserController(){
	 	 super();
	 	 userDAO = new UserDAOImpl();
	 }
	 
	 protected void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException , ServletException
	 {
	 	 String action=request.getParameter("action");
	 	 if(action.equals("list")){
	 		 forward = LIST_USERS;
	 		 List<User> list = userDAO.getAllUsers(); 
	 		 request.setAttribute("users", list);
	 	 } else if(action.equals("edit")){
	 		 forward = INSERT_OR_EDIT;
	 		 String userId = request.getParameter("userId");
	 		 User user = userDAO.getUserById(Long.parseLong(userId));
	 		 request.setAttribute("user", user);
	 	 } else if(action.equals("delete")){
	 		 String userId = request.getParameter("userId");
	 		 User user = new User();
	 		 user.setUserId(Long.parseLong(userId));
	 		 userDAO.deleteUser(user); 
	 		 forward = LIST_USERS;
	 		 request.setAttribute("users", userDAO.getAllUsers()); 
	 	 } else if(action.equals("search")){ 
	 		 forward = SEARCH_USERS;
	 		 /* Long userId = Long.parseLong(request.getParameter("userId"));
	 		 String usgType = request.getParameter("usgType");
	 		 List<User> list = userDAO.getUsers(userId,usgType);
	 		 forward = LIST_USERS;
	 		 request.setAttribute("users", list); */
	 	 }  else { 
	 		 forward = INSERT_OR_EDIT;
	 	 }
	 	 RequestDispatcher view = request.getRequestDispatcher(forward);
	 	 view.forward(request, response);
	 }
	 
	 protected void doPost(HttpServletRequest request , HttpServletResponse response)throws IOException , ServletException
	 {
	 	 User user = new User();
	 	 String userId = request.getParameter("userId");
	 	 user.setUserName(request.getParameter("userName"));
	 	 user.setEmail(request.getParameter("email"));
	 	 user.setCountry(request.getParameter("country"));
	 	 user.setPhoneNumber(request.getParameter("phoneNumber"));
	 	 user.setUsgType(request.getParameter("usgType"));
	 	 //user.setTimeStamp(request.getParameter("timeStamp"));
	 	 
	 	 try {
	 		user.setTimeStamp(new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("timeStamp")));
	 	 } catch (ParseException e) {
	 		 
	 		 e.printStackTrace();
	 	 }
	 	 if(userId==null || userId.isEmpty()){
	 		 userDAO.addUser(user);
	 	 } else{
	 		 user.setUserId(Long.parseLong(userId));
	 		 userDAO.updateUser(user);
	 	 }
	 	 
	 	 RequestDispatcher view = request.getRequestDispatcher("listUsers.jsp");
	 	 List<User> list = userDAO.getAllUsers(); 
	 	 request.setAttribute("users", list);
	 	 view.forward(request, response);
	 }
}