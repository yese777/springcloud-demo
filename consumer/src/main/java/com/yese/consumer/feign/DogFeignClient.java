package com.yese.consumer.feign;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "microservice-provider", fallbackFactory = UserFeignClientFallbackFactory.class)
@Component
public interface DogFeignClient {
    @GetMapping("/provider/dog")
    R test();
}