package cn.hxh.travel.dao;

import cn.hxh.travel.domain.Category;

import java.util.List;

public interface CategoryDao {
    /**
     * 查询所有
     * @return
     */
    List<Category> findAll();
}
