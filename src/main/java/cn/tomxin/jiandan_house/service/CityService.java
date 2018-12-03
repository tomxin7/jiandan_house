package cn.tomxin.jiandan_house.service;

import cn.tomxin.jiandan_house.entity.City;

import java.util.List;

public interface CityService {

    List<City> list();

    City save(City city);

    City delete(Integer id);
}
