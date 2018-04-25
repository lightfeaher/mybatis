package cn.hdu.mybatis.dao;

import cn.hdu.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory =sqlSessionFactory;
    }
    @Override
    public User findUserById(Integer id) {
        SqlSession openSession = sqlSessionFactory.openSession();
        User user = openSession.selectOne("test.findUserById", id);
        return user;
    }

    @Override
    public List<User> findUserByUsername(String username) {
        SqlSession openSession = sqlSessionFactory.openSession();
        List<User> list = openSession.selectList("test.findUserByUsername", username);
        return list;
    }
}
