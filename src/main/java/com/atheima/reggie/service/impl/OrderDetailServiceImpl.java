package com.atheima.reggie.service.impl;

import com.atheima.reggie.entity.OrderDetail;
import com.atheima.reggie.mapper.OrderDetailMapper;
import com.atheima.reggie.service.OrderDetailService;
import com.atheima.reggie.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * FileName:     OrderDetailServiceImpl
 * CreateBy:     IntelliJ IDEA
 * Author:       wei
 * Date:         2022-09-13
 * Description :
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper , OrderDetail> implements OrderDetailService {
}
