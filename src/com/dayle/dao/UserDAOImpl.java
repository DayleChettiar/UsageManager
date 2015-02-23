package com.dayle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dayle.model.User;
import com.dayle.util.DbUtil;

public class UserDAOImpl implements UserDAO {

	Connection connection=null;
	 
    public UserDAOImpl(){
     	connection = DbUtil.getConnection();
     	System.out.println("connection");
    }
 
    @Override
    public void addUser(User user) {
     	try{
     		String sql="INSERT INTO User(user_name,email,country,phoneNumber,usg_type,time_stamp) values ( ?, ?, ?, ?, ?, ? )";
     		PreparedStatement pst = connection.prepareStatement(sql);
     		pst.setString(1, user.getUserName());
     		pst.setString(2, user.getEmail());
     		pst.setString(3, user.getCountry());
     		pst.setString(4, user.getPhoneNumber());
     		pst.setString(5, user.getUsgType());
     		pst.setDate(6, new java.sql.Date(user.getTimeStamp().getTime()));
     		int res = pst.executeUpdate();
     		if(res > 0){
     			System.out.println("User Id " +user.getUserId() + " generated.");
     		}
     	} catch(SQLException e){
     		e.printStackTrace();
     	}
    }

    @Override
    public void updateUser(User user) {
    	try{
    		String sql="UPDATE User SET user_name = ?, email = ?, country = ?, phoneNumber = ?, usg_type = ?, time_stamp = ? WHERE user_id = ? ";
    		PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getCountry());
			pst.setString(4, user.getPhoneNumber());
			pst.setString(5, user.getUsgType());
			pst.setDate(6, new java.sql.Date(user.getTimeStamp().getTime()));
			pst.setLong(7, user.getUserId());
			int res = pst.executeUpdate();
			if(res > 0){
				System.out.println("Updated User db.");
			}
    	} catch(SQLException e){
    		e.printStackTrace(); 
    	}
    }
    
    @Override
    public void deleteUser(User user) {
    	try{
    		String sql="DELETE FROM User WHERE user_id = ? "; 
    		PreparedStatement pst = connection.prepareStatement(sql);
    		pst.setLong(1, user.getUserId());
    		int res = pst.executeUpdate(); 
    		if(res > 0){
    			System.out.println("Delete query fired.");
    		}
    	} catch(SQLException e){
    		e.printStackTrace();
    	}
    }

    @Override
    public List<User> getAllUsers() { 
    	List<User> users = new ArrayList<User>();
    	try{ 
    		String sql="SELECT * FROM User ";
    		PreparedStatement pst = connection.prepareStatement(sql);
    		ResultSet rs = pst.executeQuery();
    		while(rs.next()){
    			User user = new User();
    			user.setUserId(rs.getLong(1));
    			user.setUserName(rs.getString(2));
    			user.setEmail(rs.getString(3));
    			user.setCountry(rs.getString(4));
    			user.setPhoneNumber(rs.getString(5));
    			user.setUsgType(rs.getString(6));
    			user.setTimeStamp(rs.getDate(7));
    			users.add(user);
    		}
    	} catch(SQLException e){
    		e.printStackTrace();
    	}
    	return users;
    }

    @Override
    public User getUserById(long userId) {
    	User user = null;
    	try{
    		String sql="SELECT * FROM User WHERE user_id = ? "; 
    		PreparedStatement pst = connection.prepareStatement(sql);
    		pst.setLong(1, userId); 	
    		ResultSet rs = pst.executeQuery();
 
    		while(rs.next()){
    			user = new User();
    			user.setUserId(rs.getLong(1));
    			user.setUserName(rs.getString(2));
    			user.setEmail(rs.getString(3));
    			user.setCountry(rs.getString(4));
    			user.setPhoneNumber(rs.getString(5));
    			user.setUsgType(rs.getString(6));
    			user.setTimeStamp(rs.getDate(7));
    		}
    	} catch(SQLException e){
    		e.printStackTrace();
    	}
    	return user;
    }	

    @Override 
    public List<User> getUsers(long userId, String usgType) {
    	List<User> users = new ArrayList<User>();
    	try{ 
    		String sql="SELECT * FROM User WHERE user_id = ?, usg_type = ?"; 
    		PreparedStatement pst = connection.prepareStatement(sql);
    		pst.setLong(1, userId);
    		pst.setString(2, usgType);
    		ResultSet rs = pst.executeQuery();
    		
    		while(rs.next()){
    			User user = new User();
    			user.setUserId(rs.getLong(1));
    			user.setUserName(rs.getString(2));
    			user.setEmail(rs.getString(3));
    			user.setCountry(rs.getString(4));
    			user.setPhoneNumber(rs.getString(5));
    			user.setUsgType(rs.getString(6));
    			user.setTimeStamp(rs.getDate(7));
    			users.add(user);
    		}
    	} catch(SQLException e){
    		e.printStackTrace();
    	}
    	return users;
    }
}
