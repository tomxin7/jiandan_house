package cn.tomxin.jiandan_house.repository;

import cn.tomxin.jiandan_house.entity.Info;
import cn.tomxin.jiandan_house.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InforRepository extends JpaRepository<Info, String> {

    Info findInfoById(String id);
}
