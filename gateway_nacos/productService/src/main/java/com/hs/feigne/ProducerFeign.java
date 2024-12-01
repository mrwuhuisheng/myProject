package com.hs.feigne;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "order-service")
public interface ProducerFeign {

    @RequestMapping("test")
    public String test();
}
