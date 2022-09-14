package com.atheima.reggie.service;

import com.atheima.reggie.dto.SetmealDto;
import com.atheima.reggie.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * FileName:     SetmealService
 * CreateBy:     IntelliJ IDEA
 * Author:       wei
 * Date:         2022-09-10
 * Description :
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids);

}
