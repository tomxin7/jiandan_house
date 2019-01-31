package cn.tomxin.jiandan_house.service.Impl;

import cn.tomxin.jiandan_house.entity.Info;
import cn.tomxin.jiandan_house.repository.InforRepository;
import cn.tomxin.jiandan_house.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService{

    @Autowired
    InforRepository inforRepository;


    @Override
    public Info findById(String id) {
        return inforRepository.findInfoById(id);
    }
}
