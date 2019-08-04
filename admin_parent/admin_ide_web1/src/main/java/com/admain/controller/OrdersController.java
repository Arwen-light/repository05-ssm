package com.admain.controller;


import com.admin.domain.Orders;
import com.admin.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// Orders 添加订单
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersServiceImpl;


//    未分页controller 代码
  /*  @RequestMapping("/findAll.do")
    public ModelAndView findOrdersAll(ModelAndView mv) throws Exception{

    ModelAndView modelAndView = new ModelAndView();
    List<Orders> ordersList = ordersServiceImpl.findAll();
    modelAndView.addObject("ordersList",ordersList);
    modelAndView.setViewName("orders-list");

    return modelAndView;
}*/

//    分页后代码 pageBean

    @RequestMapping("/findAll.do")
    public ModelAndView findOrdersAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                      @RequestParam(name = "size", required = true, defaultValue = "4") int size)
            throws Exception {

        ModelAndView modelAndView = new ModelAndView();


        List<Orders> ordersList = ordersServiceImpl.findAll(page,size);

        // pageBean 生成路径
        PageInfo pageInfo = new PageInfo(ordersList);

        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-page-list");

        return modelAndView;

    }

    // 订单详情的查询

    @RequestMapping("/findById.do")
    public ModelAndView findOrdersById(@RequestParam(name = "id",required = true) String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = ordersServiceImpl.findById(id);
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }


}