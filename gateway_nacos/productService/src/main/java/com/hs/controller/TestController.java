package com.hs.controller;


import com.hs.feigne.ProducerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test1")
    public String get() {
        return "test1";
    }

    @Autowired
    private ProducerFeign producerFeign;
    @RequestMapping("/test")
    public String getTest() {
        return producerFeign.test();
    }

}
