package org.ncu.hirewheels.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.ncu.hirewheels.dao.RoleDao;
import org.ncu.hirewheels.dao.UserDao;
import org.ncu.hirewheels.entities.Role;
import org.ncu.hirewheels.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao; 
	
	@Override
	public String createUser(User user) {
		
        Role userRole = roleDao.findByRoleName(user.getRole().getRoleName());
        System.out.println(userRole);
        
        if (userRole == null) {
            userRole = new Role();
            userRole.setRoleName(user.getRole().getRoleName());
            userRole = roleDao.save(userRole);
        }
        user.setRole(userRole);
        System.out.println(user);
        
		User u = userDao.save(user);
		if(u == null) {
			return "Failed to signup User!!!!";
		}
		return "User SignUp Successfull!!, User:"+u;
	}

	@Override
	public User getUser(String email, String password) {
		User e = userDao.findByEmail(email);

		if (e != null) {
			User u = userDao.findByEmailAndPassword(email, password);
			if(u != null)
			{
				return u;
			}
			else {
				System.out.println("Unauthorized User");				
			}
		}
		else {
			System.out.println("User not Registered");
		}
		return null;
	}

	@Override
	public Map<Long, User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> list =  userDao.findAll();
		Map<Long, User> map = new HashMap<Long, User>();
		for(User p: list) {
			System.out.println(p);
			map.put(p.getUserId(), p);
		}
		return map;
	}

}
