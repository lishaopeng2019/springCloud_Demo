package com.spring.demo.controller;

import com.spring.demo.entity.RestResult;
import com.spring.demo.entity.User;
import com.spring.demo.service.UserManageService;
import com.spring.demo.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @Description: 用户管理rest接口类
 * @Author: Super
 * @CreateDate: 2020/6/27 17:31
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserManageService userManageService;

    /**
     * 新增单个用户信息
     */
    @PostMapping("/insert")
    public RestResult insertUserInfo(@RequestBody User user) {
        log.info("request url is /insert, user is {}", user.toString());
        // 此处省略1w行参数校验
//        User user = new User(id, userName, passWord, age, sex, phone);
        RestResult restResult = new RestResult();
        if (userManageService.insertUserInfo(user) < Constants.NumberConstants.INT_ONE) {
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("insertUserInfo failed");
        }
        restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
        return restResult;
    }

    /**
     * 删除单个用户信息
     */
    @DeleteMapping("/delete/{id}")
    public RestResult deleteUser(@PathVariable("id") int userId) {
        log.info("request url is /delete/{}", userId);
        RestResult restResult = new RestResult();
        if (userManageService.deleteUser(userId) < Constants.NumberConstants.INT_ONE) {
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("deleteUser failed");
        }
        restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
        return restResult;
    }

    /**
     *更新用户信息,成功返回更新后的用户数据
     */
    @PutMapping("/update")
    public RestResult updateUser(@RequestBody User user) {
        log.info("request url is /update, user is {}", user.toString());
        RestResult restResult = new RestResult();
		User returnUser = userManageService.updateUser(user);
		if (!user.equals(returnUser)) {
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("update User failed");
        }
        restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
		restResult.setData(user); // user前台传参可以是某几个字段，因此返回的数据只包含更新过的字段
        return restResult;
    }

    /**
     * 查询单个用户信息
     */
    @GetMapping("/query")
    public RestResult queryUser(Integer id, String phone) {
        log.info("request url is /query, id = {}, phone = {}", id, phone);
        RestResult restResult = new RestResult();
        User user = userManageService.queryUser(id, phone);
        if (Objects.isNull(user)) {
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("queryUser failed");
            return restResult;
        }
        log.info("query end");
        restResult.setData(user);
        restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
        return restResult;
    }

    /**
     * 查询所有用户信息
     */
    @GetMapping("/query/all")
    public RestResult queryAllUser(){
        log.info("request url is /query/all");
        RestResult restResult = new RestResult();
        List<User> users = userManageService.queryAllUser();
        if (Objects.isNull(users)) {
            restResult.setStatus(Constants.StatusCode.FAIL_CODE);
            restResult.setErrorMsg("queryAllUser failed");
            return restResult;
        }
        restResult.setData(users);
        restResult.setStatus(Constants.StatusCode.SUCCESS_CODE);
        return restResult;
    }
}
