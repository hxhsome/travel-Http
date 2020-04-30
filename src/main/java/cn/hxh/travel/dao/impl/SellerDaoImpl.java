package cn.hxh.travel.dao.impl;

import cn.hxh.travel.dao.SellerDao;
import cn.hxh.travel.domain.Seller;
import cn.hxh.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SellerDaoImpl implements SellerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Seller findById(int id) {
        String sql = "select * from tab_seller where sid = ? ";

        return template.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), id);
    }
}
