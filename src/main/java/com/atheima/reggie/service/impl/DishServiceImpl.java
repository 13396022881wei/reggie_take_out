package com.atheima.reggie.service.impl;

import com.atheima.reggie.dto.DishDto;
import com.atheima.reggie.entity.Dish;
import com.atheima.reggie.entity.DishFlavor;
import com.atheima.reggie.mapper.DishMapper;
import com.atheima.reggie.service.DishFlavorService;
import com.atheima.reggie.service.DishService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * FileName:     DishServiceImpl
 * CreateBy:     IntelliJ IDEA
 * Author:       wei
 * Date:         2022-09-10
 * Description :
 */
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl <DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * 新增菜品，同时保存对应的口味数据
     */
    @Transactional
    public void saveWithFlavor(DishDto dishDto) {

        this.save(dishDto);

        Long dishId = dishDto.getId();

        List<DishFlavor> flavors = dishDto.getFlavors();

        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());


        dishFlavorService.saveBatch(flavors);
        // dishFlavorService.saveBatch(dishDto.getFlavors());

    }

    /**
     * 根据id查询菜单信息和对应的口味信息
     * @param id
     * @return
     */
    @Override
    public DishDto getByIdWithFlavor(Long id) {

        Dish dish  = this.getById(id);

        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);


        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();


        queryWrapper.eq(DishFlavor::getDishId,dish.getId());

        List<DishFlavor> flavors = dishFlavorService.list(queryWrapper);

        dishDto.setFlavors(flavors);


        return dishDto;
    }

    @Override
    public void updateWithFlavor(DishDto dishDto) {
        //更新dish表基本信息
        this.updateById(dishDto);
        //清理当前菜品对应口味数据--dish_flavor表的delete表
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dishDto.getId());

        dishFlavorService.remove(queryWrapper);
        //添加当前提交过来的口味数据--dish_flavor表的insert操作
        List<DishFlavor> flavors = dishDto.getFlavors();

        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());

        dishFlavorService.saveBatch(flavors);

    }
}
