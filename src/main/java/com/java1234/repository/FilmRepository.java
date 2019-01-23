package com.java1234.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java1234.entity.Film;

/**
 * 电影Repository接口
 * @author Administrator
 *
 */
public interface FilmRepository extends JpaRepository<Film, Integer>{

}
