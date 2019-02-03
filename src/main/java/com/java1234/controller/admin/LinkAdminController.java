package com.java1234.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java1234.entity.Link;
import com.java1234.service.LinkService;

/**
 * 友情链接Controller类
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/admin/link")
public class LinkAdminController {

    @Resource
    private LinkService linkService;

    /**
     * 分页查询友情链接
     *
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping("list")
    public Map<String, Object> list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) throws Exception {
        List<Link> linkList = linkService.list(page - 1, rows);
        Long total = linkService.getCount();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("rows", linkList);
        resultMap.put("total", total);
        return resultMap;
    }
}
