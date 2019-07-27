package com.deppatori.mellong;

import com.deppatori.mellong.model.User;
import com.deppatori.mellong.repository.UserRepository;
import com.deppatori.mellong.security.jwt.UserDetailsServiceImpl;
import com.deppatori.mellong.service.UserService;
import com.deppatori.mellong.service.UserServiceImpl;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@MockBean
	UserService userService;



	@Test
	public void testloadUserByUsername(){
		when(userService.findByUsernaem("tommy")).thenReturn(new User(1L,"tommy","password"));
		assertEquals("tommy",userDetailsService.loadUserByUsername("tommy").getUsername());
	}

	@Test(expected = UsernameNotFoundException.class)
	public void test_ifUserNotFound(){
		when(userService.findByUsernaem("tommy")).thenReturn(null);
		userDetailsService.loadUserByUsername("tommy");
	}



}
