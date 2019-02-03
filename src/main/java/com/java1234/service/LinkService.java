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

    /**
     * 获取总记录数
     *
     * @return
     */
    Long getCount();
}
