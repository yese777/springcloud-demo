package com.yese.consumer.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.yese.consumer.feign.DogFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 张庆福
 * @date 2021/3/28
 */
@RestController
@Slf4j
public class TestController {


    @Autowired
    private DogFeignClient dogFeignClient;

    @GetMapping("/test")
    public R test() {
        R test = dogFeignClient.test();
        return test;
    }

}
