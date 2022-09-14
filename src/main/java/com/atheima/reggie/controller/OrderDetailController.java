package com.atheima.reggie.controller;

import com.atheima.reggie.entity.OrderDetail;
import com.atheima.reggie.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName:     OrderDetailController
 * CreateBy:     IntelliJ IDEA
 * Author:       wei
 * Date:         2022-09-13
 * Description :
 */
@Slf4j
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;


}
