package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.Role;

//import javax.management.relation.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long>{
	
	public Role findByRoleName(String roleName);

}
