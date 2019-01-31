package cn.tomxin.jiandan_house.controller;

import cn.tomxin.jiandan_house.entity.Info;
import cn.tomxin.jiandan_house.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v0.1/info")
public class InfoController {

    @Autowired
    InfoService infoService;

    @GetMapping(value = "/{id}")
    public Info get(@PathVariable(value = "id") String id){
        return infoService.findById(id);
    }
}
