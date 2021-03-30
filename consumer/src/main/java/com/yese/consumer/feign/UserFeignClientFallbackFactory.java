package com.yese.consumer.feign;

import com.baomidou.mybatisplus.extension.api.R;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author 张庆福
 * @date 2021/3/29
 */
@Slf4j
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<DogFeignClient> {

    @Override
    public DogFeignClient create(Throwable throwable) {
        return new DogFeignClient() {
            @Override
            public R test() {
                log.error("请求provider接口失败", throwable);
                return R.failed("出错了");
            }
        };
    }
}
