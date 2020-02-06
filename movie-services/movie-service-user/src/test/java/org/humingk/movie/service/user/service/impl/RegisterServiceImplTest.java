package org.humingk.movie.service.user.service.impl;

import org.humingk.movie.common.exception.MyException;
import org.humingk.movie.dal.entity.User;
import org.humingk.movie.service.user.service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RegisterServiceImplTest {

    @Autowired
    private RegisterService registerService;

    @Test(expected = MyException.class)
    public void register() {
        registerService.register(new User("id2", "email2", "1233"));
        // 重复ID
        registerService.register(new User("id2", "email3", "1233"));
        // 重复email
        registerService.register(new User("id3", "email2", "1233"));
    }
}