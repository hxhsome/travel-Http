package cn.hxh.travel.service.impl;

import cn.hxh.travel.dao.UserDao;
import cn.hxh.travel.dao.impl.UserDaoImpl;
import cn.hxh.travel.domain.User;
import cn.hxh.travel.service.UserService;
import cn.hxh.travel.util.MailUtils;
import cn.hxh.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //1.根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断u是否为null
        if (u != null) {
            //用户名存在，注册失败
            return false;
        }
        //2.保存用户信息
        //2.1设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("N");
        userDao.save(user);
        //3.发送邮件
        String content = "<a href='http://localhost:8080/travel/user/active?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";
        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        return true;
    }

    /**
     *激活用户
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //1.根据激活码查找用户对象
        User user = userDao.findByCode(code);
        //2.调用dao的修改激活状态的方法
        if(user!=null){
            userDao.updateStatus(user);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 登陆方法
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
