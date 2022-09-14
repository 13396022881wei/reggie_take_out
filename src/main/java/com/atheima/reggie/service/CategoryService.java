package com.atheima.reggie.service;

import com.atheima.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * FileName:     CategoryService
 * CreateBy:     IntelliJ IDEA
 * Author:       wei
 * Date:         2022-09-10
 * Description :
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
