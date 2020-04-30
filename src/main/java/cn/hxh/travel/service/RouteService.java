package cn.hxh.travel.service;

import cn.hxh.travel.domain.PageBean;
import cn.hxh.travel.domain.Route;

/**
 * 线路的service
 */
public interface RouteService {
    /**
     * 根据类别进行分页查询
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Route> pageQuery(int cid, int currentPage,int pageSize,String rname);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    Route findOne(String rid);
}
