package cn.tomxin.jiandan_house.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
  * @Description: 添加不拦截路径
  * @author: tomxin
  * @date: 2018/11/28 11:19
  * @Version 1.0
 **/
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/*/user","/error", "/*/city/*", "/*/info/*");

    }
}
