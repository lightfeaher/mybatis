package cn.hdu.mybatis.dao;

import cn.hdu.mybatis.pojo.User;

import java.util.List;

public interface UserDao {
    public User findUserById(Integer id);
    public List<User> findUserByUsername(String username);

}
