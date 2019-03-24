package com.java1234.service;

import java.util.List;

import com.java1234.entity.WebSite;

/**
 * 收录电影网址Service接口
 *
 * @author Administrator
 */
public interface WebSiteService {

    /**
     * 分页查询收录电影网址
     *
     * @param page
     * @param pageSize
     * @return
     */
    List<WebSite> list(WebSite webSite, Integer page, Integer pageSize);

    /***
    * @Description : 获取最新收录网址
    * @Method_Name : newestList
    * @Param :  @param page
    *  @param pageSize
    * @return : java.util.List<com.java1234.entity.WebSite>
    * @Creation Date : 2019/3/23
    * @Author : Sean
    */
    List<WebSite> newestList(Integer page, Integer pageSize);

    /**
     * @return : java.lang.Long
     * @Description : 获取总记录数
     * @Method_Name : getCount
     * @Param :  @param webSite
     * @Creation Date : 2019/2/8
     * @Author : Sean
     */
    Long getCount(WebSite webSite);

    /**
     * @return : void
     * @Description : 添加或者修改网址信息功能
     * @Method_Name : save
     * @Param :  @param webSite
     * @Creation Date : 2019/2/8
     * @Author : Sean
     */
    void save(WebSite webSite);

    /**
     * @return : void
     * @Description : 根据id删除收录电影网址
     * @Method_Name : delete
     * @Param :  @param id
     * @Creation Date : 2019/2/8
     * @Author : Sean
     */
    void delete(Integer id);
}
