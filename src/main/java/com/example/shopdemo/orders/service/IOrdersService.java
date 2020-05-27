package com.example.shopdemo.orders.service;

import com.example.shopdemo.orders.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shopdemo.orders.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dcy
 * @since 2020-05-27
 */
public interface IOrdersService extends IService<Orders> {

    boolean  select(int id);
}
