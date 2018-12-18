package cn.tomxin.jiandan_house.service.Impl;

import cn.tomxin.jiandan_house.entity.City;
import cn.tomxin.jiandan_house.repository.CityRepository;
import cn.tomxin.jiandan_house.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;

    /**
     * 查询所有城市
     * @return
     */
    @Override
    public List<City> list() {
        return cityRepository.findByOrderByIdAsc();
    }

    /**
     * 添加城市
     * @param city
     * @return
     */
    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City delete(Integer id) {
        City city =cityRepository.findCityById(id);
        if (city == null){
        }

//        cityRepository.deleteById(id);
        return city;
    }


}
