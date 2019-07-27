package com.deppatori.mellong.security.jwt;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.deppatori.mellong.model.User;
import com.deppatori.mellong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> findUser = Optional.ofNullable(userService.findByUsernaem(username));

        if(findUser.isPresent()){
            AppUser appUser = new AppUser(1, findUser.get().getUsername(),findUser.get().getPassword(), "USER");
                           List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                        .commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());


                return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
        }

        throw new UsernameNotFoundException("Username: " + username + " not found");
    }


    private static class AppUser {
        private Integer id;
        private String username, password;
        private String role;

        public AppUser(Integer id, String username, String password, String role) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}
