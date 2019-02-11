package com.java1234.service;

import com.java1234.entity.Film;

import java.util.List;

/**
 * 电影Service接口
 *
 * @author Administrator
 */
public interface FilmService {

    /**
     * 添加或者修改电影
     *
     * @param film
     */
    void save(Film film);

    /**
     * 分页查询电影信息
     *
     * @param page
     * @param pageSize
     * @return
     */
    List<Film> list(Film film, Integer page, Integer pageSize);

    /**
     * 获取总记录数
     *
     * @return
     */
    Long getCount(Film film);
}

