package com.example.shopdemo.customers.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shopdemo.customers.service.impl.CustomersServiceImpl;
import com.example.shopdemo.menudishes.entity.MenuDishes;
import com.example.shopdemo.menudishes.service.impl.MenuDishesServiceImpl;
import com.example.shopdemo.orderdishes.entity.OrderDishes;
import com.example.shopdemo.orderdishes.service.impl.OrderDishesServiceImpl;
import com.example.shopdemo.orders.entity.Orders;
import com.example.shopdemo.orders.service.impl.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
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
@RequestMapping("/customers/customers")
public class CustomersController {
    @Autowired
    CustomersServiceImpl customersService;
    @Autowired
    MenuDishesServiceImpl menuDishesService;
    @Autowired
    OrdersServiceImpl ordersService;
    @Autowired
    OrderDishesServiceImpl orderDishesService;

    /*
    * 提交订单
    * */
    @PostMapping("orderpost")
    public String getOrder(Orders orders){
        ordersService.save(orders);
        if(orders.getId()!=null){
            List<OrderDishes> orderDishes=orders.getOrderDishes();
            try {
                for ( OrderDishes orderDish:orderDishes) {
                    orderDish.setOrderId(orders.getId());
                    orderDishesService.save(orderDish);
                }
                return "提交订单成功";
            }catch (Exception e){
                return "提交订单错误";
            }

        }else {
            return "提交订单错误";
        }
    }

    /*
    * 获取菜单
    * */
    @RequestMapping("getmenudishes")
    public List<MenuDishes> getMenuDishes(){
       return menuDishesService.list();
    }
    /*
    * 条件查询菜单
    * */
    @RequestMapping("getmenudishesByCondition")
    public List<MenuDishes> getmenudishesByCondition(String name){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("name",name);
        return menuDishesService.list();
    }

    /*
    * 修改订单
    * */
    @PostMapping("repairOrder")
    public boolean repairOrder(Orders orders){

        boolean b= ordersService.updateById(orders);
        if(b){
            List<OrderDishes> orderDishes=orders.getOrderDishes();
            try {
                for ( OrderDishes orderDish:orderDishes) {
                    orderDish.setOrderId(orders.getId());
                    orderDishesService.updateById(orderDish);
                }
                return true;
            }catch (Exception e){
                return false;
            }
        }else {
            return false;
        }

    }
    /*
    * 检测订单是否可编辑
    * */
    @RequestMapping("checkOrder")
    public boolean checkOrder(int id){
      return   ordersService.select(id);
    }

}
