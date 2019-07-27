package com.deppatori.mellong;

import com.deppatori.mellong.model.User;
import com.deppatori.mellong.repository.UserRepository;
import com.deppatori.mellong.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MellongApplicationTests {

	@MockBean
	UserRepository userRepositoryMock;

	@Autowired
	UserServiceImpl userServiceImpl;

	@Test
	public void testFindAll(){

		when(userRepositoryMock.findAll()).thenReturn(Arrays.asList(new User(1L,"Tom","PAssword")));
		assertEquals(1,userServiceImpl.findAll().size());
	}

	@Test
	public void contextLoads() {
	}

}
