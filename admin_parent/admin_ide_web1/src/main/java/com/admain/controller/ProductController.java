package com.admain.controller;

import com.admin.domain.Product;
import com.admin.service.IProductService;
import com.admin.service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productServiceImpl;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll ( ModelAndView mv) throws Exception{
        List<Product> ps = productServiceImpl.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");
        return mv;
    }


    @RequestMapping("/save.do")
    public String saveProduct(Product product)throws Exception{
        // 调用daolmpl 实现类的方法存储product 信息
         productServiceImpl.save(product);
        // 跳转到 findAll.do 展示添加的数据
         return "redirect:findAll.do";
    }

}
