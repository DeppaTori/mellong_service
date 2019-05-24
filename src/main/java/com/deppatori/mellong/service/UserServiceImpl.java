package com.deppatori.mellong.service;

import com.deppatori.mellong.model.User;
import com.deppatori.mellong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Set<User> findAll() {
        return new HashSet<>(userRepository.findAll());
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        User found = userRepository.findById(id).orElse(null);
        if(user != null){
            user.setId(found.getId());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
