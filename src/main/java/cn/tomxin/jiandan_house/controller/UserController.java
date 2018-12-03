package cn.tomxin.jiandan_house.controller;

import cn.tomxin.jiandan_house.entity.QQInfo;
import cn.tomxin.jiandan_house.entity.User;
import cn.tomxin.jiandan_house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 用户相关
 * @author: tomxin
 * @date: 2018/11/27 15:18
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/v0.1/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录，调用QQ
     * @param qqInfo QQ登录信息
     * @return
     * @throws Exception
     */
    @PostMapping
    public User login(@RequestBody QQInfo qqInfo) throws Exception {

        return userService.addOrGetUser(qqInfo);
    }
}
