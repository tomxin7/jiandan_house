package cn.tomxin.jiandan_house.controller;

import cn.tomxin.jiandan_house.entity.City;
import cn.tomxin.jiandan_house.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
  * @Description: 城市相关
  * @author: tomxin
  * @date: 2018/11/22 19:18
  * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/v0.1/city")
public class CityController {


    @Autowired
    private CityService cityService;

    /**
     * 查询全部城市
     * @return
     */
    @GetMapping(value = "/list")
    public List<City> list(){
        return cityService.list();
    }
}
