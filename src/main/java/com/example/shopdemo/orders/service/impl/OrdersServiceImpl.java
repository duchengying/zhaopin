package com.example.shopdemo.orders.service.impl;

import com.example.shopdemo.orders.entity.Orders;
import com.example.shopdemo.orders.mapper.OrdersMapper;
import com.example.shopdemo.orders.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dcy
 * @since 2020-05-27
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Autowired
    OrdersMapper ordersMapper;
    public  boolean  select(int id){
        Orders orders= ordersMapper.selectById(id);
        if(orders.getStatus()!=3){
            return true;
        }else {
            return false;
        }
    }
}
