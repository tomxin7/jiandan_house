package cn.tomxin.jiandan_house.service;

import cn.tomxin.jiandan_house.entity.QQInfo;
import cn.tomxin.jiandan_house.entity.User;


public interface UserService {
    User addOrGetUser(QQInfo qqInfo) throws Exception;
}
