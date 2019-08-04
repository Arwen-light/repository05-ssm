package com.admain.cotroller;

import com.admin.domain.Product;
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
    private ProductServiceImpl productServiceImpl;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll ( ModelAndView mv) throws Exception{
        List<Product> ps = productServiceImpl.findAll();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");
        return mv;
    }

}
