package cn.hxh.travel.service.impl;

import cn.hxh.travel.dao.FavoriteDao;
import cn.hxh.travel.dao.impl.FavoriteDaoImpl;
import cn.hxh.travel.domain.Favorite;
import cn.hxh.travel.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public boolean isFavorite(String rid, int uid) {
        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);
        return favorite != null;//如果对象有值，表示收藏过true，没值为false
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid),uid);
    }
}
