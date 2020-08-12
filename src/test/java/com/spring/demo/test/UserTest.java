package com.spring.demo.test;

import com.spring.demo.entity.User;
import com.spring.demo.service.UserManageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description: TODO
 * @Author: Super
 * @CreateDate: 2020/8/12 18:51
 * @Version: 1.0
 */

@SpringBootTest
public class UserTest {

	@Autowired
	private UserManageService userManageService;

	@Test
	void queryAll() {
		List<User> users = userManageService.queryAllUser();
		users.forEach((user) -> System.out.println(user));
	}
}
