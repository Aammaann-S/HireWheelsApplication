package org.ncu.hirewheels.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.ncu.hirewheels.entities.User;

public interface UserService {

	public String createUser(User user);
	
	public User getUser(String email, String password);
	
	public Map<Long, User> getAllUsers ();
	
}
