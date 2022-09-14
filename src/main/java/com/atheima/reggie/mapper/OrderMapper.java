package com.atheima.reggie.mapper;

import com.atheima.reggie.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;

/**
 * FileName:     OrdersMapper
 * CreateBy:     IntelliJ IDEA
 * Author:       wei
 * Date:         2022-09-13
 * Description :
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
