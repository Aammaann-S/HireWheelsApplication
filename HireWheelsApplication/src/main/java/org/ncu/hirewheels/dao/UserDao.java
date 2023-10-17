package org.ncu.hirewheels.dao;

import java.util.List;
import java.util.Optional;

import org.ncu.hirewheels.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Long>{

	public User findByUserId(long userId);
	
	// Find users by first name 
    public List<User> findByFirstName(String firstName);
//    public List<User> findByFirstNameIgnoreCase(String firstName);

    // Find users by first name or last name 
//    @Query("SELECT u FROM users u WHERE LOWER(u.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :name, '%'))")
//    public List<User> findByFirstNameOrLastName(@Param("name") String name);

    // Find users by email 
    public User findByEmail(String email);
    
 // Find users by password
    public User findByPassword(String password);
    
 // Find users by email and password
    public User findByEmailAndPassword(String email,String password);
//  public Optional<User> findByEmailAndPassword(String email, String password)

    // Find users by mobile number 
    public User findByMobileNo(String mobileNo);

}


