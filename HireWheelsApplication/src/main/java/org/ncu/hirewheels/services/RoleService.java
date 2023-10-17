package org.ncu.hirewheels.services;

import org.ncu.hirewheels.dao.RoleDao;
import org.ncu.hirewheels.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

//    private final RoleDao roleDao; 
    @Autowired
    RoleDao roleDao;

    @Autowired
    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Role createRole(String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        return roleDao.save(role);
    }
}