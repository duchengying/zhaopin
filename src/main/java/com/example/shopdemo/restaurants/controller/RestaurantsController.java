package com.example.shopdemo.restaurants.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shopdemo.orders.entity.Orders;
import com.example.shopdemo.orders.service.impl.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dcy
 * @since 2020-05-27
 */
@RestController
@RequestMapping("/restaurants/restaurants")
public class RestaurantsController {

    @Autowired
    OrdersServiceImpl ordersService;


    /*
    * 获取订单列表
    * */
    @RequestMapping("getorders")
    public List<Orders> getOrders(){

        return  ordersService.list();
    }

    /*
    * 根据状态查询状态
    * */
    @RequestMapping("getorderByStatus")
    public  List<Orders> getorderByStatus(int status){

        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("status",status);
        return  ordersService.list(queryWrapper);
    }
    /*
    * 修改状态，已送达，已接单，以支付
    * */
    @PostMapping("changeStatusByRes")
    public Boolean changeStatusByRes(Orders orders){
      return   ordersService.updateById(orders);
    }



}
