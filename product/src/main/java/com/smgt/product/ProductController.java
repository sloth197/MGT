package com.smgt.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    Dao dao;

    //HOME
    @RequestMapping(path = "/", method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    //List
    @RequestMapping(path = "/product_list", method = RequestMethod.GET)
    public ModelAndView product_List() {
        ModelAndView mv = new ModelAndView();
        List<ProductVo> list = dao.list(null); 
        mv.addObject("list", list);
        mv.setViewName("product/product_list");
        return mv;
    }

    //Register
    @RequestMapping(path = "/product_register", method = RequestMethod.GET)
    public ModelAndView product_Register() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product/product_register");
        return mv;
    }

    //Update
    @RequestMapping(path = "/product_update", method = RequestMethod.GET)
    public ModelAndView product_Update(@RequestParam("code") String code) {
        ModelAndView mv = new ModelAndView();
        ProductVo vo = dao.view(code);
        mv.addObject("vo", vo);
        mv.setViewName("product/product_update");
        return mv;
    }

    //View
    @RequestMapping(path = "/product_view", method = RequestMethod.GET)
    public ModelAndView product_View(@RequestParam("codeName") String codeName) {
        ModelAndView mv = new ModelAndView();
        ProductVo vo = dao.view(codeName);
        mv.addObject("vo", vo);
        mv.setViewName("product/product_view");
        return mv;
    }
    //Delete
    @RequestMapping(path="/product_delete")
    public ModelAndView product_Delete(@RequestParam("codeName") String codeName) {
        ModelAndView mv = new ModelAndView();
        //ProductVo vo = dao.delete(codeName);
        mv.addObject("vo", codeName);
        mv.setViewName("product/product_delete");
        return mv;
    }

    //Code관련
    //Register
    @RequestMapping(path="/code_register")
    public ModelAndView code_Register(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("code/code_register");
        return mv;
    }
    @RequestMapping(path="/code_registerR")
    public boolean bjmRegisterR(CodeVo vo){
        boolean b = false;
        b = code.code_register(vo);
        return b;
    }

}
