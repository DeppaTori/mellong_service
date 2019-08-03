package com.deppatori.mellong.service;

import com.deppatori.mellong.model.Role;
import com.deppatori.mellong.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Set<Role> findAll() {
        return new HashSet<>(roleRepository.findAll());
    }

    @Override
    public Role findOne(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Long id, Role role) {
        Optional<Role> roleExist = roleRepository.findById(id);
        if(roleExist.isPresent()){
            return roleRepository.save(role);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
