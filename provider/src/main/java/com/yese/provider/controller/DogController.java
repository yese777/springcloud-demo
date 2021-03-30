package com.yese.provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yese.provider.entity.Dog;
import com.yese.provider.service.DogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 狗(Dog)表控制层
 *
 * @author 张庆福
 * @since 2021-03-28 18:54:22
 */
@Api(tags = "狗接口")
@Slf4j
@RestController
@RequestMapping("dog")
public class DogController {

    /**
     * 服务对象
     */
    @Autowired
    DogService dogService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param dog 查询实体
     * @return 所有数据
     */
    @ApiOperation("分页查询所有数据")
    @GetMapping
    public R<IPage<Dog>> selectAll(Page<Dog> page, Dog dog) {
        return R.ok(dogService.page(page, new QueryWrapper<>(dog)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public R<Dog> selectOne(@PathVariable Serializable id) {
        return R.ok(dogService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param dog 实体对象
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public R<Long> insert(@RequestBody Dog dog) {
        boolean rs = dogService.save(dog);
        return R.ok(rs ? dog.getId() : 0);
    }

    /**
     * 修改数据
     *
     * @param dog 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping
    public R<Boolean> update(@RequestBody Dog dog) {
        return R.ok(dogService.updateById(dog));
    }

    /**
     * 单条/批量删除数据
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @ApiOperation("单条/批量删除数据")
    @DeleteMapping
    public R<Boolean> delete(@RequestParam("idList") List<Long> idList) {
        return R.ok(dogService.removeByIds(idList));
    }
}

