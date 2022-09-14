package com.atheima.reggie.service;

import com.atheima.reggie.dto.DishDto;
import com.atheima.reggie.entity.Dish;
import com.atheima.reggie.entity.DishFlavor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * FileName:     DishService
 * CreateBy:     IntelliJ IDEA
 * Author:       wei
 * Date:         2022-09-10
 * Description :
 */
public interface DishService extends IService<Dish> {

    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜单信息和对应的口味信息
    public  DishDto getByIdWithFlavor(Long id);

    public  void updateWithFlavor(DishDto dishDto);
}
