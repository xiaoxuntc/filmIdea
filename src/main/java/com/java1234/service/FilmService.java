package com.java1234.service;

import com.java1234.entity.Film;

/**
 * 电影Service接口
 * @author Administrator
 *
 */
public interface FilmService {
	
	/**
	 * 添加或者修改电影
	 * @param film
	 */
	public void save(Film film);
}

