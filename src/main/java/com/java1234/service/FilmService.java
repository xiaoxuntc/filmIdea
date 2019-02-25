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
     * @param page
     * @param pageSize
     * @return : java.util.List<com.java1234.entity.Film>
     * @Description : 分页查询电影信息
     * @Method_Name : list
     * @Param :  @param film
     * @Creation Date : 2019/2/12
     * @Author : Sean
     */
    List<Film> list(Film film, Integer page, Integer pageSize);

    /**
     * @return : java.lang.Long
     * @Description : 获取总记录数
     * @Method_Name : getCount
     * @Param :  @param film
     * @Creation Date : 2019/2/12
     * @Author : Sean
     */
    Long getCount(Film film);

    /**
     * @return : com.java1234.entity.Film
     * @Description : 根据id查找实体
     * @Method_Name : findById
     * @Param :  @param id
     * @Creation Date : 2019/2/12
     * @Author : Sean
     */
    Film findById(Integer id);

    /**
     * @return : void
     * @Description : 根据id删除电影
     * @Method_Name : delete
     * @Param :  @param id
     * @Creation Date : 2019/2/12
     * @Author : Sean
     */
    void delete(Integer id);
}

