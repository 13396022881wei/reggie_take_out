package com.atheima.reggie.service.impl;

import com.atheima.reggie.common.CustomException;
import com.atheima.reggie.entity.Category;
import com.atheima.reggie.entity.Dish;
import com.atheima.reggie.entity.Setmeal;
import com.atheima.reggie.mapper.CategoryMapper;
import com.atheima.reggie.service.CategoryService;
import com.atheima.reggie.service.DishService;
import com.atheima.reggie.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FileName:     CategoryServiceImpl
 * CreateBy:     IntelliJ IDEA
 * Author:       wei
 * Date:         2022-09-10
 * Description :
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;
    /**
     * 根据id删除分类，删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();

        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);

        int count1 = dishService.count(dishLambdaQueryWrapper);

        if(count1 > 0){
            //已经关联菜品，抛一个异常
            throw new CustomException("当前分类下关联了菜品,不能删除");

        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();

        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);

        int count2 = setmealService.count();

        if(count2 > 0 ){
            throw new CustomException("当前分类下关联了套餐,不能删除");
        }

        super.removeById(id);
    }
}
