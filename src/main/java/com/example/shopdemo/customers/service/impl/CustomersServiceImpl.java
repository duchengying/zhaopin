package com.example.shopdemo.customers.service.impl;

import com.example.shopdemo.customers.entity.Customers;
import com.example.shopdemo.customers.mapper.CustomersMapper;
import com.example.shopdemo.customers.service.ICustomersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shopdemo.orders.entity.Orders;
import com.example.shopdemo.orders.mapper.OrdersMapper;
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
public class CustomersServiceImpl extends ServiceImpl<CustomersMapper, Customers> implements ICustomersService {


}
