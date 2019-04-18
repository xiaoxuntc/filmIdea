package com.java1234.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.java1234.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java1234.entity.Film;
import com.java1234.service.FilmService;

/**
 * 电影Contrller类
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/film")
public class FilmController {

    @Resource
    private FilmService filmService;

    /**
     * 搜索电影 简单模糊查询
     *
     * @param s_film
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @RequestMapping("/search")
    public ModelAndView search(@Valid Film s_film, BindingResult bindingResult) throws Exception {
        ModelAndView mav = new ModelAndView();
        if (bindingResult.hasErrors()) {
            mav.addObject("error", bindingResult.getFieldError().getDefaultMessage());
            mav.addObject("title", "首页");
            mav.addObject("mainPage", "film/indexFilm");
            mav.addObject("mainPageKey", "#f");
            mav.setViewName("index");
        } else {
            List<Film> filmList = filmService.list(s_film, 0, 32);
            mav.addObject("filmList", filmList);
            mav.addObject("title", s_film.getName());
            mav.addObject("mainPage", "film/result");
            mav.addObject("mainPageKey", "#f");
            mav.addObject("s_film", s_film);
            mav.addObject("total", filmList.size());
            mav.setViewName("index");
        }
        return mav;
    }

    /***
     * @Description : 分页查询电影信息
     * @Method_Name : list
     * @Param :  @param page
     * @return : org.springframework.web.servlet.ModelAndView
     * @Creation Date : 2019/4/17
     * @Author : Sean
     */
    @RequestMapping("/list{id}")
    public ModelAndView list(@PathVariable(value = "id", required = false) Integer page) throws Exception {
        ModelAndView mav = new ModelAndView();
        List<Film> filmList = filmService.list(null, page - 1, 32);
        Long total = filmService.getCount(null);
        mav.addObject("filmList", filmList);
        mav.addObject("pageCode", PageUtil.genPagination("/film/list", total, page, 20));
        mav.addObject("title", "电影列表");
        mav.addObject("mainPage", "film/list");
        mav.addObject("mainPageKey", "#f");
        mav.setViewName("index");
        return mav;
    }
}
