package cn.tomxin.jiandan_house.service.Impl;

import cn.tomxin.jiandan_house.entity.QQInfo;
import cn.tomxin.jiandan_house.entity.User;
import cn.tomxin.jiandan_house.repository.UserRepository;
import cn.tomxin.jiandan_house.service.UserService;
import cn.tomxin.jiandan_house.util.HttpClientHelper;
import cn.tomxin.jiandan_house.util.JwtToken;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author tomxin
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecordServiceImpl recordService;

    @Override
    public User addOrGetUser(QQInfo qqInfo) throws Exception {
        //数据库查询用户是否存在
        User user = userRepository.findUserByOpenId(qqInfo.getOpenId());

        if (user == null){
            //如果用户第一次登录，获取用户信息并存入数据库
            user = getUserInfoHttp(qqInfo);
            userRepository.save(user);
        }
        //生成token
        String token = JwtToken.createToken(user.getOpenId());
        user.setToken(token);

        return user;
    }

    /**
     * 发起get请求获取user信息
     * @param qqInfo
     * @return
     */
    private User getUserInfoHttp(QQInfo qqInfo){
        String url ="https://graph.qq.com/user/get_user_info?access_token=r_token&oauth_consumer_key=r_appId&openid=r_openid";
        url = url.replace("r_token",qqInfo.getAccessToken());
        url = url.replace("r_appId",qqInfo.getAppId());
        url = url.replace("r_openid",qqInfo.getOpenId());
        String userInfo = HttpClientHelper.get(url);
        User user = JSONObject.parseObject(userInfo, User.class);
        user.setOpenId(qqInfo.getOpenId());
        user.setRegisterTime(LocalDateTime.now());
        return user;
    }
}
