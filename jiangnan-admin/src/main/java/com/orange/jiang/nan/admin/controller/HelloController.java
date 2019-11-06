package com.orange.jiang.nan.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xieyong
 * @date 2019/11/5
 * @Description:
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String hello){
        return hello+"hello";
    }
}
