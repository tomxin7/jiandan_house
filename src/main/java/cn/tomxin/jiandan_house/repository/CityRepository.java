package cn.tomxin.jiandan_house.repository;

import cn.tomxin.jiandan_house.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    City findCityById(Integer id);
}
