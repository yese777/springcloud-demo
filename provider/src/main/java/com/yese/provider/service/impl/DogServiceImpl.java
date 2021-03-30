package com.yese.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yese.provider.entity.Dog;
import com.yese.provider.mapper.DogMapper;
import com.yese.provider.service.DogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 狗(Dog)表服务实现类
 *
 * @author 张庆福
 * @since 2021-03-28 18:48:32
 */
@Slf4j
@Service
public class DogServiceImpl extends ServiceImpl<DogMapper, Dog> implements DogService {

}
