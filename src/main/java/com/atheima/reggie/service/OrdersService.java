package com.atheima.reggie.service;

import com.atheima.reggie.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * FileName:     OrdersService
 * CreateBy:     IntelliJ IDEA
 * Author:       wei
 * Date:         2022-09-13
 * Description :
 */

public interface OrdersService extends IService<Orders> {
   public void submit(Orders orders);
}
