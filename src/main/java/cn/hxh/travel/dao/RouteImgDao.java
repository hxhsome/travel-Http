package cn.hxh.travel.dao;

import cn.hxh.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {
    /**
     * 根据rid查询图片
     * @param rdi
     * @return
     */
    public List<RouteImg> findByRid(int rdi);
}
