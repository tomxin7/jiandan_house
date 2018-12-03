package cn.tomxin.jiandan_house.config;

import cn.tomxin.jiandan_house.util.JwtToken;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
  * @Description: 用户校验拦截器
  * @author: tomxin
  * @date: 2018/11/28 11:17
  * @Version 1.0
 **/
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入controller层之前拦截请求
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //OPTIONS直接释放
        if (httpServletRequest.getMethod().equals("OPTIONS")){
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        String access_token = httpServletRequest.getHeader("Authorization");

        if (access_token == null){
            throw new IllegalArgumentException("token不能为空");
        }
        //验证token
        JwtToken.verifyToken(access_token);
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

}
