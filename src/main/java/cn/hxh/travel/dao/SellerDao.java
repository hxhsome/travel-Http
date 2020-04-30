package cn.hxh.travel.dao;

import cn.hxh.travel.domain.Seller;

public interface SellerDao {
    /**
     * 根据id查询对象
     * @param id
     * @return
     */
    public Seller findById(int id);
}
