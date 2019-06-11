package com.deppatori.mellong;

import com.deppatori.mellong.security.jwt.JwtParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JwtParams.class)
@TestPropertySource(locations = "/application.properties")
public class JwtParamsTest {

    @Autowired
    JwtParams jwtParams;

    @Test
    public void test_url_string(){
        String url = jwtParams.getAuthLoginUrl();

        assertThat(url).isEqualTo("/api/authenticate");
    }

}
