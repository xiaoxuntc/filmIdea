package com.java1234.service;

import java.util.List;

import com.java1234.entity.Link;

/**
 * 友情链接Service接口
 *
 * @author Administrator
 */
public interface LinkService {

    /**
     * 分页查询友情链接
     *
     * @param page
     * @param pageSize
     * @return
     */
    List<Link> list(Integer page, Integer pageSize);

    /***
    * @Description : 查询所有友情链接
    * @Method_Name : listAdd
    * @Param :
    * @return : java.util.List<com.java1234.entity.Link>
    * @Creation Date : 2019/3/23
    * @Author : Sean
    */
    List<Link> listAll();

    /**
     * 获取总记录数
     *
     * @return
     */
    Long getCount();

    /**
     * @return : void
     * @Description : 添加或者修改友情链接
     * @Method_Name : save
     * @Param :  @param link
     * @Creation Date : 2019/2/4
     * @Author : Sean
     */
    void save(Link link);

    /**
     * @return : void
     * @Description : 根据id删除友情链接
     * @Method_Name : delete
     * @Param :  @param id
     * @Creation Date : 2019/2/4
     * @Author : Sean
     */
    void delete(Integer id);
}
