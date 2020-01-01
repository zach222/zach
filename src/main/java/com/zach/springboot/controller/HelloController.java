package com.zach.springboot.controller;

import com.zach.springboot.pojo.Articl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {


    @RequestMapping("/hello")
    public Articl hellWorld( String name){

        Articl articl = new Articl(1L,"zach");
        log.info("测试代码"+ articl);
        return articl;

    }
}
