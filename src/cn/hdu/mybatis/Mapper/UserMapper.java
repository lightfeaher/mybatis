package cn.hdu.mybatis.Mapper;

import cn.hdu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    public User findUserById(Integer id);
    public List<User> findUserByUsername(String username);
}
