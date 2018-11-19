package cn.tomxin.jiandan_house.controller;

import cn.tomxin.jiandan_house.entity.City;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * city controller
 *
 * @author tomxin
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/v0.1/city")
public class CityController {


    /**
     *
     * @return
     */
    @GetMapping(value = "/list")
    public List<City> list(){

        return null;
    }
}
