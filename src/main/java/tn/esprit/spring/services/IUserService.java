package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.message.Message;

import tn.esprit.spring.entities.User;

public interface IUserService { 
	 
	List<User> retrieveAllUsers(); 
	User addUser(User u);
	void deleteUser(String id);
	User updateUser(User u);
	User retrieveUser(String id);

} 
 