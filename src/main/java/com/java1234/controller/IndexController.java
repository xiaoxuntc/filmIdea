package com.java1234.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 根路径以及其他请求处理
 *
 * @author Administrator
 */
@Controller
public class IndexController {

    /**
     * 网页根目录请求
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView root() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "首页");
        mav.setViewName("index");
        return mav;
    }

    /**
     * 登录请求
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    /**
     * 进入后台管理请求
     *
     * @return
     */
    @RequestMapping("/admin")
    public String toAdmin() {
        return "/admin/main";
    }
}
