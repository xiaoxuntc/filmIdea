package com.java1234.service;

import java.util.List;

import com.java1234.entity.WebSiteInfo;

/**
 * 电影动态信息Service接口
 *
 * @author Administrator
 */
public interface WebSiteInfoService {

    /**
     * 分页查询电影动态信息
     *
     * @param page
     * @param pageSize
     * @return
     */
    List<WebSiteInfo> list(WebSiteInfo webSiteInfo, Integer page, Integer pageSize);

    /**
     * 获取总记录数
     *
     * @return
     */
    Long getCount(WebSiteInfo webSiteInfo);

    /**
     * 根据电影id查询动态信息
     *
     * @param filmId
     * @return
     */
    List<WebSiteInfo> getByFilmId(Integer filmId);

    /**
     * 根据电影网址id查询电影动态信息
     *
     * @param webSiteId
     * @return
     */
    List<WebSiteInfo> getByWebSiteId(Integer webSiteId);


}
