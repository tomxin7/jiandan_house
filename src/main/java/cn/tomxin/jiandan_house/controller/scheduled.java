package cn.tomxin.jiandan_house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v0.1/scheduled")
public class scheduled {

    @GetMapping
    public void scheduled(){

        System.out.println(123);
    }
}
