package com.deppatori.mellong.service;

import com.deppatori.mellong.model.User;
import org.springframework.stereotype.Service;


public interface UserService extends BaseService<User>{
    User findByUsernaem(String username);
}
