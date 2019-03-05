package com.java1234.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java1234.entity.WebSiteInfo;
import com.java1234.service.WebSiteInfoService;

/**
 * 电影动态信息管理Controller类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/admin/webSiteInfo")
public class WebSiteInfoAdminController {

	@Resource
	private WebSiteInfoService webSiteInfoService;
	
	/**
	 * 分页查询电影动态信息
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public Map<String,Object> list(WebSiteInfo webSiteInfo,@RequestParam(value="page",required=false)Integer page,@RequestParam(value="rows",required=false)Integer rows)throws Exception{
		List<WebSiteInfo> webSiteInfoList=webSiteInfoService.list(webSiteInfo,page-1, rows);
		Long total=webSiteInfoService.getCount(webSiteInfo);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("rows", webSiteInfoList);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
}
